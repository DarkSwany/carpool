package com.example.carpool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carpool.DataTypes.DBConnection;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //private String username, password;
    private EditText usernameInput;
    private EditText passwordInput;
    static String username, password;

    private FirebaseAuth mAuth;
    public static final DBConnection dbc = new DBConnection();
    Button logOnButton;
    Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        usernameInput = findViewById(R.id.username);
        passwordInput =  findViewById(R.id.password);

        logOnButton = findViewById(R.id.logOnbutton);
        createAccountButton = findViewById(R.id.createAccount);

        mAuth = FirebaseAuth.getInstance();
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateAccount.class));
            }
        });

        logOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameInput.getText().toString().trim();
                password = passwordInput.getText().toString().trim();



                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dbc.updateCurrentUser(username);
                                    startActivity(new Intent(getApplicationContext(),Homescreen.class));

                                } else {
                                    Toast.makeText(MainActivity.this, "Login Failed or User Not Available", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

    }
}

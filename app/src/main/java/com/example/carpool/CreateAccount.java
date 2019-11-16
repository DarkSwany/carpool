package com.example.carpool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carpool.DataTypes.DBConnection;
import com.example.carpool.DataTypes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.mortbay.jetty.Main;

public class CreateAccount extends AppCompatActivity{
    static String name, email, password, phoneNumber;
    static int carSize;

    private EditText nameCreate, emailCreate, passwordCreate, phoneNumberCreate, carSizeCreate;
    private Button submitCreate;

    private FirebaseAuth mAuth;
    private DBConnection dbc;
    private User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        this.dbc = MainActivity.dbc;

        nameCreate = findViewById(R.id.nameBox);
        emailCreate = findViewById(R.id.emailBox);
        passwordCreate = findViewById(R.id.passwordBox);
        phoneNumberCreate = findViewById(R.id.phoneNumber);
        carSizeCreate = findViewById(R.id.carSize);

        submitCreate = findViewById(R.id.submitButton);

        mAuth = FirebaseAuth.getInstance();

        submitCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameCreate.getText().toString().trim();
                email = emailCreate.getText().toString().trim();
                password = passwordCreate.getText().toString().trim();
                phoneNumber = phoneNumberCreate.getText().toString().trim();
                carSize = Integer.parseInt(carSizeCreate.getText().toString().trim());
                newUser = new User(name, email, password, phoneNumber, carSize);
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dbc.addUserToDB(newUser);
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                } else {
                                    Toast.makeText(CreateAccount.this, "Account already exists with that email address", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}

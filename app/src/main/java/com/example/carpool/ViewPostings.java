package com.example.carpool;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import java.util.*;
import com.example.carpool.DataTypes.CarPool;
import com.example.carpool.DataTypes.DBConnection;

import org.mortbay.jetty.Main;


public class ViewPostings extends AppCompatActivity {
    static String selectedCarpool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DBConnection dbc = MainActivity.dbc;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_postings);
        //DataSnapshot postingsSnap = dbc.getPostingsSnapshot();

        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        //final ArrayList<CarPool> allCarpools = dbc.getCarpools();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //for(int i = 0; i < allCarpools.size(); i++){
            final Button button = new Button(this);
            button.setText("Location Goes here /n Date Goes Here");
            button.setLayoutParams(params);
            button.setTextSize(28);
            //button.setId(i);

            //button.setOnClickListener(new View.OnClickListener()

        //}
    }
}

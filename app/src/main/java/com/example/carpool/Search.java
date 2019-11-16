package com.example.carpool;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carpool.DataTypes.DBConnection;

public class Search extends AppCompatActivity {

    private String location;
    public static final DBConnection dbc = new DBConnection();

    public Search(String location) {
        this.location = location;
    }

    /**
     * Search for all the carpools available to a specific location.
     *
     * @param location the place the user would like to go to
     */

    public void searchCarpool(String location){
        //List carpools = dbc.getCarpools()
        //get all the locations from the carpools
        //if location in locations in Carpool
          //display all carpools to this location
        //else
          //message saying, "there is no carpool to this location"
        //Toast.makeText(this, "Sorry, there is no carpool to this location :(",
              // Toast.LENGTH_SHORT).show();

   }
}

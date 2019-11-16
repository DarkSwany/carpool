package com.example.carpool;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carpool.DataTypes.CarPool;
import com.example.carpool.DataTypes.DBConnection;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    private String location;
    private ViewPostings viewPostings;
    public static final DBConnection dbc = new DBConnection();

    public Search(String location) {
        this.location = location;
    }

    /**
     * Search for all the carpools available to a specific location.
     *
     * @param location the place the user would like to go to
     */

    public ArrayList<CarPool> searchCarpool(String location){
        ArrayList<CarPool> carPools = dbc.getCarpools();
        ArrayList<CarPool> carpoolsAvailable = new ArrayList<>();

        for(CarPool carpool : carPools){
            if(location.equals(carpool.getLocation())){
                carpoolsAvailable.add(carpool);
            }
        }

        if(carpoolsAvailable.equals(null)){
            Toast.makeText(this, "Sorry, there is no carpool to this location :(",
                    Toast.LENGTH_SHORT).show();
        }

        return carpoolsAvailable;
   }
}

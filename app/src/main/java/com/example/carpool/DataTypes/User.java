package com.example.carpool.DataTypes;

import com.google.api.services.calendar.model.Event;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    private String email;
    private String password;
    private String firstName;
    private String phoneNumber;
    private int carSize;
    private String currentCarpoolID;

    public User(String firstName, String email, String password, String phoneNumber, int carSize){
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.phoneNumber = phoneNumber;
        this.carSize = carSize;
        this.currentCarpoolID = "No current carpool";
    }

    /*creates a key for a user object based on their email.
     * Firebase does not accept "@" or "." as the name of a node so these are stripped and replaced*/
    public static String getUserKey(String email){
        int indexOfAt = email.indexOf("@");
        return email.substring(0, indexOfAt).replace('.', '-');
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getCarSize() {
        return carSize;
    }
    public String getCurrentCarpoolID(){ return currentCarpoolID;}

    public void setCurrentCarpoolID(String currentCarpoolID){
        this.currentCarpoolID = currentCarpoolID;
    }
}


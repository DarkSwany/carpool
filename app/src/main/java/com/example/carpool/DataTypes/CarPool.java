package com.example.carpool.DataTypes;

import java.util.UUID;

public class CarPool {
    private String location;
    private String date;
    private int seatNumber;
    private String carOwner;
    private String phoneNumber;
    private String name;
    private String uuid;


    public CarPool(String location, String date, int seatNumber, String carOwner, String phoneNumber, String name) {
        this.location = location;
        this.date = date;
        this.seatNumber = seatNumber;
        this.carOwner = carOwner;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.uuid = UUID.randomUUID().toString();
    }


    /**
     * Updates the number of seats left in the car and returns true
     * if the specified seat difference is less than or equal to the
     * remaining seats in the car
     *
     * @param seatDiff
     * @return
     */
    public boolean changeNumSeats(int seatDiff) {
        if (seatDiff - this.seatNumber >= 0) {
            return false;
        }
        else {
            this.seatNumber -= seatDiff;
            return true;
        }

    }


    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }


    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }


    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }


    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }


    /**
     * @return the seatNumber
     */
    public int getSeatNumber() {
        return seatNumber;
    }


    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }


    /**
     * @return the carOwner
     */
    public String getCarOwner() {
        return carOwner;
    }


    /**
     * @param carOwner the carOwner to set
     */
    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }


}

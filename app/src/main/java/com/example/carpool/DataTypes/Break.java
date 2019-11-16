package com.example.carpool.DataTypes;

import java.util.ArrayList;

public class Break {
    ArrayList<String> carPoolKey;
    String breakName;

    public Break(String breakName, ArrayList<String> carPools) {
        this.breakName = breakName;
        this.carPoolKey = carPools;
    }


    public void listCarpools() {
        //code of displaying carpools in andriod studio
    }


    /**
     * @return the carPools
     */
    public ArrayList<String> getCarPools() {
        return carPoolKey;
    }


    /**
     * @param carPools the carPools to set
     */
    public void setCarPools(ArrayList<String> carPools) {
        this.carPoolKey = carPools;
    }


    /**
     * @return the breakName
     */
    public String getBreakName() {
        return breakName;
    }


    /**
     * @param breakName the breakName to set
     */
    public void setBreakName(String breakName) {
        this.breakName = breakName;
    }


}

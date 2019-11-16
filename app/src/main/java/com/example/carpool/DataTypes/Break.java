package com.example.carpool.DataTypes;

import java.util.ArrayList;

public class Break {
    ArrayList<CarPool> carPools;
    String breakName;

    public Break(String breakName, ArrayList<CarPool> carPools) {
        this.breakName = breakName;
        this.carPools = carPools;
    }


    public void listCarpools() {
        //code of displaying carpools in andriod studio
    }


    /**
     * @return the carPools
     */
    public ArrayList<CarPool> getCarPools() {
        return carPools;
    }


    /**
     * @param carPools the carPools to set
     */
    public void setCarPools(ArrayList<CarPool> carPools) {
        this.carPools = carPools;
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

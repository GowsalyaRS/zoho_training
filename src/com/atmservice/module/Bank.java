package com.atmservice.module;
public class Bank 
{
    private String name;
    private final float cashBackPercentage =0.01f;
    private final float mininumCharge = 0.02f;
    private final float maximunCharge =0.04f ;
    public Bank(String name)
    {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public float getCashBackPercentage() {
        return cashBackPercentage;
    }
    public float getMininumCharge() {
        return mininumCharge;
    }
    public float getMaximunCharge() {
        return maximunCharge;
    }
}

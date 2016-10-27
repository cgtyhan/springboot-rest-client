package com.cagatayhan.model;

/**
 * Created by Çağatay Han on 21.10.2016.
 */
public class Worker extends Employee {
    private int feePerHour;
    private int hourPerDay;

    public Worker() {
        super();
    }

    public Worker(int id, String name, String address, int feePerHour, int hourPerDay) {
        super(id, name, address);
        this.feePerHour = feePerHour;
        this.hourPerDay = hourPerDay;
    }

    public int getFeePerHour() {
        return feePerHour;
    }

    public void setFeePerHour(int feePerHour) {
        this.feePerHour = feePerHour;
    }

    public int getHourPerDay() {
        return hourPerDay;
    }

    public void setHourPerDay(int hourPerDay) {
        this.hourPerDay = hourPerDay;
    }
}

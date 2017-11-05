package com.expotek.mn.forces;

import com.expotek.mn.basic.Force;
import com.expotek.mn.basic.Mass;

public class Gravity {

    private Mass mass1;
    private Mass mass2;
    private Force force;
    private double distance; //meters

    public Gravity (Mass mass1, Mass mass2, double distance) {
        this.mass1=mass1;
        this.mass2=mass2;
        this.distance=distance;
    }

    public Force getForce(double distance) {

        return force;
    }

    public Force getEarthGravity(double distance){//distance from center of earth

        return force;
    }
}

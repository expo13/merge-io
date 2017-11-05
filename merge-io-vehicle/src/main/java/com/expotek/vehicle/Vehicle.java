package com.expotek.vehicle;

import com.expotek.mn.basic.Acceleration;
import com.expotek.mn.basic.Mass;
import com.expotek.mn.basic.Velocity;
import com.expotek.vehicle.predictive.PredictiveMotion;

public class Vehicle {

    private Velocity velocity;
    private Mass mass;
    private Acceleration acceleration;
    private PredictiveMotion predictiveMotion;

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }
}

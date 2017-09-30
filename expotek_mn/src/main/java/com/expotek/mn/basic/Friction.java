package com.expotek.mn.basic;



public class Friction extends Force{

    private Double frictionCoefficient;

    public Friction(Mass mass, Acceleration acceleration, Vector vector) {
        super(mass, acceleration, vector);
    }

    public Double getFrictionCoefficient() {
        return frictionCoefficient;
    }

    public void setFrictionCoefficient(Double frictionCoefficient) {
        this.frictionCoefficient = frictionCoefficient;
    }
}

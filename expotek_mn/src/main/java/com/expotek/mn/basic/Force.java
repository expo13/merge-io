package com.expotek.mn.basic;


import java.util.List;

public class Force {

    private Vector vector;
    private int newtons;

    public Force(Mass mass, Acceleration acceleration, Vector vector){
        newtons = mass.getKilogram() * acceleration.getMs2();
        this.vector=vector;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public int getNewtons() {
        return newtons;
    }

    public void setNewtons(int newtons) {
        this.newtons = newtons;
    }

    public Force(List<Force> forces) {//TODO: using stream here.

    }
}

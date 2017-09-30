package com.expotek.mn.basic;

import java.util.List;

public class Vector {

    private int deltaX;
    private int deltaY;
    private int deltaZ;
//    private double amplitude;

    public Vector(List<Vector> vectors){//TODO use stream here
        deltaX=0;
        deltaY=0;
        deltaZ=0;
        for (Vector v : vectors) {
            deltaZ+=v.getDeltaZ();
            deltaX+=v.getDeltaX();
            deltaY+=v.getDeltaY();
        }
    }

    public Vector(List<Vector> vectors, Point p){//TODO use stream here

        for (Vector v : vectors) {

        }
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public int getDeltaZ() {
        return deltaZ;
    }

    public void setDeltaZ(int deltaZ) {
        this.deltaZ = deltaZ;
    }

    public double getAmplitude() {
        return Math.sqrt((deltaX^2)+(deltaX^2)+(deltaZ^2));
    }

}

package com.yevdokymov.figure;

public abstract class Figure3D {

    private double volume;
    private String name;
    Figure3D(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }
    Figure3D(){}
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

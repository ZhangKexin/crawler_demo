package com.zkx.bbs.entity;

public class Car {
    String brand;
    int color;

    public Car() {
    }

    public Car(String brand, int color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        System.out.println(brand);
        return this;
    }

    public int getColor() {
        return color;
    }

    public Car setColor(int color) {
        this.color = color;
        return this;
    }

    public void introduce() {
        System.out.println("brand:" + brand + ", color:" + color);
    }
}

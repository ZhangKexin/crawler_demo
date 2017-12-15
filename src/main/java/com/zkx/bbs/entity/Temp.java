package com.zkx.bbs.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Temp {
    public static void main(String[] args) throws Throwable {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();//getClassLoader
        Class clazz = classLoader.loadClass("com.zkx.bbs.entity.Car");//classLoader.loadClass
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);//class.getDeclaredConstructor
        Car car = (Car) constructor.newInstance("benz", 4);//constructor.newInstance
        car.introduce();

        Car car1 = (Car) clazz.newInstance();

        Field color = clazz.getDeclaredField("color");
        System.out.println(color);
        color.setInt(car1, 123);
        Method setBrand = clazz.getMethod("setBrand", String.class);//class.getMethod
        setBrand.invoke(car1, "BMW");//method.invoke
        car1.introduce();
        Method setColor = clazz.getMethod("setColor", int.class);
        setColor.invoke(car1, 12);
        car1.introduce();
    }
}

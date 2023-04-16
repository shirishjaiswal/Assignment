package com.DIocOne.DIoc;

public class Dog {
    public String name;

   Dog(String name) {
        System.out.println("Spring Call with dog name : " + name);
        this.name = name;
    }
    public Dog() {
    }
}

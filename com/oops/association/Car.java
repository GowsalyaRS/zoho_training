package com.oops.association;
class Car {
    private String carModel;
    private  Engine engine;  
    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
    }
    public void startCar() {
        engine.start();
        System.out.println(carModel + " is starting.....");
    }
    public String getCarModel() {
        return carModel;
    }
    public Engine getEngine() {
        return engine;
    }
}
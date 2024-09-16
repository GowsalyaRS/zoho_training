package com.oops;
class Engine {
    private  String engineType;
    public Engine(String engineType) {
        this.engineType = engineType;
    }
    public void start() {
        System.out.println(engineType + " engine is starting...");
    }
    public String getEngineType() {
        return engineType;
    }
}
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
public class CompositionDemo 
{
    public static void main(String[] args) 
    {
        Engine engine = new Engine("v7") ;
        Car bmw= new Car("BMW",engine);
        bmw.startCar(); 
    }
}

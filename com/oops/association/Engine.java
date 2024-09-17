package com.oops.association;
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

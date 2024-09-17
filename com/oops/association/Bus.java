package com.oops.association;
class Bus 
{
    private String busModel;
    private  Music music;
    public Bus(String busModel, Music music) {
        this.busModel = busModel;
        this.music = music;
    }
    public String getBusModel() {
        return busModel;
    }
    public Music getMusic() {
        return music;
    }
    void startMusic()
    {
        System.out.println("Starting Music........");
    }
}
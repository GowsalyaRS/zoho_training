package com.oops;
class Music 
{
    private String songName;
    private String movieName;
    public Music(String songName, String movieName) 
    {
        this.songName = songName;
        this.movieName = movieName;
    }
    void startMusic()
    {
        System.out.println("Song Name : " + songName  + " Movie Name : " + movieName);
    }
}
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
public class AggregationDemo 
{
    public static void main(String[] args) 
    {
        Music song = new Music("aaaa...!", "ABC");
        Bus bus = new Bus("xyz",song);
        bus.startMusic();
    }
}

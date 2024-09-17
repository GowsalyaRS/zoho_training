package com.oops.association;
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
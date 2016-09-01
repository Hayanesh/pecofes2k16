package com.hayanesh.pecofes;

/**
 * Created by Hayanesh on 23-Aug-16.
 */
public class FestEvent {
    private int thumbnail;
    private String schedule;
    private String name;

    public FestEvent(){

    }
    public FestEvent(String schedule, String name, int thumbnail)
    {
        this.thumbnail=thumbnail;
        this.schedule = schedule;
        this.name = name;
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getSchedule(){return schedule;}
    public void setSchedule(String schedule){this.schedule = schedule;}
    public int getThumbnail(){return thumbnail;}
    public void setThumbnail(int thumbnail){this.thumbnail=thumbnail;}
}

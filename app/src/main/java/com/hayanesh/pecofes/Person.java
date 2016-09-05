package com.hayanesh.pecofes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Created by Hayanesh on 05-Sep-16.
 */
public class Person {
    private String name;
    private String email;
    private String phone;
    private String team;
    private String event;

    public Person(){

    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setTeam(String team){
        this.team = team;
    }
    public String getTeam(){
        return team;
    }
    public void setEvent(String event){
        this.event = event;
    }
    public String getEvent(){
        return event;
    }
    public Map<String,Object> toMap(){
        HashMap<String,Object> registration = new HashMap<>();
        registration.put("Event",event);
        registration.put("Name",name);
        registration.put("Email",email);
        registration.put("Phone",phone);
        registration.put("team",team);
        return registration;
    }
}

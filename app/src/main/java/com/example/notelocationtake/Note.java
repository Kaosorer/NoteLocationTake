package com.example.notelocationtake;

public class Note {

    private long ID;
    private String Title;
    private String Content;
    private String Date;
    private String Time;
    private String Address;

    Note(){

    }

    Note(String title, String content, String date, String time, String address){//Address constructor

        this.Title = title;
        this.Content = content;
        this.Date = date;
        this.Time = time;
        this.Address = address;

    }

    Note(String title, String content, String date, String time){//No Address constructor

        this.Title = title;
        this.Content = content;
        this.Date = date;
        this.Time = time;
        this.Address = "Unknown Address";


    }

    Note(long id, String title, String content, String date, String time, String address){//ID+Address constructor

        this.ID = id;
        this.Title = title;
        this.Content = content;
        this.Date = date;
        this.Time = time;
        this.Address = address;

    }

    Note(long id, String title, String content, String date, String time){ //ID+No Address constructor

        this.ID = id;
        this.Title = title;
        this.Content = content;
        this.Date = date;
        this.Time = time;
        this.Address = "Unknown Address";

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

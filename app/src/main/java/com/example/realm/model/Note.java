package com.example.realm.model;

import com.example.realm.app.MyApplication;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Note extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    private String description;
    @Required
    private Date createdAt;

    public Note(){

    }


    public Note (String description){
        this.id = MyApplication.NoteId.incrementAndGet();
        this.description = description;
        this.createdAt = new Date ();
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}

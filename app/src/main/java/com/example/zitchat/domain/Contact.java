package com.example.zitchat.domain;

public class Contact {

    int id;
    String name;
    String lastmsg;

    public Contact(){}

    public Contact(int id,String name, String lastmsg) {
        this.id = id;
        this.name = name;
        this.lastmsg = lastmsg;

    }

    public int getId() {
        return id;
    }

    public String getLastmsg() {
        return lastmsg;
    }

    public String getName() {
        return name;
    }
}

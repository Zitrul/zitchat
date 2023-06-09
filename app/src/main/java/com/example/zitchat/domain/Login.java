package com.example.zitchat.domain;

public class Login {
    private String msg;
    public Login(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }

    @Override
    public String toString() {return "Login{" + "msg='" + msg + '\'' + '}';}
}


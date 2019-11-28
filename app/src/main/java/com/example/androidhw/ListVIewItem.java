package com.example.androidhw;

import android.graphics.drawable.Drawable;

public class ListVIewItem {
    private Drawable IconDrawable;
    private String titleStr;
    private String descStr;
    private String Email;
    private String location;

    public void setIcon(Drawable icon){
        IconDrawable = icon;
    }

    public void setTitleStr(String title){
        titleStr=title;
    }

    public void setDescStr(String desc){
        descStr = desc;
    }

    public void setEmail(String email){
        Email = email;
    }
    public void setLocation(String loc){
        location =loc;
    }


    public String getLocation(){
        return this.location;
    }

    public Drawable getIcon(){
        return this.IconDrawable;
    }

    public String getTitle(){
        return this.titleStr;
    }

    public String getDescStr(){
        return this.descStr;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setData(Drawable ic,String title, String Desc, String email, String aa){
        IconDrawable = ic;
        titleStr=title;
        descStr = Desc;
        Email = email;
        location = aa;

    }
}

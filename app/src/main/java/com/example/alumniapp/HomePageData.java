package com.example.alumniapp;

public class HomePageData {

    String postid,postimage,postownerimage,postownername,posttext,userid;
    public HomePageData() {
    }
    public HomePageData(String postid, String postimage, String postownerimage, String postownername, String posttext, String userid) {
        this.postid = postid;
        this.postimage = postimage;
        this.postownerimage = postownerimage;
        this.postownername = postownername;
        this.posttext = posttext;
        this.userid = userid;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostimage() {
        return postimage;
    }

    public void setPostimage(String postimage) {
        this.postimage = postimage;
    }

    public String getPostownerimage() {
        return postownerimage;
    }

    public void setPostownerimage(String postownerimage) {
        this.postownerimage = postownerimage;
    }

    public String getPostownername() {
        return postownername;
    }

    public void setPostownername(String postownername) {
        this.postownername = postownername;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}

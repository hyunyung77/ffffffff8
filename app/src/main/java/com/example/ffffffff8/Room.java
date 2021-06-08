package com.example.ffffffff8;

public class Room {

    private String id;
    private int pw;
    private String roomName;

    private String profile;
    //private String roomN;
    private String place;
    private int recruitmentN;

    public Room(){}

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    //----------------------

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getRecruitmentN() {
        return recruitmentN;
    }

    public void setRecruitmentN(int recruitmentN) {
        this.recruitmentN = recruitmentN;
    }
}

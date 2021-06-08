package com.example.ffffffff8;

public class RoomAccount {
    //방을 생성할때 그 방(객체)들을 어떤식을 담아줄 것이냐 하는 클래스

    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private String roomToken;       //Firebase Uid (고유 토큰정보 - 사용자 한명당 가질 수 있는 고유한 키 값)
    private String roomName;        //
    private String placeActivity;   //
    private String entryNumber;     //
    private String applyPeriod;
    private String activityPeriod;
    private String roomExplain;

    public String getRoomToken() { return roomToken; }

    public void setRoomToken(String roomToken) { this.roomToken = roomToken; }

    public String getRoomName() { return roomName; }

    public void setRoomName(String roomName) { this.roomName = roomName; }

    public String getPlaceActivity() { return placeActivity; }

    public void setPlaceActivity(String placeActivity) { this.placeActivity = placeActivity; }

    public String getEntryNumber() { return entryNumber; }

    public void setEntryNumber(String entryNumber) { this.entryNumber = entryNumber; }

    public String getApplyPeriod() { return applyPeriod; }

    public void setApplyPeriod(String applyPeriod) { this.applyPeriod = applyPeriod; }

    public String getActivityPeriod() { return activityPeriod; }

    public void setActivityPeriod(String activityPeriod) { this.activityPeriod = activityPeriod; }

    public String getRoomExplain() { return roomExplain; }

    public void setRoomExplain(String roomExplain) { this.roomExplain = roomExplain; }

}

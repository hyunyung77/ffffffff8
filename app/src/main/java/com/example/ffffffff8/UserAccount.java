package com.example.ffffffff8;

//* 사용자 계정 정보 모델 클래스*/
public class UserAccount {
    //사용자가 로그인 할 때 그 객체들을 어떤식으로 담아줄 것이냐 하는 클래스
    
    private String idToken;     //Firebase Uid (고유 토큰정보 - 사용자 한명당 가질 수 있는 고유한 키 값)
    private String emailId;     //이메일 아이디
    private String password;    //비밀번호

    public UserAccount() { }

    public String getIdToken() { return idToken; }

    public void setIdToken(String idToken) { this.idToken = idToken; }

    public String getEmailId() { return emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}

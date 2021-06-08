package com.example.ffffffff8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mFirebaseAuth = FirebaseAuth.getInstance(); //로그아웃에 사용하기 위해서 파이어베이스 유저정보 연결

        Button btn_roomInfor = findViewById(R.id.btn_roomInfor); //방생성
        btn_roomInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //방 정보 입력 액티비티로 이동
                Intent intent = new Intent(HomeActivity.this, RoomInfor.class);
                startActivity(intent);
            }
        });

        Button btn_waitRoom = findViewById(R.id.btn_waitRoom); //방목록
        btn_waitRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //방 목록 액티비티로 이동
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn_logout = findViewById(R.id.btn_logout); //로그아웃
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃 하기
                mFirebaseAuth.signOut();
                Toast.makeText(HomeActivity.this, "성공적으로 로그아웃 되었습니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);  //다시 로그인창으로 갈것이냐
                finish(); //앱을 끝내버릴 것이냐
                //계정 탈퇴 처리
                //mFirebaseAuth.getCurrentUser().delete();
            }
        });



    }
}
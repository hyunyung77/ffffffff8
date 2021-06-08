package com.example.ffffffff8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoomInfor extends AppCompatActivity {

    private DatabaseReference mDatabaseRef;     //실시간 데이터베이스
    private EditText mRoomName, mPlaceActivity, mEntryNumber;   //방정보 입력필드
    private EditText mApplyPeriod, mActivityPeriod, mRoomExplain;
    private Button mBtnRoomCreate, mBtnCancle;  //방정보, 취소 입력버튼

//    public RoomInfor(){
//        //Default constructor required for calls to DataSnapshot. getValue(FirebasePost.class)
//    }
//
//    public RoomInfor(String mRoomName, String mPlaceActivity, String mEntryNumber, String mApplyPeriod, String mActivityPeriod, String mRoomExplain){
//        this.mRoomName = mRoomName;
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_infor);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Room");

        //입력값 6개
        mRoomName = findViewById(R.id.et_roomName);
        mPlaceActivity = findViewById(R.id.et_placeActiviy);
        mEntryNumber = findViewById(R.id.et_entryNumber);
        mApplyPeriod = findViewById(R.id.et_applyPeriod);
        mActivityPeriod = findViewById(R.id.et_acticityPeriod);
        mRoomExplain = findViewById(R.id.et_roomExplain);

        mBtnRoomCreate = findViewById(R.id.btn_roomCreate);
        mBtnCancle = findViewById(R.id.btn_cancle);


        mBtnRoomCreate.setOnClickListener(new View.OnClickListener() { //방생성 버튼 눌렀을때 이벤트
            @Override
            public void onClick(View v) {
                //방 생성하기 버튼이 눌렸을 때
                String strRoomName = mRoomName.getText().toString();            //방정보 입력필드에 입력된 값을 getText로 불러와서 str 스트링변수에 대입
                String strPlaceActivity = mPlaceActivity.getText().toString();
                String strEntryNumber = mEntryNumber.getText().toString();
                String strApplyReriod = mApplyPeriod.getText().toString();
                String strActivityPeriod = mActivityPeriod.getText().toString();
                String strRoomExplain = mRoomExplain.getText().toString();

                RoomAccount account = new RoomAccount();
                //account.setRoomToken(mDatabaseRef.getKey());
                account.setRoomName(strRoomName);
                account.setPlaceActivity(strPlaceActivity);
                account.setEntryNumber(strEntryNumber);
                account.setApplyPeriod(strApplyReriod);
                account.setActivityPeriod(strActivityPeriod);
                account.setRoomExplain(strRoomExplain);

                mDatabaseRef.push().setValue(account);
                //.child("RoomAccount")

                Toast.makeText(RoomInfor.this, "(" + strRoomName + ")방 생성에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RoomInfor.this, RoomOpen.class);
                startActivity(intent);
                //mDatabaseRef.child("RoomAccount").child()

                //mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);



                //mDatabaseRef.getDatabase(strRoomName, strPlaceActivity, strEntryNumber, strApplyReriod, strActivityPeriod, strRoomExplain);


            }
        });





        mBtnCancle.setOnClickListener(new View.OnClickListener() {  //취소버튼 눌렀을때 이벤트
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomInfor.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
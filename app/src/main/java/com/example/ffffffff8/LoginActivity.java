package com.example.ffffffff8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;     //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd;      //로그인 입력필드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); //findViewById를 설정할때 해당 액티비티에 들어있는 id만 검색을 할 수 있다.

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("ffff4");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);


        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 버튼 눌렀을 때 요청
                String strEmail = mEtEmail.getText().toString(); //회원가입 입력필드에 입력된 값(mEtEmail)을 getText로 불러와서 strEmail 스트링변수에 대입
                String strPwd = mEtPwd.getText().toString(); //위와 같음

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    //회원가입에서는 createUser.. 함수였음
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish(); //현재 액티비티 파괴 (다시 로그인 액티비티로 돌아올 일이 없기 때문에 메모리 제거)
                        } else {
                            Toast.makeText(LoginActivity.this, "로그인 실패..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입 버튼 눌렀을 때 회원가입 화면으로 이동
                Intent intent = new Intent(LoginActivity.this, activity_resgister.class); //화면을 이동할 때 쓰는게 인탠트 (첫 인자에는 현재 자신 액티비티, 두번째 인자는 이동할 액티비티 쓰기)
                startActivity(intent);
            }
        });
    }
}
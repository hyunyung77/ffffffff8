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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_resgister extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;     //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd;      //회원가입 입력필드
    private Button mBtnRegister;            //회원가입 입력버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgister);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("ffff4");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mBtnRegister = findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {    //해당 버튼이 눌렸을때 이벤트
            @Override
            public void onClick(View v) {
                //회원가입 처리 시작
                String strEmail = mEtEmail.getText().toString(); //회원가입 입력필드에 입력된 값(mEtEmail)을 getText로 불러와서 strEmail 스트링변수에 대입
                String strPwd = mEtPwd.getText().toString(); //위와 같음

                //Firebase Auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(activity_resgister.this, new OnCompleteListener<AuthResult>() {
                    //2개의 인자를 받는데 하나는 email, 두번째는 비밀번호를 입력받는다. 왜 로그인 id를 email형식으로 받는지 알 수 있다. 왜냐하면 저 함수를 사용하기 때문이다.
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //회원가입이 성공적으로 이루어졌을때
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser(); //현재 회원가입 된 유저를 가져와서 객체에 담는다.
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());   //로그인된 유저의 고유값
                            account.setEmailId(firebaseUser.getEmail()); //정확히 로그인된 유저 기준으로 세팅을 해야한다.
                            account.setPassword(strPwd);                 //비밀번호는 입력된 그대로 받아오면 된다.

                            //setValue : database에 insert(삽입)하는 행위, 즉 아래 코드에서는 account에 담긴 Uid, email, pwd 3개의 값이 담긴 UserAccount 객체인 account를 실제 db에 세팅하는 과정임.
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(activity_resgister.this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity_resgister.this, LoginActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(activity_resgister.this, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}
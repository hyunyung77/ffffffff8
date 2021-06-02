package com.example.ffffffff8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Room> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); //아이디 연결
        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); //Room 객체를 담을 어레이 리스트 (어댑터쪽으로)

        database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("Room"); //DB 테이블 연결결 , 실제 realTime DB에 있는 Room 데이터를 연동한거임 (액티비티 Room을 연동한게 아님)
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            //@org.jetbrains.annotations.NotNull
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); //기존 배열리스트가 존재하지 않게 초기화. 에러방지차원
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { //반목문으로 데이터 List를 추출해냄
                    Room room = snapshot.getValue(Room.class); //만들어뒀던 Room 객체에 데이터를 담는다.
                    arrayList.add(room); //담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); //리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던중 에러 발생 시 //사실 이부분은 입력 안해도 오늘 구현하는데에 있어서는 큰 문제가 생기지는 않음.
                Log.e("MainActivity", String.valueOf(databaseError.toException())); //에러문 출력

            }
        });

        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter); //리사이클러뷰에 어댑터 연결

    }
}
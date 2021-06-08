package com.example.ffffffff8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomOpen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_open);


        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomOpen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
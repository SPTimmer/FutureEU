package com.example.futureeu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

public class MyNotificationsConversations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int mnc = this.getIntent().getExtras().getInt("mnc");
        setContentView(R.layout.activity_my_notifications_conversations);

        if(mnc == 0){
            loadMyNotifications();
        }else if(mnc == 1){
            loadConversations();
        }
    }

    void loadMyNotifications(){
        TextView text = findViewById(R.id.mncTitle);
        text.setText(R.string.my_notifications);
        getSupportActionBar().setTitle(R.string.my_notifications);
    }

    void loadConversations(){
        TextView text = findViewById(R.id.mncTitle);
        text.setText(R.string.conversations);
        getSupportActionBar().setTitle(R.string.conversations);
    }
}
package com.example.futureeu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.futureeu.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.futureeu.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter =
                new SectionsPagerAdapter(this, getSupportFragmentManager());

        getSupportActionBar().setTitle("FutureEU");

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        addOnClickListenerToFabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // We are using switch case because multiple icons can be kept
        switch (item.getItemId()) {
            case R.id.accountButton:
                Intent intent;
                Boolean loggedIn = false;
                if(loggedIn){
                    intent = new Intent(context, AccountActivity.class);
                }else{
                    intent = new Intent(context, LoginActivity.class);
                }
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return super.onOptionsItemSelected(item);
    }

    public void addOnClickListenerToFabs(){
        View notificationsButton = findViewById(R.id.fabMyNotifications);
        if (notNull(notificationsButton)) {
            notificationsButton.setOnClickListener((View v) -> {
                Intent intent = new Intent(context, MyNotificationsConversations.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("mnc", 0);
                startActivity(intent);
            });
        }
        View conversationsButton = findViewById(R.id.fabConversations);
        if (notNull(conversationsButton)) {
            conversationsButton.setOnClickListener((View v) -> {
                Intent intent = new Intent(context, MyNotificationsConversations.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("mnc", 1);
                startActivity(intent);
            });
        }
    }

    public boolean notNull(Object obj){
        return obj != null;
    }
}
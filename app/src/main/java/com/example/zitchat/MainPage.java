package com.example.zitchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        FragmentManager fragmentManager = getSupportFragmentManager();

        Chats_Fragment list_fragment = new Chats_Fragment();
        Profile_fragment profile_fragment = new Profile_fragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, list_fragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_mail:
                        System.out.println("главная");
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, list_fragment).commit();
                        return true;
                    case R.id.action_profile:
                        System.out.println("Проф");
                        fragmentManager.beginTransaction().replace(R.id.fragment_container, profile_fragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
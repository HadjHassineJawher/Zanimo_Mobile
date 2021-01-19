package com.example.zanimo11.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zanimo11.R;
import com.example.zanimo11.UserManager.UserSessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final DrawerLayout dr = findViewById(R.id.drawerlayout);

        session = new UserSessionManager(getApplicationContext());

        // Check user login (this is the important point)
        // If User is not logged in , This will redirect user to LoginActivity
        // and finish current activity from activity stack.
        if (session.checkLogin())
            finish();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String id = user.get(UserSessionManager.KEY_ID);
        String mail = user.get(UserSessionManager.KEY_EMAIL);

        System.out.println("id user :" + id);

        BottomNavigationView botNavView = findViewById(R.id.bottom_navigation);
        botNavView.setSelectedItemId(R.id.btn_lost);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LostFragment()).commit();
        botNavView.setOnNavigationItemSelectedListener(navListener);

        findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr.openDrawer(GravityCompat.START);
            }
        });

        NavigationView nv = findViewById(R.id.sideBar);

        //set the shared prefeances attributes into the header of navigation view
        View header = nv.getHeaderView(0);
        TextView mailnv = (TextView) header.findViewById(R.id.mailUser);
        mailnv.setText(mail);
        nv.setNavigationItemSelectedListener(sidnavListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.btn_lost:
                            selectedFragment = new LostFragment();

                            break;
                        case R.id.btn_adopte:
                            selectedFragment = new AdopteFragment();

                            break;
                        case R.id.btn_found:
                            selectedFragment = new FoundFragment();

                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };


    private NavigationView.OnNavigationItemSelectedListener sidnavListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            DrawerLayout dr = findViewById(R.id.drawerlayout);

            switch (item.getItemId()) {
                case R.id.logoPost:
                    selectedFragment = new AddPostFragment();
                    dr.closeDrawers();

                    break;
                case R.id.logoInfoUser:
                    selectedFragment = new infoUserFragment();
                    dr.closeDrawers();
                case R.id.logoLogout:
                    session.logoutUser();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return false;
        }
    };

}



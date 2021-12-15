package com.java.iburger_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class Check_Activity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView naviV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_);
        drawer = findViewById(R.id.drawer);
        naviV = findViewById(R.id.navi_view);

        findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.END);
            }
        });
        naviV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                checkItemSelected(item);
                return false;
            }
        });
        findViewById(R.id.back_ic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Home_activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.ordernow_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (getApplicationContext(),Confirm_Activity.class);
                startActivity(in);
            }
        });
    }

    private void checkItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.profile_nav):
                Intent intent = new Intent(getApplicationContext(), Profile_Activity.class);
                startActivity(intent);
                finish();
                break;
            case (R.id.logout_nav):
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case (R.id.burger_nav):
                Intent intent2 = new Intent(getApplicationContext(), Burger_Activity.class);
                startActivity(intent2);
                finish();
                break;
            case (R.id.snaks_nav):
                Intent intent3 = new Intent(getApplicationContext(), Snaks_Activity.class);
                startActivity(intent3);
                finish();
                break;
            case (R.id.orders_nav):
                Intent intent4 = new Intent(getApplicationContext(), Orders_Activity.class);
                startActivity(intent4);
                finish();
                break;
            case (R.id.locations_nav):
                Intent intent5 = new Intent(getApplicationContext(), Location_Activity.class);
                startActivity(intent5);
                finish();
                break;

        }
    }
}
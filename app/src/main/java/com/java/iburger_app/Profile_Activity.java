package com.java.iburger_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Profile_Activity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView naviV;
    TextView loc;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        loc=(TextView) findViewById(R.id.locationIn);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        findViewById(R.id.locationIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });

        drawer = findViewById(R.id.drawer);
        naviV=findViewById(R.id.navi_view);
        findViewById(R.id.menu_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.END);
            }
        });
        findViewById(R.id.back_ic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Home_activity.class);
                startActivity(intent);
            }
        });

        naviV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                checkitemSelected(item);
                return false;
            }
        });
    }

    private void checkitemSelected(MenuItem item) {
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
                Intent intent3 = new Intent(getApplicationContext(),Snaks_Activity.class);
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
    void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Profile_Activity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();

                if(location!= null)
                {
                    try {
                        Geocoder geocoder = new Geocoder(Profile_Activity.this, Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        loc.setText(""+addresses.get(0).getCountryName()+ " , "+addresses.get(0).getLocality());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
    }
}
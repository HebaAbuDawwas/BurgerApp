package com.java.iburger_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Orders_Activity extends AppCompatActivity {
    DrawerLayout drawer;
    NavigationView naviV;
    GridView gridView;

    String [] itemsNames ={"Shawarma\n5JD","Buger\n6JD","Faheta\n4JD"} ;
    int [] icons={R.drawable.snaks,R.drawable.burger,R.drawable.snaks};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_);

        drawer = findViewById(R.id.drawer);
        naviV = findViewById(R.id.navi_view);






        gridView = findViewById(R.id.grid_burger);




        CustomAdapter customAdapter= new CustomAdapter() ;
        gridView.setAdapter(customAdapter);

        findViewById(R.id.back_ic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Home_activity.class);
                startActivity(intent);
            }
        });
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
        ImageView img = findViewById(R.id.tocheck);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Check_Activity.class);
                startActivity(i);
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
            case (R.id.locations_nav):
                Intent intent5 = new Intent(getApplicationContext(), Location_Activity.class);
                startActivity(intent5);
                finish();
                break;


        }
    }
    private class CustomAdapter extends BaseAdapter {


        int num = 0;

        @Override
        public int getCount() {
            return itemsNames.length;
        }

        @Override
        public Object getItem(int position) {

            return null;
        }

        @Override
        public long getItemId(int position) {


            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.orders_row_data, null);

            ImageView imageViewP = view.findViewById(R.id.plus);
            ImageView imageViewM = view.findViewById(R.id.minus);
            ImageView imageView = view.findViewById(R.id.itemDes);
           TextView textView = view.findViewById(R.id.item_name);
            imageView.setImageResource(icons[position]);
            TextView count = view.findViewById(R.id.num_view);
            textView.setText(itemsNames[position]);
            count.setText("0");

            imageViewP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    num = Integer.parseInt(count.getText().toString()) + 1;
                    count.setText(num + "");
                }
            });
            imageViewM.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (num > 0) {
                        num = Integer.parseInt(count.getText().toString()) - 1;
                        count.setText(num + "");
                    }

                    count.setText("0");
                }
            });


            return view;
        }
    }
}
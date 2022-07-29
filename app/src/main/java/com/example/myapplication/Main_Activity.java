package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout season = (LinearLayout) findViewById(R.id.LinearGra1_id);
        season.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this,season_Activity.class);
                startActivity(numbersIntent);

            }

        });

        LinearLayout ranking = (LinearLayout) findViewById(R.id.LinearGra3_id);
        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this,IccRankingActivity.class);
                startActivity(numbersIntent);

            }

        });


        bottomNavigationView=findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.seasons:
                        startActivity(new Intent(getApplicationContext(),season_Activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.live:
                        startActivity(new Intent(getApplicationContext(),LiveMatch_activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ranking:
                        startActivity(new Intent(getApplicationContext(),IccRankingActivity.class));
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });

        //Button season = (Button) findViewById(R.id.button3);
        //season.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Intent numbersIntent = new Intent(Main_Activity.this, season_Activity.class);
              //  startActivity(numbersIntent);

           // }
       // });
        /*Button Live = (Button) findViewById(R.id.button4);
        Live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this, LiveMatch_activity.class);
                startActivity(numbersIntent);

            }
        });
        Button Ranking = (Button) findViewById(R.id.Ranking);
        Ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Activity.this, IccRankingActivity.class);
                startActivity(intent);

            }
        });*/
        LinearLayout match = (LinearLayout) findViewById(R.id.LinearGra2_id);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Main_Activity.this,dummy.class);
                startActivity(numbersIntent);

            }

        });

    }
//    private void replacefragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.schedulefgrame,fragment);
//        fragmentTransaction.commit();
//
//    }
}


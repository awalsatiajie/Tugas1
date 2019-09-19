package com.awal.awalsatiaje.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.awal.awalsatiaje.tugas1.R;


public class Follower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);

        Button facebook=(Button)findViewById(R.id.btnfb);
        facebook.setOnClickListener((arg0) -> {
            Uri uri = Uri.parse("http://facebook.com/AS.AwalSatiajie");
            Intent i =new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        });

        Button instagram=(Button)findViewById(R.id.btnig);
        instagram.setOnClickListener((arg0) -> {
            Uri uri = Uri.parse("http://instagram.com/awal_satiajie");
            Intent i =new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        });

        Button twiitter=(Button)findViewById(R.id.btntwiiter);
        twiitter.setOnClickListener((arg0) -> {
            Uri uri = Uri.parse("http://twitter.com/SatiajieAwal");
            Intent i =new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        });
    }

    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(),MenuProgram.class);
        startActivity(i);
        finish();
    }
}

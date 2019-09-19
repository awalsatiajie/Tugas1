package com.awal.awalsatiaje.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.awal.awalsatiaje.tugas1.R;
import com.awal.awalsatiaje.tugas1.loginregister.LoginRegister;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bpage1=(Button)findViewById(R.id.btnMenu);
        bpage1.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),LoginRegister.class);
            startActivity(i);
            finish();
        });


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

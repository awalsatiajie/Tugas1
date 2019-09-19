package com.awal.awalsatiaje.tugas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.awal.awalsatiaje.tugas1.loginregister.LoginRegister;
import com.awal.awalsatiaje.tugas1.R;

public class MenuProgram extends AppCompatActivity {

    private long backpressedtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_program);

        Button btnProg1=(Button)findViewById(R.id.btn);
        btnProg1.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),ScrollingActivity.class);
            startActivity(i);
            finish();
        });

        Button btnProg2=(Button)findViewById(R.id.btn1);
        btnProg2.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),scrollGambarku.class);
            startActivity(i);
            finish();
        });

        Button btnProg3=(Button)findViewById(R.id.btn2);
        btnProg3.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),CalculatorAngka.class);
            startActivity(i);
            finish();
        });

        Button UTS=(Button)findViewById(R.id.btn3);
        UTS.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),Tabuts.class);
            startActivity(i);
            finish();
        });

        Button bebas=(Button)findViewById(R.id.btn4);
        bebas.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),hitungBMI.class);
            startActivity(i);
            finish();
        });

        Button follower=(Button)findViewById(R.id.btn5);
        follower.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),Follower.class);
            startActivity(i);
            finish();
        });

        Button crud=(Button)findViewById(R.id.btn6);
        crud.setOnClickListener((arg0) -> {
            Intent i =new Intent(getApplicationContext(),MenuCrud.class);
            startActivity(i);
            finish();
        });

        Button game=(Button)findViewById(R.id.btn7);
        game.setOnClickListener((arg0 -> {
            Intent i =new Intent(getApplicationContext(),Menu.class);
            startActivity(i);
            finish();
        }));

        Button logout=(Button)findViewById(R.id.btn8);
        logout.setOnClickListener((arg0 -> {
            Intent i =new Intent(getApplicationContext(),LoginRegister.class);
            startActivity(i);
            finish();
        }));
    }

    @Override
    public void onBackPressed() {
        //Intent intent = new Intent(MainActivity.this, NextActivity.class);
        //startActivity(intent);
        Toast.makeText(getApplicationContext(), "Logout Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

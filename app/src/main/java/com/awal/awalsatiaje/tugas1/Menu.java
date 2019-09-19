package com.awal.awalsatiaje.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.awal.awalsatiaje.tugas1.R;

public class Menu extends AppCompatActivity {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button1 = (Button) findViewById(R.id.btneasy);
        button2 = (Button) findViewById(R.id.btnNormal);
        button3 = (Button) findViewById(R.id.btnHard);

        button1.setOnClickListener((arg0 -> {
            Intent i =new Intent(getApplicationContext(),Easy.class);
            startActivity(i);
        }));

        button2.setOnClickListener((arg0 -> {
            Intent i = new Intent(getApplicationContext(),Normal.class);
            startActivity(i);
        }));

        button3.setOnClickListener((arg0 -> {
            Intent i = new Intent(getApplicationContext(),Hard.class);
            startActivity(i);
        }));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu.this, MenuProgram.class);
        startActivity(intent);
        finish();
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

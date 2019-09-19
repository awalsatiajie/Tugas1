package com.awal.awalsatiaje.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.awal.awalsatiaje.tugas1.R;

public class Won extends Activity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        tv = (TextView) findViewById(R.id.congo);
        Bundle b = getIntent().getExtras();
        int y = b.getInt("score");
        tv.setText("FINAL SCORE:" + y);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Won.this, Menu.class);
        startActivity(intent);
        finish();
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

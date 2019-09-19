package com.awal.awalsatiaje.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.widget.TextView;

import com.awal.awalsatiaje.tugas1.R;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = (TextView) findViewById(R.id.txtPoint);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");

        textResult.setText("Point Kamu Adalah " + " " + score);
    }

    public void playagain(View o) {

        Intent intent = new Intent(this, Menu.class);

        startActivity(intent);

        finish();


    }
}

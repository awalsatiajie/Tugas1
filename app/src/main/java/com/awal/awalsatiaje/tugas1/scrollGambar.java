package com.awal.awalsatiaje.tugas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.awal.awalsatiaje.tugas1.R;

public class scrollGambar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_gambar);
    }

    public void onBackPressed(){
        Intent i =new Intent(getApplicationContext(),MenuProgram.class);
        startActivity(i);
        finish();
    }
}

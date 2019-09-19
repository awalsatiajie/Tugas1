package com.awal.awalsatiaje.tugas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.awal.awalsatiaje.tugas1.biodatapegawai.DaftarBiodataPegawai;
import com.awal.awalsatiaje.tugas1.loginregister.DaftarUser;
import com.awal.awalsatiaje.tugas1.R;

public class MenuCrud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_crud);

        Button btnTambahGaji = (Button) findViewById(R.id.btnTambahPegawai);
        btnTambahGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TambahPegawai.class);
                startActivity(i);
                finish();
            }
        });

        Button btnLihatGaji = (Button) findViewById(R.id.btnLihatPegawai);
        btnLihatGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ViewAllPegawai.class);
                startActivity(i);
                finish();
            }
        });

        Button btnTambahData = (Button) findViewById(R.id.btnBiodataPegawai);
        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DaftarBiodataPegawai.class);
                startActivity(i);
                finish();
            }
        });

        Button btnDaftarUser = (Button) findViewById(R.id.btnUser);
        btnDaftarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DaftarUser.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MenuCrud.this, MenuProgram.class);
        startActivity(intent);
        finish();
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

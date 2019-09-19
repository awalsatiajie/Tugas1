package com.awal.awalsatiaje.tugas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.awal.awalsatiaje.tugas1.R;

public class hitungBMI extends AppCompatActivity {

    hitungnya hitungBMI = new hitungnya();

    EditText txtBeratBadan, txtTinggibadan;
    TextView txtStatusBadan;
    Button btnCekBMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_bmi);

        txtBeratBadan = findViewById(R.id.txtBeratBadan);
        txtTinggibadan = findViewById(R.id.txtTinggiBadan);
        txtStatusBadan = findViewById(R.id.txtStatusBadan);
        btnCekBMI = findViewById(R.id.btnCekBMI);

        btnCekBMI.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String stringBeratBadan = txtBeratBadan.getText().toString();
                String stringTinggiBadan = txtTinggibadan.getText().toString();

                double beratBadan = Double.parseDouble(stringBeratBadan);
                double tinggiBadan = Double.parseDouble(stringTinggiBadan);

                String statusBadan = hitungBMI.hitungBMI(beratBadan, tinggiBadan);
                txtStatusBadan.setText(statusBadan);
            }
        });
    }

    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(),MenuProgram.class);
        startActivity(i);
        finish();
    }
}

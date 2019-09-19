package com.awal.awalsatiaje.tugas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;
import com.awal.awalsatiaje.tugas1.R;

public class CalculatorAngka extends AppCompatActivity {

    EditText angkaSatu, angkaDua;
    Button hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_angka);
        angkaSatu = (EditText) findViewById(R.id.txtAngka1);
        angkaDua = (EditText) findViewById(R.id.txtAngka2);
        hitung = (Button) findViewById(R.id.btnHitung);
        hasil = (TextView) findViewById(R.id.txtHasil);
        hitung.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(angkaSatu.length() == 0 && angkaDua.length() == 0) {
                    Toast.makeText(getApplication(), "Angka Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                else if (angkaSatu.length() == 0) {
                    Toast.makeText(getApplication(), "Angka 1 Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                else if (angkaDua.length() == 0) {
                    Toast.makeText(getApplication(), "Angka 2 Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String isiAngka1 = angkaSatu.getText().toString();
                    String isiAngka2 = angkaDua.getText().toString();
                    double A1 = Double.parseDouble(isiAngka1);
                    double A2 = Double.parseDouble(isiAngka2);
                    double hs = hitungJumlah(A1, A2);
                    String output = String.valueOf(hs);
                    hasil.setText(output.toString());

                }
            }
        });
    }

    public double hitungJumlah (double Angka1, double Angka2) {
        return Angka1 + Angka2;
    }

    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(),MenuProgram.class);
        startActivity(i);
        finish();
    }
}

package com.awal.awalsatiaje.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.awal.awalsatiaje.tugas1.R;

public class Login extends AppCompatActivity {

    Button btn1;
    EditText txtuser,txtpass;
    TextView txt1;
    int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1=(Button)findViewById(R.id.btnLogin);
        txtuser=(EditText) findViewById(R.id.txtUsername);
        txtpass=(EditText)findViewById(R.id.txtPass);
        txt1=(TextView)findViewById(R.id.labeltigakali);

        txt1.setVisibility(View.GONE);
        btn1.setOnClickListener((v)-> {
            if (txtuser.getText().toString().equals("Admin") &&
                    txtpass.getText().toString().equals("Admin")){
                    Intent i =new Intent(getApplicationContext(),MenuProgram.class);
                    startActivity(i);
                //Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
                txt1.setVisibility(View.VISIBLE);
                txt1.setBackgroundColor(Color.RED);
                counter--;
                txt1.setText(Integer.toString(counter));

                if (counter == 0 ){
                    btn1.setEnabled(false);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

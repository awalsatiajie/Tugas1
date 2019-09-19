package com.awal.awalsatiaje.tugas1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import com.awal.awalsatiaje.tugas1.R;

public class TambahPegawai extends AppCompatActivity implements View.OnClickListener {

    //Defining views
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;
    private EditText editTextId;

    private Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pegawai);

        //Initializing views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSal = (EditText) findViewById(R.id.editTextSalary);
        editTextId = (EditText) findViewById(R.id.editTextId);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
    }

    //Adding an employee
    private void addEmployee(){

        final String id = editTextId.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String desg = editTextDesg.getText().toString().trim();
        final String sal = editTextSal.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading = ProgressDialog.show(TambahPegawai.this,"Adding...","Wait...",false,false);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahPegawai.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_ID,id);
                params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_DESG,desg);
                params.put(Config.KEY_EMP_SAL,sal);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    public void kosong(){
        editTextId.setText("");
        editTextName.setText("");
        editTextDesg.setText("");
        editTextSal.setText("");
    }

    @Override
    public void onClick(View v) {

        if(v == buttonAdd){
            addEmployee();
            kosong();
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TambahPegawai.this, MenuCrud.class);
        startActivity(intent);
        finish();
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

package com.awal.awalsatiaje.tugas1.biodatapegawai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.awal.awalsatiaje.tugas1.R;

public class TambahBiodata extends AppCompatActivity {

    EditText txt_id , txt_nik, txt_name, txt_jenkel, txt_ttl, txt_status, txt_agama, txt_alamat, txt_nohp, txt_email;;
    Button btn_submit, btn_cancel;
    DbHelper SQLite = new DbHelper(this);
    String id, nik, name, jenkel, ttl, status, agama, alamat, nohp, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_biodata);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_id = (EditText) findViewById(R.id.txt_id);
        txt_nik = (EditText) findViewById(R.id.txt_nik);
        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_jenkel = (EditText) findViewById(R.id.txt_jenkel);
        txt_ttl = (EditText) findViewById(R.id.txt_ttl);
        txt_status = (EditText) findViewById(R.id.txt_status);
        txt_agama = (EditText) findViewById(R.id.txt_agama);
        txt_alamat = (EditText) findViewById(R.id.txt_alamat);
        txt_nohp = (EditText) findViewById(R.id.txt_nohp);
        txt_email = (EditText) findViewById(R.id.txt_email);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        id = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_ID);
        nik = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_NIK);
        name = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_NAME);
        jenkel = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_JENKEL);
        ttl = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_TTL);
        status = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_STATUS);
        agama = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_AGAMA);
        alamat = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_ALAMAT);
        nohp = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_NOHP);
        email = getIntent().getStringExtra(DaftarBiodataPegawai.TAG_EMAIL);


        if (id == null || id == "") {
            setTitle("Tambah Data Karyawan");
        } else {
            setTitle("Edit Data Karyawan");
            txt_id.setText(id);
            txt_nik.setText(nik);
            txt_nik.setEnabled(false);
            txt_name.setText(name);
            txt_jenkel.setText(jenkel);
            txt_ttl.setText(ttl);
            txt_status.setText(status);
            txt_agama.setText(agama);
            txt_alamat.setText(alamat);
            txt_nohp.setText(nohp);
            txt_email.setText(email);
        }

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txt_id.getText().toString().equals("")) {
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e){
                    Log.e("Submit", e.toString());
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blank();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void blank() {
        txt_name.requestFocus();
        txt_id.setText(null);
        txt_nik.setText(null);
        txt_name.setText(null);
        txt_jenkel.setText(null);
        txt_ttl.setText(null);
        txt_status.setText(null);
        txt_agama.setText(null);
        txt_alamat.setText(null);
        txt_nohp.setText(null);
        txt_email.setText(null);
    }

    private void save() {
        if (String.valueOf(txt_nik.getText()).equals(null) || String.valueOf(txt_nik.getText()).equals("") ||
                String.valueOf(txt_name.getText()).equals(null) || String.valueOf(txt_name.getText()).equals("") ||
                String.valueOf(txt_jenkel.getText()).equals(null) || String.valueOf(txt_jenkel.getText()).equals("") ||
                String.valueOf(txt_ttl.getText()).equals(null) || String.valueOf(txt_ttl.getText()).equals("") ||
                String.valueOf(txt_status.getText()).equals(null) || String.valueOf(txt_status.getText()).equals("") ||
                String.valueOf(txt_agama.getText()).equals(null) || String.valueOf(txt_agama.getText()).equals("") ||
                String.valueOf(txt_alamat.getText()).equals(null) || String.valueOf(txt_alamat.getText()).equals("") ||
                String.valueOf(txt_nohp.getText()).equals(null) || String.valueOf(txt_nohp.getText()).equals("") ||
                String.valueOf(txt_email.getText()).equals(null) || String.valueOf(txt_email.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Kolom Isian Tidak Boleh Kosong ...", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.insert(txt_nik.getText().toString().trim(),
                    txt_name.getText().toString().trim(),
                    txt_jenkel.getText().toString().trim(),
                    txt_ttl.getText().toString().trim(),
                    txt_status.getText().toString().trim(),
                    txt_agama.getText().toString().trim(),
                    txt_alamat.getText().toString().trim(),
                    txt_nohp.getText().toString().trim(),
                    txt_email.getText().toString().trim());
            blank();
            Toast.makeText(getApplicationContext(), "Data Berhasil Di Simpan", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void edit() {
        if (String.valueOf(txt_name.getText()).equals(null) || String.valueOf(txt_name.getText()).equals("") ||
                String.valueOf(txt_jenkel.getText()).equals(null) || String.valueOf(txt_jenkel.getText()).equals("") ||
                String.valueOf(txt_ttl.getText()).equals(null) || String.valueOf(txt_ttl.getText()).equals("") ||
                String.valueOf(txt_status.getText()).equals(null) || String.valueOf(txt_status.getText()).equals("") ||
                String.valueOf(txt_agama.getText()).equals(null) || String.valueOf(txt_agama.getText()).equals("") ||
                String.valueOf(txt_alamat.getText()).equals(null) || String.valueOf(txt_alamat.getText()).equals("") ||
                String.valueOf(txt_nohp.getText()).equals(null) || String.valueOf(txt_nohp.getText()).equals("") ||
                String.valueOf(txt_email.getText()).equals(null) || String.valueOf(txt_email.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Kolom Isian Tidak Boleh Kosong ...", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.update(Integer.parseInt(txt_id.getText().toString().trim()), txt_nik.getText().toString().trim(), txt_name.getText().toString().trim(),
                    txt_jenkel.getText().toString().trim(),
                    txt_ttl.getText().toString().trim(),
                    txt_status.getText().toString().trim(),
                    txt_agama.getText().toString().trim(),
                    txt_alamat.getText().toString().trim(),
                    txt_nohp.getText().toString().trim(),
                    txt_email.getText().toString().trim());
            blank();
            Toast.makeText(getApplicationContext(), "Data Berhasil Di Update", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

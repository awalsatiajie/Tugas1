package com.awal.awalsatiaje.tugas1.biodatapegawai;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.awal.awalsatiaje.tugas1.MenuCrud;
import com.awal.awalsatiaje.tugas1.R;

public class DaftarBiodataPegawai extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    DbHelper SQLite = new DbHelper(this);

    public static final String TAG_ID = "id";
    public static final String TAG_NIK = "nik";
    public static final String TAG_NAME = "name";
    public static final String TAG_JENKEL = "jenkel";
    public static final String TAG_TTL = "ttl";
    public static final String TAG_STATUS = "status";
    public static final String TAG_AGAMA = "agama";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_NOHP = "nohp";
    public static final String TAG_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_biodata_pegawai);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLite = new DbHelper(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.list_view);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarBiodataPegawai.this, TambahBiodata.class);
                startActivity(intent);
            }
        });

        adapter = new Adapter(DaftarBiodataPegawai.this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,
                                           final int position, long id) {
                // TODO Auto-generated method stub
                final String idx = itemList.get(position).getId();
                final String nik = itemList.get(position).getNik();
                final String name = itemList.get(position).getName();
                final String jenkel = itemList.get(position).getJenkel();
                final String ttl = itemList.get(position).getTtl();
                final String status = itemList.get(position).getStatus();
                final String agama = itemList.get(position).getAgama();
                final String alamat = itemList.get(position).getAlamat();
                final String nohp = itemList.get(position).getNohp();
                final String email = itemList.get(position).getEmail();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(DaftarBiodataPegawai.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(DaftarBiodataPegawai.this, TambahBiodata.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_NIK, nik);
                                intent.putExtra(TAG_NAME, name);
                                intent.putExtra(TAG_JENKEL, jenkel);
                                intent.putExtra(TAG_TTL, ttl);
                                intent.putExtra(TAG_STATUS, status);
                                intent.putExtra(TAG_AGAMA, agama);
                                intent.putExtra(TAG_ALAMAT, alamat);
                                intent.putExtra(TAG_NOHP, nohp);
                                intent.putExtra(TAG_EMAIL, email);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                getAllData();
                                Toast.makeText(getApplicationContext(), "Data Berhasil Di Delete", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });

        getAllData();
    }

    private void getAllData() {
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String nik = row.get(i).get(TAG_NIK);
            String name = row.get(i).get(TAG_NAME);
            String jenkel = row.get(i).get(TAG_JENKEL);
            String ttl = row.get(i).get(TAG_TTL);
            String status = row.get(i).get(TAG_STATUS);
            String agama = row.get(i).get(TAG_AGAMA);
            String alamat = row.get(i).get(TAG_ALAMAT);
            String nohp = row.get(i).get(TAG_NOHP);
            String email = row.get(i).get(TAG_EMAIL);

            Data data = new Data();

            data.setId(id);
            data.setNik(nik);
            data.setName(name);
            data.setJenkel(jenkel);
            data.setTtl(ttl);
            data.setStatus(status);
            data.setAgama(agama);
            data.setAlamat(alamat);
            data.setNohp(nohp);
            data.setEmail(email);

            itemList.add(data);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DaftarBiodataPegawai.this, MenuCrud.class);
        startActivity(intent);
        finish();
        //Toast.makeText(getApplicationContext(), "Klick Tombol Menu Untuk Kembali", Toast.LENGTH_SHORT).show();
        //finish();
    }
}

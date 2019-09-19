package com.awal.awalsatiaje.tugas1.biodatapegawai;

public class Data {
    private String id, nik, name, jenkel, ttl, status, agama, alamat, nohp, email;

    public Data() {
    }

    public Data(String id, String nik, String name, String jenkel, String ttl, String status, String agama, String alamat, String nohp, String email) {
        this.id = id;
        this.nik = nik;
        this.name = name;
        this.jenkel = jenkel;
        this.ttl = ttl;
        this.status = status;
        this.agama = agama;
        this.alamat = alamat;
        this.nohp = nohp;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

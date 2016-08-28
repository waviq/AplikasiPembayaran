package com.mastahcode.waviq.pembayaran.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by waviq on 28/08/2016.
 */
public class Tagihan {

    //yang akan ditampilkan dalam ListView

    private String namaProduk;
    private String nomerPelanggan;
    private String namaPelanggan;
    private Date bulanTagihan;
    private Date jatuhTempo;
    private BigDecimal nilai;

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getNomerPelanggan() {
        return nomerPelanggan;
    }

    public void setNomerPelanggan(String nomerPelanggan) {
        this.nomerPelanggan = nomerPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Date getBulanTagihan() {
        return bulanTagihan;
    }

    public void setBulanTagihan(Date bulanTagihan) {
        this.bulanTagihan = bulanTagihan;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}

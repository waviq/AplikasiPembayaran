package com.mastahcode.waviq.pembayaran.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by waviq on 28/08/2016.
 */
public class PembayaranDbHelper extends SQLiteOpenHelper {


    //SQL create Tabel Tagihan
    private static final String SQL_CREATE_TAGIHAN = " create table " + SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME + "(" +
            SkemaDatabasePembayaran.TabelTagihan._ID + "INTEGER PRIMARY KEY, " +
            SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_PRODUK + " TEXT, " +
            SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NOMOR_PELANGGAN + " TEXT, " +
            SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PELANGGAN + " TEXT, " +
            SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN + " TEXT, " +
            SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO + " TEXT, " +
            SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NILAI + " REAL " +
            ")";

    //SQL Hapus Table tagihan
    private static final String SQL_DROP_TAGIHAN
            = "drop table if exists " + SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME;

    public PembayaranDbHelper(Context context) {
        super(context, SkemaDatabasePembayaran.DATABASE_NAME, null, SkemaDatabasePembayaran.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TAGIHAN);
    }

    //Method untuk melakukan aktifitas ketika aplikasi kenapa2, bisa d re instal,
    // atau method untuk menjalankan perintah-perintah tertentu
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_TAGIHAN);
        onCreate(db);
    }
}

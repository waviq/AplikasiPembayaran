package com.mastahcode.waviq.pembayaran.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mastahcode.waviq.pembayaran.domain.Tagihan;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waviq on 28/08/2016.
 */
public class TagihanDao {

    private static final String TAG = "DB_TAG";
    private Context context;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public TagihanDao(Context ctx) {
        this.context = ctx;
    }

    public void insertTagihan(Tagihan t) {
        PembayaranDbHelper dbHelper = new PembayaranDbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //data yang mau di insert, menggunakan ContentValues
        ContentValues cv = new ContentValues();
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_PRODUK, t.getNamaProduk());
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NOMOR_PELANGGAN, t.getNomerPelanggan());
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PELANGGAN, t.getNamaPelanggan());
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN, formatter.format(t.getBulanTagihan()));
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO, formatter.format(t.getJatuhTempo()));
        //Pakai double value karena sqlite gak support bidDecimal, makanya mesti di convert dlo k doubleValue
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN, t.getNilai().doubleValue());

        db.insert(SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME, null, cv);
    }

    public List<Tagihan> semuaTagihan() {
        List<Tagihan> dataTagihan = new ArrayList<>();

        PembayaranDbHelper dbHelper = new PembayaranDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] daftarKolom = {
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_PRODUK,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NOMOR_PELANGGAN,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PELANGGAN,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NILAI
        };

        //urutan Tampilan Tagihan yang keluar berdasarkan yang pling deket dg Jatuh tempo
        String urutan = SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO
                + " ASC";
        Cursor c = db.query(SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME,
                daftarKolom, null, null, null, null, urutan);

        //Jika ada datanya, maka kita looping tampilkan datanya
        if (c.moveToFirst()) {
            while (c.moveToNext()) {
                Tagihan t = new Tagihan();
                t.setNamaProduk(c.getString(0));
                t.setNomerPelanggan(c.getString(1));
                t.setNamaPelanggan(c.getString(2));
                try {
                    t.setBulanTagihan(formatter.parse(c.getString(3)));
                    t.setJatuhTempo(formatter.parse(c.getString(4)));
                } catch (ParseException e) {
                    Log.w(TAG, e.getMessage());
                }
                t.setNilai(new BigDecimal(c.getDouble(5)));
                dataTagihan.add(t);
            }

            c.close();
        }
        return dataTagihan;


        /*Tagihan t1 = new Tagihan();
        t1.setNamaProduk("PLN Pasca Bayar");
        t1.setNomerPelanggan("2323423423");
        t1.setNamaPelanggan("Waviq Subhi");
        t1.setNilai(new BigDecimal("100000.00"));
        try {
            t1.setBulanTagihan(formatter.parse("2016-08-01"));
            t1.setJatuhTempo(formatter.parse("2016-01-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dataTagihan.add(t1);

        Tagihan t2 = new Tagihan();
        t2.setNamaProduk("Telkom");
        t2.setNomerPelanggan("4235345345");
        t2.setNamaPelanggan("Samsul Faruq");
        t2.setNilai(new BigDecimal("250000.00"));
        try {
            t2.setBulanTagihan(formatter.parse("2016-08-24"));
            t2.setJatuhTempo(formatter.parse("2016-08-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dataTagihan.add(t2);

        Tagihan t3 = new Tagihan();
        t3.setNamaProduk("Speedy");
        t3.setNomerPelanggan("23453434");
        t3.setNamaPelanggan("Fatikhatul Baruni");
        t3.setNilai(new BigDecimal("90000.00"));
        try {
            t3.setBulanTagihan(formatter.parse("2016-08-24"));
            t3.setJatuhTempo(formatter.parse("2016-08-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dataTagihan.add(t3);

        return dataTagihan;*/

    }
}

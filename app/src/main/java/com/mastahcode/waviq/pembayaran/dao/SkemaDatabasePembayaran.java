package com.mastahcode.waviq.pembayaran.dao;

import android.provider.BaseColumns;

/**
 * Created by waviq on 28/08/2016.
 */
public final class SkemaDatabasePembayaran {

    public static final String DATABASE_NAME = "Pembayaran.db";
    public static final int DATABASE_VERSION = 1;


    //Dilarang menginstantkan, atau
    //tidak bisa di panggil class ini
    private SkemaDatabasePembayaran() {

    }

    // Skema Tabel Tagihan
    public abstract class TabelTagihan implements BaseColumns {
        public static final String TABLE_NAME = "tagihan";
        public static final String COLUMN_NAME_TAGIHAN_ID = "tagihan_id";
        public static final String COLUMN_NAME_PRODUK = "produk";
        public static final String COLUMN_NAME_NOMOR_PELANGGAN = "no_pelanggan";
        public static final String COLUMN_NAME_NAMA_PELANGGAN = "nama_pelanggan";
        public static final String COLUMN_NAME_BULAN_TAGIHAN = "bulan_tagihan";
        public static final String COLUMN_NAME_JATUH_TEMPO = "jatuh_tempo";
        public static final String COLUMN_NAME_NILAI = "nilai";
    }
}

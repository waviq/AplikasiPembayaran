package com.mastahcode.waviq.pembayaran;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by waviq on 29/08/2016.
 * Class untuk supaya kita bisa memanage SQLite kita, via stetho app dr facebook
 * <p/>
 * class StethoAplikasiManageDb perlu di panggil di file AndroidManifest,
 * supaya d jalanin clas aplikasinya
 */
public class StethoAplikasiManageDb extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}

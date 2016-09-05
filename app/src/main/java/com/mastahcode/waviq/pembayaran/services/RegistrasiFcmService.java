package com.mastahcode.waviq.pembayaran.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.mastahcode.waviq.pembayaran.R;
import com.mastahcode.waviq.pembayaran.restclient.PembayaranClient;

import java.io.IOException;

/**
 * Created by waviq on 3/09/2016.
 *
 */
public class RegistrasiFcmService extends IntentService {

    private static final String TAG ="RegIntentService";

    public RegistrasiFcmService(){
        super(TAG);

    }
    @Override
    protected void onHandleIntent(Intent intent) {
        //FirebaseInstanceId instanceId = FirebaseInstanceId.getInstance(FirebaseApp.zzek(this));
        String token = null;

        try {
            Log.d(TAG, "Memulai registrasi FCM");
            token = FirebaseInstanceId.getInstance().getToken();
            String email = intent.getStringExtra("email");
            registrasiTokenKeServer(email, token);
        }catch (Exception e){
            Log.e(TAG, "FCM registrasi gagal : "+e.getMessage());
        }
        Log.i(TAG, "FCM Registrasi token: "+token);
    }

    private void registrasiTokenKeServer(String email, String token){
        PembayaranClient p = new PembayaranClient();
        Log.d(TAG,"Mendaftarkan token ke server");
        p.registrasiToken(email, token);
        Log.d(TAG, "Pendaftaran token sukses");
    }
}

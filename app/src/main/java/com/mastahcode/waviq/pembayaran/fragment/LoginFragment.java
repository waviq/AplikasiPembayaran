package com.mastahcode.waviq.pembayaran.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mastahcode.waviq.pembayaran.R;
import com.mastahcode.waviq.pembayaran.activity.SeteahLoginActivity;
import com.mastahcode.waviq.pembayaran.exceptions.GagalLoginException;
import com.mastahcode.waviq.pembayaran.restclient.PembayaranClient;

/**
 * Created by waviq s on 25/08/2016.
 *
 */
public class LoginFragment extends Fragment {

    private PembayaranClient pembayaranClient = new PembayaranClient();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View fragmentView = inflater.inflate(R.layout.fr_login, container, false);

        final Button btnLogin = (Button) fragmentView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //semua inputan harus di convert ke string
                String username = ((EditText) fragmentView.findViewById(R.id.etEmailLogin)).getText().toString();
                String password = ((EditText) fragmentView.findViewById(R.id.etPasswordLogin)).getText().toString();

                //proses thread
                //untuk cek berhasil login atau tidaknya, kita return jd tipe data Boolean ketika sukses
                new AsyncTask<String, Void, Boolean>() {

                    ProgressDialog progressDialog;

                    //variabel penampung jika ada error, nantinya bisa di pakai dimanapun jika diperlukan
                    String errorMessage;
                    String email;

                    //method yang akan dijalankan, sebelum menjalankan doInbackground
                    @Override
                    protected void onPreExecute() {
                        progressDialog = ProgressDialog.show(getContext(), "Login", "Tunggu bro sabar", true);
                        btnLogin.setEnabled(false);
                    }

                    @Override
                    protected Boolean doInBackground(String... params) {
                        try {

                            email = params[0];
                            //param[0] = ambil username
                            //param[1] =  ambil password
                            pembayaranClient.login(params[0], params[1]);
                            return true;
                        } catch (GagalLoginException e) {
                            errorMessage = e.getMessage();
                            return false;
                        }
                    }

                    @Override
                    //method yang dilakukan ketika mengirim ke server
                    protected void onPostExecute(Boolean sukses) {

                        //button di enable kembali ketika proses login selesai
                        btnLogin.setEnabled(true);
                        //dismis kita hilangkan
                        progressDialog.dismiss();
                        if (sukses) {
                            //explisit intent (karena sudah jelas akan menjalankan activity yg mana)
                            Intent setelahLoginActivity = new Intent(getContext(), SeteahLoginActivity.class);
                            setelahLoginActivity.putExtra("email", email);
                            startActivity(setelahLoginActivity);
                        } else {
                            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
                        }
                    }

                    //username dan password di dalam parameter excecute, didefinisikan sebagai param ke 0 = username
                    //dan param ke 1 = password
                }.execute(username, password);

            }
        });
        return fragmentView;
    }
}

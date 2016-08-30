package com.mastahcode.waviq.pembayaran.fragment;

import android.content.Intent;
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

        Button btnLogin = (Button) fragmentView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //semua inputan harus di convert ke string
                String username = ((EditText) fragmentView.findViewById(R.id.etEmailLogin)).getText().toString();
                String password = ((EditText) fragmentView.findViewById(R.id.etPasswordLogin)).getText().toString();

                try {
                    pembayaranClient.login(username, password);

                    //explisit intent (karena sudah jelas akan menjalankan activity yg mana)
                    Intent setelahLoginActivity = new Intent(getContext(), SeteahLoginActivity.class);
                    startActivity(setelahLoginActivity);
                } catch (GagalLoginException e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT);
                }


            }
        });
        return fragmentView;
    }
}

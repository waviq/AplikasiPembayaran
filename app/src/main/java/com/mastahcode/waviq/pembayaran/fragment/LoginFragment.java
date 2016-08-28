package com.mastahcode.waviq.pembayaran.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mastahcode.waviq.pembayaran.R;
import com.mastahcode.waviq.pembayaran.activity.SeteahLoginActivity;

/**
 * Created by waviq s on 25/08/2016.
 */
public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fr_login, container, false);

        Button btnLogin = (Button) fragmentView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //explisit intent (karena sudah jelas akan menjalankan activity yg mana)
                Intent setelahLoginActivity = new Intent(getContext(), SeteahLoginActivity.class);
                startActivity(setelahLoginActivity);
            }
        });
        return fragmentView;
    }
}

package com.mastahcode.waviq.pembayaran.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mastahcode.waviq.pembayaran.R;

/**
 * Created by waviq s on 25/08/2016.
 */
public class CekTagihanFragment  extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fr_cek_tagihan,container, false);

        //load dolo xmlnya menjadi view (inflate), baru kita bisa cari buttonnya dalam view tersebut
        Button btnCekTagihan = (Button) fragmentView.findViewById(R.id.btnCekTagihan);
        btnCekTagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil fragment dari activitynya, supaya bisa minta support fragmen manager ke activitynya
                FragmentTransaction ft = CekTagihanFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction();

                ft.replace(R.id.fragment_sebelum_login, new HasilTagihanFragment());
                ft.commit();
            }
        });
        return fragmentView;


    }
}

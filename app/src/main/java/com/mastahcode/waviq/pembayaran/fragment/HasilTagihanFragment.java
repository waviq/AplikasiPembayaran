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
 * Created by waviq on 26/08/2016.
 */
public class HasilTagihanFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //code back to fragment hasil tagihan
        View fragmentView = inflater.inflate(R.layout.fr_hasil_tagihan, container, false);

        Button btnBackHasilTagihan = (Button) fragmentView.findViewById(R.id.btnBackHasilTagihan);
        btnBackHasilTagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = HasilTagihanFragment.this.getActivity().getSupportFragmentManager()
                        .beginTransaction();

                ft.replace(R.id.fragment_sebelum_login, new CekTagihanFragment());
                ft.commit();
            }
        });

        return fragmentView;
    }
}

package com.mastahcode.waviq.pembayaran.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mastahcode.waviq.pembayaran.R;

/**
 * Created by waviq s on 25/08/2016.
 */
public class CekTagihanFragment  extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_cek_tagihan, container, false);


    }
}

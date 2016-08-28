package com.mastahcode.waviq.pembayaran.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mastahcode.waviq.pembayaran.R;
import com.mastahcode.waviq.pembayaran.adapter.TagihanAdapter;
import com.mastahcode.waviq.pembayaran.dao.TagihanDao;

/**
 * Created by waviq on 28/08/2016.
 */
public class DashboardFragment extends Fragment {

    /*private TagihanDao tagihanDao;

    public DashboardFragment (){
        tagihanDao = new TagihanDao(getContext());
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //instant TagihanDao
        TagihanDao tagihanDao = new TagihanDao(getContext());

        View fragmentView = inflater.inflate(R.layout.fr_dashboard, container, false);

        ListView lvTagihan = (ListView) fragmentView.findViewById(R.id.lvTagihan);
        lvTagihan.setAdapter(new TagihanAdapter(getContext(), R.layout.lv_daftar_tagihan, tagihanDao.semuaTagihan()));

        return fragmentView;
    }
}

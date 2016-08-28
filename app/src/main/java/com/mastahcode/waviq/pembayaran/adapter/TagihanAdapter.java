package com.mastahcode.waviq.pembayaran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mastahcode.waviq.pembayaran.R;
import com.mastahcode.waviq.pembayaran.domain.Tagihan;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by waviq on 28/08/2016.
 * <p/>
 * class Tagihan Adapter akan di pakai di DashboardFragment
 */
public class TagihanAdapter extends ArrayAdapter<Tagihan> {


    public TagihanAdapter(Context context, int resource, List<Tagihan> objects) {
        super(context, resource, objects);
    }

    //pada class adapter perlu overide method getView
    //posisi List view pertama ditandakan dg int posisi mulai dr 0
    //parrent fragment di atasnya
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lv_daftar_tagihan, parent, false);
        }

        TextView txtNamaProduk = (TextView) convertView.findViewById(R.id.lblNamaProduk);
        TextView txtNomerPelanggan = (TextView) convertView.findViewById(R.id.lblNomerPelanggan);
        TextView txtNamaPelanggan = (TextView) convertView.findViewById(R.id.lblNamaPelanggan);
        TextView txtBulanTagihan = (TextView) convertView.findViewById(R.id.txtBulanTagihan);
        TextView txtJatuhTempo = (TextView) convertView.findViewById(R.id.txtJatuhTempo);
        TextView txtNilaiTagihan = (TextView) convertView.findViewById(R.id.txtNilaiTagihan);

        //posisi disini adalah posisi objek yang akan ditampilkan
        Tagihan t = getItem(position);
        txtNamaProduk.setText(t.getNamaProduk());
        txtNomerPelanggan.setText(t.getNomerPelanggan());
        txtNamaPelanggan.setText(t.getNamaPelanggan());

        try {
            //Karena pake date, jd kita tentukan dlo Datenya
            txtBulanTagihan.setText(new SimpleDateFormat("MMMMM yyyy").format(t.getBulanTagihan()));
            txtJatuhTempo.setText(new SimpleDateFormat("dd MMMMM yyyy").format(t.getJatuhTempo()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //karena pakai mata uang, jadi kita perlu buat dlo mata uang indo, karena java gak support ke indo secara default
        Locale currentLocale = new Locale("id", "id");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);

        txtNilaiTagihan.setText(currencyFormatter.format(t.getNilai()));

        return convertView;


    }
}

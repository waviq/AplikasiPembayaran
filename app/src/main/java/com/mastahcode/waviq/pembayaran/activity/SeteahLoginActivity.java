package com.mastahcode.waviq.pembayaran.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mastahcode.waviq.pembayaran.R;
import com.mastahcode.waviq.pembayaran.dao.TagihanDao;
import com.mastahcode.waviq.pembayaran.domain.Tagihan;
import com.mastahcode.waviq.pembayaran.fragment.DashboardFragment;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SeteahLoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seteah_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //load dashbiard setelah kita sukses login
        loadFragment(new DashboardFragment());
        //load dummy data sqlite
        //insertDummyData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.seteah_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fr) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.fragment_setelah_login, fr);

        fragmentTransaction.commit();
    }

    private void insertDummyData() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Tagihan t1 = new Tagihan();
        t1.setNamaProduk("PLN Pasca Bayar");
        t1.setNomerPelanggan("2323423423");
        t1.setNamaPelanggan("Waviq Subhi");
        t1.setNilai(new BigDecimal("100000.00"));
        try {
            t1.setBulanTagihan(formatter.parse("2016-08-01"));
            t1.setJatuhTempo(formatter.parse("2016-01-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Tagihan t2 = new Tagihan();
        t2.setNamaProduk("Telkom");
        t2.setNomerPelanggan("4235345345");
        t2.setNamaPelanggan("Samsul Faruq");
        t2.setNilai(new BigDecimal("250000.00"));
        try {
            t2.setBulanTagihan(formatter.parse("2016-08-24"));
            t2.setJatuhTempo(formatter.parse("2016-08-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Tagihan t3 = new Tagihan();
        t3.setNamaProduk("Speedy");
        t3.setNomerPelanggan("23453434");
        t3.setNamaPelanggan("Fatikhatul Baruni");
        t3.setNilai(new BigDecimal("90000.00"));
        try {
            t3.setBulanTagihan(formatter.parse("2016-08-24"));
            t3.setJatuhTempo(formatter.parse("2016-08-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TagihanDao td = new TagihanDao(this);
        td.insertTagihan(t1);
        td.insertTagihan(t2);
        td.insertTagihan(t3);


    }
}

package com.login.menulistactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    public static final String MODE_1 = "Beranda";
    public static final String MODE_2 = "Lowongan Kerja";
    public static final String MODE_3 = "Pendaftaran";
    public static final String MODE_4 = "Jadwal";
    public static final String MODE_5 = "Pengumuman";
    public static final String MODE_6 = "Exit";

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Buat String Array , untuk ditampilkan pada ListActivity
        String[] menuPilihan = new String[]{

                //"Beranda",
                MODE_1,
                //"Lowongan Kerja",
                MODE_2,
                //"Pendaftaran",
                MODE_3,
                //"Jadwal",
                MODE_4,
                //"Pengumuman",
                MODE_5,
                //"Exit"
                MODE_6

        };

        //Buat ArayAdapter, yang akan menaruh Strig tadi
        //tampilkan listview
        //Dan Set Nilai Array ke dalam list adapter sehingga data pada array akan dumunculkan dalam list
        this.setListAdapter(
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        menuPilihan
                )
        );
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        //menamngkap nilai text yang diklik
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();

        //Menampilkan hasil pilihan menu dalam bentuk Toast
        tampilkanpilihan(pilihan);

    }

    protected void tampilkanpilihan(String pilihan) {

        try {

            Intent i = null;

            switch (pilihan) {
                case MODE_1:
                    i = new Intent(this, beranda.class);
                    break;
                case MODE_2:
                    i = new Intent(this, tampilSemuaLoker.class);
                    break;
                case MODE_3:
                    i = new Intent(this, LowonganKerja.class);
                    break;
                case MODE_4:
                    i = new Intent(this, JadwalTes.class);
                    break;
                case MODE_5:
                    i = new Intent(this, Pengumuman.class);
                    break;
                case MODE_6:
                    finish();
                    break;
                default:
                    Toast.makeText(
                            this,
                            "Masuk Ke Menu: " + pilihan + " , Actionnya belum dibuat",
                            Toast.LENGTH_LONG
                    ).show();
                    break;
            }

            startActivity(i);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}

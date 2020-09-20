package com.login.menulistactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class LowonganKerja extends AppCompatActivity {

    EditText nTV;
    Button nbtn;

    String[] listItems;
    Button btnjekel;
    EditText jekel;

    String[] listItemsAgama;
    Button btnagama;
    EditText agama;

    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowongan_kerja);

        nTV = (EditText) findViewById(R.id.editTextTanggal);
        nbtn = (Button)findViewById(R.id.btnPick);
        btnjekel = findViewById(R.id.btnjekel);
        jekel = findViewById(R.id.editTextJekel);
        btnagama = findViewById(R.id.btnagama);
        agama = findViewById(R.id.editTextAgama);

        nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_WEEK);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(LowonganKerja.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int nYear, int nMonth, int nDay) {
                        nTV.setText(nDay + "/" + (nMonth+1) + "/" + nYear);
                    }
                }, day, month, year);
                dpd.show();

            }
        });

        btnjekel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems = new String[]{"Perempuan", "Laki-Laki"};
                AlertDialog.Builder nBuilder = new AlertDialog.Builder(LowonganKerja.this);
                nBuilder.setTitle("Jenis Kelamin"); // set title atas
                nBuilder.setIcon(R.drawable.iconjekel); // set icon alert
                nBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                   jekel.setText(listItems[i]);
                   dialogInterface.dismiss();
                    }
                });
                nBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //show alert dialog
                AlertDialog nDialog = nBuilder.create();
                nDialog.show();
            }
        });

       btnagama.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listItemsAgama = new String[]{"Islam", "Kristen", "Hindhu"};
               AlertDialog.Builder mBuilder = new AlertDialog.Builder(LowonganKerja.this);
               mBuilder.setTitle("Agama");
               mBuilder.setIcon(R.drawable.iconagama);
               mBuilder.setSingleChoiceItems(listItemsAgama, -1, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int j) {
                       agama.setText(listItemsAgama[j]);
                       dialogInterface.dismiss();
                   }
               });
               mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int j) {

                   }
               });
               AlertDialog mDialog = mBuilder.create();
               mDialog.show();
           }
       });
    }

    public void backtoMenu(View view){
        finish();
    }
}

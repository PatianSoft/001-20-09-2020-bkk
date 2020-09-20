package com.login.menulistactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class tampilSemuaLoker extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tampil_semua_loker);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

        getJSON();
    }

    private void showEmployee(){

        JSONObject jsonObject;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id_loker = jo.getString(konfigurasi.TAG_ID);

                String nama_per = jo.getString(konfigurasi.TAG_NAMA_PER);
                String nama_lok = jo.getString(konfigurasi.TAG_NAMA_LOK);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID,id_loker);
                employees.put(konfigurasi.TAG_NAMA_PER,nama_per);
                employees.put(konfigurasi.TAG_NAMA_LOK,nama_lok);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                tampilSemuaLoker.this,
                list,
                R.layout.activity_list_item,
                new String[]{
                        konfigurasi.TAG_ID,
                        konfigurasi.TAG_NAMA_PER,
                        konfigurasi.TAG_NAMA_LOK
                },
                new int[]{
                        R.id.id_loker,
                        R.id.nama_per,
                        R.id.nama_lok
                }
                );

        listView.setAdapter(adapter);
    }

    private void getJSON(){

        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(
                        tampilSemuaLoker.this,
                        "Mengambil Data","Mohon Tunggu...",
                        false,
                        false
                );
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                return rh.sendGetRequest(konfigurasi.URL_GET_ALL_LOKER);
            }
        }

        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, tampilSemuaLoker.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(konfigurasi.TAG_ID);
        intent.putExtra(konfigurasi.EMP_ID,empId);
        startActivity(intent);

    }

}






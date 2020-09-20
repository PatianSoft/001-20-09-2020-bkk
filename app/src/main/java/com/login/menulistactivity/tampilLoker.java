package com.login.menulistactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tampilLoker extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextId;
    private EditText editTextNm_per;
    private EditText editTextNm_loker;
    private EditText editTextKeterangan;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_loker);
        Intent intent = getIntent();

        id = intent.getStringExtra(konfigurasi.EMP_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextNm_per = (EditText) findViewById(R.id.editTextNm_per);
        editTextNm_loker = (EditText) findViewById(R.id.editTextNm_loker);
        editTextKeterangan = (EditText) findViewById(R.id.editTextKeterangan);
        editTextId.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(tampilLoker.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_EMP_DETLOKER,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String id_lok = c.getString(konfigurasi.TAG_ID);
            String nm_per = c.getString(konfigurasi.TAG_NAMA_PER);
            String nm_lok = c.getString(konfigurasi.TAG_NAMA_LOK);
            String ket = c.getString(konfigurasi.TAG_KETLOK);

            editTextId.setText(id_lok);
            editTextNm_per.setText(nm_per);
            editTextNm_loker.setText(nm_lok);
            editTextKeterangan.setText(ket);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
    }

}


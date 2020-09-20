package com.login.menulistactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lihatLoker extends AppCompatActivity implements View.OnClickListener{

    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_loker);

        buttonView = (Button) findViewById(R.id.buttonView);

        buttonView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == buttonView){
            startActivity(new Intent(this, tampilSemuaLoker.class));
        }
    }
}

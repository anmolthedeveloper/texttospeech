package com.anmolthedeveloper.texttospeech;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Developer_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void onclick(View view){
        Intent BrowserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://anmolthedeveloper.com"));
        startActivity(BrowserIntent);
    }

}

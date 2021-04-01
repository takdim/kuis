package com.example.navdraw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Biodata extends AppCompatActivity implements View.OnClickListener {

    private Button btnBack, btnShutDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        btnBack = findViewById(R.id.btnBack);
        btnShutDown = findViewById(R.id.btnShutDown);

        btnBack.setOnClickListener(this);
        btnShutDown.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBack:
                Intent i = new Intent(new Intent(Biodata.this, MainActivity.class));
                startActivity(i);
                return;
            case R.id.btnShutDown:
                out(this);
                return;
        }
    }

    @Override
    public void onBackPressed() {
        out(Biodata.this);
    }

    private void out(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("out");
        builder.setMessage("do you wanna go out?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
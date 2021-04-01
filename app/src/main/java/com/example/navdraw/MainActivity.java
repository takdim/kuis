package com.example.navdraw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnHome, btnPhone, btnShutDown;
    private TextView tvBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btnHome);
        btnPhone = findViewById(R.id.btnPhone);
        btnShutDown = findViewById(R.id.btnShutDown);

        tvBiodata = findViewById(R.id.tvBiodata);

        btnHome.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnShutDown.setOnClickListener(this);

        tvBiodata.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHome:
                Uri uri = Uri.parse("geo:-5.173869,119.4815338");
                Intent ii = new Intent(Intent.ACTION_VIEW, uri);
                ii.setPackage("com.google.android.apps.maps");
                startActivity(ii);
                return;
            case R.id.btnPhone:
                Uri number = Uri.parse("tel:+6282293410911");
                Intent intent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(intent);
                return;
            case R.id.btnShutDown:
                out(this);
                return;
            case R.id.tvBiodata:
                startActivity(new Intent(MainActivity.this, Biodata.class));
        }
    }

    @Override
    public void onBackPressed() {
        out(MainActivity.this);
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
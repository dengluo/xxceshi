package com.example.a53kf.xxceshi;

import android.Manifest;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.net.ssl.ManagerFactoryParameters;

import cn.xsdzq.kf.Interface.ResultInit;
import cn.xsdzq.kf.activity.MainActivity;
import cn.xsdzq.kf.activity.chatActivity;
import cn.xsdzq.kf.util.*;

public class TesActivity extends AppCompatActivity {
    private Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);

        Manager manager = new Manager();
        manager.init(this, "10034819", new ResultInit() {
            @Override
            public void onSuccess(int i, String s) {

            }

            @Override
            public void onFailure(int i, String s) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TesActivity.this, chatActivity.class);

                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TesActivity.this, KfActivity.class);

                startActivity(intent);

            }
        });
    }


}

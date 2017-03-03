package com.droiddev.scanbracode;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);

        //ดักรอการกดปุ่ม
        findViewById(R.id.btn_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //เมื่อกดปุ่มจะให้เปิดกล้อง
                startActivityForResult(new Intent(MainActivity.this,Camera_QRscan.class),1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra(Camera_QRscan.EXTRA_DATA); // หมายเลข หรือ ข้อความที่อยู่ใน QrCode หรือ Bracode
                txt.setText(result);
            }
        }
    }
}

package com.example.application_6_samplereceiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        AutoPermissions.Companion.loadAllPermissions(this, 101);
    }

    // 위험권한 요청 후 사용자의 허용/거부에 대한 응답 정보 확인 메서드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }

    @Override
    public void onDenied(int requestCode, @NonNull String[] permissions) {
        showToast("권한 거부된 것: " + permissions.length);
    }

    @Override
    public void onGranted(int requestCode, @NonNull String[] permissions) {
        showToast("권한 허가된 것: " + permissions.length);
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
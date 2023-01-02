package com.example.app_search;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);  // XML로 정의된 메뉴 정보를 인플레이션하여 메모리에 로딩

        View v = menu.findItem(R.id.menu_search).getActionView();   // 메뉴 아이템 중에서 검색을 위해 정의한 아이템을 뷰 객체로 참조
        if (v != null) {
            EditText editText = v.findViewById(R.id.editText);  // 검색을 위한 메뉴 아이템 안에 정의한 입력상자 객체 참조

            if (editText != null) {     // 입력상자 객체에 리스너 설정
                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        Toast.makeText(getApplicationContext(), "입력됨.", Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        return true;
    }

}
package com.example.doitmission_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {
    public static final int PRODUCT_CODE_FROM_MENU = 104;
    public static final int MAIN_CODE_FROM_PRODUCT = 114;
    public static final int MENU_CODE_FROM_PRODUCT = 124;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toast.makeText(getApplicationContext(), "메뉴 → 상품 관리", Toast.LENGTH_LONG).show();

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        getData(intent);

        Button menu = findViewById(R.id.button_menu_product);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(MENU_CODE_FROM_PRODUCT, intent);
                finish();
            }
        });

        Button login = findViewById(R.id.button_login_product);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                setResult(MAIN_CODE_FROM_PRODUCT, intent);
                finish();
            }
        });
    }

    private void getData(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");

            textView.setText("ID : " + data.id + "\nPW : " + data.pw);
        }
    }

}
package com.example.app02_scroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃에 정의된 뷰 객체 참조
        scrollView = (ScrollView) findViewById(R.id.scroll2); // 수직 방향 스크롤 뷰
        imageView = (ImageView) findViewById(R.id.image1); // 이미지 뷰
        Button button = (Button) findViewById(R.id.button1); // 버튼

        // 수평/수직 스크롤 바 사용 가능하도록 설정.
        scrollView.setHorizontalScrollBarEnabled(true);
        scrollView.setVerticalScrollBarEnabled(true);

        // 리소스의 이미지 참조
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        // 이미지뷰의 크기 설정
        imageView.setImageDrawable(bitmap);
        // 이미지뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    public void onButton1Clicked(View v) {
        changeImage();
    }

    // 다른 이미지 리소스로 변경
    public void changeImage() {
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image2);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        // 이미지 뷰를 새로운 이미지로 세팅
        imageView.setImageDrawable(bitmap);
        // 이미지 뷰의 크기를 지정하지 않을 시 이미지가 자동으로 축소됨.
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }
}
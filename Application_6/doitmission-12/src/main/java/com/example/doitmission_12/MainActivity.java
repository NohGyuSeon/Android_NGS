package com.example.doitmission_12;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    MyReceiver myReceiver;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("name", name);
                intent.putExtra("command", "메인 시작\n");
                startService(intent);
            }
        });

        myReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter("com.example.doitmission12.myAction");
        this.registerReceiver(myReceiver, filter);

        NewActivity(getIntent());
    }

    private void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", editText.getText().toString());
        editor.commit();
    }

    public void NewActivity(Intent intent) {
        String name = intent.getStringExtra("name");
        String command = intent.getStringExtra("command");
        if (name != null) {
            textView.setText("내용: " + name + "\n경로: " + command + "다시 메인으로");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();

        restoreState();
    }

    private void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ( (pref != null) && (pref.contains("name")) ) {
            name = pref.getString("name", "");
            editText.setText(name);
        }
    }

    public class MyReceiver extends BroadcastReceiver {
        public static final String TAG = "MyReceiver";
        public Intent BroadcastIntent;

        @Override
        public void onReceive(Context context, Intent intent) {
            String name = intent.getStringExtra("name");
            String command = intent.getStringExtra("command") + "브로드캐스트 거침\n";
            Log.d(TAG, "BroadCast에서 받은 문자: " + name);
//            textView.setText("내용: " + name + "\n" + "경로: " + command + "다시 메인으로");
            sendToActivity(context, name, command);
        }

        // 아래 메서드를 사용하면 새 액티비티 창을 띄워서 인텐트 전송 가능
        public void sendToActivity(Context context, String name, String command) {
            BroadcastIntent = new Intent(context.getApplicationContext(), MainActivity.class);
            BroadcastIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            BroadcastIntent.putExtra("name", name);
            BroadcastIntent.putExtra("command", command);
            context.getApplicationContext().startActivity(BroadcastIntent);
        }
    }

}
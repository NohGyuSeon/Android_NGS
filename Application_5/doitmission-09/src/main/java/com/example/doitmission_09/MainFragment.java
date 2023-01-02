package com.example.doitmission_09;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainFragment extends Fragment {
    EditText editName;
    EditText editAge;
    Button editDate;

    Calendar myCalendar = Calendar.getInstance();
    // default 값으로 오늘 날짜
    DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            myCalendar.set(Calendar.YEAR, i);
            myCalendar.set(Calendar.MONTH, i1);
            myCalendar.set(Calendar.DAY_OF_MONTH, i2);
            transDate();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        editName = rootView.findViewById(R.id.editName);
        editAge = rootView.findViewById(R.id.editAge);
        editDate = rootView.findViewById(R.id.btn_date);
        Date currentTime = Calendar.getInstance().getTime();
        editDate.setText(new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(currentTime));

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), setDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        Button button = rootView.findViewById(R.id.btn_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String date = editDate.getText().toString();

                if(name.length() < 1 || age.length() < 1 || date.length() < 1) {
                    Toast.makeText(getContext(), "정보를 모두 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "이름: " + name + " 나이 :" + age + " 생년월일 : " + date, Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }

    public void transDate() {
        String format = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.KOREA);
        editDate.setText(simpleDateFormat.format(myCalendar.getTime()));
    }
}
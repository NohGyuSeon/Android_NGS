package com.example.app_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int num, String msg) {
        number = num;
        message = msg;
    }

    public SimpleData(Parcel src) {    // Parcel 객체에서 읽기
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {     //  CREATOR 상수 정의
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);       // SimpleData 생성자 호출해 Parcel 객체에서 읽기
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {     // Parcel 객체로 쓰기
        dest.writeInt(number);
        dest.writeString(message);
    }
}

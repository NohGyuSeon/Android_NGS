package com.example.doitmission_08;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    String id;
    String pw;

    public SimpleData(String id_value, String pw_value) {
        id = id_value;
        pw = pw_value;
    }

    protected SimpleData(Parcel in) {
        id = in.readString();
        pw = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(pw);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };
}

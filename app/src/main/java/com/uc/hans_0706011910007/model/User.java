package com.uc.hans_0706011910007.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String fname, address, age;

    public User(String fname, String address, String age) {
        this.fname = fname;
        this.address = address;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fname);
        dest.writeString(this.address);
        dest.writeString(this.age);
    }

    protected User(Parcel in) {
        this.fname = in.readString();
        this.address = in.readString();
        this.age = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}

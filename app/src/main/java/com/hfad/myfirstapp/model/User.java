package com.hfad.myfirstapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String email;
    private String password;

    private String firstName = "Empty";
    private String secondName = "user";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public User(String email, String password, String firstName, String secondName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(firstName);
        dest.writeString(secondName);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            String email = in.readString();
            String password = in.readString();
            String firstName = in.readString();
            String secondName = in.readString();
            return new User(email, password, firstName, secondName);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}

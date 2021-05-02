package com.streamliners.sending_objects.Models;

import android.os.Parcel;
import android.os.Parcelable;

//Represent student class which implement parcelable to make student class object parcelable to send from one activity to another
public class Student implements Parcelable {
    String name;
    String gender;
    String rollNumber;
    String mobileNumber;

    //Parameterized constructor for student class
    public Student(String name, String gender,String rollNumber,String mobileNumber){
        this.name = name;
        this.gender = gender;
        this.rollNumber = rollNumber;
        this.mobileNumber = mobileNumber;
    }

    protected Student(Parcel in) {
        name = in.readString();
        gender = in.readString();
        rollNumber = in.readString();
        mobileNumber = in.readString();
    }

    @Override
    //writeToParcel is responsible for serializing the data
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(rollNumber);
        dest.writeString(mobileNumber);
    }

    //Can be used to set bitwise flags indicating special data types
    @Override
    public int describeContents() {
        return 0;
    }

    //Creator is responsible for deserialize to reconstruct the original parcelable object
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    //Getter to get name
    public String getName(){
        return name;
    }
    //Getter to get gender
    public String getGender(){
        return gender;
    }
    //Getter to get roll number
    public String getRollNumber(){
        return rollNumber;
    }
    //Getter to get mobile number
    public String getMobileNumber(){
        return mobileNumber;
    }
}

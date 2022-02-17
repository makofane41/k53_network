package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class DrivingRVModal implements Parcelable {
    //creating variables for our different fields.
    private String drivingName;
    private String location;
    private String contact;
    private String description;
    private String alternativeNumber;
    private String drivingId;


    public String getCourseId() {
        return drivingId;
    }

    public void setDrivingId(String drivingId) {
        this.drivingId = drivingId;
    }


    //creating an empty constructor.
    public DrivingRVModal() {

    }

    protected DrivingRVModal(Parcel in) {
        drivingName = in.readString();
        drivingId = in.readString();
        description = in.readString();
        location = in.readString();
        contact = in.readString();
        alternativeNumber= in.readString();

    }

    public static final Creator<DrivingRVModal> CREATOR = new Creator<DrivingRVModal>() {
        @Override
        public DrivingRVModal createFromParcel(Parcel in) {
            return new DrivingRVModal(in);
        }

        @Override
        public DrivingRVModal[] newArray(int size) {
            return new DrivingRVModal[size];
        }
    };

    //creating getter and setter methods.
    public String getDrivingNameName() {
        return   drivingName;
    }

    public void setDrivingName(String   drivingName) {
        this.  drivingName =   drivingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAlternativeNumber() {
        return alternativeNumber;
    }

    public void setAlternativeNumber(String alternativeNumber) {
        this.alternativeNumber = alternativeNumber;
    }


    public DrivingRVModal(String courseId, String drivingName, String description, String contact, String alternativeNumber, String location) {
        this.drivingName = drivingName;
        this.drivingId = courseId;
        this.description = description;
        this.contact = contact;
        this.alternativeNumber = alternativeNumber;
        this.location = location;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(drivingName);
        dest.writeString(drivingId);
        dest.writeString(description);
        dest.writeString(contact);
        dest.writeString(alternativeNumber);
        dest.writeString(location);

    }
}

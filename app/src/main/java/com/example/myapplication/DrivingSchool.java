package com.example.myapplication;

public class DrivingSchool {
    private int drivingProfile;
    private  String drivingName,drivingLocation;

    public DrivingSchool(int drivingSchoolProfile, String drivingName, String drivingLocation) {
        this.drivingProfile = drivingSchoolProfile;
        this.drivingName = drivingName;
        this.drivingLocation = drivingLocation;
    }

    public int getDrivingSchoolProfile() {
        return drivingProfile;
    }

    public void setDrivingSchoolProfile(int drivingSchoolProfile) {
        this.drivingProfile = drivingSchoolProfile;
    }

    public String getDrivingName() {
        return drivingName;
    }

    public void setDrivingName(String drivingName) {
        this.drivingName = drivingName;
    }

    public String getDrivingLocation() {
        return drivingLocation;
    }

    public void setDrivingLocation(String drivingLocation) {
        this.drivingLocation = drivingLocation;
    }
}

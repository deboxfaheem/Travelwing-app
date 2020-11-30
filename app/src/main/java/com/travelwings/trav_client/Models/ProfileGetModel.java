package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileGetModel {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("anniversaryDate")
    @Expose
    private String anniversaryDate;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("accomodationpreference")
    @Expose
    private String accomodationpreference;

    @SerializedName("holidaypreference")
    @Expose
    private String holidaypreference;

    @SerializedName("mealPreference")
    @Expose
    private String mealPreference;

    @SerializedName("specialassistance")
    @Expose
    private String specialassistance;

    public ProfileGetModel(String id, String firstName, String lastName, String country, String mobile, String dob, String anniversaryDate, String address, String email, String accomodationpreference, String holidaypreference, String mealPreference, String specialassistance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.mobile = mobile;
        this.dob = dob;
        this.anniversaryDate = anniversaryDate;
        this.address = address;
        this.email = email;
        this.accomodationpreference = accomodationpreference;
        this.holidaypreference = holidaypreference;
        this.mealPreference = mealPreference;
        this.specialassistance = specialassistance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(String anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccomodationpreference() {
        return accomodationpreference;
    }

    public void setAccomodationpreference(String accomodationpreference) {
        this.accomodationpreference = accomodationpreference;
    }

    public String getHolidaypreference() {
        return holidaypreference;
    }

    public void setHolidaypreference(String holidaypreference) {
        this.holidaypreference = holidaypreference;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(String mealPreference) {
        this.mealPreference = mealPreference;
    }

    public String getSpecialassistance() {
        return specialassistance;
    }

    public void setSpecialassistance(String specialassistance) {
        this.specialassistance = specialassistance;
    }
}


package com.travelwings.trav_client.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("day")
    @Expose
    private String day;

    @SerializedName("tripName")
    @Expose
    private String tripName;

    @SerializedName("destination")
    @Expose
    private String destination;

    @SerializedName("image1")
    @Expose
    private String image1;

    @SerializedName("hotelname")
    @Expose
    private String hotelname;

    @SerializedName("hotelcategory")
    @Expose
    private String hotelcategory;

    @SerializedName("roomtype")
    @Expose
    private String roomtype;

    @SerializedName("noofrooms")
    @Expose
    private String noofrooms;

    @SerializedName("mealplan")
    @Expose
    private String mealplan;

    @SerializedName("veimage2")
    @Expose
    private String veimage2;

    @SerializedName("vetransferName")
    @Expose
    private String vetransferName;

    @SerializedName("vetype")
    @Expose
    private String vetype;

    @SerializedName("vename")
    @Expose
    private String vename;

    @SerializedName("vemaxpax")
    @Expose
    private String vemaxpax;

    @SerializedName("vestarttime")
    @Expose
    private String vestarttime;

    @SerializedName("veendtime")
    @Expose
    private String veendtime;

    @SerializedName("vetransferDetail")
    @Expose
    private String vetransferDetail;

    @SerializedName("tpickupTime")
    @Expose
    private String tpickupTime;

    @SerializedName("tdropTime")
    @Expose
    private String tdropTime;


    @SerializedName("Images3")
    @Expose
    private String images3;

    @SerializedName("enrouteName")
    @Expose
    private String enrouteName;

    @SerializedName("enrouteDetail")
    @Expose
    private String enrouteDetail;

    @SerializedName("entranceImage")
    @Expose
    private String entranceImage;

    @SerializedName("entranceName")
    @Expose
    private String entranceName;

    @SerializedName("estartTime")
    @Expose
    private String estartTime;

    @SerializedName("eendTime")
    @Expose
    private String eendTime;

    @SerializedName("entranceDetail")
    @Expose
    private String entranceDetail;

    @SerializedName("activityImage")
    @Expose
    private String activityImage;

    @SerializedName("otherActivityName")
    @Expose
    private String otherActivityName;

    @SerializedName("otherActivityDetail")
    @Expose
    private String otherActivityDetail;

    @SerializedName("astartTime")
    @Expose
    private String astartTime;

    @SerializedName("aendTime")
    @Expose
    private String aendTime;

    @SerializedName("flightName")
    @Expose
    private String flightName;

    @SerializedName("flightNumber")
    @Expose
    private String flightNumber;

    @SerializedName("flightClass")
    @Expose
    private String flightClass;

    @SerializedName("departure")
    @Expose
    private String departure;

    @SerializedName("arrival")
    @Expose
    private String arrival;

    @SerializedName("trainName")
    @Expose
    private String trainName;

    @SerializedName("trainNumber")
    @Expose
    private String trainNumber;

    @SerializedName("trainClass")
    @Expose
    private String trainClass;

    @SerializedName("trainDeparture")
    @Expose
    private String trainDeparture;

    @SerializedName("trainArrival")
    @Expose
    private String trainArrival;

    @SerializedName("hotelvoucher")
    @Expose
    private String hotelvoucher;

    @SerializedName("flightVoucher")
    @Expose
    private String flightVoucher;

    @SerializedName("transferVoucher")
    @Expose
    private String transferVoucher;

    @SerializedName("activityVoucher")
    @Expose
    private String activityVoucher;

    @SerializedName("entranceVoucher")
    @Expose
    private String entranceVoucher;


    public Result() {
    }

    public Result(String id, String date, String time, String day, String tripName, String destination, String image1, String hotelname, String hotelcategory, String roomtype, String noofrooms, String mealplan, String veimage2, String vetransferName, String vetype, String vename, String vemaxpax, String vestarttime, String veendtime, String vetransferDetail, String tpickupTime, String tdropTime, String images3, String enrouteName, String enrouteDetail, String entranceImage, String entranceName, String estartTime, String eendTime, String entranceDetail, String activityImage, String otherActivityName, String otherActivityDetail, String astartTime, String aendTime, String flightName, String flightNumber, String flightClass, String departure, String arrival, String trainName, String trainNumber, String trainClass, String trainDeparture, String trainArrival, String hotelvoucher, String flightVoucher, String transferVoucher, String activityVoucher, String entranceVoucher) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.day = day;
        this.tripName = tripName;
        this.destination = destination;
        this.image1 = image1;
        this.hotelname = hotelname;
        this.hotelcategory = hotelcategory;
        this.roomtype = roomtype;
        this.noofrooms = noofrooms;
        this.mealplan = mealplan;
        this.veimage2 = veimage2;
        this.vetransferName = vetransferName;
        this.vetype = vetype;
        this.vename = vename;
        this.vemaxpax = vemaxpax;
        this.vestarttime = vestarttime;
        this.veendtime = veendtime;
        this.vetransferDetail = vetransferDetail;
        this.tpickupTime = tpickupTime;
        this.tdropTime = tdropTime;
        this.images3 = images3;
        this.enrouteName = enrouteName;
        this.enrouteDetail = enrouteDetail;
        this.entranceImage = entranceImage;
        this.entranceName = entranceName;
        this.estartTime = estartTime;
        this.eendTime = eendTime;
        this.entranceDetail = entranceDetail;
        this.activityImage = activityImage;
        this.otherActivityName = otherActivityName;
        this.otherActivityDetail = otherActivityDetail;
        this.astartTime = astartTime;
        this.aendTime = aendTime;
        this.flightName = flightName;
        this.flightNumber = flightNumber;
        this.flightClass = flightClass;
        this.departure = departure;
        this.arrival = arrival;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.trainClass = trainClass;
        this.trainDeparture = trainDeparture;
        this.trainArrival = trainArrival;
        this.hotelvoucher = hotelvoucher;
        this.flightVoucher = flightVoucher;
        this.transferVoucher = transferVoucher;
        this.activityVoucher = activityVoucher;
        this.entranceVoucher = entranceVoucher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHotelcategory() {
        return hotelcategory;
    }

    public void setHotelcategory(String hotelcategory) {
        this.hotelcategory = hotelcategory;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getNoofrooms() {
        return noofrooms;
    }

    public void setNoofrooms(String noofrooms) {
        this.noofrooms = noofrooms;
    }

    public String getMealplan() {
        return mealplan;
    }

    public void setMealplan(String mealplan) {
        this.mealplan = mealplan;
    }

    public String getVeimage2() {
        return veimage2;
    }

    public void setVeimage2(String veimage2) {
        this.veimage2 = veimage2;
    }

    public String getVetransferName() {
        return vetransferName;
    }

    public void setVetransferName(String vetransferName) {
        this.vetransferName = vetransferName;
    }

    public String getVetype() {
        return vetype;
    }

    public void setVetype(String vetype) {
        this.vetype = vetype;
    }

    public String getVename() {
        return vename;
    }

    public void setVename(String vename) {
        this.vename = vename;
    }

    public String getVemaxpax() {
        return vemaxpax;
    }

    public void setVemaxpax(String vemaxpax) {
        this.vemaxpax = vemaxpax;
    }

    public String getVestarttime() {
        return vestarttime;
    }

    public void setVestarttime(String vestarttime) {
        this.vestarttime = vestarttime;
    }

    public String getVeendtime() {
        return veendtime;
    }

    public void setVeendtime(String veendtime) {
        this.veendtime = veendtime;
    }

    public String getVetransferDetail() {
        return vetransferDetail;
    }

    public void setVetransferDetail(String vetransferDetail) {
        this.vetransferDetail = vetransferDetail;
    }

    public String getTpickupTime() {
        return tpickupTime;
    }

    public void setTpickupTime(String tpickupTime) {
        this.tpickupTime = tpickupTime;
    }

    public String getTdropTime() {
        return tdropTime;
    }

    public void setTdropTime(String tdropTime) {
        this.tdropTime = tdropTime;
    }

    public String getImages3() {
        return images3;
    }

    public void setImages3(String images3) {
        this.images3 = images3;
    }

    public String getEnrouteName() {
        return enrouteName;
    }

    public void setEnrouteName(String enrouteName) {
        this.enrouteName = enrouteName;
    }

    public String getEnrouteDetail() {
        return enrouteDetail;
    }

    public void setEnrouteDetail(String enrouteDetail) {
        this.enrouteDetail = enrouteDetail;
    }

    public String getEntranceImage() {
        return entranceImage;
    }

    public void setEntranceImage(String entranceImage) {
        this.entranceImage = entranceImage;
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName;
    }

    public String getEstartTime() {
        return estartTime;
    }

    public void setEstartTime(String estartTime) {
        this.estartTime = estartTime;
    }

    public String getEendTime() {
        return eendTime;
    }

    public void setEendTime(String eendTime) {
        this.eendTime = eendTime;
    }

    public String getEntranceDetail() {
        return entranceDetail;
    }

    public void setEntranceDetail(String entranceDetail) {
        this.entranceDetail = entranceDetail;
    }

    public String getActivityImage() {
        return activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
    }

    public String getOtherActivityName() {
        return otherActivityName;
    }

    public void setOtherActivityName(String otherActivityName) {
        this.otherActivityName = otherActivityName;
    }

    public String getOtherActivityDetail() {
        return otherActivityDetail;
    }

    public void setOtherActivityDetail(String otherActivityDetail) {
        this.otherActivityDetail = otherActivityDetail;
    }

    public String getAstartTime() {
        return astartTime;
    }

    public void setAstartTime(String astartTime) {
        this.astartTime = astartTime;
    }

    public String getAendTime() {
        return aendTime;
    }

    public void setAendTime(String aendTime) {
        this.aendTime = aendTime;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public String getTrainDeparture() {
        return trainDeparture;
    }

    public void setTrainDeparture(String trainDeparture) {
        this.trainDeparture = trainDeparture;
    }

    public String getTrainArrival() {
        return trainArrival;
    }

    public void setTrainArrival(String trainArrival) {
        this.trainArrival = trainArrival;
    }

    public String getHotelvoucher() {
        return hotelvoucher;
    }

    public void setHotelvoucher(String hotelvoucher) {
        this.hotelvoucher = hotelvoucher;
    }

    public String getFlightVoucher() {
        return flightVoucher;
    }

    public void setFlightVoucher(String flightVoucher) {
        this.flightVoucher = flightVoucher;
    }

    public String getTransferVoucher() {
        return transferVoucher;
    }

    public void setTransferVoucher(String transferVoucher) {
        this.transferVoucher = transferVoucher;
    }

    public String getActivityVoucher() {
        return activityVoucher;
    }

    public void setActivityVoucher(String activityVoucher) {
        this.activityVoucher = activityVoucher;
    }

    public String getEntranceVoucher() {
        return entranceVoucher;
    }

    public void setEntranceVoucher(String entranceVoucher) {
        this.entranceVoucher = entranceVoucher;
    }
}

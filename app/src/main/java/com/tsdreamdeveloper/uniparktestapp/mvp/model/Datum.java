
package com.tsdreamdeveloper.uniparktestapp.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_favourite")
    @Expose
    private Boolean isFavourite;
    @SerializedName("driver_name")
    @Expose
    private String driverName;
    @SerializedName("transport_number")
    @Expose
    private String transportNumber;
    @SerializedName("number_of_seats")
    @Expose
    private Integer numberOfSeats;
    @SerializedName("transport_type_image")
    @Expose
    private Object transportTypeImage;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("images_count")
    @Expose
    private Integer imagesCount;
    @SerializedName("city")
    @Expose
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Object getTransportTypeImage() {
        return transportTypeImage;
    }

    public void setTransportTypeImage(Object transportTypeImage) {
        this.transportTypeImage = transportTypeImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

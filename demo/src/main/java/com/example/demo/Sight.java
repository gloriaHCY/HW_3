package org.example;

public class Sight implements java.io.Serializable {
    private String sightName; // 景點名稱
    private String zone; //區
    private String category; //景點類別
    private String photoURL; //
    private String description; //描述
    private String address; //地址


    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "SightName:" + sightName +
                "Zone:" + zone +
                "Category:" + category +
                "PhotoURL:" + photoURL +
                "Description:" + description +
                "Address:" + address;
    }
}
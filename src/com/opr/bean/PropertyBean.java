package com.opr.bean;

import java.io.File;

public class PropertyBean extends AmenitiesBean {

    private String location = "";
    private String propType = "";
    private String propTitle = "";
    private String city = "";
    private String publicLocaton = "";
    private String distance = "";
    private String address = "";
    private String price = "";
    private String area = "";
    private String bedrooms = "";
    private String bathrooms = "";
    private String contractType = "";
    private String proofType = "";
    private String proofId = "";
    private String propertyId = "";
    private String postDate = "";
    private String status = "";
    private String quality = "";
    private String minPrice = "";
    private String maxPrice = "";
    private String description = "";
    private String type = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //Files
    private File coverImage = null;
    private File video = null;
    private File photo1 = null;
    private File photo2 = null;
    private File photo3 = null;

    public File getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(File coverImage) {
        this.coverImage = coverImage;
    }

    public File getVideo() {
        return video;
    }

    public void setVideo(File video) {
        this.video = video;
    }

    public File getPhoto1() {
        return photo1;
    }

    public void setPhoto1(File photo1) {
        this.photo1 = photo1;
    }

    public File getPhoto2() {
        return photo2;
    }

    public void setPhoto2(File photo2) {
        this.photo2 = photo2;
    }

    public File getPhoto3() {
        return photo3;
    }

    public void setPhoto3(File photo3) {
        this.photo3 = photo3;
    }

    public String getLocation() {
        return location;
    }

    public String getPropTitle() {
        return propTitle;
    }

    public void setPropTitle(String propTitle) {
        this.propTitle = propTitle;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPublicLocaton() {
        return publicLocaton;
    }

    public void setPublicLocaton(String publicLocaton) {
        this.publicLocaton = publicLocaton;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getProofId() {
        return proofId;
    }

    public void setProofId(String proofId) {
        this.proofId = proofId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }
}

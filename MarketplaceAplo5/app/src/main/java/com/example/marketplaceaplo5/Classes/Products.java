package com.example.marketplaceaplo5.Classes;

public class Products {
    private String pid;
    private String productName;
    private String description;
    private Double price;
    private String image;
    private String sellerID;
    private String buyerID;
    private Integer sellEpoch;
    private Integer listEpoch;
    private Boolean isSold;
    private Boolean isRemoved;

    Products(){

    }

    public Products(String pid, String productName, String description, Double price, String image, String buyerID, String sellerID, Integer listEpoch, Integer sellEpoch, Boolean isSold, Boolean isRemoved) {
        this.pid = pid;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.sellerID = sellerID;
        this.buyerID = buyerID;
        this.listEpoch = listEpoch;
        this.sellEpoch = sellEpoch;
        this.isSold = isSold;
        this.isRemoved = isRemoved;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public Integer getListEpoch() {
        return listEpoch;
    }

    public void setListEpoch(Integer listEpoch) {
        this.listEpoch = listEpoch;
    }

    public Integer getSellEpoch() {
        return sellEpoch;
    }

    public void setSellEpoch(Integer sellEpoch) {
        this.sellEpoch = sellEpoch;
    }

    public Boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
}

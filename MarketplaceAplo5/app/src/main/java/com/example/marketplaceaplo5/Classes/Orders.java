package com.example.marketplaceaplo5.Classes;

public class Orders {
    private String orderID, firstname, lastname, phone, address, city, state, zip, cardnumber, cvv, expiration, productid, price, productName, productPrice, buyerID, listEpoch, sellEpoch;

    public Orders() {
    }

    public Orders(String orderID,String firstname, String lastname, String phone, String address, String city, String state, String zip, String cardnumber, String cvv, String expiration, String productid, String price, String productName, String productPrice, String buyerID, String listEpoch, String sellEpoch) {
        this.orderID = orderID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.expiration = expiration;
        this.productid = productid;
        this.price = price;
        this.productName = productName;
        this.productPrice = productPrice;
        this.buyerID = buyerID;
        this.listEpoch = listEpoch;
        this.sellEpoch = sellEpoch;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public String getListEpoch() {
        return listEpoch;
    }

    public void setListEpoch(String listEpoch) {
        this.listEpoch = listEpoch;
    }

    public String getSellEpoch() {
        return sellEpoch;
    }

    public void setSellEpoch(String sellEpoch) {
        this.sellEpoch = sellEpoch;
    }
}




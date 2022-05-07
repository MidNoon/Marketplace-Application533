package com.example.marketplaceaplo5.Classes;

public class Orders {
    private String firstname, lastname, phone, address, city, state, zip, cardnumber, cvv, expiration, productid, price;

    public Orders(){}

    public Orders(String firstname, String lastname, String phone, String address, String city, String state, String zip, String cardnumber, String cvv, String expiration, String productid, String price) {
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
        //this.solddate = solddate;
        //this.buyerID = buyerID;
        //this.sellerID = sellerID;

    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
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

    public String getCardNumber() {
        return cardnumber;
    }

    public void setCardNumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCVV() {
        return cvv;
    }

    public void setCVV(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductID() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }


/*
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getUserID(){
        return userID;
    }

    public void setUserID(){
        this.userID = userID;
    }

 */
}

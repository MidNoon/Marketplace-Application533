package com.example.marketplaceaplo5.Classes;


public class Invoice {

    /* Invoices Will be titled with a UniqueInvoiceId. Invoices will*/

    private String invoiceID, firstname, lastname, phone, address, city, state, zip, productID, productName, price, sellerID, buyerID, listEpoch, sellEpoch;

    public Invoice(){}

    public Invoice(String invoiceID, String firstname, String lastname, String phone, String address, String city, String state, String zip, String productID, String productName, String price, String sellerID, String buyerID, String listEpoch, String sellEpoch) {
        this.invoiceID = invoiceID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.sellerID = sellerID;
        this.buyerID = buyerID;
        this.listEpoch = listEpoch;
        this.sellEpoch = sellEpoch;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

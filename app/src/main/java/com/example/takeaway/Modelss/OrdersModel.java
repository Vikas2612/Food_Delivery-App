package com.example.takeaway.Modelss;

public class OrdersModel {

    int orderImage;
    String soldItem,price,orderNumber;

    public OrdersModel(int orderImage, String soldItem, String price, String orderNumber) {
        this.orderImage = orderImage;
        this.soldItem = soldItem;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public OrdersModel() {
        this.orderImage = orderImage;
        this.soldItem = soldItem;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItem() {
        return soldItem;
    }

    public void setSoldItem(String soldItem) {
        this.soldItem = soldItem;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}

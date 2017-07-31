package com.example.demo.mobilityservice.jms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PredictionEntity {

    private long id;

    private int year;
    private int kw;
    private int count;
    private int area;
    private String marketNumber;
    private int nan;
    private int units;
    private int deliveryTime;
    private int orderCount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getMarketNumber() {
        return marketNumber;
    }

    public void setMarketNumber(String marketNumber) {
        this.marketNumber = marketNumber;
    }

    public int getNan() {
        return nan;
    }

    public void setNan(int nan) {
        this.nan = nan;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "PredictionEntity{" +
                "year=" + year +
                ", kw=" + kw +
                ", count=" + count +
                ", area=" + area +
                ", marketNumber='" + marketNumber + '\'' +
                ", nan=" + nan +
                ", units=" + units +
                ", deliveryTime=" + deliveryTime +
                ", orderCount=" + orderCount +
                '}';
    }
}

package com.example.demo.mobilityservice.jms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PredictionMessage {

    private int year;
    private int kw;
    private int count;
    private int area;
    private String marketNumber;
    private int nan;
    private int units;
    private int deliveryTime;
    private int orderCount;

    @XmlElement(name = "von_Jahr")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlElement(name = "KW")
    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    @XmlElement(name = "Lfd_Nr")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name = "Bereich")
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @XmlElement(name = "Markt_Nr")
    public String getMarketNumber() {
        return marketNumber;
    }

    public void setMarketNumber(String marketNumber) {
        this.marketNumber = marketNumber;
    }

    @XmlElement(name = "NAN")
    public int getNan() {
        return nan;
    }

    public void setNan(int nan) {
        this.nan = nan;
    }

    @XmlElement(name = "WA_Einheit")
    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @XmlElement(name = "Liefertermin")
    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @XmlElement(name = "Bestellmenge")
    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "PredictionMessage{" +
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

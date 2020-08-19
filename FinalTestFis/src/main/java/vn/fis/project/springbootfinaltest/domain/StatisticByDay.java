package vn.fis.project.springbootfinaltest.domain;

import java.util.Date;

public class StatisticByDay {

    private Date day;
    private int orderQuantity;
    private double amountTotal;

    public StatisticByDay(){

    }

    public StatisticByDay(Date day, int orderQuantity, double amountTotal) {
        this.day = day;
        this.orderQuantity = orderQuantity;
        this.amountTotal = amountTotal;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(double amountTotal) {
        this.amountTotal = amountTotal;
    }

    @Override
    public String toString() {
        return "StatisticByDay{" +
                "day=" + day +
                ", orderQuantity=" + orderQuantity +
                ", amountTotal=" + amountTotal +
                '}';
    }
}

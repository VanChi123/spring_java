package vn.fis.project.springbootfinaltest.domain;

public class StatisticByProduct {

    private String orderNo;
    private double amount;
    private int id;
    private int quantity;

    public StatisticByProduct() {
    }

    public StatisticByProduct(String orderNo, double amount, int id, int quantity) {
        this.orderNo = orderNo;
        this.amount = amount;
        this.id = id;
        this.quantity = quantity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StatisticByProduct{" +
                "orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}

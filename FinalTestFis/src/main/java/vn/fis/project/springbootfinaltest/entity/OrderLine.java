package vn.fis.project.springbootfinaltest.entity;

import javax.persistence.*;

@Entity
@Table(name="order_line")
public class OrderLine {

    private Integer id;
    private String productName;
    private double amount;
    private int quantity;
    private int orderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name="quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name="product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                '}';
    }
}

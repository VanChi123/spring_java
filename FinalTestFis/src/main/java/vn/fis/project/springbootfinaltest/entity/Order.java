package vn.fis.project.springbootfinaltest.entity;

import vn.fis.project.springbootfinaltest.domain.OrderDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@NamedNativeQueries(
        @NamedNativeQuery(
                name="Order.getOrdersUserLogin",
                query = "select id, order_no, status, customer_name from orders where user_id=:user_id",
                resultSetMapping = "Order.mapToDto"
        )
)
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "Order.mapToDto",
                classes = @ConstructorResult(
                        targetClass = OrderDto.class,
                        columns = {
                                @ColumnResult(name = "id"
                                        , type = Integer.class),
                                @ColumnResult(name = "order_no"
                                        , type = String.class),
                                @ColumnResult(name = "status"
                                        , type = Integer.class),
                                @ColumnResult(name = "customer_name"
                                        , type = String.class)
                        }
                )

        )
)
public class Order {

    private Integer id;
    private String orderNo;
    private double amount;
    private Date orderDate;
    private int status;
    private String customerName;

    private int userId;
    private List<OrderLine> orderLines;

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="order_no")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Column(name="amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name="order_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", customerName='" + customerName + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }
}

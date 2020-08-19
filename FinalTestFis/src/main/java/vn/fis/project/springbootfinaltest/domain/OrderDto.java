package vn.fis.project.springbootfinaltest.domain;

public class OrderDto{

    private Integer id;
    private String orderNo;
    private int status;
    private String customerName;

    public OrderDto() {
    }

    public OrderDto(Integer id, String orderNo, int status, String customerName) {
        this.id = id;
        this.orderNo = orderNo;
        this.status = status;
        this.customerName = customerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", status=" + status +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}

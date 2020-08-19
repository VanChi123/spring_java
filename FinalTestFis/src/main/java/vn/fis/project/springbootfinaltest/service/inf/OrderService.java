package vn.fis.project.springbootfinaltest.service.inf;

import vn.fis.project.springbootfinaltest.domain.OrderDto;
import vn.fis.project.springbootfinaltest.domain.StatisticByDay;
import vn.fis.project.springbootfinaltest.domain.StatisticByProduct;
import vn.fis.project.springbootfinaltest.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Order saveOrder(Order order);
    public Order create(Order order);
    public Order update(String userName,int idOrder,int status,String customerName);
    List<Order> findAll();
    Optional<Order> findById(Integer id);

    //lấy tất cả order của user đang login
    public List<OrderDto> getAllOrderByUserId(String userName);

    //xoa order theo id va trang thai cua nguoi tao ra
    public boolean deleteOrderByUserAndStatus(String userName,int id);

    //thống kê theo ngày
    List<StatisticByDay> getStatisticByDay();

    //thống kê theo product
    List<StatisticByProduct> getStatisticByProduct();
}

package vn.fis.project.springbootfinaltest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.project.springbootfinaltest.domain.OrderDto;
import vn.fis.project.springbootfinaltest.domain.StatisticByDay;
import vn.fis.project.springbootfinaltest.domain.StatisticByProduct;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.entity.Order;
import vn.fis.project.springbootfinaltest.repos.OrderRepos;
import vn.fis.project.springbootfinaltest.service.inf.OrderService;
import vn.fis.project.springbootfinaltest.service.inf.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepos res;

    @Override
    public Order saveOrder(Order order) {
        return res.save(order);
    }

    @Override
    public Order create(Order order) {
        return res.save(order);
    }

    @Override
    public Order update(String userName,int idOrder,int status,String customerName) {
        UserDto userDto = userService.loadUserByUserName(userName);
        Optional<Order> orderOptional = orderService.findById(idOrder);
        if(orderOptional.isPresent()){
            Order order = orderOptional.get();
            if(userDto.getId() == order.getUserId()) {
                order.setStatus(status);
                order.setCustomerName(customerName);
                try {
                    LOGGER.info("Update thành công order : {}", res.save(order));
                    return order;
                }catch (Exception ex){
                    LOGGER.error("Update không thành công");
                    return null;
                }
            }
            LOGGER.error("order có id = {} không do người  dùng id={} tạo",order.getId(),userDto.getId());
            return null;
        }
        LOGGER.error("id order= {} không tồn tại",idOrder);
        return null;
    }

    @Override
    public List<Order> findAll() {
        return res.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return res.findById(id);
    }

    @Override
    public List<OrderDto> getAllOrderByUserId(String userName) {
        List<OrderDto> dtoList ;
        try {
            UserDto userDto = userService.loadUserByUserName(userName);
            Integer idUserLogin = userDto.getId();
            dtoList = res.getOrdersUserLogin(idUserLogin);
            dtoList.forEach(orderDto -> LOGGER.info("order Dto: {}",orderDto));
            return dtoList;
        }catch (Exception e){
            LOGGER.error(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteOrderByUserAndStatus(String userName,int id) {

        UserDto userDto = userService.loadUserByUserName(userName);
        System.out.println(userDto);
        Optional<Order> orderOptional = orderService.findById(id);
        Order order = orderOptional.get();
        System.out.println(order);
        if(userDto.getId() == order.getUserId()){
            try {
                res.deleteOrderByUserAndStatus(id);
                LOGGER.info("Xóa thành công order : {}",order);
                return true;
            }catch (Exception ex){
                LOGGER.error("Lỗi Khi xóa");
                return false;
            }
        }
        return false;
    }

    @Override
    public List<StatisticByDay> getStatisticByDay() {
        return res.getAllDay();
    }

    @Override
    public List<StatisticByProduct> getStatisticByProduct() {
        return res.getAllProduct();
    }

    public OrderRepos getRes() {
        return res;
    }

    public void setRes(OrderRepos res) {
        this.res = res;
    }
}

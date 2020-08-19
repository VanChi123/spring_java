package vn.fis.project.springbootfinaltest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.project.springbootfinaltest.entity.Order;
import vn.fis.project.springbootfinaltest.entity.OrderLine;
import vn.fis.project.springbootfinaltest.repos.OrderLineRepos;
import vn.fis.project.springbootfinaltest.service.inf.OrderLineService;

import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderLineServiceImpl.class);

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderLineRepos repos;

    @Override
    public OrderLine saveOrderLine(OrderLine orderLine) {
        OrderLine orderLineResult;
        try {
            orderLineResult=repos.save(orderLine);
            //lấy thằng order cha ra và cập nhật lại amount
            Order order = orderService.findById(orderLineResult.getOrderId()).get();
            if(null!=order){
                order.setAmount(getSumAmountByOrderId(order.getId()));
                orderService.saveOrder(order);
                LOGGER.info("Thêm thành công Order Line : {}",orderLine);
                return orderLineResult;
            }
            return null;
        }catch (Exception e){
            LOGGER.error(e.toString());
            return null;
        }
    }

    @Override
    public OrderLine updateOrderLine(OrderLine orderLine) {
        OrderLine orderLineResult;
        try {
            orderLineResult = repos.save(orderLine);
            Order order = orderService.findById(orderLineResult.getOrderId()).get();
            if (null != order) {
                order.setAmount(getSumAmountByOrderId(order.getId()));
                orderService.saveOrder(order);
                LOGGER.info("Update thành công order Line :{}", orderLineResult);
                return orderLineResult;
            }
            return null;
        }catch (Exception e){
            LOGGER.error(e.toString());
            return null;
        }
    }

    @Override
    public float getSumAmountByOrderId(Integer id) {
        return  repos.getSumAmountByOrderId(id);
    }

    @Override
    public boolean deleteOrderLineById(Integer id) {
        boolean result = false;
        //xóa order line theo id
        try {
            OrderLine orderLine = findById(id).get();
            repos.deleteById(id);
            Order order = orderService.findById(orderLine.getOrderId()).get();
            order.setAmount(getSumAmountByOrderId(order.getId()));
            orderService.saveOrder(order);
            LOGGER.info("delete thành công OrderLine : {}", orderLine);
            result = true;
        } catch (Exception e) {
            LOGGER.error("Không xóa thành công ");
            return false;
        }
        return result;
    }

    @Override
    public Optional<OrderLine> findById(Integer id) {
        return repos.findById(id);
    }

    public OrderLineRepos getRepos() {
        return repos;
    }

    public void setRepos(OrderLineRepos repos) {
        this.repos = repos;
    }
}

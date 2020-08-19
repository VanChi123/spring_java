package vn.fis.project.springbootfinaltest.service.inf;

import vn.fis.project.springbootfinaltest.entity.OrderLine;
import java.util.Optional;

public interface OrderLineService {

    OrderLine saveOrderLine(OrderLine orderLine);
    OrderLine updateOrderLine(OrderLine orderLine);
    float getSumAmountByOrderId(Integer id);
    boolean deleteOrderLineById(Integer id);
    Optional<OrderLine> findById(Integer id);
}

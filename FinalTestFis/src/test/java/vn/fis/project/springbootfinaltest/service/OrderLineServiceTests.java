package vn.fis.project.springbootfinaltest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.fis.project.springbootfinaltest.entity.OrderLine;
import vn.fis.project.springbootfinaltest.service.inf.OrderLineService;
import vn.fis.project.springbootfinaltest.service.inf.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderLineServiceTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderLineService orderLineService;

    @Test
    public void testInsertOrderLine(){
        OrderLine orderLine = new OrderLine();
        orderLine.setId(13);
        orderLine.setAmount(100);
        orderLine.setOrderId(8);
        orderLineService.saveOrderLine(orderLine);
        LOGGER.info("order Line: "+orderLine);

    }

    public OrderLineService getOrderLineService() {
        return orderLineService;
    }

    public void setOrderLineService(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }
}

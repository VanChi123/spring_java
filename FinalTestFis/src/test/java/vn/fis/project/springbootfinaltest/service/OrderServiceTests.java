package vn.fis.project.springbootfinaltest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.fis.project.springbootfinaltest.domain.StatisticByProduct;
import vn.fis.project.springbootfinaltest.service.inf.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderService orderService;

    @Test
    public void testStatisticByProduct(){
        for(StatisticByProduct statistic:orderService.getStatisticByProduct()){
            LOGGER.info("Get statistic by product : {}"+statistic);
        }
    }
    @Test
    public void testDeleteOrder(){
        //orderService.deleteOrderByUserAndStatus("tien",9);
    }
}

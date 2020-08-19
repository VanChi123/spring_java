package vn.fis.project.springbootfinaltest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.fis.project.springbootfinaltest.domain.StatisticByDay;
import vn.fis.project.springbootfinaltest.domain.StatisticByProduct;
import vn.fis.project.springbootfinaltest.service.inf.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class StatisticApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("/total")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<StatisticByDay> getAll(){
        return orderService.getStatisticByDay();
    }

    @GetMapping("/groupByProduct")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<StatisticByProduct> getStatisticProduct(){
        return orderService.getStatisticByProduct();
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}

package vn.fis.project.springbootfinaltest.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.fis.project.springbootfinaltest.controller.message.AppResponse;
import vn.fis.project.springbootfinaltest.controller.message.ErrorResponse;
import vn.fis.project.springbootfinaltest.controller.message.SuccessResponse;
import vn.fis.project.springbootfinaltest.entity.OrderLine;
import vn.fis.project.springbootfinaltest.service.inf.OrderLineService;
import vn.fis.project.springbootfinaltest.service.inf.OrderService;
import java.security.Principal;

@RestController
@RequestMapping("/api/order/orderline")
public class OrderLineApi {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderLineApi.class);

    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private OrderService orderService;

    //thêm 1 order line , sau đó cập nhật amount trong orders
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public AppResponse addOrderLine(@RequestBody OrderLine orderLine, Principal principal){
        AppResponse appResponse;
        //thêm mới order line
        OrderLine orderLineSave =orderLineService.saveOrderLine(orderLine);
        if(null!=orderLineSave){
            appResponse= new SuccessResponse();
            appResponse.setMessage("Insert Thành công Order Line");
            appResponse.setData(orderLineSave);
            return appResponse;
        }
        appResponse = new ErrorResponse();
        appResponse.setMessage("Insert Không Thành Công");
        return appResponse;
    }

    //update 1 order line , sau đó cập nhật amount trong orders
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/update")
    public AppResponse updateOrderLine(@RequestBody OrderLine orderLine, Principal principal){
        AppResponse appResponse;
        OrderLine orderLineUpdate =orderLineService.saveOrderLine(orderLine);
        if (null!=orderLineUpdate){
            appResponse = new SuccessResponse();
            appResponse.setMessage("Update thành công");
            appResponse.setData(orderLineUpdate);
            return appResponse;
        }
        appResponse=new ErrorResponse();
        appResponse.setMessage("Update không thành công");
        return appResponse;
    }

    //xóa 1 order line và cập nhật lại amount trong orders
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public AppResponse deleteOrdeLine(@PathVariable("id")Integer id){
        AppResponse appResponse;
        boolean result = orderLineService.deleteOrderLineById(id);
        if(true==result){
            appResponse=new SuccessResponse();
            appResponse.setMessage("Xóa thành công");
            return appResponse;
        }
        appResponse=new ErrorResponse();
        appResponse.setMessage("Xóa không thành công");
        return appResponse;
    }

    public OrderLineService getOrderLineService() {
        return orderLineService;
    }

    public void setOrderLineService(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}

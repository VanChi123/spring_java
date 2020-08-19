package vn.fis.project.springbootfinaltest.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.fis.project.springbootfinaltest.controller.message.AppResponse;
import vn.fis.project.springbootfinaltest.controller.message.ErrorResponse;
import vn.fis.project.springbootfinaltest.controller.message.SuccessResponse;
import vn.fis.project.springbootfinaltest.domain.OrderDto;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.entity.Order;
import vn.fis.project.springbootfinaltest.service.inf.OrderService;
import vn.fis.project.springbootfinaltest.service.inf.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/order")
public class OrderApi {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderApi.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    private AppResponse appResponse;

    //Tạo một order, user id của order là id của user đang sử dụng
    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_MANAGER') or hasRole('ROLE_SALE')")
    public AppResponse insertOrder(@RequestBody Order order, Authentication authentication){

        UserDto userDto = userService.loadUserByUserName(authentication.getName());
        order.setUserId(userDto.getId());
        try {
            LOGGER.info("Insert thành công order : {}", orderService.create(order));
            appResponse = new SuccessResponse();
            appResponse.setMessage("Insert Thành Công");
            appResponse.setData(order);

            }catch (Exception ex){
            appResponse= new ErrorResponse();
            appResponse.setMessage(ex.toString());
        }
        return appResponse;
    }
    //Update order , truyền vào id của order(id), tình trạng mới (status), tên khách hàng mới(customerName)
    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_MANAGER') or hasRole('ROLE_SALE')")
    @PostMapping("/update")
    public AppResponse updateOrder(@RequestBody Map<String, Object> input, Authentication authentication){

        int idOrder = (int) input.get("id");
        int status= (int) input.get("status");
        String customerName = (String) input.get("customerName");
        Order order = orderService.update(authentication.getName(),idOrder,status,customerName);
        if(null!=order){
            appResponse = new SuccessResponse();
            appResponse.setMessage("Update Thành Công");
            appResponse.setData(order);
            return appResponse;
        }
        appResponse = new ErrorResponse();
        appResponse.setMessage("Update Không thành công");
        return appResponse;
    }
    //xóa order theo id với trạng thái là hủy(0) và người tạo nó sẽ xóa
    @GetMapping(value = "/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_MANAGER') or hasRole('ROLE_SALE')")
    public AppResponse deleteOrder(@RequestParam("orderId") int orderId,Authentication authentication){

        boolean resultDelete = orderService.deleteOrderByUserAndStatus(authentication.getName(),orderId);
        if(true==resultDelete){
            appResponse = new SuccessResponse();
            appResponse.setMessage("Xóa thành công");
            return appResponse;
        }
        appResponse = new ErrorResponse();
        appResponse.setMessage("Xóa không thành công");
        return appResponse;
    }
    //hiển thị danh sách order tương ứng user login
    @PreAuthorize("hasRole('ROLE_MANAGER')or hasRole('ROLE_ADMIN')or hasRole('ROLE_SALE')")
    @GetMapping("/list")
    public AppResponse listOrderByUserLogin(Principal principal){
        AppResponse appResponse;
        List<OrderDto> list = orderService.getAllOrderByUserId(principal.getName());
        if(list.size()>0){
            appResponse= new SuccessResponse();
            appResponse.setMessage("Lấy thành công");
            appResponse.setData(list);
            return appResponse;
        }
        appResponse = new ErrorResponse();
        appResponse.setMessage("Không thành công");
        return appResponse;
    }
    //Hiển thị toàn bộ danh sách user ( chỉ có manager  là truy cập được)
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/listall")
    @ResponseBody
    public AppResponse findAll() {
        AppResponse appResponse;
        List<UserDto> list = userService.findAll();
        if(null!=list){
            appResponse =new SuccessResponse();
            appResponse.setMessage("Thành công");
            return appResponse;
        }
        appResponse= new ErrorResponse();
        appResponse.setMessage("Không thành công");
        return appResponse;
    }

    public OrderService getService() {
        return orderService;
    }

    public void setService(OrderService service) {
        this.orderService = service;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

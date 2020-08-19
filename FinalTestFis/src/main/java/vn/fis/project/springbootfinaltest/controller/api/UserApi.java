package vn.fis.project.springbootfinaltest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.fis.project.springbootfinaltest.controller.message.AppResponse;
import vn.fis.project.springbootfinaltest.controller.message.ErrorResponse;
import vn.fis.project.springbootfinaltest.controller.message.SuccessResponse;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.service.inf.UserService;
import vn.fis.project.springbootfinaltest.utils.JwtService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/auth")
    public AppResponse login(HttpServletRequest request, @RequestBody UserDto user) {
        AppResponse appResponse;
        String jwtChain= "";
        try {
            if (userService.checkLogin(user)) {
                jwtChain = jwtService.generateTokenLogin(user.getUsername());
                appResponse = new SuccessResponse();
                appResponse.setMessage("Lấy Thành Công chuỗi Jwt ");
                appResponse.setData(jwtChain);
            } else {
                appResponse=new ErrorResponse();
                appResponse.setMessage("Wrong userId and password");
            }
        } catch (Exception ex) {
            appResponse=new ErrorResponse();
            appResponse.setMessage("Server Error");
        }
        return appResponse;
    }

    @GetMapping("/logout")
    public AppResponse logOut(){
        AppResponse appResponse;
        appResponse = new SuccessResponse();
        appResponse.setMessage("Đã logout thành công");
        return appResponse;
    }

    public JwtService getJwtService() {
        return jwtService;
    }

    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

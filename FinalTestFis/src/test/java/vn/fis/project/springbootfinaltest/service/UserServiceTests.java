package vn.fis.project.springbootfinaltest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.service.inf.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTests.class);

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll(){
        for(UserDto userDto:userService.findAll()){
            LOGGER.info("User Dto: {}",userDto);
        }
    }
    @Test
    public void testCheckLogin(){
        UserDto userDto = new UserDto();
        userDto.setUsername("chibuivan97");
        userDto.setPassword("chi");
        LOGGER.info("Kết quả login là : {}",userService.checkLogin(userDto));
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

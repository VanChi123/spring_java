package vn.fis.project.springbootfinaltest.service.inf;

import vn.fis.project.springbootfinaltest.domain.UserDto;

import java.util.List;


public interface UserService {

    //trả vè list<UserDto>
    public List<UserDto> findAll();
    public UserDto findById(Integer id);
    public boolean add(UserDto userDto);
    public void delete(Integer id);
    public UserDto loadUserByUserName(String userName);
    public boolean checkLogin(UserDto userDto);
    //lấy danh sách role theo id user
    String[] roles(Integer id);
}

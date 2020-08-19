package vn.fis.project.springbootfinaltest.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.repos.UserRepos;
import vn.fis.project.springbootfinaltest.service.inf.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepos userRepos;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> listUserDto =userRepos.getUsersDto();
        for(UserDto userDto:listUserDto){
            String[] roles = roles(userDto.getId());
            userDto.setRoles(roles);
        }
       return listUserDto;
    }

    @Override
    public UserDto findById(Integer id) {
        List<UserDto> listUserDto =findAll();
        for(UserDto userDto :listUserDto){
            if(userDto.getId()==id){
                return userDto;
            }
        }
        return null;
    }

    @Override
    public boolean add(UserDto userDto) {
        List<UserDto> listUserDto =findAll();
        for(UserDto userDtoExist :listUserDto){
        if(userDto.getId()==userDtoExist.getId()||
                StringUtils.equals(userDto.getUsername(), userDtoExist.getUsername())){
            return  false;
            }
        }
        listUserDto.add(userDto);
        return  true;
    }

    @Override
    public void delete(Integer id) {
        List<UserDto> listUserDto =findAll();
        listUserDto.removeIf(userDto -> userDto.getId()==id);
    }

    @Override
    public UserDto loadUserByUserName(String userName) {
        List<UserDto> listUserDto =findAll();
        for(UserDto userDto:listUserDto){
            if(userDto.getUsername().equals(userName)){
                return userDto;
            }
        }
        return null;
    }

    @Override
    public boolean checkLogin(UserDto userDto) {
        List<UserDto> listUserDto =findAll();
        for(UserDto userDtoExist:listUserDto){
            if(StringUtils.equals(userDto.getUsername(),userDtoExist.getUsername())
            &&StringUtils.equals(userDto.getPassword(),userDtoExist.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] roles(Integer id) {
        List<String> rolesList =  userRepos.getRoles(id);
        String[] roles =rolesList.toArray(new String[rolesList.size()]);
        return roles;
    }

    public UserRepos getUserRepos() {
        return userRepos;
    }

    public void setUserRepos(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

}

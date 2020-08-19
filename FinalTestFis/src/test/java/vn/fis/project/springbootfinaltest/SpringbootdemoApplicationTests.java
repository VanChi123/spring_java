package vn.fis.project.springbootfinaltest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.entity.Role;
import vn.fis.project.springbootfinaltest.entity.User;
import vn.fis.project.springbootfinaltest.repos.RoleRepos;
import vn.fis.project.springbootfinaltest.repos.UserRepos;
import vn.fis.project.springbootfinaltest.service.inf.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootdemoApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootdemoApplicationTests.class);

	@Autowired
	private UserRepos userRepos;

	@Autowired
	private UserService userService;

	@Autowired
	private  RoleRepos roleRepos;

	@Test
	@Transactional
	public void contextLoads() {

//		Role role = new Role(4, "A", "Quanr lys a");
//
//		User user1 = new User(4, "a", "a", "buif vawn a");
//		User re1 = userRepos.save(user1);
//		LOGGER.warn(re1.toString());
//		User user2 = new User(5, "b", "b", "buif vawn b");
//
//		User user3 = new User(6, "c", "c", "buif vawn c");
//		User re2 = userRepos.save(user2);
//		LOGGER.warn(re2.toString());
//		User re3 = userRepos.save(user3);
//		LOGGER.warn(re3.toString());
//
//		Set<User> userSet = new HashSet<User>();
//		userSet.add(re1);
//		userSet.add(re2);
//		userSet.add(re3);
//		role.setUsers(userSet);
//
//		roleRepos.save(role);
//		for (Role roleValue : roleRepos.findAll()) {
//			LOGGER.warn("\n" + roleValue.toString());
//		}
	}

	@Test
	@Transactional
	public  void testTwo(){

		Role role1 = roleRepos.getOne(1);
		Role role2 = roleRepos.getOne(2);
		Role role3 = roleRepos.getOne(3);
		Set<Role> roleSet = new HashSet<Role>();
		roleSet.add(role1);
		roleSet.add(role2);
		roleSet.add(role3);
		User user1 = new User();
		user1.setRoles(roleSet);
		userRepos.save(user1);
		for(User user:userRepos.findAll()){
			LOGGER.warn(user.toString());
		}
	}

	@Test
	public  void testGetListUserDto(){
		List<UserDto> userDtoList=userRepos.getUsersDto();
		userDtoList.forEach(userValue->{
			LOGGER.info(userValue.toString());
		});
	}

	@Test
	public  void testGetListUserDto1(){
		List<UserDto> userDtoList=userService.findAll();
		userDtoList.forEach(userValue->{
			LOGGER.info(userValue.toString());
		});
	}

	@Test
	public  void testGetListUserDto2(){
		UserDto userDtoList=userService.findById(1);
			LOGGER.info(userDtoList.toString());
	}

	@Test
	public  void testGetListRole(){
		List<String> getAll = userRepos.getRoles(3);
		for (String str :getAll){
			LOGGER.info(str);
		}
	}

}

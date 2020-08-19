package vn.fis.project.springbootfinaltest.repos;

import java.util.List;

public interface UserReposJDBCTemplate {
    //lấy danh sách tên role theo id user
    List<String> getRoles(Integer id);
}

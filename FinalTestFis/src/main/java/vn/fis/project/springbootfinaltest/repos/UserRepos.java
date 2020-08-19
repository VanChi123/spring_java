package vn.fis.project.springbootfinaltest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.fis.project.springbootfinaltest.domain.UserDto;
import vn.fis.project.springbootfinaltest.entity.User;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface UserRepos extends JpaRepository<User,Integer>, UserReposJDBCTemplate {
    @Transactional
    @Query(name="User.getAllUsers", nativeQuery = true)
    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize",value = "10"))
    public List<UserDto> getUsersDto();
}

package vn.fis.project.springbootfinaltest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fis.project.springbootfinaltest.entity.Role;

public interface RoleRepos extends JpaRepository<Role,Integer> {
}

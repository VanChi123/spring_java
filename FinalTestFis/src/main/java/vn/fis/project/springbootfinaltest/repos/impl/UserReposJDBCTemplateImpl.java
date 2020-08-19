package vn.fis.project.springbootfinaltest.repos.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.fis.project.springbootfinaltest.repos.UserReposJDBCTemplate;

import java.util.List;
@Component
public class UserReposJDBCTemplateImpl implements UserReposJDBCTemplate {
    static final Logger LOG = LoggerFactory
            .getLogger(UserReposJDBCTemplateImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getRoles(Integer id) {
                return jdbcTemplate.queryForList(
                "select r.role_name from user_role ur join roles r on ur.role_id = r.id\n" +
                        "where ur.user_id = ?",new Object[] { id },String.class);
    }
}

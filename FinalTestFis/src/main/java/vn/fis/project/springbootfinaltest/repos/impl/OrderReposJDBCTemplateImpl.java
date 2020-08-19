package vn.fis.project.springbootfinaltest.repos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import vn.fis.project.springbootfinaltest.domain.StatisticByDay;
import vn.fis.project.springbootfinaltest.domain.StatisticByProduct;
import vn.fis.project.springbootfinaltest.repos.OrderReposJDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderReposJDBCTemplateImpl implements OrderReposJDBCTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<StatisticByDay> getAllDay() {
        return jdbcTemplate.query("select date(order_date) DateOnly,count(*),sum(amount)" +
                " from orders where day(date(order_date)) between 1 and 30 group by DateOnly"
                ,new RowMapper<StatisticByDay>(){
            @Override
            public StatisticByDay mapRow(ResultSet resultSet, int i) throws SQLException {
                StatisticByDay statisticByDay = new StatisticByDay();
                statisticByDay.setDay(resultSet.getDate(1));
                statisticByDay.setOrderQuantity(resultSet.getInt(2));
                statisticByDay.setAmountTotal(resultSet.getDouble(3));
                return statisticByDay;
            }
        });
    }

    @Override
    public List<StatisticByProduct> getAllProduct() {
        return jdbcTemplate.query("select o.order_no,o.amount,o.user_id,sum(ol.quantity) from orders o left join order_line ol on o.id = ol.order_id group by o.order_no order by amount desc",
                new RowMapper<StatisticByProduct>(){
                    @Override
                    public StatisticByProduct mapRow(ResultSet resultSet, int i) throws SQLException {
                        StatisticByProduct statisticByProduct = new StatisticByProduct();
                        statisticByProduct.setOrderNo(resultSet.getString(1));
                        statisticByProduct.setAmount(resultSet.getDouble(2));
                        statisticByProduct.setId(resultSet.getInt(3));
                        statisticByProduct.setQuantity(resultSet.getInt(4));
                        return statisticByProduct;
                    }
                });
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

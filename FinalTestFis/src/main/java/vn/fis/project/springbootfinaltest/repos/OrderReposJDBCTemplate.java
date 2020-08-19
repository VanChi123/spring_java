package vn.fis.project.springbootfinaltest.repos;

import vn.fis.project.springbootfinaltest.domain.StatisticByDay;
import vn.fis.project.springbootfinaltest.domain.StatisticByProduct;

import java.util.List;

public interface OrderReposJDBCTemplate {

    //hàm thống kê theo từng ngày
    List<StatisticByDay> getAllDay();

    //hàm thống kê theo từng product
    List<StatisticByProduct> getAllProduct();

}

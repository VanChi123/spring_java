package vn.fis.project.springbootfinaltest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.fis.project.springbootfinaltest.domain.OrderDto;
import vn.fis.project.springbootfinaltest.entity.Order;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface OrderRepos extends JpaRepository<Order, Integer>,OrderReposJDBCTemplate{

    @Transactional
    @Query(name="Order.getOrdersUserLogin", nativeQuery = true)
    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize",value = "10"))
    public List<OrderDto> getOrdersUserLogin(@Param("user_id")int userId);

    @Transactional
    @Modifying
    @Query(value = "delete from Order o where o.status = 0 and o.id=:order_id",nativeQuery = false)
    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "10"))
    public void deleteOrderByUserAndStatus(@Param("order_id")int orderId);
}

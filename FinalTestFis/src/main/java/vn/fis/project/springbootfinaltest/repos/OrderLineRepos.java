package vn.fis.project.springbootfinaltest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.fis.project.springbootfinaltest.entity.OrderLine;
@Repository
public interface OrderLineRepos extends JpaRepository<OrderLine,Integer> {
    @Transactional
    @Query("select sum(o.amount) from OrderLine o where o.orderId = :orderId")
    float getSumAmountByOrderId(@Param("orderId")Integer orderId);
}

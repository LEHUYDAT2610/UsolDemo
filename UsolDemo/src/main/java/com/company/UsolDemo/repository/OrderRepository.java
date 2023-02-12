package com.company.UsolDemo.repository;

import com.company.UsolDemo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "CALL  `usoldb`.proc_getOrder",nativeQuery = true)
    public List<Object[]> GetOrder();

    @Procedure("Update_order")
    public void UpdateOrder(@Param("id") long id);
}

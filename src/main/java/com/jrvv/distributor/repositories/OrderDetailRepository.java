package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.OrderDetail;
import com.jrvv.distributor.entities.Orders;
import com.jrvv.distributor.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrder(Orders order);
    List<OrderDetail> findByProduct(Product product);
}

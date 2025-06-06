package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.OrderDetail;
import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    Optional<OrderDetail> getOrderDetailById(Long id);
    OrderDetail createOrderDetail(OrderDetail detail);
    OrderDetail updateOrderDetail(Long id, OrderDetail detail);
    void deleteOrderDetail(Long id);
}

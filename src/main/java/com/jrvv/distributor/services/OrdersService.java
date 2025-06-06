package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.Orders;
import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> getAllOrders();
    Optional<Orders> getOrderById(Long id);
    Orders createOrder(Orders order);
    Orders updateOrder(Long id, Orders order);
    void deleteOrder(Long id);
}

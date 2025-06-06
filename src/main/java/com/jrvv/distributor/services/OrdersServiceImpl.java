package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.Orders;
import com.jrvv.distributor.repositories.OrdersRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public Orders updateOrder(Long id, Orders order) {
        return ordersRepository.findById(id)
            .map(existing -> {
                existing.setClient(order.getClient());
                existing.setOdrDate(order.getOdrDate());
                existing.setOdrStatus(order.getOdrStatus());
                existing.setOdrTotal(order.getOdrTotal());
                existing.setDetails(order.getDetails());
                return ordersRepository.save(existing);
            }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}

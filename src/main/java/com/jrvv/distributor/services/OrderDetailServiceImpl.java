package com.jrvv.distributor.services;

import com.jrvv.distributor.entities.OrderDetail;
import com.jrvv.distributor.repositories.OrderDetailRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository detailRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return detailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> getOrderDetailById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public OrderDetail updateOrderDetail(Long id, OrderDetail detail) {
        return detailRepository.findById(id)
            .map(existing -> {
                existing.setOrder(detail.getOrder());
                existing.setProduct(detail.getProduct());
                existing.setDtlQuantity(detail.getDtlQuantity());
                existing.setDtlUnitPrice(detail.getDtlUnitPrice());
                return detailRepository.save(existing);
            }).orElseThrow(() -> new RuntimeException("OrderDetail not found"));
    }

    @Override
    public void deleteOrderDetail(Long id) {
        detailRepository.deleteById(id);
    }
}

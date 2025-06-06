package com.jrvv.distributor.repositories;

import com.jrvv.distributor.entities.Orders;
import com.jrvv.distributor.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByClient(Client client);
    List<Orders> findByOdrStatus(String status);
}

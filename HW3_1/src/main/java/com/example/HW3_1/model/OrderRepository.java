package com.example.HW3_1.model;

import com.example.HW3_1.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findById(int id);
    Long deleteById(int id); //// To get deleted record count
}

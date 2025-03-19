package com.project.handloomProject.service;

import com.project.handloomProject.model.Orders;
import com.project.handloomProject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    
    public Orders updateOrder(Long id, Orders updatedOrder) {
        Orders existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setCustomerName(updatedOrder.getCustomerName());
        existingOrder.setStatus(updatedOrder.getStatus());
        return orderRepository.save(existingOrder);
    }

}

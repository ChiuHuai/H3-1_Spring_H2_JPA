package com.example.HW3_1.controller;

import com.example.HW3_1.controller.dto.request.CreateOrderRequest;
import com.example.HW3_1.controller.dto.request.UpdateOrderRequest;
import com.example.HW3_1.controller.dto.response.StatusResponse;
import com.example.HW3_1.model.entity.Order;
import com.example.HW3_1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //http://localhost:8080/order
    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> response = orderService.getAllOrders();
        if (response.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found.");
        }
        return response;
    }

    //http://localhost:8080/order:id
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        Order order = this.orderService.getOrderById(id);
        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        return order;
    }

    //http://localhost:8080/order
    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest request) {
        String response = this.orderService.createOrder(request);
        return new StatusResponse(response);
    }

    //http://localhost:8080/order/:orderId/meal/:mealId
    @PutMapping("/{orderId}/meal/{mealId}")
    public StatusResponse addMealToOrder(@PathVariable int orderId, @PathVariable int mealId) {
        String response = this.orderService.addMealToOrder(orderId, mealId);
        return new StatusResponse(response);
    }

    //http://localhost:8080/order:id
    @PutMapping("/{id}")
    public StatusResponse updateOrder(@PathVariable int id, @RequestBody UpdateOrderRequest request) {
        String response = this.orderService.updateOrder(id, request);
        return new StatusResponse(response);
    }

    //http://localhost:8080/order:id
    @DeleteMapping("/{id}")
    public StatusResponse deleteOrder(@PathVariable int id) {
        String response = this.orderService.deleteOrder(id);
        return new StatusResponse(response);
    }

}

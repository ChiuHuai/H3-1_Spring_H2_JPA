package com.example.HW3_1.service;

import com.example.HW3_1.controller.dto.request.CreateOrderRequest;
import com.example.HW3_1.controller.dto.request.UpdateOrderRequest;
import com.example.HW3_1.model.MealRepository;
import com.example.HW3_1.model.OrderRepository;
import com.example.HW3_1.model.entity.Meal;
import com.example.HW3_1.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 取得所有Order
     *
     * @return List<Order>
     */
    public List<Order> getAllOrders() {
        List<Order> response = orderRepository.findAll();
        return response;
    }

    /**
     * 取得特定id的Order
     *
     * @param id
     * @return Order
     */
    public Order getOrderById(int id) {
        return this.orderRepository.findById(id);
    }

    /**
     * 新增Order
     * id 重複無法新增
     *
     * @param request
     * @return String
     */
    public String createOrder(CreateOrderRequest request) {
        List<Order> allOrders = getAllOrders();
        for (Order o : allOrders) {
            if (o.getId() == request.getId()) {
                return "This ID is not available, please change it!";
            }
        }

        Order order = new Order();
        order.setId(request.getId());
        order.setWaiter(request.getWaiter());
        orderRepository.save(order);
        return "OK";
    }

    /**
     * 取得特定id的Order，並加入特定id的Meal
     * Order id 或 Meal id 找不到會無法修改
     *
     * @param orderId
     * @param mealId
     * @return String
     */
    public String addMealToOrder(int orderId, int mealId) {
        Meal meal = mealRepository.findById(mealId);
        Order order = orderRepository.findById(orderId);

        if (null == meal || null == order) {
            return "Fail.";
        }

        order.addMealToMealList(meal);
        int totalPrice = order.getTotalPrice();
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
        return "OK";
    }

    /**
     * 取得特定id的Order，並修改其內容
     * ID找不到會無法修改
     *
     * @param id
     * @param request
     * @return String
     */
    public String updateOrder(int id, UpdateOrderRequest request) {
        Order order = orderRepository.findById(id);

        if (null == order) {
            return "Fail";
        }

        order.setWaiter(request.getWaiter());
        orderRepository.save(order);
        return "OK";
    }

    /**
     * 取得特定id的Order，並刪除
     * ID找不到會無法刪除
     *
     * @param id
     * @return String
     */
    public String deleteOrder(int id) {
        Order order = orderRepository.findById(id);

        if (null == order) {
            return "Fail";
        }

        Long count = this.orderRepository.deleteById(id);
        if (null == count) {
            return "ok";
        } else {
            String s = count.toString();
            return "delete " + s + " records";
        }
    }

}

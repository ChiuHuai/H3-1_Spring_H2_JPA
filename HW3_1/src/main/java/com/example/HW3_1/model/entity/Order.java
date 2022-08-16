package com.example.HW3_1.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = true)
    private Integer totalPrice;
    //totalPrice 隨著mealList 的增加而變動，不要放在constructor
    @Column
    private String waiter;//服務生

    @Column
    @ManyToMany
    @JoinTable(name = "order_meal",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> mealList = new ArrayList<>(); //餐點list

    public Order(int id, String waiter) {
        this.id = id;
        this.waiter = waiter;
        totalPrice = 0;
    }

    public Order(int id, String waiter, List<Meal> meals) {
        this.id = id;
        this.waiter = waiter;
        this.mealList = meals;
        this.totalPrice = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Meal meal : this.getMealList()) {
            totalPrice += meal.getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;//It's weird to modified totalPrice here.
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void addMealToMealList(Meal meal) {
        this.mealList.add(meal);
    }

}

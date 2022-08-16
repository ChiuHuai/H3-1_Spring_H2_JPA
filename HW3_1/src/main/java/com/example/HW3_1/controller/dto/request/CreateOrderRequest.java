package com.example.HW3_1.controller.dto.request;

import com.example.HW3_1.model.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private int id;
    private String waiter;
}

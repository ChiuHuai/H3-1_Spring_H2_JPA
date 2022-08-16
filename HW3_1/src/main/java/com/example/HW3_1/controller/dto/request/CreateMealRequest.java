package com.example.HW3_1.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMealRequest {
    private int id;
    private String name;
    private int price;
    private String description;
}

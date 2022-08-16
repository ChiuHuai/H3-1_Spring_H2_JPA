package com.example.HW3_1.controller;

import com.example.HW3_1.controller.dto.request.CreateMealRequest;
import com.example.HW3_1.controller.dto.request.UpdateMealRequest;
import com.example.HW3_1.controller.dto.response.StatusResponse;
import com.example.HW3_1.model.entity.Meal;
import com.example.HW3_1.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    MealService mealService;

    //http://localhost:8080/meal
    @GetMapping()
    public List<Meal> getAllMeals() {
        List<Meal> meals = mealService.getAllMeals();
        if (meals.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found.");
        }
        return meals;
    }

    //http://localhost:8080/meal/:id
    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable int id) {
        Meal meal = this.mealService.getMealById(id);
        if(meal == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Not Found");
        }
        return meal;
    }

    //http://localhost:8080/meal
    @PostMapping()
    public StatusResponse createMeal(@RequestBody CreateMealRequest request) {
        String response = this.mealService.createMeal(request);
        return new StatusResponse(response);
    }
    //http://localhost:8080/meal/:id
    @PutMapping("/{id}")
    public StatusResponse updateMeal(@PathVariable int id,@RequestBody UpdateMealRequest request) {
        String response = this.mealService.updateMeal(id, request);
        return new StatusResponse(response);
    }

    //http://localhost:8080/meal/:id
    @DeleteMapping("/{id}")
    public StatusResponse deleteMeal(@PathVariable int id) {
        String response = this.mealService.deleteMealById(id);
        return new StatusResponse(response);
    }
}

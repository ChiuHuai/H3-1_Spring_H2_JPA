package com.example.HW3_1.model;

import com.example.HW3_1.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    Meal findById(int id);
    Long deleteById(int id); //// To get deleted record count
}

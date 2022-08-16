package com.example.HW3_1.service;

import com.example.HW3_1.controller.dto.request.CreateMealRequest;
import com.example.HW3_1.controller.dto.request.UpdateMealRequest;
import com.example.HW3_1.model.MealRepository;
import com.example.HW3_1.model.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    /**
     * 取得所有Meal
     *
     * @return List<Meal>
     */
    public List<Meal> getAllMeals() {
        List<Meal> response = mealRepository.findAll();
        return response;
    }

    /**
     * 取得特定id的Meal
     *
     * @param id
     * @return Meal
     */
    public Meal getMealById(int id) {
        return this.mealRepository.findById(id);
    }

    /**
     * 新增Ｍeal
     * id 重複無法新增
     *
     * @param request
     * @return String
     */
    public String createMeal(CreateMealRequest request) {
        List<Meal> allMeals = getAllMeals();
        for (Meal m : allMeals) {
            if (m.getId() == request.getId()) {
                return "This ID is not available, please change it!";
            }
        }

        Meal meal = new Meal();
        meal.setId(request.getId());
        meal.setName(request.getName());
        meal.setPrice(request.getPrice());
        meal.setDescription(request.getDescription());
        mealRepository.save(meal);
        return "OK";
    }

    /**
     * 取得特定id的Meal，並修改其內容
     * ID找不到會無法修改
     *
     * @param id
     * @param request
     * @return String
     */
    public String updateMeal(int id, UpdateMealRequest request) {
        Meal meal = mealRepository.findById(id);

        if (null == meal) {
            return "Not Found with ID: " + id;
        }

        meal.setName(request.getName());
        meal.setPrice(request.getPrice());
        meal.setDescription(request.getDescription());
        mealRepository.save(meal);
        return "OK";

    }

    /**
     * 取得特定id的Meal，並刪除
     * ID找不到會無法刪除
     *
     * @param id
     * @return String
     */
    public String deleteMealById(int id) {
        Meal meal = mealRepository.findById(id);

        if (null == meal) {
            return "Fail";
        }

        Long count = this.mealRepository.deleteById(id);
        //不確定怎麼使用 count
        // 1.
        // if (null == count) {
//            return "ok";
//        } else {
//            String s = count.toString();
//            return "delete " + s + " records";
//        }
        // 2.
        // assertThat(count).isEqualTo(1);
        return "ok";
    }
}

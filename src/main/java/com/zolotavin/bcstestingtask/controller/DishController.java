package com.zolotavin.bcstestingtask.controller;

import com.zolotavin.bcstestingtask.model.ServiceRequestDish;
import com.zolotavin.bcstestingtask.model.ServiceResponseDish;
import com.zolotavin.bcstestingtask.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DishController {

    private final DishesService dishesService;

    @Autowired
    public DishController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @PostMapping("/register-likes")
    public void registerLikes(@RequestBody ServiceRequestDish serviceRequestDish) {
        dishesService.addDishes(serviceRequestDish.getListDishes());
    }

    @GetMapping("/likes")
    public List<ServiceResponseDish> getAllLikes() {
        return dishesService.getAllLovelyDishes();
    }
}

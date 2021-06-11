package com.zolotavin.bcstestingtask.controller;

import com.zolotavin.bcstestingtask.model.LikedDishRequest;
import com.zolotavin.bcstestingtask.model.DishModel;
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
    public void registerLikes(@RequestBody LikedDishRequest likedDishRequest) {
        dishesService.addDishes(likedDishRequest.getListDishes());
    }

    @GetMapping("/likes/{number}")
    public List<DishModel> getAllLikes(@PathVariable Integer number) {
        return dishesService.getAllLovelyDishes(number);
    }
}

package com.zolotavin.bcstestingtask.controller;

import com.zolotavin.bcstestingtask.model.DishModel;
import com.zolotavin.bcstestingtask.model.LikedDishRequest;
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
        dishesService.dishInsert(likedDishRequest.getListDishes());
    }

    @RequestMapping(value = "/likes", method = RequestMethod.GET)
    @ResponseBody
    public List<DishModel> getNumberOfBestDishes(@RequestParam("top") Integer top) {
        return dishesService.findNumberOfBestDishes(top);
    }
}

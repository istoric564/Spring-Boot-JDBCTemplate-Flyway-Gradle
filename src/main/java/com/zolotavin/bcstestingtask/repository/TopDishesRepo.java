package com.zolotavin.bcstestingtask.repository;

import com.zolotavin.bcstestingtask.model.DishModel;

import java.util.List;


public interface TopDishesRepo {
    List<DishModel> findNumberOfBestDishes(Integer number);
}

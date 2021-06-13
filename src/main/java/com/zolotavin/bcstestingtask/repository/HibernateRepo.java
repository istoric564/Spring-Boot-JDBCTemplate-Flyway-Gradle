package com.zolotavin.bcstestingtask.repository;

import com.zolotavin.bcstestingtask.model.DishModel;

import java.util.List;


public interface HibernateRepo {
    List<DishModel> findNumberOfBestDishes(Integer number);
}

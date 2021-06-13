package com.zolotavin.bcstestingtask.service;

import com.zolotavin.bcstestingtask.model.DishModel;
import com.zolotavin.bcstestingtask.repository.DishesRepositoryHiberImpl;
import com.zolotavin.bcstestingtask.repository.DishesRepositoryJdbcImpl;
import com.zolotavin.bcstestingtask.repository.HibernateRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DishesService {

    private final DishesRepositoryHiberImpl dishesRepositoryHiber;
    private final DishesRepositoryJdbcImpl dishesRepositoryJdbc;

    public DishesService(DishesRepositoryHiberImpl dishesRepositoryHiber, DishesRepositoryJdbcImpl dishesRepositoryJdbc) {
        this.dishesRepositoryHiber = dishesRepositoryHiber;
        this.dishesRepositoryJdbc = dishesRepositoryJdbc;
    }

    public void dishInsert(List<String> listDishes) {
        dishesRepositoryJdbc.dishInsert(listDishes);
    }

    public List<DishModel> findNumberOfBestDishes(@PathVariable Integer number) {
        return dishesRepositoryHiber.findNumberOfBestDishes(number);
    }
}

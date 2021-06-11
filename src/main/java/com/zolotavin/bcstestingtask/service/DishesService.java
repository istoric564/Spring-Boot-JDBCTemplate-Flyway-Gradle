package com.zolotavin.bcstestingtask.service;

import com.zolotavin.bcstestingtask.model.DishModel;
import com.zolotavin.bcstestingtask.repository.DishesRepositoryJdbcImpl;
import com.zolotavin.bcstestingtask.repository.HibernateRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DishesService {

    private final HibernateRepo hibernateRepo;
    private final DishesRepositoryJdbcImpl dishesRepositoryJdbc;

    public DishesService(HibernateRepo hibernateRepo, DishesRepositoryJdbcImpl dishesRepositoryJdbc) {
        this.hibernateRepo = hibernateRepo;
        this.dishesRepositoryJdbc = dishesRepositoryJdbc;
    }

    public void addDishes(List<String> listDishes) {
        dishesRepositoryJdbc.dishInsert(listDishes);
    }

    public List<DishModel> getAllLovelyDishes(@PathVariable Integer number) {
        System.out.println("Топ 10 самых популярных и супер крутых блюд");
        return hibernateRepo.findTopnumberByCount(number);
    }
}

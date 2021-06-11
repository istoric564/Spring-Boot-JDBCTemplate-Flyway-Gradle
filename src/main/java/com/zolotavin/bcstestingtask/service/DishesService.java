package com.zolotavin.bcstestingtask.service;

import com.zolotavin.bcstestingtask.model.ServiceResponseDish;
import com.zolotavin.bcstestingtask.repository.HibernateRepo;
import com.zolotavin.bcstestingtask.repository.JdbcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishesService {

    private final HibernateRepo hibernateRepo;
    private final JdbcRepo jdbcRepo;

    @Autowired
    public DishesService(HibernateRepo hibernateRepo, JdbcRepo jdbcRepo) {
        this.hibernateRepo = hibernateRepo;
        this.jdbcRepo = jdbcRepo;
    }

    public void addDishes(ArrayList<String> listDishes) {
        jdbcRepo.dishInsert(listDishes);
    }

    public List<ServiceResponseDish> getAllLovelyDishes() {
        System.out.println("Топ 10 самых популярных и супер крутых блюд");
        return hibernateRepo.findTop10ByOrderByCountDesc();
    }
}

package com.zolotavin.bcstestingtask.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface DishesRepository {

   void dishInsert(List<String> listDishes);
}

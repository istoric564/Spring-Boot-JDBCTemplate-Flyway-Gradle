package com.zolotavin.bcstestingtask.repository;

import com.zolotavin.bcstestingtask.model.DishModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface HibernateRepo extends JpaRepository<DishModel, Long> {

    List<DishModel> findTopnumberByCount(@PathVariable Integer number);
}

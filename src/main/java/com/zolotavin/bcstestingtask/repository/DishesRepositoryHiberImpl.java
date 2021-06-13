package com.zolotavin.bcstestingtask.repository;

import com.zolotavin.bcstestingtask.model.DishModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DishesRepositoryHiberImpl implements TopDishesRepo {
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public List<DishModel> findNumberOfBestDishes(Integer number) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DishModel> criteriaQuery = criteriaBuilder.createQuery(DishModel.class);
        Root<DishModel> dishModelRoot = criteriaQuery.from(DishModel.class);
        CriteriaQuery<DishModel> getAll = criteriaQuery.select(dishModelRoot);
        criteriaQuery.orderBy(criteriaBuilder.desc(dishModelRoot.get("count")));
        TypedQuery<DishModel> allQuery = entityManager.createQuery(getAll).setMaxResults(number);
        return allQuery.getResultList();
    }
}

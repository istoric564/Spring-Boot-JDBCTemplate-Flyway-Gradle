package com.zolotavin.bcstestingtask.repository;

import com.zolotavin.bcstestingtask.model.DishModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DishesRepositoryHiberImpl implements HibernateRepo {
    @Autowired
    EntityManager entityManager;

    @Override
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

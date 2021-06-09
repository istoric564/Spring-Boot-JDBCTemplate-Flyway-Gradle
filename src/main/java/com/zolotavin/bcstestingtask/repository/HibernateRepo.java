package com.zolotavin.bcstestingtask.repository;

import com.zolotavin.bcstestingtask.model.ServiceResponseDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateRepo extends JpaRepository<ServiceResponseDish, Long> {
}

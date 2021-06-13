package com.zolotavin.bcstestingtask.repository;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class DishesRepositoryJdbcImpl implements DishesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sql = "INSERT INTO likes (dish, count) " +
            "VALUES(?, 1)" +
            "ON CONFLICT (dish) " +
            "DO UPDATE " +
            "SET count = likes.count + 1";

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void dishInsert(List<String> listDishes) {
        this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @SneakyThrows
            public void setValues(PreparedStatement ps, int i) {
                ps.setString(1, listDishes.get(i));
            }

            public int getBatchSize() {
                return listDishes.size();
            }
        });
    }
}

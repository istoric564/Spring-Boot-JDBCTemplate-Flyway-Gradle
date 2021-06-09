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
public class JdbcRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public void dishInsert(List<String> listDishes) {
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO likes (dish, count) VALUES(?, ?)",
                new BatchPreparedStatementSetter() {
                    @SneakyThrows
                    public void setValues(PreparedStatement ps, int i) {
                        ps.setString(1, listDishes.get(i));
                        ps.setInt(2, 1);
                    }
                    public int getBatchSize() {
                        return listDishes.size();
                    }
                });
    }
}

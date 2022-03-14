package com.example.basic.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class sunbyulDAO {

    @Autowired
    JdbcTemplate jt;

    public List<Map<String, Object>> select(int startRow) {
        return jt.queryForList("select * from sunbyul limit ?, 10",startRow);
    }
    
}

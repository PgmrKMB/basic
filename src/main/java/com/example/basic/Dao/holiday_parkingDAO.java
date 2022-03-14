package com.example.basic.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class holiday_parkingDAO {

    @Autowired
    JdbcTemplate jt;

    public List<Map<String, Object>> select(int page) {
        return jt.queryForList("select * from holiday_parking limit ?, 10",page);
    }
}

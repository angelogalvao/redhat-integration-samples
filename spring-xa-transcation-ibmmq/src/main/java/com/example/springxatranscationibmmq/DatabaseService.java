package com.example.springxatranscationibmmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    

    @Transactional(propagation = Propagation.REQUIRED)
    public void doSomethingTransacted(){

        jdbcTemplate.update("INSERT INTO test(value) values (?)", "TEST");
    }
}

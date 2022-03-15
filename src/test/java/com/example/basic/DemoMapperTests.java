package com.example.basic;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.example.basic.mapper.DemoMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoMapperTests {

    @Autowired
    DemoMapper demoMapper;

     @Test
     public void insert(){
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 map.put("seq", 3);
    	 map.put("user", "CCC");
    	 int z = demoMapper.insert(map);
    	 System.out.println(z);
     }
     
     @Test
     public void select() {
    	 List<Map<String, Object>> result = demoMapper.select();
    	 System.out.println(result);
     }

}

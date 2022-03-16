package com.example.basic;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.example.basic.mapper.DemoMapper;
import com.example.basic.model.Demo;
import com.example.basic.model.Holiday_Parking;
import com.example.basic.repository.DemoRepository;
import com.example.basic.repository.HoliRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoRepositoryTests {

    @Autowired
    DemoRepository demoRepository;
    @Autowired
    HoliRepository hp;
    
    @Test
    public void insert() {
    	Demo demo = new Demo();
    	demo.setSeq(4L);
    	demoRepository.save(demo);
    }

    @Test
    public void update() {
    	Demo demo = new Demo(); 
    	demo.setSeq(4L);		
    	demo.setUser("DDDaa");
    	demoRepository.save(demo);
    }
    
    @Test
    public void update2() {
    	Demo demo = demoRepository.findById(4L).get();
    	demo.setUser("DDD");
    	demoRepository.save(demo);
    }
    
    @Test
    public void select() {
    	System.out.println(demoRepository.findAll());
    }
    
    @Test
    public void holiins() {
    	List<Holiday_Parking> list = hp.findByInstitution("성산고등학교");
    	List<Holiday_Parking> list2 = hp.findByInstitutionContaining("중학");
    	System.out.println(list);
    }
    
}

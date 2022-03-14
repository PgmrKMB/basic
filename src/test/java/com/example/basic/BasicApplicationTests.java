package com.example.basic;

import java.util.List;
import java.util.Map;

import com.example.basic.Dao.holiday_parkingDAO;
import com.example.basic.Dao.sunbyulDAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BasicApplicationTests {
	
	
	//JUnit - 단위테스트 ( <--> 통합테스트 )
	//기능별.. API(메소드- ex. dao.select()), 회원가입(기능,업무)
	//테스트 했던 상황-데이터는 한번 확인 후 소멸...
	//흔적을 남겨둘 수 있음 (어떤 데이터, 어떤 사오항에서 테스트를 실행 했음)
	// 업데이트(업그레이드) 수행 시 이전의 테스트 환경대로 다시 확인 가능
	//TDD (Test Driven Development) -- 실패하는 경우를 먼저 코드로 작성!
	//etc.. DDD(Domain) / BDD(Behavior) 


	@Autowired
	holiday_parkingDAO hDao;
	
	@Test
	void contextLoads() {
		List<Map<String, Object>> result = hDao.select(1);
		System.out.println(result);
	}
		
	@Autowired
	sunbyulDAO sDao;
	
	@Test
	void contextLoads2() {
		List<Map<String, Object>> result = sDao.select(1);
		System.out.println(result);
		
	}
}
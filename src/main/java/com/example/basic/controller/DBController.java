package com.example.basic.controller;

import java.util.List;
import java.util.Map;

import com.example.basic.Dao.holiday_parkingDAO;
import com.example.basic.Dao.sunbyulDAO;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.PollMapper;
import com.example.basic.mapper.SunbyulMapper;
import com.example.basic.model.Demo;
import com.example.basic.model.Holiday_Parking;
import com.example.basic.model.Night_Pharmacy;
import com.example.basic.repository.DemoRepository;
import com.example.basic.repository.HoliRepository;
import com.example.basic.repository.NightpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
    @Autowired
    JdbcTemplate jt;
    
    @Autowired
    holiday_parkingDAO hDao;

    @Autowired
    sunbyulDAO sDao;
    
    @Autowired
    DemoMapper demoMapper;

    //class 영역에 명령문(코드) 작성x
    // List list;
    // list.add(1);

    @GetMapping("/mybatis/demo")
    public List<Map<String, Object>> select(List<Map<String, Object>> a) {
    	a = demoMapper.select();
    	return a; 
    }
   
    @Autowired
    PollMapper pollMapper;
    
    @GetMapping("mybatis/poll")
    public String mybatisPoll(@RequestParam Map<String, Object> map) {
    	pollMapper.insert(map);
    	return "ok";
    }
    
    
    @GetMapping("/jdbc/demo")
    public List<Map<String, Object>> jdbcDemo() {
        
        //지역변수는 반드시 초기화 수행 후 활용
        // List<Integer> list = null;
        // list.add(1);
        // list.add("aa");
        
        return jt.queryForList("select * from demo");

    }
    
    
    @GetMapping("/jdbc/demo2")
    public Map<String, Object> jdbcDemo2() {
        return jt.queryForObject("select * from demo", Map.class);
    }
    
    @GetMapping("/jdbc/demo3")
    public Demo jdbcDemo3() {
        Demo demo = jt.queryForObject("select * from demo", Demo.class);
        return demo;
    }

    @GetMapping("/jdbc/holi")
    public List<Map<String, Object>> holi(@RequestParam(value = "page", defaultValue = "1") int page ){
        // return jt.queryForList("select * from holiday_parking where address like '%금천구%'");
        int startRow = page * 10 - 10;

        return hDao.select(startRow);
    }

    @GetMapping("/jdbc/sunbyul")
    public List<Map<String, Object>> sunbyul(@RequestParam(value = "page", defaultValue = "0") int page ){
        int startRow = 0;
        if(page == 0){
            startRow = 0;
        }else{
            startRow = page * 10 - 10;
        }

        return sDao.select(startRow);
    }
    
    @Autowired
    SunbyulMapper sunbyulMapper;
    
    @GetMapping("/mybatis/sunbyul")
    public List<Map<String, Object>> mbsunbyul(@RequestParam(value = "page", defaultValue = "0") int page ){
    	int startRow = 0;
    	if(page == 0){
    		startRow = 0;
    	}else{
    		startRow = page * 10 - 10;
    	}
    	return sunbyulMapper.select(startRow);
    }
    
	@Autowired
	DemoRepository demoRepository;

	@GetMapping("/jpa/demo/{page}")
	public List<Demo> jpaDemo(@PathVariable("page")int page) {
		
//		Sort sort = Sort.by(Sort.Direction.DESC, "user");
//		
//		Pageable p = PageRequest.of(page-1,3,sort);
//		
//		Page<Demo> result = demoRepository.findAll(p);
//    	
//    	List<Demo> demoList = result.getContent();
//		
//		return demoList;
		
		Pageable p = PageRequest.of(page-1,3);
		
		return demoRepository.findByOrderByUserDesc(p);
	}

	
	@Autowired
	HoliRepository hp;
	
	@GetMapping("/jpa/holi")
    public List<Holiday_Parking> jpaholi(){
        return hp.findAll();
    
    }
    
    @Autowired
    NightpRepository np;
    
    @GetMapping("/jpa/np1")
    public List<Night_Pharmacy> pn(@RequestParam("page") int page){
    	Pageable p = PageRequest.of(page-1,5);
    	return np.findByRoadAddressContainingOrJibunAddressContainingOrderByIdDesc("대전","대전",p);
    }

    @GetMapping("/jpa/np2/{page}")
    public List<Night_Pharmacy> pn2(@PathVariable("page")int page){
    	
    	Sort sort = Sort.by("name");
    	
    	sort = Sort.by(Sort.Direction.DESC, "id");
    	
    	
    	Pageable p = PageRequest.of(page-1,10,sort);
    	
    	Page<Night_Pharmacy> result = np.findAll(p);
    	
    	List<Night_Pharmacy> npList = result.getContent();
    	
    	return npList;
    }
    
}


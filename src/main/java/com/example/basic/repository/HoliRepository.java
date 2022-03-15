package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Demo;
import com.example.basic.model.Holiday_Parking;

@Repository // @생략가능
public interface HoliRepository extends JpaRepository<Holiday_Parking, Long> {

	List<Holiday_Parking> findByInstitution(String institution);
	List<Holiday_Parking> findByInstitutionContaining(String institution);
	
}

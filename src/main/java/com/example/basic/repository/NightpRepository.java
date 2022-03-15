package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Night_Pharmacy;

@Repository // @생략가능
public interface NightpRepository extends JpaRepository<Night_Pharmacy, Long> {
	
	List<Night_Pharmacy> findByRoadAddressContainingOrJibunAddressContaining(String roadAdress, String jibunAdress);
	
	
}

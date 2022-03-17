package com.example.basic;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Player;
import com.example.basic.model.Team;
import com.example.basic.repository.TeamRepository;


@SpringBootTest
public class TeamRepositoryTests {

	@Autowired
	TeamRepository tr;

	@Test
	void 조회연습() {
		Optional<Team> opt = tr.findById(1L);
		Team team = opt.get();
		String teamName = team.getName();
		System.out.println(teamName);
		
		List<Player> players = team.getPlayers();
		
		System.out.println(players);
		// toString() 에서 재귀호출 처럼 동작
		// team -> player -> team -> player ....
		


	}
}
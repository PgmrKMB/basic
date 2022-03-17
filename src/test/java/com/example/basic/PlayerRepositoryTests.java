package com.example.basic;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Player;
import com.example.basic.model.Team;
import com.example.basic.repository.PlayerRepository;

@SpringBootTest
public class PlayerRepositoryTests {

	@Autowired
	PlayerRepository pr;

	@Test
	void 조회연습() {
		Optional<Player> opt = pr.findById(3L);
		Player player = opt.get();

		String teamName = player.getTeam().getName(); // join
		System.out.println(teamName);

	}

	@Test
	void 입력연습() {
		Player player = new Player();
		player.setName("player 1");

		Team team = new Team();
		team.setId(1L);

		player.setTeam(team);

		pr.save(player);
	}

}

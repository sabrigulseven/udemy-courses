package com.godoro.springrest.sports.service;


import java.util.ArrayList;
import java.util.List;

//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.springrest.data.Player;

@RestController
public class PlayerResource {
	// @GetMapping(value = "/sports/player", produces=
	// MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/sports/player/{id}")
	public Player getPlayer(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan GEncebay", 12.34);
		return player;
	}
	
	@GetMapping("/sports/players")
	public List<Player> getPlayers() {
		
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player(801, "Orhan GEncebay", 12.34)) ;
		playerList.add(new Player(802, "Ferdi Tayfur", 15.67)) ;
		playerList.add(new Player(803, "Müslüm Gürses", 18.90)) ;
		return playerList;
	}
	
	@PostMapping("/sports/player")
	public Player postPlayer(@RequestBody Player player) {
		
		System.out.println(player);
		player.setPlayerId(804);
		return player;
		
	}
}

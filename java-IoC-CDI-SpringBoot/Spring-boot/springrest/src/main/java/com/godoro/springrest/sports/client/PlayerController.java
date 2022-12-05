package com.godoro.springrest.sports.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.godoro.springrest.data.Player;


@Controller
public class PlayerController {
	@GetMapping("/client/player/{id}")
	@ResponseBody
	public String getPlayer(@PathVariable("id") long playerId) {
		String url = "http://localhost:8080/sports/player/"+playerId;
		RestTemplate restTemplate = new RestTemplate();
		//String json = restTemplate.getForObject(url, String.class);
		Player player = restTemplate.getForObject(url, Player.class);
		System.out.println("Json"+player);
		return "Oyuncu alındı: " + player;
	}
}

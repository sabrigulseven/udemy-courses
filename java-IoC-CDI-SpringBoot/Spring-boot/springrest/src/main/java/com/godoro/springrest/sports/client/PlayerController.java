package com.godoro.springrest.sports.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.godoro.springrest.data.Player;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
	/*
	 * @GetMapping("/client/player/{id}")
	 * 
	 * @ResponseBody public String getPlayer(@PathVariable("id") long playerId) {
	 * String url = "http://localhost:8080/sports/player/"+playerId; RestTemplate
	 * restTemplate = new RestTemplate(); //String json =
	 * restTemplate.getForObject(url, String.class); Player player =
	 * restTemplate.getForObject(url, Player.class);
	 * System.out.println("Json"+player); return "Oyuncu alındı: " + player; }
	 */

	@GetMapping("/client/player/{id}")
	@ResponseBody
	public String getPlayer(@PathVariable("id") long playerId) {
		String url = "http://localhost:8080/sports/player/" + playerId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Player> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				Player.class);
		Player player = responseEntity.getBody();
		return "Oyuncu alındı: " + player;
	}

	@GetMapping("/client/players")
	@ResponseBody
	public String getPlayers() {
		String url = "http://localhost:8080/sports/players/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Player>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
				new ParameterizedTypeReference<List<Player>>() {
				});
		List<Player> playerList = responseEntity.getBody();
		for (Player player : playerList) {
			System.out.println(player);
		}
		return "Oyuncu alındı: " + playerList.size();
	}

	@GetMapping("/client/send")
	@ResponseBody
	public String sendPlayer(@RequestParam(name = "name") String playerName,
			@RequestParam(name = "score") double averageScore) {
		Player player = new Player(0, playerName, averageScore);
		String url = "http://localhost:8080/sports/player";
		RestTemplate restTemplate = new RestTemplate();

		// Player resultPlayer = restTemplate.postForObject(url, player, Player.class);

		ResponseEntity<Player> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
				new HttpEntity<Player>(player), Player.class);
		Player resultPlayer = responseEntity.getBody();
		return "Yollandı" + resultPlayer;
	}

}

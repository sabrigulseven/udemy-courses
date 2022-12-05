package com.godoro.springrest.sports.service;

import java.nio.charset.Charset;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.springrest.data.Player;

@RestController
public class StatusResource {
	@GetMapping("/status/ok/{id}")
	public ResponseEntity<Player> getOk(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan GEncebay", 12.34);
		// return new ResponseEntity<>(player, HttpStatus.OK);
		// return ResponseEntity.status(HttpStatus.OK).body(player);
		return ResponseEntity.ok(player);
	}
	
	@GetMapping("/status/notfound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan GEncebay", 12.34);
		if (playerId==0) {
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oyuncu Bulunamadı");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(player);
	}
	
	@GetMapping("/status/type/{id}")
	public ResponseEntity<Player> getType(@PathVariable("id") long playerId) {
		Player player = new Player(playerId, "Orhan GEncebay", 12.34);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(new MediaType("application","json",Charset.forName("UTF-8")))
				.body(player);
	}
}

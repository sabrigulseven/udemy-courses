package com.godoro.springrest.data;

public class Player {

	private long playerId;
	private String playerName;
	private Double averageScore;

	public Player() {
	}

	public Player(long playerId, String playerName, Double averageScore) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.averageScore = averageScore;
	}

	public long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Double getAverageScore() {
		return this.averageScore;
	}

	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}

	public Player playerId(long playerId) {
		setPlayerId(playerId);
		return this;
	}

	public Player playerName(String playerName) {
		setPlayerName(playerName);
		return this;
	}

	public Player averageScore(Double averageScore) {
		setAverageScore(averageScore);
		return this;
	}

	@Override
	public String toString() {
		return "{" + " playerId='" + getPlayerId() + "'" + ", playerName='" + getPlayerName() + "'" + ", averageScore='"
				+ getAverageScore() + "'" + "}";
	}

}

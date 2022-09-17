package br.com.cod3r.flyweight.musicPlayer.model;

import br.com.cod3r.flyweight.musicPlayer.musicFlyweight.MusicFlyweight;

public class Music {

	private MusicFlyweight musicFlyweight;
	private Integer playerQty;

	public Music(final MusicFlyweight musicFlyweight) {
		this.musicFlyweight = musicFlyweight;
		this.playerQty = 0;
	}

	public MusicFlyweight getMusicFlyweight() {
		return musicFlyweight;
	}

	public void listenning() {
		playerQty++;
	}

	public Integer getPlayerQty() {
		return playerQty;
	}

	@Override
	public String toString() {
		return "Music [name=" + musicFlyweight.getName() +
				", artist=" + musicFlyweight.getArtist() +
				", durationInSeconds=" + musicFlyweight.getDurationInSeconds()
				+ ", playerQty=" + playerQty + "]";
	}
}

package rageteam.butterslap.arena;

import rageteam.butterslap.main.ButterSlap;

public class Game {
	ButterSlap plugin;
	public Game(ButterSlap instance) { this.plugin = instance; }

	public static enum GameMode {
		DISABLED,LOBBY,INGAME,ENDING,NEW_ARENA,ERROR;
	}
}


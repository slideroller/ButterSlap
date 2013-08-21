package rageteam.butterslap.objects;

public class BPlayer {
	public String username;
	public String rank;
	public int wins;
	public int kills;
	
	public BPlayer(String username, String rank, int wins, int kills) {
		this.username = username;
		this.rank = rank;
		this.wins = wins;
		this.kills = kills;
	}
}

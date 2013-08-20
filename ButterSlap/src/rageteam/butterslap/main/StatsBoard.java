package rageteam.butterslap.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class StatsBoard {
	ButterSlap plugin;
	public StatsBoard(ButterSlap instance) { this.plugin = instance; }
	
	public ScoreboardManager manager;
	public Scoreboard board;
	public Objective obj;
	
	//Integers
	public int coins = 0;
	public int wins = 0;
	public int scores = 0;
	
	public void stats(){
		
		manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
		obj = board.registerNewObjective("Stats", "dummy");
		
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ChatColor.GOLD + "ButterSlap Stats");
		
	    Score coin = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Coins;"));
	    coin.setScore(coins);
		
		Score win = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Wins:"));
		win.setScore(wins);
		
		Score score = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Score:"));
		score.setScore(scores);
		
		for(Player player : Bukkit.getOnlinePlayers()){
			player.setScoreboard(board);
		}
	}
}
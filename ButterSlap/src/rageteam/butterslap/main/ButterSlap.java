package rageteam.butterslap.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import rageteam.butterslap.arena.Game;
import rageteam.butterslap.listeners.PlayerListener;


public class ButterSlap extends JavaPlugin{
	
	//Util Classes
	public Logger logger;
	
	//Scoreboard
	public ScoreboardManager manager;
	public Objective obj;
	public Scoreboard ingame;
	public StatsBoard stats;
	
	//Listeners
	public PlayerListener pListener;
	
	//Integers
	public int timeLeft = 240;
	public int players = 0;
	public int highScore = 0;
	public int arena = 0;
	public int doublejump = 1;
	
	//Config
	
	//Commands
	//-------------------------------
	// ADD COMMANDS HERE!!!! - only the connection to the main (not real commands :D)
	//----------------------------------------
	//Arena
	public Game game;

	public Object bridge;

	public void loadDepdencies(){

		this.stats = new StatsBoard(this);
		
		this.pListener = new PlayerListener(this);
		
		this.game = new Game(this);
	
	}
	
	public void loadListeners(){
		getServer().getPluginManager().registerEvents(pListener, this);
	}
	
	@Override
	public void onEnable(){
		loadDepdencies();
		loadListeners();
		
		//In-Game Scoreboard
		manager = Bukkit.getScoreboardManager();
		ingame = manager.getNewScoreboard();
		obj = ingame.registerNewObjective("ButterSlap", "dummy");
					
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ChatColor.GOLD + "ButterSlap");
						
		final Score time = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.RED + "Time Left:" + ChatColor.RED));
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			public void run(){
				if(timeLeft != -1){
					if(timeLeft != 0){
						time.setScore(timeLeft);
						timeLeft--;
					} else if(timeLeft == 0){
						time.setScore(0);
						timeLeft--;
					}
				}
			}
		}, 0L, 20L);
						
		Score online = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_AQUA + "Players:" + ChatColor.RED));
		online.setScore(players);
						
		Score hScore = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.YELLOW + "HighScore:" + ChatColor.RED));
		hScore.setScore(highScore);
						
		Score arenas = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Arena Name:" + ChatColor.RED));
		arenas.setScore(arena);
		
		stats.stats();
	    Score doublejumps = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE + "Double Jump:" + ChatColor.RED));
	    doublejumps.setScore(doublejump);
	
	}
	
	public void onDisable(){
	}
}


package rageteam.butterslap.util;

import rageteam.butterslap.main.ButterSlap;

public class Logger {
	ButterSlap plugin;
	public Logger(ButterSlap instance) { this.plugin = instance; }
	
	public void log(boolean warning, String message) {
		if(warning) { }
		else { }
	}
	
	public void logError(Exception ex) {
		log(true, "Error");
	}
}

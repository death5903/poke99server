package poke99server.utils;

import poke99server.gameobj.GameMessage;

public class GameLogger {
	
	public static synchronized void log(String s){
		System.out.println("///////");
		System.out.println(s);
	}
	
	public static synchronized void log(GameMessage msg){
		System.out.println("///////");
		System.out.println("action: "+msg.getAction());
		System.out.println("data: "+msg.getData());
	}

}

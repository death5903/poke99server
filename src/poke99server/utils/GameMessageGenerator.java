package poke99server.utils;

import poke99server.gameobj.GameMessage;

public class GameMessageGenerator {
	
	public static synchronized GameMessage create(String action , String data){
		GameMessage message = new GameMessage();
		message.setAction(action);
		message.setData(data);
		return message;
	}

}

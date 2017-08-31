package poke99server.utils;

import poke99server.gameobj.GameMessage;

public class GameMessageGenerator {
<<<<<<< HEAD
	
=======

>>>>>>> a78e5ee7b7b91bbb6389b61745ce9ffeb9f7d1a7
	public static synchronized GameMessage create(String action) {
		GameMessage message = new GameMessage();
		message.setAction(action);
		return message;
	}

	public static synchronized GameMessage create(String action, String data) {
		GameMessage message = new GameMessage();
		message.setAction(action);
		message.setData(data);
		return message;
	}

	public static synchronized GameMessage create(String action, String data, String data2) {
		GameMessage message = new GameMessage();
		message.setAction(action);
		message.setData(data);
		message.setData2(data2);
		return message;
	}

}

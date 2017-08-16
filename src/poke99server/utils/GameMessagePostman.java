package poke99server.utils;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import poke99server.gameobj.GameMessage;

public class GameMessagePostman {
	
	public static synchronized boolean send(Session session , GameMessage message){
		
		boolean flag = true;
		
		try {
			session.getBasicRemote().sendObject(message);
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}

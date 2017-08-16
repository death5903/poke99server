package poke99server.utils;

import javax.websocket.Session;

import poke99server.gameobj.GameMessage;
import poke99server.gameobj.GameTask;

public class GameTaskGenerator {

	public static GameTask create(Session playerSession,GameMessage message){
		return new GameTask(playerSession, message);
	}
}

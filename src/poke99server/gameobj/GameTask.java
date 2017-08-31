package poke99server.gameobj;

import javax.websocket.Session;

import poke99server.utils.GameLogger;
import poke99server.utils.GameMessagePostman;
import poke99server.utils.ServerActions;

public class GameTask implements Runnable {

	private Session playerSession;
	private GameMessage message;

	public GameTask(Session playerSession, GameMessage message) {
		this.playerSession = playerSession;
		this.message = message;
	}

	@Override
	public void run() {

		switch (message.getAction()) {
		case "LOGIN":

			break;
		default:
			GameMessagePostman.send(this.playerSession, message);
		}
	}

}

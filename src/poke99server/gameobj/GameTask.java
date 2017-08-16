package poke99server.gameobj;

import javax.websocket.Session;

import poke99server.utils.GameLogger;
import poke99server.utils.GameMessagePostman;

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
		case "test":
			GameLogger.log(message);
			if (playerSession.isOpen()) {
				GameMessagePostman.send(playerSession, message);
			}

		}
	}

}

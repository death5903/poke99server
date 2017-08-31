package poke99server.gameobj;

import javax.websocket.Session;

import poke99server.utils.PlayerStatus;

public class Player {
	
	private Session session;
	private int status;
	private GameField gameField;

	public Player(Session session){
		this.session = session;
		this.status = PlayerStatus.IDLE.ordinal();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public GameField getGameField() {
		return gameField;
	}

	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}
	

}

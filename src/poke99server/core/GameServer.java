package poke99server.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;


import poke99server.gameobj.GameField;
import poke99server.gameobj.Player;
import poke99server.utils.GameLogger;
import poke99server.utils.GameMessageGenerator;
import poke99server.utils.GameMessagePostman;
import poke99server.utils.ServerActions;

public class GameServer extends Endpoint {

	public static Map<Integer, Player> allPlayer = Collections.synchronizedMap(new HashMap<Integer, Player>());
	public static Map<Integer, GameField> allGameField = Collections.synchronizedMap(new HashMap<Integer, GameField>());
	public static ExecutorService gameHandleTaskThreadPool = Executors.newFixedThreadPool(2);

	public GameServer() {
		super();
		GameLogger.log("server 初始化");
	}

	@Override
	public void onOpen(Session session, EndpointConfig arg1) {
		
		Player incomingPlayer = new Player(session);

		GameLogger.log("玩家: " + session.hashCode() + " 登入遊戲!");

		session.addMessageHandler(new GameMessageHandler(session));

		allPlayer.put(session.hashCode(), incomingPlayer);
		GameLogger.log("線上人數: " + allPlayer.size());

		GameMessagePostman.send(session, GameMessageGenerator.create(ServerActions.LOGIN.toString(), "success"));

	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		
		GameLogger.log("玩家: " + session.hashCode() + " 離開遊戲!");

		allPlayer.remove(session.hashCode());
		GameLogger.log("線上人數: " + allPlayer.size());
	}

	@Override
	public void onError(Session session, Throwable throwable) {

		GameLogger.log("玩家: " + session.hashCode() + " 斷線!");

		allPlayer.remove(session.hashCode());
		GameLogger.log("線上人數: " + allPlayer.size());

	}

}

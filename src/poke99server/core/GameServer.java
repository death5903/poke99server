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
import poke99server.utils.GameLogger;
import poke99server.utils.GameMessageGenerator;
import poke99server.utils.GameMessagePostman;
import poke99server.utils.ServerActions;

public class GameServer extends Endpoint {

	public static Map<Integer, Session> allPlayerSession = Collections.synchronizedMap(new HashMap<Integer, Session>());
	public static Map<Integer, GameField> allGameField = Collections.synchronizedMap(new HashMap<Integer, GameField>());
//	public static SynchronizedQueue<GameTask> gameTaskQueue = new SynchronizedQueue<GameTask>();
	public static ExecutorService gameHandleTaskThreadPool = Executors.newFixedThreadPool(2);

	public GameServer() {
		super();
		GameLogger.log("server ��l��");
	}

	@Override
	public void onOpen(Session session, EndpointConfig arg1) {

		GameLogger.log("���a: " + session.hashCode() + " �n�J�C��!");

		session.addMessageHandler(new GameMessageHandler(session));

		allPlayerSession.put(session.hashCode(), session);
		GameLogger.log("�u�W�H��: " + allPlayerSession.size());

		GameMessagePostman.send(session, GameMessageGenerator.create(ServerActions.LOGIN.toString(), "success"));

	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {

		GameLogger.log("���a: " + session.hashCode() + " �o�Ϳ��~!");

		allPlayerSession.remove(session.hashCode());
		GameLogger.log("�u�W�H��: " + allPlayerSession.size());
	}

	@Override
	public void onError(Session session, Throwable throwable) {

		GameLogger.log("���a: " + session.hashCode() + " �_�u!");

		allPlayerSession.remove(session.hashCode());
		GameLogger.log("�u�W�H��: " + allPlayerSession.size());

	}

}

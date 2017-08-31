package poke99server.core;

import java.util.Date;
import java.util.concurrent.ExecutorService;

import javax.websocket.MessageHandler;
import javax.websocket.Session;

import poke99server.gameobj.GameMessage;
import poke99server.utils.GameLogger;
import poke99server.utils.GameTaskGenerator;

public class GameMessageHandler implements MessageHandler.Whole<GameMessage> {
	
	public Session playerSession = null;
	public ExecutorService gameHandleTaskThreadPool = null;

	public GameMessageHandler(Session session) {
		this.playerSession = session;
		this.gameHandleTaskThreadPool = GameServer.gameHandleTaskThreadPool;
	}
	
	@Override
	public void onMessage(GameMessage message) {
		
//		for(int i=0;i<10;i++)
//		gameHandleTaskThreadPool.execute(GameTaskGenerator.create(playerSession, message));
//		
//		System.out.println(Thread.currentThread().getName()+"/"+new Date().getTime()+"/¥D");
		
		gameHandleTaskThreadPool.execute(GameTaskGenerator.create(playerSession, message));
		
	}

}

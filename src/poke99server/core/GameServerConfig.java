package poke99server.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.Decoder;
import javax.websocket.Encoder;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

import poke99server.gameobj.MessageDecoder;
import poke99server.gameobj.MessageEncoder;


public class GameServerConfig implements ServerApplicationConfig {

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		
		Set<ServerEndpointConfig> configSet = new HashSet<ServerEndpointConfig>();
		
		List<Class<? extends Decoder>> decoders = new ArrayList<Class<? extends Decoder>>();
		decoders.add(MessageDecoder.class);
		List<Class<? extends Encoder>> encoders = new ArrayList<Class<? extends Encoder>>();
		encoders.add(MessageEncoder.class);
		
		configSet.add(ServerEndpointConfig.Builder.create(GameServer.class, "/server")
				.decoders(decoders).encoders(encoders).build());
		
		return configSet;
	}
	
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

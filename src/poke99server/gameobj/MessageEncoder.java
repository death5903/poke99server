package poke99server.gameobj;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<GameMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String encode(GameMessage message) throws EncodeException {
		
		JsonObject jObj = Json.createObjectBuilder()
				.add("action", message.getAction())
				.add("data", message.getData())
				.add("data2", message.getData2())
				.build();
		
		return jObj.toString();
	}

}

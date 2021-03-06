package poke99server.gameobj;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import poke99server.utils.GameMessageGenerator;

public class MessageDecoder implements Decoder.Text<GameMessage> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public GameMessage decode(String str) throws DecodeException {
		JsonObject jObj = Json.createReader(new StringReader(str)).readObject();
		switch (jObj.keySet().size()) {
		case 1:
			return GameMessageGenerator.create(jObj.getString("action"));
		case 2:
			return GameMessageGenerator.create(jObj.getString("action"), jObj.getString("data"));
		case 3:
			return GameMessageGenerator.create(jObj.getString("action"), jObj.getString("data"),
					jObj.getString("data2"));
		default:
			return null;
		}
	}

	@Override
	public boolean willDecode(String str) {
		boolean flag = true;
		try {
			Json.createReader(new StringReader(str)).readObject();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}

		return flag;
	}

}

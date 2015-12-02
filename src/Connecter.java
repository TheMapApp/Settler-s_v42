import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class Connecter extends Listener {

	public Client client;

	public void connect(String ip) throws IOException {
		// SERVER CLIENT STUFF
		client = new Client();
		Kryo kryo = client.getKryo();
		kryo.register(HousePosX.class);
		kryo.register(HousePosY.class);
		client.start();
		client.connect(5000, ip, Main.tcpPort, Main.udpPort);
		client.addListener(new Connecter());
	}

	public void sendPacket(int tempX, int tempY) {
		HousePosX posX = new HousePosX();
		HousePosY posY = new HousePosY();
		posX.x = tempX;
		posY.y = tempY;
		client.sendTCP(posX);
		client.sendTCP(posY);
	}

	@Override
	public void received(Connection c, Object p) {
		if (p instanceof HousePosX) {

			HousePosX packet = (HousePosX) p;
			System.out.println(packet.x);
			Grid.hus[1] = new House(packet.x, packet.x);
		}
		if (p instanceof HousePosY) {
			HousePosY packet = (HousePosY) p;
			System.out.println(packet.y);
		}
	}
}

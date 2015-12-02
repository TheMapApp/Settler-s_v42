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
        System.out.println("Sent package");
	}

	@Override
	public void received(Connection c, Object p) {
		if (p instanceof HousePosX) {
			HousePosX packet = (HousePosX) p;
			Main.houseX = packet.x;
            Main.addHouseX = true;
            System.out.println("Received x");
		}
		if (p instanceof HousePosY) {
			HousePosY packet = (HousePosY) p;
			Main.houseY = packet.y;
            Main.addHouseY = true;
            System.out.println("Received y");

        }
	}
}

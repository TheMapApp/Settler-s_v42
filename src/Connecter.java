import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

public class Connecter extends Listener {

	public Client client;

	public void connect(String ip) throws IOException {
        Log.set(Log.LEVEL_DEBUG); // A log for debugging

        // SERVER CLIENT STUFF
        //Registering all the classes sent between the server and the client
		client = new Client();
		Kryo kryo = client.getKryo();
		kryo.register(HousePosX.class);
		kryo.register(HousePosY.class);
        kryo.register(RoadX1.class);
        kryo.register(RoadX2.class);
        kryo.register(RoadY1.class);
        kryo.register(RoadY2.class);
        kryo.register(PlayerColor.class);
        //This class is needed in order to send the array used to place the ressource numbers and ressource type
        kryo.register(int[].class);
        kryo.register(Ressources.class);
        kryo.register(ResType.class);
        kryo.register(Turn.class);
        kryo.register(DiceRoll.class);


        client.start();
		client.connect(5000, ip, Main.tcpPort, Main.udpPort); //Connect the client to the server
		client.addListener(new Connecter());
	}

    // A function used to send the placed house's coordinates to the server. Takes two positions as input
	public void sendHousePacket(int tempX, int tempY) {
		HousePosX posX = new HousePosX();
		HousePosY posY = new HousePosY();
		posX.x = tempX;
		posY.y = tempY;
		client.sendTCP(posX);
		client.sendTCP(posY);
        System.out.println("Sent house package");
	}

    // A function used to send the placed road's coordinates to the server. Takes four positions as input
    public void sendRoadPacket(int tempX1, int tempX2, int tempY1, int tempY2){
        RoadX1 posX1 = new RoadX1();
        RoadX2 posX2 = new RoadX2();
        RoadY1 posY1 = new RoadY1();
        RoadY2 posY2 = new RoadY2();
        posX1.x1 = tempX1;
        posX2.x2 = tempX2;
        posY1.y1 = tempY1;
        posY2.y2 = tempY2;
        client.sendTCP(posX1);
        client.sendTCP(posX2);
        client.sendTCP(posY1);
        client.sendTCP(posY2);
        System.out.println("Sent road package");
    }

    //
    public void endTurn(){
        //send package til server om tur er slut
        Turn tur = new Turn();
        Main.turn = false;
        client.sendTCP(tur);
        System.out.println("Sending turn package");
    }
    //This function is called, every time the client receives something from the server
	@Override
	public void received(Connection c, Object p) {
        if(p instanceof ResType){ // If it receives the array containing the ressource types
            ResType packet = (ResType) p;
            Hexagon.resType = packet.resType;
            System.out.println("ResType package " + packet.resType[0]);
        }

        if(p instanceof Ressources){ // If it receives the array containing the ressource types
            Ressources packet = (Ressources) p;
            Grid.shuffledArray = packet.res;
            Grid.arrayReceived = true;
            System.out.println("Received shuffled array");
            System.out.println(packet.res[2]);
        }

		if (p instanceof HousePosX) { // If it receives the array containing the x-position of the house
            HousePosX packet = (HousePosX) p;
            Main.houseX = packet.x;
            Player.setcolor(packet.x);
            Main.addHouseX = true;
            System.out.println("Received x");
        }
        if (p instanceof HousePosY) { // If it receives the array containing the y-position of the house
            HousePosY packet = (HousePosY) p;
            Main.houseY = packet.y;
            Main.addHouseY = true;
            System.out.println("Received y");
        }
        if (p instanceof RoadX1) { // If it receives the array containing the first x-position of the road
            RoadX1 packet = (RoadX1) p;
            Main.roadTempX1 = packet.x1;
            Main.addRoadX1 = true;
            System.out.println("Received x1");
        }
        if (p instanceof RoadX2) { // If it receives the array containing the second x-position of the road
            RoadX2 packet = (RoadX2) p;
            Main.roadTempX2 = packet.x2;
            Main.addRoadX2 = true;
            System.out.println("Received x2");
        }
        if (p instanceof RoadY1) { // If it receives the array containing the first y-position of the road
            RoadY1 packet = (RoadY1) p;
            Main.roadTempY1 = packet.y1;
            Main.addRoadY1 = true;
            System.out.println("Received y1");
        }
        if (p instanceof RoadY2) { // If it receives the array containing the second y-position of the road
            RoadY2 packet = (RoadY2) p;
            Main.roadTempY2 = packet.y2;
            Main.addRoadY2 = true;
            System.out.println("Received y2");
        }
        if (p instanceof PlayerColor) {
            PlayerColor packet = (PlayerColor) p;
            Player.setcolor(packet.playerColor);
            Main.id = packet.playerColor;
            System.out.println("Player ID is: " + packet.playerColor);
        }
        if(p instanceof Turn){
            Turn packet = (Turn) p;
            if(packet.turn == Main.id){
                Main.turn = true;
            }
        }
        if(p instanceof DiceRoll){ //If it receives the integer containg the diceroll
            DiceRoll packet = (DiceRoll) p;
            Main.roll = packet.dieRoll;
            Main.bob = true;
            System.out.println("Received dieroll and it is: " + packet.dieRoll);
        }
	}
}

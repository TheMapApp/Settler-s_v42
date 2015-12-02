import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Scanner;



public class Main extends JPanel {
	Image image1;

// CLIENT - SERVER STUFF START

    public static boolean houseSend = false;
    public static int houseTempX;
    public static int houseTempY;
    public static int houseX;
    public static int houseY;

    public static boolean addHouseX = false;
    public static boolean addHouseY = false;

    public static boolean roadSend = false;
    public static int roadTempX1;
    public static int roadTempX2;
    public static int roadTempY1;
    public static int roadTempY2;

    public static boolean addRoadX1 = false;
    public static boolean addRoadY1 = false;
    public static boolean addRoadX2 = false;
    public static boolean addRoadY2 = false;

    public static String ipconnect;
    public static int tcpPort = 54555, udpPort = 54555;
    public boolean connected = true;

    // CLIENT - SERVER STUFF END

    // LOBBY STUFF START

    public static boolean lobby = true;
    public static boolean gameStart = false;
    Scanner reader = new Scanner(System.in);

    // LOBBY STUFF END

	
	


	 Grid gamemap = new Grid(100,100);
	 static boolean updater = false;



	DiceRoller dice = new DiceRoller();

	
	Buying buy = new Buying();
    Connecter connect = new Connecter();
	
	 Main(int width, int height) {

		 this.addMouseListener(buy);
		 gamemap.fill();
			
		 for(int k =0; k<5;k++){
			 for(int l =0; l<5;l++){		 
		 // some of the places in the array are empty because of the 3,4,5,4,3 structure of the game map
		if(gamemap.hexarray[k][l]!=null){
			 this.addMouseListener(gamemap.hexarray[k][l]);
		}
	 }
			 
		 }


		 ImageIcon background = new ImageIcon("images/background.jpg");
		  image1 = background.getImage();

		 dice.Roll();


		 Grid gamemap = new Grid(200,200);

		 

	
	 }
	 public void update(){

         if(connected){
             try {
                 connect.connect("127.0.0.1");
                 connected = false;
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

		if(Grid.updater==true){
	    this.repaint();
	    Grid.updater=false;
		}

         while (houseSend) {
             System.out.println("Trying to send house package");
             connect.sendHousePacket(houseTempX, houseTempY);
             houseSend = false;
         }
         while (roadSend) {
             System.out.println("Trying to send road package");
             connect.sendRoadPacket(roadTempX1, roadTempX2, roadTempY1, roadTempY2);
             roadSend = false;
         }
         while(addHouseX && addHouseY){
             Grid.hus[Grid.housecounter] = new House(houseX, houseY);
             Grid.housecounter+=1;
             Grid.updater=true;
             addHouseX = false;
             addHouseY = false;
         }
         while(addRoadX1 && addRoadX2 && addRoadY1 && addRoadY2){
             System.out.println("Trying to draw road");
             Grid.vej[Grid.roadcounter] = new Road(roadTempX1, roadTempY1, roadTempX2, roadTempY2);
             Grid.roadcounter += 1;
             Grid.updater = true;
             addRoadX1 = false;
             addRoadX2 = false;
             addRoadY1 = false;
             addRoadY2 = false;
         }
	 }
	 
	 
	
	    public void paint(Graphics g) {
			g.drawImage(image1, 0, 0, null);

		 // this for loop draws each hexagon
		 for(int k =0; k<5;k++){
			 for(int l =0; l<5;l++){

		 // some of the places in the array are empty because of the 3,4,5,4,3 structure of the game map
		if(gamemap.hexarray[k][l]!=null){

			 this.addMouseListener(gamemap.hexarray[k][l]);
		 gamemap.hexarray[k][l].paint(g);

		
				 }
			 }

		 }
		 
		 //buy.paint(g);//paints the circles for buttons

		 buy.paint(g);//paints the circles for buttons
		 
		 
	    }
	


	 public static void main(String[] args) {
//sizing of the gamemap
	        int width = 800;
	        int height = 600;

         JFrame frame = new JFrame("Settler's"); //create a new window and set title on window
	        frame.setSize(width, height); //set size of window
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set the window to close when the cross in the corner is pressed
	          
	 
	       Main m = new Main(width,height-22);
	        frame.add(m);
	        frame.setVisible(true); //make the window visible
	        
	        while (true) { //keep running a loop
	            //each time the loop is run do
	        	  m.update();
	            try {
	                Thread.sleep(30); //stops this part of the program for 10 milliseconds to avoid the loop locking everything. Now the screen has time to update content etc.
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	        }
	        
	    	

	    }
	
	
}

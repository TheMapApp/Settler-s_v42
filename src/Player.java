import java.awt.*;

import javax.swing.JFrame;

public class Player {

	// this is the constructor for the player
	
	private int playerId;
	private boolean longestRoad;
	private boolean Playersturn;
	static Color _Playercolor= new Color(255,0,0);
	static int [] resources= new int [6]; // an array that stores each player's resources and victory points






	public Player(int id)
	{
		playerId=id;
		resources[5]=0;
		setcolor(3);

		resources[0] = 10;//brick
		resources[1] = 10;//wood
		resources[2] = 10;//wheat
		resources[3] = 10;//ship
		resources[4] = 10;//stone
		resources[5] = 10;//victory point

	}
	//this function initialize an array at the start of the game
	//on the last position the player has the victory 
	public void initializeResources()
	{
		for(int i=0;i<6;i++) {
			if(i==5) resources[i]=2;// at the  beginning of the game each player has 2 points
			else resources[i]=0; //
		}
	}
	//this function returns 1 if the player has reached the maximum number of points
	public int CheckWin(){
		
		if(resources[5]==10) return 1; 
		else return 0;
		
	}
	//methods for checking if the player has the longest road
	
	public boolean checkLongestRoad() {
		return longestRoad;
	}
	public void changeLongestRoad() {
		
		if(longestRoad==true) { 
			longestRoad=false;
			resources[5]=-2;
		}
		else {
			longestRoad=true;
			resources[5]=+2;
		}
	}
		
		public int getId (){
			return playerId;
		}
		
		public boolean checkPlayersTurn (int PlayersTurn){
		
			 if (PlayersTurn==1) return true;
			 else return false;
	}


	public void paintPlayer(Graphics g){
		g.setColor(Color.white);
		g.setFont(new Font("Cambria",Font.BOLD, 14));
		g.drawString("Player "+ playerId +":",25,25);
		g.drawString("Brick: "+resources[0],25,40);
		g.drawString("Wheat: "+resources[4],25,55);
		g.drawString("Stone: "+resources[3],25,70);
		g.drawString("Ship: "+resources[2],25,85);
		g.drawString("Wheat: "+resources[1],25,100);
		g.drawString("Points: "+resources[5],25,115);


	}


	public static void setcolor(int k )
	{
		if(k == 1) {
			_Playercolor= new Color(232, 215, 45);
		}
		if(k == 2) {
			_Playercolor= new Color(199, 9, 72);
		}
		if(k == 3) {
			_Playercolor= new Color(0, 46, 199);
		}
		if(k == 4) {
			_Playercolor= new Color(12, 190, 199);
		}
	}

}
	
	
	// depending on where the player has the settlements he will get resources
	//the code needs to be changed 
	//a function that checks where the player has settlements and/or cities and updates the resources array
	
    


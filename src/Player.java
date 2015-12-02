import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Player {
	int [] resources= new int [6]; // an array that stores each player's resources and victory points
	// this is the constructor for the player
	
	private int playerId;
	private boolean longestRoad;
	private boolean Playersturn;
	
	
	public Player(int id)
	{
		playerId=id;
		resources[5]=0;
		
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
}
	
	
	// depending on where the player has the settlements he will get resources
	//the code needs to be changed 
	//a function that checks where the player has settlements and/or cities and updates the resources array
	
    


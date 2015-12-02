import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Grid  implements MouseListener {
	
		
	
	int _i;
	int _k;
	static boolean updater = false;
	public static House[] hus = new House[10];
	public static Road[] vej = new Road[10];
	static int housecounter =1;
	
	public Hexagon[][] hexarray = new Hexagon[5][5];
	
	
	Grid(int i, int k){
		
		_i=i;
		_k = k;
		
	}
	// makes the pattern and fills the hexagons into the 2d array
		public void fill(){
			
		 
		 for(int r =0; r <3; r++){
		    hexarray[0][r]=new Hexagon((r*50+_i)*2,(_k)*2);}
		 for(int r =0; r <4; r++){
			 hexarray[1][r]=new Hexagon ((r*50+_i-25)*2,(_k+43)*2);  }
		 for(int r =0; r <5; r++){
			 hexarray[2][r]=new Hexagon ((r*50+_i-50)*2,(_k+86)*2);  }
		 for(int r =0; r <4; r++){
			 hexarray[3][r]=new Hexagon ((r*50+_i-25)*2,(_k+129)*2);  }
		 for(int r =0; r <3; r++){
			 hexarray[4][r]=new Hexagon ((r*50+_i)*2,(_k+172)*2);  }
		 
	
				 
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("hey");
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
		
		
		
				 
			 
}

	
	



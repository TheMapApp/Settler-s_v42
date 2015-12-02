import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

	public class Buying extends JPanel implements MouseListener{

		Trading trading; 
	
		Image image;
		boolean window, window1, window2, window3;
		 static boolean roadactive = false, houseactive = false, townactive = false;
	
		Buying(){
			int[] tmparray = new int[6];
			tmparray[0]= 100;
			tmparray[1]= 100;
			tmparray[2]= 100;
			tmparray[3]= 100;
			tmparray[4]= 100;
			tmparray[5]= 100;

			trading = new Trading(tmparray);

		}
		   
	public void paint(Graphics g) { 
		
		int width = 800;
		int height = 600;
		
				
			    g.setColor(Color.WHITE);
			    g.fillOval(width - 100, height - 120, 70, 70);
			    g.setColor(Color.WHITE);
			    g.fillOval(width - 100, height - 200, 70, 70);
			    g.setColor(Color.WHITE);
			    g.fillOval(width - 100, height - 280, 70, 70);
			    
			   		
			    ImageIcon road = new ImageIcon("images/Road.png");
			    image = road.getImage();
			    g.drawImage(image, width - 100, height - 120 , null);
			    
			    ImageIcon house = new ImageIcon("images/House.png");
			    image = house.getImage();
			    g.drawImage(image, width - 100, height - 200 , null);
			    
			    ImageIcon town = new ImageIcon("images/Town.png");
			    image = town.getImage();
			    g.drawImage(image, width - 100, height - 280 , null);
			    
			   
			    if(window==true){
			    	//create a confirmation window
				    g.setColor(Color.GRAY);
				    g.drawRect(200, 200, 400, 200);
				    ImageIcon popUp = new ImageIcon("images/itempopup.png");
				    image = popUp.getImage();
				    g.drawImage(image, 200, 200, null);
				    
			  

			    }
			    
	    
}



	 
	public double dist(int x1, int x2, int y1, int y2 ){
		double dist;
		float xdif;
		float ydif;
		
			if(x1 > x2)
				xdif = x1 - x2;
			else 
				xdif = x2 - x1;
			if(y1 > y2)
				ydif = y1 - y2;
			else
				ydif = y2 - y1;
			
			dist = Math.sqrt(xdif*xdif+ydif*ydif);
			
		return dist;
		}
		
		

		@Override
		public void mouseClicked(MouseEvent e) {

			int mx = e.getX();
			int my = e.getY();
			
			//buy a road
		if (mx > 800 - 100 && mx < 800 && my > 600 - 120 && my < 600) {
			System.out.println("3");
			window = true;
			window1 = true;
			}

			if(window1 == true && mx > 255 && mx < 365 && my > 315 && my < 355){
				System.out.println("yes");
				if(trading.BuyARoad()==true){
				roadactive =true;
				}
				window = false;
				window1 = false;
			} 
			
				if (mx > 435 && mx < 545 && my > 315 && my < 355){
					System.out.println("No");
					window = false;
					window1 = false;
			}
			
		
	
			
			//buy a settlement 
		if (mx > 800 - 100 && mx < 800 && my > 600 - 200 && my < 600 - 120) {
			System.out.println("2");
			window = true;
			window2 = true;
		       
			}
			if(window2 == true && mx > 255 && mx < 365 && my > 315 && my < 355){
				System.out.println("yes");
				if(trading.BuySettlement()==true){
					houseactive =true;
					}
				
				window = false;
				window2 = false;
			}
			if (mx > 435 && mx < 545 && my > 315 && my < 355){
				System.out.println("No");
				window = false;
				window2 = false;
			
			
			}
			//buy a city
		if (mx > 800 - 100 && mx < 800 && my > 600 - 280 && my < 600 - 200) {
			System.out.println("1");
			window = true;		
			window3 = true;
		
		}
			if(window3 == true && mx > 255 && mx < 365 && my > 315 && my < 355){
				System.out.println("yes");
				if(trading.BuyCity()==true){
					townactive =true;
					}
				window = false;
			}
			if (mx > 435 && mx < 545 && my > 315 && my < 355){
				System.out.println("No");
				window = false;
		}
							
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




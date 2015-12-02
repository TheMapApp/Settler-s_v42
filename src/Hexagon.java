import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Hexagon extends JPanel implements MouseListener {
	
	static int pmx=0;
	static int pmy=0;
	// the posistion of each hexagon
	int _posx;
	int _posy;
	boolean itson = false;
	Color _color = new Color(0, 100, 0);
	Color _color2 = new Color(0, 0, 0);

	// arrays filled with x and y vaules of the hexagon points
	int[] shapex = new int[6];
	int[] shapey = new int[6];

	int r = 57;
	Middlepoint[] middlearray = new Middlepoint[6];
	  
	  Color brick = new Color (152, 0, 0);
	  Color wood = new Color (0, 102, 0);
	  Color stone = new Color (115, 115, 115);
	  Color wheat = new Color (247, 244, 57);
	  Color sheep = new Color (102, 255, 102);
	  Color desert = new Color (235, 177, 54);

	Hexagon(int posx, int posy) {

		_posy = posy;
		_posx = posx;

		// filles in the posisition of the points
		for (int i = 0; i < 6; i++) {
			shapex[i] = ((int) (_posy + r * Math.cos(i * 2 * Math.PI / 6)));
			shapey[i] = (int) (_posx + r * Math.sin(i * 2 * Math.PI / 6));
		}
		
		// initialises the corner points
		for (int b = 0; b < 6; b++) {
			middlearray[b] = new Middlepoint(shapex[b] - 5, shapey[b] - 5);
					}	
	}

	@Override
	public void paint(Graphics g) {
		
		
		for (int l = 0; l < 6; l++) {
			for(int i=0 ;i<10;i++){
			if(Grid.hus[i]!=null){
			if (dist(Grid.hus[i]._xpos, shapex[l] ,Grid.hus[i]._ypos, shapey[l]) <= 20) {
			itson=true;
			}
			}
			}
}

		// draws the hexagon
		g.setColor(_color2);
		g.drawPolygon(shapex, shapey, 6);
		

		if (itson == true) {
			g.setColor(_color);
			g.fillPolygon(shapex, shapey, 6);

		}

		for (int b = 0; b < 6; b++) {
			middlearray[b].paint(g);

			
			for(int i=0 ;i<10;i++){
			if (Grid.hus[i] != null) {
				Grid.hus[i].paint(g);
			}
			}
			if (Grid.vej[1] != null) {
				Grid.vej[1].paint(g);
			}
			if (Grid.vej[2] != null) {
				Grid.vej[2].paint(g);
			}
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		

		int mx = e.getX();
		int my = e.getY();
		
		
		///++++++housebuyer+++++/////
		if (Buying.houseactive) {
			//checks if you are pressing a cornerpoint
			for (int l = 0; l < 6; l++) {
				
			if (dist(mx, shapex[l] , my, shapey[l]) <= 20) {
				
			
				Grid.hus[Grid.housecounter] = new House(mx, my);
				middlearray[l].setlamp(true);
				Grid.housecounter+=1;
				System.out.println("house placed on grid");
				Buying.houseactive = false;
			}
			}
		}
		///++++++housebuyer+++++/////
		
		///+++roadbuyer+++////
		if (Buying.roadactive) {
			
			//System.out.println(""+mx+"  "+ pmx+"  " +"  "+ my+"  "+ pmy+"" );
			if(pmx!=0){
			System.out.println(dist( mx, pmx , my, pmy)  );
			}
			for (int l = 0; l < 6; l++) {
				
				if (dist(mx, shapex[l] , my, shapey[l]) <= 20 && middlearray[l]._lamp==true &&pmx==0) {
					pmx =shapex[l];
					pmy =shapey[l];
					System.out.println("first point set");
					middlearray[l].setlamp2(true);
					
					}else if(dist( mx, pmx , my, pmy) <= 70 && dist(mx, pmx , my, pmy) >= 30 && dist(mx, shapex[l] , my, shapey[l]) <= 20){
					Grid.vej[1] = new Road(pmx, pmy,mx,my);
					System.out.println("second point set");
					middlearray[l].setlamp(true);
					middlearray[l].setlamp2(false);
					pmx =0;
					pmy =0;
					Buying.roadactive = false;
					
					
					
				}
			
			}
		}
		
		
		///+++roadbuyer+++////
		
		
		
		
/*
		for (int l = 0; l < 6; l++) {
			
			//checks the distance to a cornerpoint
				if (dist(mx, shapex[l] , my, shapey[l]) <= 20) {
				//sets heaxgons to true if their middlepoint is pressed.
					
					itson = true;

				//places house if there is no houses yet
				if (Buying.houseactive&& Grid.hus[1] == null) {
					Grid.hus[1] = new House(mx, my);
					
					Buying.houseactive = false;
				}
				//places road if there is a house
				if (Buying.roadactive &&  dist( mx, Grid.hus[1]._xpos, my, Grid.hus[1]._ypos) <= 70){
					Grid.vej[1] = new Road(mx, my,Grid.hus[1]._xpos,Grid.hus[1]._ypos);
					//turns on the cornerpoint so it can be used later
				middlearray[l].setlamp(true);
				}
				
				
				//makes the second road in a row
				if(Buying.roadactive && dist( mx,Grid.vej[1]._xpos, my,Grid.vej[1]._ypos)<=70 ){
					Grid.vej[2] = new Road(mx, my,Grid.vej[1]._xpos,Grid.vej[1]._ypos);
					System.out.println("detvirker");
					for (int u = 0; u < 6; u++) {
						if (dist(mx, shapex[u] , my, shapey[u]) <= 20) {
							middlearray[u].setlamp(true);
						}
						}
				}
				
				
		
			}
		}
			*/	

		Grid.updater = true;
		// System.out.println("hey"+Grid.updater);
						
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

	public double dist(int x1, int x2, int y1, int y2) {
		double dist;
		float xdif;
		float ydif;

		if (x1 > x2)
			xdif = x1 - x2;
		else
			xdif = x2 - x1;
		if (y1 > y2)
			ydif = y1 - y2;
		else
			ydif = y2 - y1;

		dist = Math.sqrt(xdif * xdif + ydif * ydif);

		return dist;
	}
	
	/*public void drawHex(int resource) {
		if(resource==0) g.setColor(wheat);
		else if (resource==1) g.setColor(stone);
		else if (resource==2) g.setColor(brick);
		else if (resource==3) g.setColor(wood);
		else if (resource==4) g.setColor(desert);
		
	}*/
	
	

}

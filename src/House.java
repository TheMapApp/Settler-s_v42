import java.awt.Color;
import java.awt.Graphics;

public class House {

	int _xpos;
	int _ypos;
	Color _color= new Color(255,0,0);
	
	House(int xpos,int ypos){
		
		
		
		_xpos = xpos;
		_ypos = ypos;
	
	}
	
public void paint(Graphics g) {
		 
		
		
		// draws the hexagon
	
	 g.setColor(_color);
    // g.fillRect(_xpos-10,_ypos-15, 30, 30);
		g.drawRect(_xpos-10, _ypos-15,30,30);
	
		
			
		
		}
		
	
	}

	
	
	


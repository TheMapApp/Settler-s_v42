import java.awt.Color;
import java.awt.Graphics;

public class Road {
	
	int _xpos;
	int _ypos;
	int _xpos2;
	int _ypos2;
	Color _color = new Color(0,0,0);
	
	Road(int xpos, int ypos,int xpos2, int ypos2){
		
		
		_xpos = xpos;
		_ypos = ypos;
		_xpos2 = xpos2;
		_ypos2 = ypos2;
	
	}

public void paint(Graphics g) {
		 
		
		
		// draws the hexagon
	
	 g.setColor(_color);
	 
		g.drawLine(_xpos, _ypos,_xpos2,_ypos2);
		
		
			
		
		}

}

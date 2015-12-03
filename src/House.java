import java.awt.Color;
import java.awt.Graphics;

public class House {

	int _xpos;
	int _ypos;
    int enemyColor;
    boolean myhouse = false;
	Color _color= Player._Playercolor;
	
	/*House(int xpos,int ypos){
		
		_xpos = xpos;
		_ypos = ypos;
	}
*/
    House(int xpos,int ypos, int i){
        enemyColor = i;
        Player.setcolor(i);
        _xpos = xpos;
        _ypos = ypos;
    }

    public void paint(Graphics g) {
		 
		
		
		// draws the hexagon
	
	 g.setColor(_color);
        if(enemyColor == 1){
            g.setColor(new Color (100, 100, 0));
        }
     g.fillRect(_xpos-10,_ypos-15, 30, 30);
		g.drawRect(_xpos-10, _ypos-15,30,30);
	
		
			
		
		}
		
	
	}

	
	
	


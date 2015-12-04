import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Grid {

    static boolean arrayReceived = false;
    static int[] shuffledArray = new int[18];
	
	int _i;
	int _k;
	static boolean updater = false;
	public static House[] hus = new House[20];
    public static House[] enemyhus = new House[20];
	public static Town[] by = new Town[20];
	public static Road[] vej = new Road[20];
	static int housecounter =0;
    static int enemyhousecounter =0;
	static int towncounter =0;
	static int roadcounter =1;
	
	public Hexagon[][] hexarray = new Hexagon[5][5];

	public static ImageIcon [] numbers = new ImageIcon[19];

	int p = 0;
    int resourcelvl =1;
	
	Grid(int i, int k){
		
		_i=i;
		_k = k;
		
	}
	// makes the pattern and fills the hexagons into the 2d array
		public void fill(){

            if(arrayReceived) {

                for (int r = 0; r < 3; r++) {
                    hexarray[0][r] = new Hexagon((r * 50 + _i) * 2, (_k) * 2);
                }
                for (int r = 0; r < 4; r++) {
                    hexarray[1][r] = new Hexagon((r * 50 + _i - 25) * 2, (_k + 43) * 2);
                }
                for (int r = 0; r < 5; r++) {
                    hexarray[2][r] = new Hexagon((r * 50 + _i - 50) * 2, (_k + 86) * 2);
                }
                for (int r = 0; r < 4; r++) {
                    hexarray[3][r] = new Hexagon((r * 50 + _i - 25) * 2, (_k + 129) * 2);
                }
                for (int r = 0; r < 3; r++) {
                    hexarray[4][r] = new Hexagon((r * 50 + _i) * 2, (_k + 172) * 2);
                }


                for (int n = 0; n < 19; n++) {
                    numbers[n] = new ImageIcon("images/" + n + ".png");
                }


                for (int n = 0; n < 5; n++) {


                    for (int k = 0; k < 5; k++) {
                        // numbers[n + k] = new ImageIcon("images/" + n + ".png");
                        if (hexarray[n][k] != null) {

                            hexarray[n][k].image = numbers[shuffledArray[p]].getImage();
                            hexarray[n][k].diceval =shuffledArray[p];
                            hexarray[n][k].colCode = Hexagon.resType[p];
                            p = p + 1;
                            if (p >= 18) {
                                p = 18;
                            }
                        }
                    }
                }

            }
            updater = true;
		}


    public void resourcedister() {


        for (int n = 0; n < 5; n++) {


            for (int k = 0; k < 5; k++) {
                // numbers[n + k] = new ImageIcon("images/" + n + ".png");
                if (hexarray[n][k] != null) {


                    if (hexarray[n][k].itson == true) {
                        resourcelvl = 1;
                    }else if (hexarray[n][k].itsontown == true){

                        resourcelvl = 2;
                        if (Main.roll == 2 && hexarray[n][k].diceval == 1) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 3 && hexarray[n][k].diceval == 2) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 3 && hexarray[n][k].diceval == 3) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 4 && hexarray[n][k].diceval == 4) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 4 && hexarray[n][k].diceval == 5) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 5 && hexarray[n][k].diceval == 6) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 5 && hexarray[n][k].diceval == 7) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 6 && hexarray[n][k].diceval == 8) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 6 && hexarray[n][k].diceval == 9) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 8 && hexarray[n][k].diceval == 10) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                       else if (Main.roll == 8 && hexarray[n][k].diceval == 11) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 9 && hexarray[n][k].diceval == 12) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                       else  if (Main.roll == 9 && hexarray[n][k].diceval == 13) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 10 && hexarray[n][k].diceval == 14) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                       else if (Main.roll == 10 && hexarray[n][k].diceval == 15) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 11 && hexarray[n][k].diceval == 16) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 11 && hexarray[n][k].diceval == 17) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                        else if (Main.roll == 12 && hexarray[n][k].diceval == 18) {
                            Player.resources[hexarray[n][k].colCode-1] += resourcelvl;
                        }
                    }
                }
            }
        }
    }
}

	
	



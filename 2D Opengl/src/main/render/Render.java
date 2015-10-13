package main.render;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Render {
	
	public int space;
	
	public static Block cube;
	
	public Render() {
		
	}
	
	public static void draw() {
		 cube  = new Block();
		 //cube.drawGrass(0, 0);
		 int x = 0;
		 int y = 0;
     for(int i = 0; i <= 13; i++) {
    	 x = i * 300;
    	 for(int k = 0; k <= 13; k++) {
    		 cube.drawCobble(x, y);
    		 y = k * 300;
    	 }
     }
		
	}
	
	public static void displayUpdate() {
		Display.update();
		Display.sync(60);

	}

}

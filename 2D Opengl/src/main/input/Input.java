package main.input;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import main.render.DisplayManager;

public class Input {

	public Input() {
	}
	
	
	public static void TranslateUp() {
		int translateX = 0;
		int translateY = 0;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			System.out.println("Right");
			translateX = -3;
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			System.out.println("left");
			translateX = 3;
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			System.out.println("Up");
			translateY = 3;
		}
		
		
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			System.out.println("Down");
			translateY = -3;
		}
		
		GL11.glTranslatef(translateX, translateY, 0);
		
	}
}

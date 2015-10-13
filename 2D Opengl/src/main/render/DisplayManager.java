package main.render;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import main.input.Input;

public class DisplayManager {
	
	private static Texture mossyCobblestone;

	private static int WIDTH;
	private static int HEIGHT;
	
	public DisplayManager() {
		WIDTH = 1280;
		HEIGHT = 1280;
		createDisplay();
	}
	
	public void createDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
		//	Display.setResizable(false);
			Display.setTitle("Game Window");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		update();
	}
	
	public void update() {
		
		while(!Display.isCloseRequested()) {
			
			glClear(GL_COLOR_BUFFER_BIT);
			GL11.glPushMatrix();
			
				
			
			//Render code goes here
            Render.draw();
				
			//Two method calls to update the display and sync it
			Render.displayUpdate();
			Input.TranslateUp();
		}
		Block.release();
		destroyDisplay();
		
	}
	
	public void destroyDisplay() {
		Display.destroy();
	}
	
	public static int getHeight() {
		return HEIGHT;
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}
	
	
	
	
	
}

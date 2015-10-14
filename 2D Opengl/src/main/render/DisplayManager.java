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
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class DisplayManager {
	
	private static long lastFrame;

	private static Texture mossyCobblestone;

	private static int WIDTH;
	private static int HEIGHT;
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	private static double getDelatTime() {
		long currentTime = getTime();
		double delta = (double)(currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
		
	}
	
	public DisplayManager() {
		WIDTH = 1280;
		HEIGHT = 720;
		createDisplay();
	}
	
	public void createDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setResizable(false);
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
		int x = 100;
		int y = 100;
		int dX = 1;
		int dY = 1;
		double delta;
		boolean isJumping = false;
		boolean isGrounded = false;
		
		
		lastFrame = getTime();
		
		Block cube = new Block();
		
		
		while(!Display.isCloseRequested()) {
			 
			glClear(GL_COLOR_BUFFER_BIT);
			GL11.glPushMatrix();
			
			delta = getDelatTime();
			
			if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
				x += delta * dX * 0.2;	
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
				x += delta * dX * -0.1;	
			}
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
				if(isGrounded) {
					y -= delta * dY * 0.5;
					isJumping = true;
					if(y <= 400) {
						isGrounded = false;
						isJumping = false;
					}
				} 
			}
			
			else {
				isJumping  = false;
			}
			
			if(delta > 0 && !isJumping) {
				y -= delta * dY * -0.3;
				if(y > 620 ) {
					y = 620;
					isGrounded = true;
				}
				else {
					isGrounded = false;
				}
			}
			
			//y += delta * dY * 0.1;
			
			//Render code goes here
			Block.drawCobble(x,y);
				
			//Two method calls to update the display and sync it 
            Display.update();
			Display.sync(60);

		}
		cube.release();
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

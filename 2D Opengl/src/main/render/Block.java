package main.render;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Block {
	private static Texture mossyCobblestone;
	private static Texture gravel;
	
	private static int blockY;
	private static int blockX;
	
	public Block() {
		blockY = 0;
        blockX = 0;
    
    	try{
			mossyCobblestone = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/textures/mossyCobble.png")));
			gravel = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/textures/gravel.png")));
		} catch(IOException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
			
		}
	}
	
	public static void update() {
		//blockY += 670 - Mouse.getY();
	   // blockX += -50 +  Mouse.getX();
	}
	
	public static void drawCobble(int x, int y) {		
		//System.out.println("Mouse X = " + Mouse.getX() + " Mouse Y = " + (720 - Mouse.getY()));
		
		//update();
		
		mossyCobblestone.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0,0);
			glVertex2i(x, y ); 
			glTexCoord2f(1,0);
			glVertex2i(x + 100, y );
			glTexCoord2f(1,1);
			glVertex2i(x + 100, y  + 100);
			glTexCoord2f(0,1);
			glVertex2i(x, y + 100); 
		glEnd();
	}
	
	public static void drawGravel(int x, int y) {

		gravel.bind();
		glBegin(GL_QUADS);
			glTexCoord2f(0,0);
			glVertex2i(x, y ); 
			glTexCoord2f(1,0);
			glVertex2i(x + 100, y );
			glTexCoord2f(1,1);
			glVertex2i(x + 100, y  + 100);
			glTexCoord2f(0,1);
			glVertex2i(x, y + 100); 
		glEnd();
	}
	
	public static void release() {
		mossyCobblestone.release();
	}


	public static int getBlockY() {
		return blockY;
	}


	public static int getBlockX() {
		return blockX;
	}


	public void setBlockY(int blockY) {
		this.blockY = blockY;
	}


	public void setBlockX(int blockX) {
		this.blockX = blockX;
	}

}

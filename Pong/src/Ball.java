import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.Timer;

public class Ball  {
 private int xCord;
 private int yCord;
 private int width;
 private int height;
 private int xspeed= 2;
 private int yspeed= 2; 
 
 public Ball(int x,int y,int w,int h) {
	this.xCord = x;
	this.yCord = y;
	this.width = w;
	this.height = h;
}
 
 
 public void show(Graphics2D g2d) {
		g2d.fillOval(xCord, yCord, width, height);
	}
 
 public boolean collision(Player player) {

	 if(xCord-width == player.getXcord() && (yCord>player.getYcord() && yCord<player.getYcord()+player.getHeight()) ) {
		return true;
	}
	 
	 if(xCord+width == player.getXcord() && (yCord>player.getYcord() && yCord<player.getYcord()+player.getHeight())) {
		 return true;
	 }
	 
	 if(xCord>800 || xCord<0) {
		 xCord=400;
		 yCord=240;
		 return true;
	 }
	
	 
	 return false;
	
 }
 
 public void setXspeed() {
	 
	 xspeed=-xspeed;
	 
 }
 
 
 public void moveBall() {
	 
	 xCord+=xspeed;
	 yCord+=yspeed;
	 if(yCord<20 || yCord>460 ) {
		 yspeed=-yspeed;
	 }
	 

 }


public int getXcord() {
	return xCord;
}


public void setXcord(int x) {
	this.xCord = x;
}


public int getYcord() {
	return yCord;
}


public void setYcord(int y) {
	this.yCord = y;
}


public int getWidth() {
	return width;
}


public void setWidth(int w) {
	this.width = w;
}


public int getHeight() {
	return height;
}


public void setHeight(int h) {
	this.height = h;
}


public int getXspeed() {
	return xspeed;
}


public int getYspeed() {
	return yspeed;
}


public void setYspeed(int yspeed) {
	this.yspeed = yspeed;
}
 
 
	
}

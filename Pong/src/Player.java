import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player  {
	private int xCord;
	private int yCord;
	private int width;	
	private int height;

	public Player(int x,int y,int w,int h) {
		this.xCord = x;
		this.yCord = y;
		this.width = w;
		this.height = h;
	}
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fillRect(xCord, yCord, width, height);
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
	
	
	

	

}

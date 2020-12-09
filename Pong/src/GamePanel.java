import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener  {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 480;
	private Ball ball = new Ball(WIDTH/2, HEIGHT/2, 20, 20);
	private Player player1 = new Player(10,HEIGHT/2,10,100);
	private Player player2 = new Player(WIDTH-20,HEIGHT/2,10,100);
	private Timer timer;
	private int scorePlayer1=0;
	private int scorePlayer2=0;
	private int delay = 5;
	private Random random = new Random();
	
	public GamePanel() {
	
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addMouseMotionListener(new MyListener());
		this.addKeyListener(new MyListener());
		timer = new Timer(delay, this);

		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		ball.show(g2d);
		player1.show(g2d);
		player2.show(g2d);
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font( Font.SERIF,Font.PLAIN,40));
		g2d.drawString("Score player1: " + scorePlayer1, 30, 30);
		g2d.drawString("Score player2: " + scorePlayer2, 500, 30);
		
		if(!timer.isRunning()) {
			g2d.setFont(new Font( Font.SERIF,Font.PLAIN,30));
			g.drawString("Press space to start", 300, 300);
			g.drawString("You can press P to pause the game", 200, 450);
		}
	}
	
	public void scorePoint() {
		if(ball.getXcord() == player1.getXcord()-ball.getXspeed()) {
			scorePlayer2++;
		}
		else if(ball.getXcord() == player2.getXcord()+ball.getXspeed()){
			scorePlayer1++;
		}
		
	}
	
	
//	public void moveBot() {
//		int temp = random.nextInt(50)+30;
//		if(player2.getYcord()+temp < ball.getYcord()) {
//			player2.setYcord(player2.getYcord() + 2);
//		}
//		else {
//			player2.setYcord(player2.getYcord() - 2);
//		}
//		
//		
//	}
	
	
	
	
	
	public int getScorePlayer1() {
		return scorePlayer1;
	}

	public void setScorePlayer1(int scorePlayer1) {
		this.scorePlayer1 = scorePlayer1;
	}

	public int getScorePlayer2() {
		return scorePlayer2;
	}

	public void setScorePlayer2(int scorePlayer2) {
		this.scorePlayer2 = scorePlayer2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.moveBall();
//		if(ball.getXcord() > WIDTH/2) {
//			moveBot();
//		}
		player2.setYcord(ball.getYcord()-50);
		if(ball.collision(player2) || ball.collision(player1)) {
			ball.setXspeed();
		}
		scorePoint();
		
		repaint();
		
	}
	

	
	
	public class MyListener implements MouseMotionListener,KeyListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseMoved(MouseEvent e) {
				player1.setYcord(e.getY()-player1.getHeight()/2);
				repaint();
			
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
				timer.start();
			}
			if(arg0.getKeyCode() == KeyEvent.VK_P) {
				timer.stop();
				repaint();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
		

		
		
		
	}




	
	
	

	
	
	
}

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	
	
	
	public GameFrame() {
		GamePanel panel = new GamePanel();
		
		this.setContentPane(panel);

		this.setTitle("Pong");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
		
		
	}

	
	
}

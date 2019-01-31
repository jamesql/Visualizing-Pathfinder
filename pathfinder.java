package live.xjames.framew;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class pathfinder extends JFrame implements ActionListener {

	private static String windowName = "Pathfinder";
	private JButton[][] b = new JButton[25][25]; 
	private int[][] ctr = new int[25][25];
	
	
	public static void main(String[] args) {
		pathfinder m = new pathfinder();
	}
	
	public window() {
		super(windowName);
		init();
	}
	
	public void init() {
		super.setBounds(50, 50, 400, 400);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(null);
		initButtons();
		appear();
	}
	
	public void initButtons() {
		int x = 0;
		int y = 0;
		
		
		for (int row = 0; row < b.length; row++){ 
			for (int col = 0; col < b[0].length; col++) {
				b[row][col] = new JButton();
				b[row][col].setBounds(x, y, 25, 25);
				b[row][col].addActionListener(this);
				b[row][col].setBackground(Color.WHITE);
				ctr[row][col] = 0;
				super.getContentPane().add(b[row][col]);
				x += 25;
			}
			y += 25;
			x = 0;
		}
	}
	
	public void appear() {
		super.setVisible(true);
	}
	
	public void disappear() {
		super.setVisible(false);
	}
	
	public void makeWall(JButton e) {
		e.setBackground(Color.DARK_GRAY);
	}
	
	public void makeStart(JButton e) {
		e.setBackground(Color.GREEN);
	}
	
	public void makeEnd(JButton e) {
		e.setBackground(Color.ORANGE);
	}
	
	public void makeReg(JButton e) {
		e.setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int row = 0; row < b.length; row++) {
			for (int col = 0; col < b[0].length; col++) {
				if (e.getSource().equals(b[row][col])) {
					ctr[row][col]++;
					switch(ctr[row][col]) {
						case 1:
							makeWall(b[row][col]);
							break;
						case 2:
							makeStart(b[row][col]);
							break;
						case 3:
							makeEnd(b[row][col]);
							break;
						case 4:
							makeReg(b[row][col]);
							ctr[row][col] = 0;
							break;
					}
				}
			}
		}
	}

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;
class GamePanel extends JPanel implements ActionListener{
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 20;
	static final int GAME_UNITS= (SCREEN_WIDTH *SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	final int x[]= new int[GAME_UNITS];
	final int y[]= new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int applex;
	int appley;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	boolean over = false;	
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newApple();
		running=true;
		timer = new Timer(DELAY,this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		//gird
		if(running) {
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0,i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			//g.setColor(Color.red);
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.fillOval(applex,appley,UNIT_SIZE,UNIT_SIZE);
			
			for(int i=0;i<bodyParts;i++) {
				if(i==0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);		
				}
				else {
					g.setColor(new Color(45,180,2));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.cyan);
			g.setFont(new Font("INK FREE",Font.BOLD,30));
			//to allign the score
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("SCORE: "+applesEaten,(SCREEN_WIDTH - metrics.stringWidth("SCORE: "+applesEaten))/2,g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
	}
	public void newApple() {
		applex=random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
		appley=random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
	}
	public void move() {
		for(int i=bodyParts;i>0;i--) {
			x[i]=x[i-1];
			y[i]=y[i-1];
		}	
			//case for each direction
			switch(direction) {
			case 'U' :
					y[0]=y[0]-UNIT_SIZE;
					break;
			
		  case 'D' :
				y[0]=y[0] + UNIT_SIZE;
				break;
		
		case 'L' :
			x[0]=x[0]-UNIT_SIZE;
			break;
		
		case 'R' :
			x[0]=x[0]+UNIT_SIZE;
			break;
		
		}
	
	}
	public void checkApple() {
		if(x[0]==applex && y[0]==appley) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	public void checkCollisions() {
		//if head of the snake touches its body parts
		for(int i=bodyParts;i>0;i--) {
			if(x[0]==x[i] && y[0]==y[i]) {
				running=false;
			}
		}
		//head touches left border
		if(x[0]<0) {
			running=false;
		}
		//head touches right border
		if(x[0]>SCREEN_WIDTH) {
			running=false;
		}
		//head touches top border
		if(y[0]<0) {
			running=false;
		}
		//head touches bottom border
		if(y[0]>SCREEN_HEIGHT) {
			running=false;
		}
		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		//game score
		g.setColor(Color.cyan);
		g.setFont(new Font("INK FREE",Font.BOLD,30));
		//to allign the score
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("SCORE: "+applesEaten,(SCREEN_WIDTH - metrics1.stringWidth("SCORE: "+applesEaten))/2,g.getFont().getSize());
		//game over text
		g.setColor(Color.cyan);
		g.setFont(new Font("sherif",Font.BOLD,75));
		//to allign the game over text to center
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("GAME OVER",(SCREEN_WIDTH - metrics.stringWidth("GAME OVER"))/2,SCREEN_HEIGHT/2);
		over=true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();		
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			//case for snake to rotate inside the panel
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction= 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction= 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction= 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction= 'D';
				}
				break;
			}
		}
	}
}
class GameFrame extends JFrame{
	GameFrame(){
		GamePanel g=new GamePanel();
		this.add(g);
		this.setTitle("World's best Memory Game!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		}
}
public class SnakeGame {
	public static void main(String[] args) {
		new GameFrame();
	}
}

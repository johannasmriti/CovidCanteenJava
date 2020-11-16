import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//Game Frame
class GameFrame extends JFrame{
    GamePanel panel;
    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    } 
}

//Game Panel
class GamePanel extends JPanel implements Runnable{
    static final int GAME_WIDTH=1000;
    static final int GAME_HEIGHT=(int)(GAME_WIDTH*(0.5555));
    static final Dimension SCREEN_SIZE= new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER=20;
    static final int PADDLE_WIDTH =25;
    static final int PADDLE_HEIGHT=100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    boolean running= true;
    GamePanel(){
    	newPaddles();
    	newBall();
    	score= new Score(GAME_WIDTH,GAME_HEIGHT);
    	this.setFocusable(true);
    	this.addKeyListener(new AL());
    	this.setPreferredSize(SCREEN_SIZE);
    	gameThread=new Thread(this);
    	gameThread.start();
    }
    public void newBall(){
    	random = new Random();
    	ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
    }
    public void newPaddles(){
    	paddle1=new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
    	paddle2=new Paddle((GAME_WIDTH-PADDLE_WIDTH),(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    	
    }
    public void paint(Graphics g){
    	image = createImage(getWidth(),getHeight());
    	graphics = image.getGraphics();
    	draw(graphics);
    	g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g){
    	if(running==true) {
    		paddle1.draw(g);
    		paddle2.draw(g);
    		ball.draw(g);
    		score.draw(g);
    	}
    	/*else {
			gameOver(g);
		}*/
    	if(score.player1==5 || score.player2==5) {
    		gameOver(g);
    	}
    }
    public void move(){
    	paddle1.move();
    	paddle2.move();
    	ball.move();
    }
    public void checkCollision(){
    	//bounces the ball of the top and bottom window edges
    	if(ball.y<=0) {
    		ball.setYDirection(-ball.yVelocity);
    	}
    	if(ball.y>=GAME_HEIGHT-BALL_DIAMETER) {
    		ball.setYDirection(-ball.yVelocity);
    	}
    	//bounces ball off paddles
    	if(ball.intersects(paddle1)) {
    		ball.xVelocity=Math.abs(ball.xVelocity);
    		ball.xVelocity++;
    		if(ball.yVelocity>0)
    			ball.yVelocity++;
    		else
    			ball.yVelocity--;
    		ball.setXDirection(ball.xVelocity);
    		ball.setYDirection(ball.yVelocity);
    	}
    	if(ball.intersects(paddle2)) {
    		ball.xVelocity=Math.abs(ball.xVelocity);
    		ball.xVelocity++;
    		if(ball.yVelocity>0)
    			ball.yVelocity++;
    		else
    			ball.yVelocity--;
    		ball.setXDirection(-ball.xVelocity);
    		ball.setYDirection(ball.yVelocity);
    	}
    	//this function stops the paddles at the window edges
    	if(paddle1.y<=0) {
    		paddle1.y=0;
    	}
    	if(paddle1.y>=(GAME_HEIGHT-PADDLE_HEIGHT)) {
    		paddle1.y=GAME_HEIGHT-PADDLE_HEIGHT;
    	}
    	if(paddle2.y<=0) {
    		paddle2.y=0;
    	}
    	if(paddle2.y>=(GAME_HEIGHT-PADDLE_HEIGHT)) {
    		paddle2.y=GAME_HEIGHT-PADDLE_HEIGHT;
    	}
    	//Gives a player one point and creates new paddles and ball
    	if(ball.x<=0) {
    		score.player2++;
    		newPaddles();
    		newBall();
    		System.out.println("player 2 : "+score.player2);
    	}
    	if(ball.x>=GAME_WIDTH-BALL_DIAMETER) {
    		score.player1++;
    		newPaddles();
    		newBall();
    		System.out.println("player 1: "+score.player1);
    	}
    }
    public void run(){
    	//game loop
    	long lastTime = System.nanoTime();
    	double amountOfTicks = 60.0;
    	double ns = 1000000000/amountOfTicks;
    	double delta = 0;
    	while(running==true) {
    		long now = System.nanoTime();
    		delta += (now-lastTime)/ns;
    		lastTime=now;
    		if(delta>=1) {
    			move();
    			checkCollision();
    			repaint();
    			delta--;
    			//System.out.println("Johanna is Awesome");
    		}
    	}
    }
    public void gameOver(Graphics g) {
		//game score
		g.setColor(Color.cyan);
		g.setFont(new Font("INK FREE",Font.BOLD,30));
		//PRINTS THE PLAYER WHO WON
		if(score.player1==5) {
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("PLAYER 1 WINS",(GAME_WIDTH - metrics.stringWidth("PLAYER 1 WINS"))/2,GAME_HEIGHT/3);
		}
		else {
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("PLAYER 2 WINS",(GAME_WIDTH - metrics.stringWidth("PLAYER 2 WINS"))/2,GAME_HEIGHT/3);
		}
		//game over text
		g.setColor(Color.cyan);
		g.setFont(new Font("sherif",Font.BOLD,75));
		//to allign the game over text to center
		FontMetrics met= getFontMetrics(g.getFont());
		g.drawString("GAME OVER",(GAME_WIDTH - met.stringWidth("GAME OVER"))/2,GAME_HEIGHT/2);
		running=false;
	}
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
        	paddle1.keyPressed(e);
        	paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
        	paddle1.keyReleased(e);
        	paddle2.keyReleased(e);
        }
    }
}

//Paddle
class Paddle extends Rectangle{
    int id;
    int yVelocity;
    int speed=10;
    Paddle(int x,int y,int PADDLE_WIDTH,int PADDLE_HEIGHT,int id){
    	super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    	this.id=id;
    }
    public void keyPressed(KeyEvent e){
    	switch(id){
    		case 1:
    			if(e.getKeyCode()==KeyEvent.VK_W) {
    				setYDirection(-speed);
    				move();
    			}
    			if(e.getKeyCode()==KeyEvent.VK_S) {
    				setYDirection(speed);
    				move();
    			}
    			break;
    		case 2:
    			if(e.getKeyCode()==KeyEvent.VK_UP) {
    				setYDirection(-speed);
    				move();
    			}
    			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
    				setYDirection(speed);
    				move();
    			}
    			break;
    	}
    }
    public void keyReleased(KeyEvent e){
    	switch(id){
			case 1:
				if(e.getKeyCode()==KeyEvent.VK_W) {
					setYDirection(0);
					move();
				}
				if(e.getKeyCode()==KeyEvent.VK_S) {
					setYDirection(0);
					move();
				}
				break;
			case 2:
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					setYDirection(0);
					move();
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					setYDirection(0);
					move();
				}
				break;
    	}
    }
    public void setYDirection(int yDirection){
    	yVelocity = yDirection;
    }
    public void move(){
    	y=y+yVelocity;
    }
    public void draw(Graphics g){
    	if(id==1) {
    		g.setColor(Color.blue);
    	}
    	else {
    		g.setColor(Color.red);
    	}
    	g.fillRect(x,y,width,height);
    }
}

//Ball
class Ball extends Rectangle{
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed=2;
    Ball(int x, int y, int width, int height){
    	super(x,y,width,height);
    	random = new Random();
    	int randomXDirection = random.nextInt(2);
    	if(randomXDirection==0) {
    		randomXDirection--;
    	}
    	setXDirection(randomXDirection*initialSpeed);
    	int randomYDirection = random.nextInt(2);
    	if(randomYDirection==0) {
    		randomYDirection--;
    	}
    	setXDirection(randomYDirection*initialSpeed);
    }
    public void setXDirection(int randomXDirection){
    	xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection){
    	yVelocity = randomYDirection;
    }
    public void move(){
    	x+=xVelocity;
    	y+=yVelocity;
    }
    public void draw(Graphics g){
    	//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
    	g.setColor(Color.white);
    	g.fillOval(x,y,height,width);
    }
}

//Score
class Score extends Rectangle{
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;
    Score(int GAME_WIDTH,int GAME_HEIGHT){
    	Score.GAME_WIDTH=GAME_WIDTH;
    	Score.GAME_HEIGHT=GAME_HEIGHT;
    }
    public void draw(Graphics g){
    	//draws score on the screen
    	g.setColor(Color.white);
    	g.setFont(new Font("Consolas",Font.PLAIN,60));
    	g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
    	g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
    	g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);
    }
}


//Main classpublic 
class PongGame {
    public static void main(String args[]){
        GameFrame frame = new GameFrame();
    }
}

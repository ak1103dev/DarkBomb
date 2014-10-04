package darkbomb;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class DarkBombGame extends BasicGame{

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	
	private Ball ball;
	private WarningBall warn;
	private Bomb[] bombs;
	
	Random random = new Random();
	
	private boolean isStarted;
	private boolean isGameover;

	private boolean ballIsClosedBomb;
	
	public DarkBombGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		//colorBG(container, 128, 128, 128);
		
		isStarted = false;
		isGameover = false;

		ballIsClosedBomb = false;
		
		initBall();
		initBombs();
	}

	public void initBall() throws SlickException {
		ball = new Ball(20, GAME_HEIGHT - 20);
		warn = new WarningBall(ball.getX(), ball.getY());
	}

	public void colorBG(GameContainer container,int i,int j,int k) {
		Color background = new Color(i, j, k);
		container.getGraphics().setBackground(background);
	}

	public void initBombs() throws SlickException {
		bombs = new Bomb[Bomb.number];
		for(int i = 0; i < Bomb.number; i++){
			bombs[i] = new Bomb(GAME_WIDTH/2, GAME_HEIGHT/2);
		}
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("START", 0, 0);
		g.drawString("FINISH", GAME_WIDTH - 60, GAME_HEIGHT -20);
		
		renderBombs();	
		renderBall();									
	}

	public void renderBall() {
		if(ballIsClosedBomb){	
			//System.out.println("close");
			warn.render();
		}
		if(!ballIsClosedBomb){
			//System.out.println("not close");
			ball.render();
		}
	}

	public void renderBombs() {
		for (Bomb bomb : bombs) {
			bomb.render();
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException { 
		//System.out.println(delta);
		if(isStarted){
			ball.update(container, delta);
			warn.update(container, delta);
			checkCollision();
			isStopwhenGameover();
			if(CheckPosition.isFinish(ball.getX(), ball.getY())){
				System.out.println("You win");
				isGameover = true;
			}	
		}
	}

	public void isStopwhenGameover() {
		if(isGameover){
			System.out.println("Gameover");
			isStarted = false;
		//dead = new DeadBall(delta, delta);
		}
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ENTER) {
			System.out.println("Start");
			isStarted = true;
			isGameover = false;
			startNewGame();
	    }
	}

	public void startNewGame() {
		try {
			initBall();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		try {
			initBombs();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkCollision() {
		int close = 0;
		for(int i = 0; i < Bomb.number; i++){
			if(CheckPosition.isClosedBomb(ball.getX(), ball.getY(), bombs[i].getX(), bombs[i].getY())){
				//System.out.println("close");
				close++;
			}
			if(close > 0){
				ballIsClosedBomb = true;
			}else{
				ballIsClosedBomb = false;
			}
			
			if(CheckPosition.isCollide(ball.getX(), ball.getY(), bombs[i].getX(), bombs[i].getY())){
				isGameover = true;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			DarkBombGame game = new DarkBombGame("Dark Bomb");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(5);
			appgc.start();
	    } 
	    catch (SlickException e) {
	    	e.printStackTrace();
	    }
	}

}

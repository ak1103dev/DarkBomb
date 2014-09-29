package darkbomb;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class DarkBombGame extends BasicGame{

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	
	private Ball ball;
	private Bomb[] bombs;
	
	Random random = new Random();
	
	public DarkBombGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		colorBG(container, 128, 128, 128);
		ball = new Ball(20, GAME_HEIGHT - 20);
		initBombs();
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
		for (Bomb bomb : bombs) {
			bomb.render();
		}		
		ball.render();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException { 
		ball.update(container, delta);
		for(int i = 0; i < Bomb.number; i++){
			if(CollisionDetector.isCollide(ball.getX(), ball.getY(), bombs[i].getX(), bombs[i].getY())){
				System.out.println("Colll");
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

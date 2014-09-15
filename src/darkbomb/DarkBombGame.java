package darkbomb;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class DarkBombGame extends BasicGame{

	private static final int width = 640;
	private static final int height = 480;
	
	private Ball ball;
	private Bomb bomb;
	
	public DarkBombGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Color background = new Color(128, 128, 128);
		container.getGraphics().setBackground(background);
		ball = new Ball(40, height - 40);
		bomb = new Bomb(width/2, height/2);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		ball.render();
		bomb.render();		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException { 
		ball.update(container, delta);
		
	}
	
	public static void main(String[] args) {
		try {
			DarkBombGame game = new DarkBombGame("Dark Bomb");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(width, height, false);
			appgc.setMinimumLogicUpdateInterval(5);
			appgc.start();
	    } 
	    catch (SlickException e) {
	    	e.printStackTrace();
	    }
	}

}

package darkbomb;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ball {

	private float x;
	private float y;
	
	private static final int BALL_WIDTH = 40;
	private static final int BALL_HEIGHT = 40;
	
	private Image image;
	
	private final float v = 1;
	
	public Ball(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("res/green.png");
	}

	public void render() {
		image.draw(x - BALL_WIDTH/2, DarkBombGame.GAME_HEIGHT - (y + BALL_HEIGHT/2));
	}

	public void update(GameContainer container, int delta) {
		
		Input input = container.getInput();
		updateMovement(input);		
	}

	public void updateMovement(Input input) {
		if (input.isKeyDown(Input.KEY_LEFT)) { 
			x -= v;
	    }
	    if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	x += v;      
	    }		
	    if (input.isKeyDown(Input.KEY_DOWN)) { 
	    	y -= v;
	    }
	    if (input.isKeyDown(Input.KEY_UP)) {
	    	y += v;      
		}
	}
	
}

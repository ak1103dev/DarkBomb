package darkbomb;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ball {

	private float x;
	private float y;
	
	public static final int BALL_WIDTH = 40;
	public static final int BALL_HEIGHT = 40;
	
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
		isOutScreen();
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
	
	public void isOutScreen(){
		if(x < BALL_WIDTH/2){
			x = BALL_WIDTH/2;
		}
		if(x > DarkBombGame.GAME_WIDTH - BALL_WIDTH/2){
			x = DarkBombGame.GAME_WIDTH - BALL_WIDTH/2;
		}
		if(y < BALL_HEIGHT/2){
			y = BALL_HEIGHT/2;
		}
		if(y > DarkBombGame.GAME_HEIGHT- BALL_HEIGHT/2){
			y = DarkBombGame.GAME_HEIGHT - BALL_HEIGHT/2;
		}
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
}

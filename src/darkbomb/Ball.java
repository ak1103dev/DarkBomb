package darkbomb;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ball {

	private float x;
	private float y;
	private Image image;
	private final float v = 1;
	
	public Ball(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("res/green.png");
	}

	public void render() {
		image.draw(x - 20, 480 - (y + 20));
	}

	public void update(GameContainer container, int delta) {
		
		Input input = container.getInput();
		UpdateMovement(input);		
	}

	public void UpdateMovement(Input input) {
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

package darkbomb;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bomb {

	private float x;
	private float y;
	public static int number = 10;
	
	private Image image;
	
	public Bomb(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("res/bomb.png");
	}

	public void render() {
		image.draw(x - 20, DarkBombGame.height - (y + 20));	
	}
	
}

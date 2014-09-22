package darkbomb;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bomb {

	Random random = new Random();
	
	private float x;
	private float y;
	private int dx = -DarkBombGame.GAME_WIDTH/2 + BOMB_WIDTH/2 + random.nextInt(DarkBombGame.GAME_WIDTH - BOMB_WIDTH);
	private int dy = -DarkBombGame.GAME_HEIGHT/2 + BOMB_HEIGHT/2 + random.nextInt(DarkBombGame.GAME_HEIGHT - BOMB_HEIGHT);
	
	private static final int BOMB_WIDTH = 40;
	private static final int BOMB_HEIGHT = 40;
	
	public static int number = 10;
	
	private Image image;
	
	public Bomb(float x, float y) throws SlickException {
		this.x = x + randomX();
		this.y = y + randomY();
		image = new Image("res/bomb.png");
	}

	public void render() {
		image.draw(x - BOMB_WIDTH/2, DarkBombGame.GAME_HEIGHT - (y + BOMB_HEIGHT/2));	
	}

	public float randomX() {
		return dx;
	}
	
	public float randomY() {
		return dy;
	}
}

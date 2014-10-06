package darkbomb;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DeadBall extends Ball {

	private Image image;

	public DeadBall(float x, float y) throws SlickException {
		super(x, y);
		image = new Image("res/red.png");
	}

	public void render() {
		image.draw(getX() - BALL_WIDTH/2, DarkBombGame.GAME_HEIGHT - (getY() + BALL_HEIGHT/2));
	}
	
	public void update(GameContainer container, int delta) {
		setY();
	}
}

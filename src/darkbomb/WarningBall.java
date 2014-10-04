package darkbomb;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class WarningBall extends Ball {

	private Image yellow;
	
	public WarningBall(float x, float y) throws SlickException {
		super(x, y);
		yellow = new Image("res/yellow.png");
	}
	
	public void render() {
		yellow.draw(getX() - BALL_WIDTH/2, DarkBombGame.GAME_HEIGHT - (getY() + BALL_HEIGHT/2));
	}
}
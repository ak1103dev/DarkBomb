package darkbomb;

public class CollisionDetector {

	static boolean isCollide(float ballX, float ballY, float bombX, float bombY) {
		if(Math.abs(ballX - bombX) < (Ball.BALL_WIDTH + Bomb.BOMB_WIDTH)/2 
			&& Math.abs(ballY - bombY) <(Ball.BALL_WIDTH + Bomb.BOMB_WIDTH)/2){
			return true;
		}else{
			return false;
		}
		
	}
}

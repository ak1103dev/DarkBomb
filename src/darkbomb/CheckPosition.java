package darkbomb;

public class CheckPosition {

	static boolean isCollide(float ballX, float ballY, float bombX, float bombY) {
		if(Math.abs(ballX - bombX) < (Ball.BALL_WIDTH + Bomb.BOMB_WIDTH)/2 
			&& Math.abs(ballY - bombY) < (Ball.BALL_WIDTH + Bomb.BOMB_WIDTH)/2){
			return true;
		}else{
			return false;
		}
	}
	
	static boolean isClosedBomb(float ballX, float ballY, float bombX, float bombY) {
		if(Math.abs(ballX - bombX) <= 20 + (Ball.BALL_WIDTH + Bomb.BOMB_WIDTH)/2
			&& Math.abs(ballY - bombY) <= 20 + (Ball.BALL_WIDTH + Bomb.BOMB_WIDTH)/2){
			return true;
		}else{
			return false;
		}
	}
	
	static boolean isFinish(float ballX, float ballY) {
		if(ballX == DarkBombGame.GAME_WIDTH - 20 && ballY == 20){
			return true;
		}else{
			return false;
		}
	}
}

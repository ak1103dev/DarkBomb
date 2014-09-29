package darkbomb;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollisionDetectorTest {

	@Test
	public void testCollider() {
		assertTrue(CollisionDetector.isCollide(0, 0, 0, 0));
	}
	
	@Test
	public void testBallNextRigthBomb() {
		assertFalse(CollisionDetector.isCollide(Ball.BALL_WIDTH, 0, 0, 0));
	}

	@Test
	public void testBallNextLeftBomb() {
		assertFalse(CollisionDetector.isCollide(-Ball.BALL_WIDTH, 0, 0, 0));
	}
	
	@Test
	public void testBallNextUpBomb() {
		assertFalse(CollisionDetector.isCollide(0, Ball.BALL_HEIGHT, 0, 0));
	}
	
	@Test
	public void testBallNextDownBomb() {
		assertFalse(CollisionDetector.isCollide(0, -Ball.BALL_HEIGHT, 0, 0));
	}
	
	@Test
	public void testBallHitRigthBomb() {
		assertTrue(CollisionDetector.isCollide(Ball.BALL_WIDTH - 1, 0, 0, 0));
	}

	@Test
	public void testBallHitLeftBomb() {
		assertTrue(CollisionDetector.isCollide(-Ball.BALL_WIDTH + 1, 0, 0, 0));
	}
	
	@Test
	public void testBallHitUpBomb() {
		assertTrue(CollisionDetector.isCollide(0, Ball.BALL_HEIGHT - 1, 0, 0));
	}
	
	@Test
	public void testBallHitDownBomb() {
		assertTrue(CollisionDetector.isCollide(0, -Ball.BALL_HEIGHT + 1, 0, 0));
	}
}

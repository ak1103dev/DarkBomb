package darkbomb;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckPositionTest {

	/*Test isCollide*/
	@Test
	public void testCollider() {
		assertTrue(CheckPosition.isCollide(0, 0, 0, 0));
	}
	
	@Test
	public void testBallNextRigthBomb() {
		assertFalse(CheckPosition.isCollide(Ball.BALL_WIDTH, 0, 0, 0));
	}

	@Test
	public void testBallNextLeftBomb() {
		assertFalse(CheckPosition.isCollide(-Ball.BALL_WIDTH, 0, 0, 0));
	}
	
	@Test
	public void testBallNextUpBomb() {
		assertFalse(CheckPosition.isCollide(0, Ball.BALL_HEIGHT, 0, 0));
	}
	
	@Test
	public void testBallNextDownBomb() {
		assertFalse(CheckPosition.isCollide(0, -Ball.BALL_HEIGHT, 0, 0));
	}
	
	@Test
	public void testBallHitRigthBomb() {
		assertTrue(CheckPosition.isCollide(Ball.BALL_WIDTH - 1, 0, 0, 0));
	}

	@Test
	public void testBallHitLeftBomb() {
		assertTrue(CheckPosition.isCollide(-Ball.BALL_WIDTH + 1, 0, 0, 0));
	}
	
	@Test
	public void testBallHitUpBomb() {
		assertTrue(CheckPosition.isCollide(0, Ball.BALL_HEIGHT - 1, 0, 0));
	}
	
	@Test
	public void testBallHitDownBomb() {
		assertTrue(CheckPosition.isCollide(0, -Ball.BALL_HEIGHT + 1, 0, 0));
	}
	
	/*Test isClosedBomb*/
	@Test
	public void testBallNotClosedBomb() {
		assertFalse(CheckPosition.isClosedBomb(100, 100, 0, 0));
	}
	
	@Test
	public void testBallClosedBomb() {
		assertTrue(CheckPosition.isClosedBomb(60, 60, 0, 0));
	}
	
	@Test
	public void testBallClosedLeftBomb() {
		assertTrue(CheckPosition.isClosedBomb(50, 0, 0, 0));
	}
	
	@Test
	public void testBallVerryClosedLeftBomb() {
		assertTrue(CheckPosition.isClosedBomb(45, 0, 0, 0));
	}
}

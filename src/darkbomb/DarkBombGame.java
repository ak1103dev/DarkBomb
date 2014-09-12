package darkbomb;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class DarkBombGame extends BasicGame{

	private static final int width = 640;
	private static final int height = 480;
	
	private ArrayList<Entity> entities;
	
	public DarkBombGame(String title) {
		super(title);
		setEntities(new ArrayList<Entity>());
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		try {
			DarkBombGame game = new DarkBombGame("Dark Bomb");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(width, height, false);
			appgc.setMinimumLogicUpdateInterval(2000 / 60);
			appgc.start();
	    } 
	    catch (SlickException e) {
	    	e.printStackTrace();
	    }
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}

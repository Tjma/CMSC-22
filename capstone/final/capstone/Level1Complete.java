package capstone;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Level1Complete extends BasicGameState{
	Animation pressEnter;
	
	public Level1Complete(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		Image[] e = {new Image("res/graphics/backgrounds/levelcompleted.png"),
				new Image("res/graphics/backgrounds/levelcompleted1.png")
				}; 
		pressEnter = new Animation(e, 1000, false);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		pressEnter.draw();
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		pressEnter.update(50);
		if(arg0.getInput().isKeyDown(Input.KEY_ENTER)) {
			arg1.enterState(23);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 22;
	}

}

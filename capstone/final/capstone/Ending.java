package capstone;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Ending extends BasicGameState{
	Animation ending;
	Animation loop;
	
	public Ending(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		Image[] e = {new Image("res/graphics/ending/1.jpg"),
				new Image("res/graphics/ending/2.png"),
				new Image("res/graphics/ending/3.jpg"),
				new Image("res/graphics/ending/4.png"),
				new Image("res/graphics/ending/5.jpg"),
				new Image("res/graphics/ending/6.jpg"),
				new Image("res/graphics/ending/7.png"),
				new Image("res/graphics/ending/8.jpg"),
				new Image("res/graphics/ending/9.jpg"),
		};
		
		ending = new Animation(e, 5000, false);
		Image[] heart = {new Image("res/graphics/ending/11.jpg"),new Image("res/graphics/ending/12.jpg")};
		loop = new Animation(heart, 1000, true);
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		ending.draw();
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		ending.update(50);
		if(ending.getFrame() == 8) {
			ending.stop();
			loop.draw();
			loop.start();
		}
		if(arg0.getInput().isKeyDown(Input.KEY_A)) {
			arg1.enterState(1);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 27;
	}

}

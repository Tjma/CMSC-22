package capstone;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver extends BasicGameState{
	Image gameover;
	Image gameover2;
	float time;
	
	public GameOver(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		gameover2 = new Image("res/graphics/backgrounds/gameovertab1.png");
		time = 0;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		gameover2.draw();
		arg2.drawString(Mouse.getX() + " " +(510 - Mouse.getY()), 200, 200);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		if(arg0.getInput().isMouseButtonDown(0)) {
		
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 28;
	}

}

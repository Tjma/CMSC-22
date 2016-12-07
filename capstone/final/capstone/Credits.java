package capstone;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Credits extends BasicGameState {

	Image background;

	public Credits(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/graphics/backgrounds/d.credit.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0, 1);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
		if (Mouse.getX() >= 720 && Mouse.getY() <= 840) {
			if (gc.getInput().isMouseButtonDown(0)) {
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}

	}

	@Override
	public int getID() {
		return 4;
	}

}

package capstone;


import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Intro extends BasicGameState {

	Animation intro;
	public static final int DURATION = 3000;
	private int time;

	public Intro(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame arg1) throws SlickException {
		Image[] tgboyz = { new Image("res/graphics/backgrounds/opening.png"),
				new Image("res/graphics/backgrounds/opening2.png") };
		intro = new Animation(tgboyz, DURATION, false);
		time = 0;
		gc.setShowFPS(false);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		intro.draw(0, 0);
		intro.start();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		intro.setAutoUpdate(true);
		intro.stopAt(1);
		if (intro.getFrame() == 1)
			time += delta;
		if (time >= 4000) {
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}

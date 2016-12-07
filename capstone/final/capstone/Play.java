package capstone;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/*
 * NOTE: This state is not yet done.
 * WHAT TO PUT: Story line, details, control, mechanics
 */

public class Play extends BasicGameState {

	Image pleasewait;
	Animation talks;
	Animation loadings;
	float time;
	
	public Play(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Image[] talking = {new Image("res/graphics/decors/talk.png"), new Image("res/graphics/decors/talk1.png")};
		Image[] loading = {new Image("res/graphics/decors/loa.png"),
				new Image("res/graphics/decors/loa.png"),
				new Image("res/graphics/decors/load.png"),
				new Image("res/graphics/decors/loadi.png"),
				new Image("res/graphics/decors/loading.png"),
				new Image("res/graphics/decors/loading..png"),
				new Image("res/graphics/decors/loading...png"),
				};
		talks = new Animation(talking, 500, true);
		loadings = new Animation(loading, 200, true);
		time = 0;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		talks.draw();
		g.drawString(Mouse.getX() + "  " + (510 - Mouse.getY()), 100, 100);
		loadings.draw(200, 200);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		time += delta/1000.0f;
		if(time >= 4) {
			sbg.enterState(21, new FadeOutTransition(),new FadeInTransition());
		}
	}

	@Override
	public int getID() {
		return 2;
	}

}

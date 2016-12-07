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

public class Options extends BasicGameState {
	
	Image background;
	Image selection;
	Image soundOn;
	Image soundOff;
	Image sfxOn;
	Image sfxOff;

	public static final int selectX = 260;
	public static final int selectY = 200;
	int indX;
	int indY;
	int choice;

	public Options(int state) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/graphics/backgrounds/c.options.png");
		selection = new Image("res/graphics/buttons/select.png");
		indX = selectX;
		indY = selectY;
		choice = 1;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0, 1);
		selection.draw(indX, indY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (Mouse.getX() >= 330 && Mouse.getX() <= 475) {
			if (Mouse.getY() >= selectY && Mouse.getY() <= selectY + 70) {
				indX = selectX;
				indY = selectY;
				choice = 1;
			}
			if (512 - Mouse.getY() >= selectY + 75 && 512 - Mouse.getY() <= selectY + 145) {
				indX = selectX;
				indY = selectY + 75;
				choice = 2;
			}
		}
		if ((Mouse.getX() >= 640 && Mouse.getY() <= 835) && (Mouse.getY() >= 12 && Mouse.getY() <= 102)) {
			indX = 570;
			indY = 425;
			choice = 3;
			if (gc.getInput().isMouseButtonDown(0)) {
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			}
		}

		if (gc.getInput().isKeyPressed(Input.KEY_UP)) {
			if (choice == 2) {
				indX = selectX;
				indY = selectY;
				choice--;

			} else if (choice == 3) {
				indX = selectX;
				indY = selectY + 75;
				choice--;
			}
		}

		if (gc.getInput().isKeyPressed(Input.KEY_DOWN)) {
			if (choice == 1) {
				indX = selectX;
				indY = selectY + 75;
				choice++;
			} else if (choice == 2) {
				indX = 570;
				indY = 425;
				choice++;
			}
		}

		if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			if (choice == 3) {
				sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
			} else {
				// TODO: SWITCH ON OFF
				// FRANKLIN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}

	}

	public int getID() {
		return 3;
	}

}

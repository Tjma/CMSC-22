package capstone;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState {

	// MAIN MENU GRAPHICS
	Image background;
	Image selection;
	private Music music;
	

	// MOUSE LOCATIONS FOR CONTROL
	public static int SELECTION_X = 550;
	// MOUSE LOCATIONS Y-coordinate
	public static int PLAY_SELECT = 200;
	public static int OPTIONS_SELECT = 275;
	public static int CREDITS_SELECT = 350;
	public static int QUIT_SELECT = 425;

	// MOUSE CONTROL COVERAGE
	public static int X_MIN = 620;
	public static int X_MAX = 770;
	public static int Y_UPDATE = 75;
	public static int Y_UPDATE_MOUSE = 70;

	private int selectionY; // Indicator location
	int select; // choice, leads to another game state

	public MainMenu(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/graphics/backgrounds/a.menu.png");
		selection = new Image("res/graphics/buttons/select.png");
		selectionY = PLAY_SELECT;
		select = 2;
		music = new Music("res/sounds/music_theme.ogg");
		music.loop();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0);
		selection.draw(SELECTION_X, selectionY);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		// USING MOUSE
		if (input.getMouseX() >= X_MIN && input.getMouseY() <= X_MAX) {
			if (input.getMouseY() >= PLAY_SELECT && input.getMouseY() <= PLAY_SELECT + Y_UPDATE_MOUSE) {
				selectionY = PLAY_SELECT;
				select = 2;
				if(input.isMouseButtonDown(0)){
					music = new Music("res/sounds/Ingame BGM.wav");
					music.loop();
				}
				
				
			}
			if (input.getMouseY() >= OPTIONS_SELECT && input.getMouseY() <= OPTIONS_SELECT + Y_UPDATE_MOUSE) {
				selectionY = OPTIONS_SELECT;
				select = 3;
			}
			if (input.getMouseY() >= CREDITS_SELECT && input.getMouseY() <= CREDITS_SELECT + Y_UPDATE_MOUSE) {
				selectionY = CREDITS_SELECT;
				select = 4;
			}
			if (input.getMouseY() >= QUIT_SELECT && input.getMouseY() <= QUIT_SELECT + Y_UPDATE_MOUSE) {
				selectionY = QUIT_SELECT;
				select = 5;
			}
		} else {
			// USING UP, DOWN and ENTER
			if (input.isKeyPressed(Input.KEY_UP)) {
				if (selectionY > PLAY_SELECT) {
					selectionY -= Y_UPDATE;
					select--;
				}
			}
			if (input.isKeyPressed(Input.KEY_DOWN)) {
				if (selectionY < QUIT_SELECT) {
					selectionY += Y_UPDATE;
					select++;
				}
			}
		}

		// Mouse Pressed/ENTER Pressed
		if (input.isMousePressed(0) || input.isKeyPressed(Input.KEY_ENTER)) {
			if (select == 5) {
				System.exit(0);
			} else {
				sbg.enterState(select, new FadeOutTransition(), new FadeInTransition());
			}
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}

package capstone;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameManager extends StateBasedGame {

	// GAME NAME, DIMENSION
	public static final String NAME = "Make Kawat the Mangoes!";
	public static final int GAMEWIDTH = 853;
	public static final int GAMEHEIGHT = 510;

	// GAME STATES
	public static final int INTRO = 0;
	public static final int MAINMENU = 1;
	public static final int PLAY = 2;
	// INSIDE PLAY STATE, LEVELS WILL EMERGE
		public static final int DEMO = 20;
		public static final int LEVEL1 = 21;
		public static final int LEVEL2 = 23;
		public static final int LEVEL3 = 25;
		public static final int ENDING = 27;
		public static final int LEVEL1_COMPLETE = 22;
		public static final int LEVEL2_COMPLETE = 24;
		public static final int LEVEL3_COMPLETE = 26;
		public static final int GAMEOVER = 28;
	// 
	public static final int OPTIONS = 3;
	public static final int CREDITS = 4;
	// END
	
	public GameManager(String name) {
		super(name);
		this.addState(new Intro(INTRO));
		this.addState(new MainMenu(MAINMENU));
		this.addState(new Play(PLAY));
		this.addState(new Options(OPTIONS));
		this.addState(new Credits(CREDITS));
		this.addState(new Level1(LEVEL1));
		this.addState(new Level2(LEVEL2));
		this.addState(new Level3(LEVEL3));
		this.addState(new Ending(ENDING));
		this.addState(new Level1Complete(LEVEL1_COMPLETE));
		this.addState(new Level2Complete(LEVEL2_COMPLETE));
		this.addState(new Level3Complete(LEVEL3_COMPLETE));
		this.addState(new GameOver(GAMEOVER));
		
		
		
		// GAME PROPER
		//this.addState(new Level3(DEMO));
		//this.addState(new Level2(DEMO));
		this.addState(new Level1(LEVEL1));
		
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(INTRO).init(gc, this);
		this.getState(MAINMENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.getState(OPTIONS).init(gc, this);
		this.getState(CREDITS).init(gc, this);
		
		// THE LEVELS
		/*
		 * TODO: Initialize Levels here, including demo
		 * 
		 * 
		 */
		this.enterState(INTRO
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			String[] icon = { ("res/graphics/game icon/icon.png") };
			appgc = new AppGameContainer(new GameManager(NAME));
			appgc.setDisplayMode(GAMEWIDTH, GAMEHEIGHT, false);
			appgc.setTargetFrameRate(60);
			appgc.setVSync(true);
			appgc.setIcons(icon);
			appgc.setAlwaysRender(true);
			appgc.start();
		} catch (SlickException se) {
			se.printStackTrace();
		}
	}

}

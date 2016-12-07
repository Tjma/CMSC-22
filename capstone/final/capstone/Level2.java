package capstone;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

public class Level2 extends BasicGameState {
	Image goal;
	Image ground;
	Image direction;
	Animation powerbar;
	Animation juan;
	Animation totoy;
	
	public Sound sound;

	// Constants
	public static float GROUNDLEVEL = 480;
	public static float G = -10; // Acceleration due to gravity

	// Juan's sprite
	public static float JUAN_WIDTH = 50;
	public static float JUAN_LENGTH = 75;
	public static float JUAN_LAUNCHPAD_X = 90;
	public static float JUAN_ONGROUND = 480 - 75;
	
	public static final int MAX = 12;

	// X and juanY coordinates of sprites
	float juanX;
	float juanY;

	float heightMouse;
	float baseMouse;

	float originX;
	float originY;

	float speed; // VelocitjuanY for Juan
	float yVelocity; // juanY-velocitjuanY
	float time; // Time passes bjuanY.
	boolean mousePressed; // Determines if the mouse is alreadjuanY released

	// test
	float angle;

	int count;
	int turns;

	// MANGO
	Animation[] mangoArray;

	// RECTANGLES FOR COLLISION
	Rectangle juannet;
	Rectangle[] mangga;
	static final int MANGGA = 32;

	public Level2(int state) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// Initialization of background;
		ground = new Image("res/graphics/backgrounds/b.playground.png");
		
		goal = new Image("res/graphics/decors/levelgoals.png");
		
		sound = new Sound("res/sounds/Ting.wav");

		// Power bar animation
		int[] duration = { 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
		Image[] power = { new Image("res/graphics/powerbar/powerbar (1).png"),
				new Image("res/graphics/powerbar/powerbar (2).png"),
				new Image("res/graphics/powerbar/powerbar (3).png"),
				new Image("res/graphics/powerbar/powerbar (4).png"),
				new Image("res/graphics/powerbar/powerbar (5).png"),
				new Image("res/graphics/powerbar/powerbar (6).png"),
				new Image("res/graphics/powerbar/powerbar (7).png"),
				new Image("res/graphics/powerbar/powerbar (8).png"),
				new Image("res/graphics/powerbar/powerbar (9).png"),
				new Image("res/graphics/powerbar/powerbar (10).png"),
				new Image("res/graphics/powerbar/powerbar (11).png") };
		powerbar = new Animation(power, duration, false);

		Image[] mg = { new Image("res/graphics/mango/Mango1.png"), new Image("res/graphics/mango/Mango2.png"),
				new Image("res/graphics/mango/Mango3.png") };
		Animation mango = new Animation(mg, 500, true);
		mangoArray = new Animation[12];
		for (int i = 0; i < mangoArray.length; i++) {
			mangoArray[i] = mango;
		}

		direction = new Image("res/graphics/arrow/arrowdirection.png");

		// Juan and his initial coordinates and speed
		Image[] juanfly = { new Image("res/graphics/juansprites/ontheground.png"),
				new Image("res/graphics/juansprites/flying.png") };
		juan = new Animation(juanfly, 100, false);

		Image[] tt = { new Image("res/graphics/totoystretcher/release.png"),
				new Image("res/graphics/totoystretcher/hold.png") };
		totoy = new Animation(tt, 500, false);

		speed = 0;
		juanX = JUAN_LAUNCHPAD_X;
		juanY = JUAN_ONGROUND;
		time = 0;
		;
		yVelocity = 0;
		originX = JUAN_LAUNCHPAD_X;
		originY = 510 - (int) GROUNDLEVEL;

		angle = 0;
		count = 0;
		turns = 8;

		// RECTANGLES
		juannet = new Rectangle(juanX, juanY, 2, 10);
		mangga = new Rectangle[MAX];
		mangga[0] = new Rectangle(400, 335, MANGGA, MANGGA);
		mangga[1] = new Rectangle(550, 35, MANGGA, MANGGA);
		mangga[2] = new Rectangle(430, 80, MANGGA, MANGGA);
		mangga[3] = new Rectangle(700, 160, MANGGA, MANGGA);
		mangga[4] = new Rectangle(550, 160, MANGGA, MANGGA);
		mangga[5] = new Rectangle(700, 380, MANGGA, MANGGA);
		mangga[6] = new Rectangle(350, 170, MANGGA, MANGGA);
		mangga[7] = new Rectangle(450, 285, MANGGA, MANGGA);
		mangga[8] = new Rectangle(600, 250, MANGGA, MANGGA);
		mangga[9] = new Rectangle(450, 150, MANGGA, MANGGA);
		mangga[10] = new Rectangle(700, 290, MANGGA, MANGGA);
		mangga[11] = new Rectangle(600, 89, MANGGA, MANGGA);

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// UNDER THE SCENE JOBS
		for (int i = 0; i < mangga.length; i++) {
			g.draw(mangga[i]);
		}
		juannet.setX(juanX + 40);
		juannet.setY(juanY + 10);
		g.draw(juannet);

		ground.draw(0, 0);
		
		goal.draw(0,0);

		g.setColor(Color.black);

		// MANGOES
		for (int i = 0; i < mangoArray.length; i++) {
			mangoArray[i].draw(mangga[i].getX(), mangga[i].getY());
		}

		juan.draw(juanX, juanY);
		totoy.draw(50, 395);
		for (int i = 0; i < mangoArray.length; i++) {

		}

		// NET OF JUAN

		if (Mouse.getY() >= originY) {
			heightMouse = Mouse.getY() - originY;
		}

		if (Mouse.getX() >= originX) {
			baseMouse = Mouse.getX() - originX;
		}
		angle = (float) Math.atan((float) heightMouse / (float) baseMouse);
		if (Math.toDegrees(angle) >= 0 && Math.toDegrees(angle) <= 90) {
			direction.setRotation(90 - (float) Math.toDegrees(angle));
		}

		powerbar.draw(-10, GROUNDLEVEL - 80);
		direction.draw(originX - 5, GROUNDLEVEL - 140);
		direction.setCenterOfRotation(direction.getWidth() / 2, direction.getHeight());

		g.drawString(" "+turns, 84, 107);
		g.drawString(" "+count, 87, 71);
		g.drawString(" 2 ", 94, 13);
		g.drawString(" 10 ", 94, 40);
	}

	/*
	 * ** PROJECTILE MOTION ** X VelocitjuanY = speed * cos(theta) ---> since
	 * X-VelocitjuanY is constant throughout the time deltaX = initialXcoord + X
	 * velocitjuanY -----> previous X + velocitjuanY ***********************
	 * juanY initial VelocitjuanY = speed * sin(theta) juanY VelocitjuanY = 1/2
	 * g t^2 ----> juanY velocitjuanY affected bjuanY g deltajuanY =
	 * initialjuanY + juanY velocitjuanY ----> displacement of juanY
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// EverjuanYtime the mouse is pressed, Juan will be but back into the
		// launchpad
		Input input = gc.getInput();
		// if(input.isKeyPressed(Input.KEY_UP)){rectY -= 10;}
		// if(input.isKeyPressed(Input.KEY_DOWN)){rectY += 10;}
		// if(input.isKeyPressed(Input.KEY_LEFT)){rectX -= 10;}
		// if(input.isKeyPressed(Input.KEY_RIGHT)){rectX += 10;}
		
		if ((count >= 10 && turns == 0) || count == MAX){
			sbg.enterState(25);
		}else{
			if (count < 10 && turns == 0){
				sbg.getState(1).init(gc, sbg);
				sbg.getState(23).init(gc, sbg);	
				sbg.enterState(1);
			}
		}

		if (input.isMouseButtonDown(0) && juanX == JUAN_LAUNCHPAD_X) {
			juan.setCurrentFrame(0);
			totoy.setCurrentFrame(1);
			mousePressed = true;
			if (gc.getFPS() < 10) {
				powerbar.update(500);
			} else if (gc.getFPS() < 20) {
				powerbar.update(125);
			} else {
				powerbar.update(75);
			}
			juan.setCurrentFrame(0);

			juanX = JUAN_LAUNCHPAD_X;
			juanY = JUAN_ONGROUND;
			time = 0;
			yVelocity = 0;
		}

		if (gc.getFPS() <= 10) {
			speed = (float) powerbar.getFrame() * 5.5f; // speed is obtained
														// from powerbar index
														// (0 - 10);
		} else if (gc.getFPS() <= 20) {
			speed = (float) powerbar.getFrame() * 3; // speed is obtained from
														// powerbar index (0 -
														// 10)
		} else if (gc.getFPS() <= 30) {
			speed = (float) powerbar.getFrame() * 2; // speed is obtained from
														// powerbar index (0 -
														// 10)
		} else if (gc.getFPS() <= 40) {
			speed = (float) powerbar.getFrame() * 1.75f; // speed is obtained
															// from powerbar
															// index (0 - 10)
		} else {
			speed = (float) powerbar.getFrame() * 1.5f; // speed is obtained
														// from powerbar index
														// (0 - 10)
		}

		// Mouse is released
		if (mousePressed == true && input.isMouseButtonDown(0) == false) {
			totoy.setCurrentFrame(0);
			juan.setCurrentFrame(1);
			float xVelocity = (float) (speed * Math.cos(angle));

			float initialYVelocity = (float) (speed * Math.sin(angle));
			float deltaY = (float) (0.5f * G * Math.pow(time, 2));
			float deltaInSecs = delta / 1000.0f;

			if (juanY <= JUAN_ONGROUND) {
				juan.setCurrentFrame(1);
				time += deltaInSecs;

				juanX += (int) xVelocity;
				juanY += (int) -(deltaY + initialYVelocity);
				if(juanY >= JUAN_ONGROUND && juanX > JUAN_LAUNCHPAD_X) {
					juanX = JUAN_LAUNCHPAD_X;
					juanY = JUAN_ONGROUND;
					if(mousePressed == true) {
						turns--;
						powerbar.restart();
						mousePressed = false;
					}
				}

			} 

			for (int i = 0; i < mangga.length; i++) {
				if (juannet.intersects(mangga[i])) {
					mangga[i].setX(20);
					mangga[i].setY(65);
					count++;
					sound.play();
				}
			}

		}

		if (gc.getInput().isMouseButtonDown(1)) {
			juanX = JUAN_LAUNCHPAD_X;
			juanY = JUAN_ONGROUND;
			mousePressed = false;
			juan.setCurrentFrame(0);
			totoy.setCurrentFrame(0);
		}

	}

	public int getID() {
		return 23;
	}

}

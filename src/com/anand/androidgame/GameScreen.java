package com.anand.androidgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.graphics.Color;
import android.graphics.Paint;

import com.anand.framework.Game;
import com.anand.framework.Graphics;
import com.anand.framework.Image;
import com.anand.framework.Input.TouchEvent;
import com.anand.framework.Screen;

public class GameScreen extends Screen {
	enum GameState {
		Ready, Running, Paused, GameOver
	}

	GameState state = GameState.Ready;

	// Variable Setup
	int x;
	int y;
	//private Image currentSprite, character, character2, character3, heliboy,
			//heliboy2, heliboy3, heliboy4, heliboy5;

	//utilize this arraylist to store bricks
	//private ArrayList<Tile> tilearray = new ArrayList<Tile>();

	int livesLeft = 3;
	Paint paint, paint2;

	public GameScreen(Game game) {
		super(game);

		// Initialize game objects here
			//Initialize rectangle for paddle and ellipse for ball
		
		
		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);

		paint2 = new Paint();
		paint2.setTextSize(100);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.WHITE);

	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		// We have four separate update methods in this example.
		// Depending on the state of the game, we call different update methods.
		// Refer to Unit 3's code. We did a similar thing without separating the
		// update methods.

		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents) {

		// This example starts with a "Ready" screen.
		// When the user touches the screen, the game begins.
		// state now becomes GameState.Running.
		// Now the updateRunning() method will be called!

		if (touchEvents.size() > 0)
			state = GameState.Running;
	}

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

		// This is identical to the update() method from our Unit 2/3 game.

		// 1. All touch input is handled here:
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {

				//specifies rectangle (button) to control movement
				if (inBounds(event, 0, 285, 65, 65)) {

				}

				//specifies another area to control movement
				else if (inBounds(event, 0, 350, 65, 65)) {
				}

				//Idea: Utilize this movement for left and right of the paddle
				if (event.x > 400) {
					// Move right.
				}

			}

			if (event.type == TouchEvent.TOUCH_UP) {

				if (inBounds(event, 0, 415, 65, 65)) {
				}

				//pause game
				if (inBounds(event, 0, 0, 35, 35)) {
					pause();

				}

				if (event.x > 400) {
					// Move right.					
				}
			}

		}

		// 2. Check miscellaneous events like death:

		if (livesLeft == 0) {
			state = GameState.GameOver;
		}

		// 3. Call individual update() methods here.
		// This is where all the game updates happen.
		// For example, robot.update();

		//ArrayList projectiles = robot.getProjectiles();

		//not sure what these methods do
		updateTiles();
		animate();
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {

					if (!inBounds(event, 0, 0, 35, 35)) {
						resume();
					}
				}

				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					goToMenu();
				}
			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					//game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}

	}

	private void updateTiles() {
		//use this method to update the bricks
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();

		paintTiles(g);

		//Use this arraylist for bricks
		//ArrayList projectiles = robot.getProjectiles();
		
		// First draw the game elements.

		// Example:
		// g.drawImage(Assets.background, 0, 0);
		// g.drawImage(Assets.character, characterX, characterY);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();

	}

	//Edit method to draw bricks
	private void paintTiles(Graphics g) {
		//for (int i = 0; i < tilearray.size(); i++) {
		//	Tile t = (Tile) tilearray.get(i);
		//	if (t.type != 0) {
		//		g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
		//	}
		//}
	}

	public void animate() {
	}

	private void nullify() {

		// Set all variables to null. You will be recreating them in the
		// constructor.
		paint = null;

		// Call garbage collector to clean up memory.
		System.gc();

	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("Tap to Start.", 400, 240, paint);

	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.button, 0, 285, 0, 0, 65, 65);
		g.drawImage(Assets.button, 0, 350, 0, 65, 65, 65);
		g.drawImage(Assets.button, 0, 415, 0, 130, 65, 65);
		g.drawImage(Assets.button, 0, 0, 0, 195, 35, 35);

	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();
		// Darken the entire screen so you can display the Paused screen.
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Menu", 400, 360, paint2);

	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("GAME OVER.", 400, 240, paint2);
		g.drawString("Tap to return.", 400, 290, paint);

	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;

	}

	@Override
	public void resume() {
		if (state == GameState.Paused)
			state = GameState.Running;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {
		pause();
	}

	private void goToMenu() {
		// TODO Auto-generated method stub
		//game.setScreen(new MainMenuScreen(game));

	}

	//Does this call the splashscreen?
	/* 
	public static Background getBg1() {
		// TODO Auto-generated method stub
		return bg1;
	}
	*/

}
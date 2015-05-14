package com.anand.androidgame;

import com.anand.framework.Game;
import com.anand.framework.Screen;
import com.anand.framework.Graphics;
import com.anand.framework.Graphics.ImageFormat;
import com.anand.androidgame.Assets;

public class SplashLoadingScreen extends Screen {

	public SplashLoadingScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		Assets.Splash = g.newImage("Splash1.jpg", ImageFormat.RGB565);
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backButton() {
		// TODO Auto-generated method stub

	}

}

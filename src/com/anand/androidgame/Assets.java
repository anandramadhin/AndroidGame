package com.anand.androidgame;

import com.anand.framework.Image;
import com.anand.framework.Music;
import com.anand.framework.Sound;

public class Assets {
	
	public static  Image Splash;
	public static Image button;
	public static Sound click;
	public static Music theme;
	public static Music bounce;
	public static Music hit;
	
	/**
	 * @param sampleGame
	 */
	public static void load(SampleGame sampleGame) {
		// TODO Auto-generated method stub
		theme = sampleGame.getAudio().createMusic("Theme.mp3");
		bounce = sampleGame.getAudio().createMusic("Bounce.mp3");
		hit = sampleGame.getAudio().createMusic("Hit.mp3");
		
		theme.setLooping(true);
		theme.setVolume(0.85f);
		theme.play();
		
		bounce.setVolume(0.80f);
		
		hit.setVolume(0.80f);
	}
	
}
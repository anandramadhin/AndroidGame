package com.anand.androidgame;

import android.graphics.Paint;
import android.graphics.Rect;

public abstract class Entity 
{
	protected float x; 
	protected float y; 
	protected float width; 
	protected float height; 
	protected GameScreen  game; 
	protected Rect boundingRect; 
	
	public Entity (GameScreen game, float x, float y, float width, float height)
	{
		this.x = x; 
		this.y = y; 
		this.width = width; 
		this.height = height; 
		this.game = game; 
		this.boundingRect = new Rect(); 
		this.boundingRect.set((int) x, (int)y, (int)width, (int)height); 
	}
	
	//update 
	public abstract void update(); 
	
	//draw 
	public abstract void draw(Paint paint); 
	
	

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Rect getBoundingRect() {
		return boundingRect;
	}

	
	
	
	

}

package com.anand.androidgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Ball  extends Entity
{
	private float xSpeed; 
	private float ySpeed;
	
	private Paint paint;
	private Canvas circle = new Canvas();
	
	public Ball(GameScreen game, float x, float y, float width, float height) 
	{		
		super(game, x, y, width, height); 
		circle.drawCircle(x, y, 5, paint);
		xSpeed = 7;
		ySpeed = 5;
	}

	public void update() 
	{
		// TODO Auto-generated method stub
		this.x += xSpeed; 
		this.y += ySpeed; 
		
		//how to get screen width???
		//if (x<0 || (x + width) > game.getWidth())
		{
			xSpeed = xSpeed * -1;			
		}
		
		if (y<0)
		{
			ySpeed = ySpeed * -1;			
		}
		
		//if((y + height) > game.getScreenHeight())
		{
			//ball hits the bottom of the screen
			//game.gameOver();
		}
		
		if(collision1())
		{
			ySpeed = ySpeed * -1;
			
		}
		
		if (collision2())
		{
			ySpeed = ySpeed * -1;
			xSpeed = xSpeed * -1;
			//game.setPlayer1points(game.getPlayer1points() + 100); Point system
		}
		
		//update our Ellipse object
		//ball.setFrame(x, y, width, height);
		
	}

	@Override
	public void draw(Paint paint) 
	{
		// TODO Auto-generated method stub
	}
	
	
	public Rect getBounds() 
	{
		return new Rect((int)x, (int)y, (int)width, (int)height);
	}
	
	private boolean collision1() {
		//return game.getPlayer1().getBounds().intersects(getBounds());
		return false;
	}
	
	private boolean collision2()
	{
		//Draw all visible bricks
		/*
		for(int count = 1; count <= 50; count ++)
		{
			if(game.bricks[count].isVisible())
			{
				if(game.bricks[count].getBounds().intersects(getBounds()))
				{
					game.bricks[count].setVisibile(false);
					return game.bricks[count].getBounds().intersects(getBounds());
				}
			}
		}*/
		return false;
	}
	
	public void increaseSpeed()
	{
		ySpeed = ySpeed + 2;
		xSpeed = xSpeed +2;
	}

}

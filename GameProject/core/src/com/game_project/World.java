package com.game_project;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game_project.view.Assets;

public class World {
	Texture background;
	
	public World()
	{
		init();
	}
	
	public void init()
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		background = Assets.instance.backgroundAsset.resource;
		batch.draw(background, 0, 0);
	}
}

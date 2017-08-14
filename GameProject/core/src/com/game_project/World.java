package com.game_project;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game_project.objects.MainCharacter;
import com.game_project.view.Assets;

public class World {
	Texture background;
	MainCharacter mainCharacter;
	
	public World()
	{
		init();
	}
	
	public void init()
	{
		mainCharacter = new MainCharacter();
	}
	
	public void render(SpriteBatch batch)
	{
		background = Assets.instance.backgroundAsset.resource;
		batch.draw(background, 0, 0);
		mainCharacter.render(batch);
	}
}

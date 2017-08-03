package com.game_project.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainTitle implements MenuItem {
	
	public void draw(SpriteBatch batch, Object resource) {
		batch.draw((Texture)resource,  175, 400, 450, 60);
	}
}

package com.game_project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameProject extends Game {
	SpriteBatch batch;
	public BitmapFont font;
//	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
//		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		// it render screens!
		super.render();
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}

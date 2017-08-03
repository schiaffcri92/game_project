package com.game_project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.game_project.view.Assets;

public class GameProject extends Game {
	SpriteBatch batch;
	public BitmapFont font;
	boolean totouch;

	public Assets assets;
	
	@Override
	public void create () {
		totouch = true;
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.instance.init(new AssetManager());
		this.setScreen(new MainMenuScreen(this));
//		img = new Texture("badlogic.jpg");
	}
	
	public void loadAssets () {
		
	}

	@Override
	public void render () {
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
		Assets.instance.dispose();
	}
}

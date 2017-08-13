package com.game_project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.game_project.handlers.MainMenuControllerHandler;
import com.game_project.handlers.MainMenuKeyboardHandler;
import com.game_project.view.Assets;
import com.badlogic.gdx.controllers.ControllerAdapter;

public class GameProject extends Game {
	SpriteBatch batch;
	public BitmapFont font;
	boolean totouch;
	
	Controller controller;
	
	public Assets assets;
	
	@Override
	public void create () {
		totouch = true;
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets.instance.init(new AssetManager());
		
		for (Controller controller : Controllers.getControllers()) {
		    System.out.println(controller.getName());
		    this.controller = controller;
		}
		if (this.controller != null) {
			MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
			this.setScreen(mainMenuScreen);
			ControllerAdapter listener = new MainMenuControllerHandler(mainMenuScreen);
			this.controller.addListener(listener);
		} else {
			// No controller plugged in
			InputMultiplexer multiplexer = new InputMultiplexer();
			multiplexer.addProcessor(new MainMenuKeyboardHandler());
			// here you can add multiple processors
			// then select only one for process input
			Gdx.input.setInputProcessor(multiplexer);
			// watch https://github.com/libgdx/libgdx/wiki/Event-handling
			MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
			this.setScreen(mainMenuScreen);
		}
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

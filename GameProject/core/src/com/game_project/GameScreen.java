package com.game_project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.game_project.handlers.MainMenuControllerHandler;
import com.game_project.utils.Const;

public class GameScreen implements Screen {

	final GameProject game;
	OrthographicCamera camera;
	
	public GameScreen(final GameProject game) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Const.APP_WIDTH, Const.APP_HEIGHT);
	}
	
	@Override
	public void show() {
		System.out.println("Showing Game Screen");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		game.font.draw(game.batch, "Game Screen", 100, 150);
		
//		game.font.draw(game.batch, "Tap anywhere to go back", 100, 100);
		game.batch.end();
		
		
		// Back to Main Menu
		
		if (Gdx.input.isTouched() && game.totouch) {
			MainMenuScreen mainMenuScreen = new MainMenuScreen(game);
			ControllerAdapter listener = new MainMenuControllerHandler(mainMenuScreen);

			this.game.controller.addListener(listener);

			game.setScreen(mainMenuScreen);
			game.totouch = false;
		} else if (! Gdx.input.isTouched()) {
			game.totouch = true;

		}
	}

	@Override
	public void resize(int width, int height) {
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
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

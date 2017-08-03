package com.game_project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.game_project.model.MainTitle;
import com.game_project.model.MenuOption;
import com.game_project.utils.Const;
import com.game_project.view.Assets;

public class MainMenuScreen implements Screen {

	final GameProject game;
	OrthographicCamera camera;
	
	Texture mainTitle;
	MainTitle mainTitleObject;
	
	Texture startGameOption;
	MenuOption startGameMenuOption;
	
	Texture exitOption;
	MenuOption exitMenuOption;
	
	Music mainTitleMusic;
	boolean totouch;
	
	public MainMenuScreen(final GameProject game) {
		totouch = true;
		this.game = game;
		
		mainTitle = Assets.instance.mainTitleAsset.resource;
		mainTitleObject = new MainTitle();
		
		startGameOption = Assets.instance.startGameOptionAsset.resource;
		startGameMenuOption = new MenuOption();
		startGameMenuOption.setItem(MenuOption.START);
		
		exitOption = Assets.instance.exitOptionAsset.resource;
		exitMenuOption = new MenuOption();
		exitMenuOption.setItem(MenuOption.EXIT);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Const.APP_WIDTH, Const.APP_HEIGHT);
		mainTitleMusic = Assets.instance.mainMenuMusic.resource;
		mainTitleMusic.setLooping(true);
		mainTitleMusic.play();
		
	}
	
	@Override
	public void show() {
		System.out.println("Showing Main Menu Screen");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(8,8, 8, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		this.mainTitleObject.draw(game.batch, this.mainTitle);
		this.startGameMenuOption.draw(game.batch, this.startGameOption);
		this.exitMenuOption.draw(game.batch, this.exitOption);
//		game.batch.draw(mainTitle, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
		game.font.setColor(Color.BLACK);
		game.font.draw(game.batch, "Tap anywhere to begin", 300, 180);
		game.batch.end();
		
		if (Gdx.input.isTouched() && game.totouch) {
			game.setScreen(new GameScreen(game));
			mainTitleMusic.stop();
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
		mainTitleMusic.dispose();
	}

}

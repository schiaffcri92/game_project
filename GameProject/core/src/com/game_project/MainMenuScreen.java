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
	
	Texture startGameSelOption;
	MenuOption startGameMenuSelOption;
	
	Texture exitSelOption;
	MenuOption exitMenuSelOption;
	
	Music mainTitleMusic;
	boolean totouch;
	
	public int selected_menu_item;
	
	public boolean start_game;
	public boolean exit_game;
	
	public MainMenuScreen(final GameProject game) {
		totouch = true;
		this.game = game;
		this.init();
	}
//	
//	public MainMenuScreen(final GameProject game, KeyboardAdapter keyboardAdapter) {
//		totouch = true;
//		this.game = game;
//		this.keyboardAdapter = keyboardAdapter;
//		this.initKeyboardListener();
//		this.init();
//	}
	
	public void init() {
		mainTitle = Assets.instance.mainTitleAsset.resource;
		mainTitleObject = new MainTitle();
		
		this.selected_menu_item = 0;
		this.start_game = false;
		this.exit_game = false;
		
		System.out.println("SELECTED MENU ITEM: " + this.selected_menu_item);
//		if (this.selected_menu_item == 0) {
			startGameSelOption = Assets.instance.startGameOptionSelAsset.resource;
			startGameMenuSelOption = new MenuOption();
			startGameMenuSelOption.setItem(MenuOption.START_S);
//		} else {
			startGameOption = Assets.instance.startGameOptionAsset.resource;
			startGameMenuOption = new MenuOption();
			startGameMenuOption.setItem(MenuOption.START);
//		}
		
		
//		if (this.selected_menu_item == 1) {
			exitSelOption = Assets.instance.exitOptionSelAsset.resource;
			exitMenuSelOption = new MenuOption();
			exitMenuSelOption.setItem(MenuOption.EXIT_S);
//		} else {
			exitOption = Assets.instance.exitOptionAsset.resource;
			exitMenuOption = new MenuOption();
			exitMenuOption.setItem(MenuOption.EXIT);
//		}
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Const.APP_WIDTH, Const.APP_HEIGHT);
		mainTitleMusic = Assets.instance.mainMenuMusic.resource;
		mainTitleMusic.setLooping(true);
//		mainTitleMusic.play();
	}
	
//	public void initKeyboardListener()
//	{
//		
//	}
	
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
		if (this.selected_menu_item == 0) {
			this.startGameMenuSelOption.draw(game.batch, this.startGameSelOption);
		} else {
			this.startGameMenuOption.draw(game.batch, this.startGameOption);
		}
		if (this.selected_menu_item == 1) {
			this.exitMenuSelOption.draw(game.batch, this.exitSelOption);
		} else {
			this.exitMenuOption.draw(game.batch, this.exitOption);
		}
//		game.batch.draw(mainTitle, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
//		game.font.setColor(Color.BLACK);
//		game.font.draw(game.batch, "Tap anywhere to begin", 300, 180);
		game.batch.end();
		
		if (this.start_game) {
			this.start_game = false;
			game.setScreen(new GameScreen(game));
			mainTitleMusic.stop();
			game.totouch = false;
		} else if (this.exit_game) {
			Gdx.app.exit();
		}
//		else if (! Gdx.input.isTouched()) {
//			game.totouch = true;
//		}
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

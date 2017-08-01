package com.game_project;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.game_project.utils.Const;

public class MainMenuScreen implements Screen {

	final GameProject game;
	OrthographicCamera camera;
	Texture mainTitle;
	Music mainTitleMusic;
	boolean totouch;
	
	public MainMenuScreen(final GameProject game) {
		totouch = true;
		this.game = game;
		mainTitle = new Texture(Gdx.files.internal("menu-partials/title_pixelate.png"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Const.APP_WIDTH, Const.APP_HEIGHT);
		mainTitleMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menuTitle.mp3"));
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
		game.batch.draw(mainTitle,  200, 300);
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

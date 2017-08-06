package com.game_project.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.game_project.utils.Const;

public class Assets implements Disposable, AssetErrorListener {

	public static final String TAG = Assets.class.getName();
	
	public static final Assets instance = new Assets();
	
	// The asset manager is a cache for assets, and a single point where get them
	private AssetManager assetManager;
	
	// singleton
	
	private Assets() {}
	
	// textures
	public MainTitleAsset mainTitleAsset;
	public StartGameOptionAsset startGameOptionAsset;
	public ExitOptionAsset exitOptionAsset;
	public StartGameOptionSelAsset startGameOptionSelAsset;
	public ExitOptionSelAsset exitOptionSelAsset;
	public MainCharAsset mainCharAsset;
	public MainCharRunAsset mainCharRunAsset;
	
	// background textures
	public BackgroundAsset backgroundAsset;
	
	// audio effects
	public MainMenuMusic mainMenuMusic;
	
	public void init (AssetManager assetManager) {
		this.assetManager = assetManager;
		// setting asset manager error handler;
		// this class implements AssetErrorListener
		this.assetManager.setErrorListener(this);
		
		// Load resources
		this.assetManager.load(Const.MAIN_TITLE_LOCATION, Texture.class);
		this.assetManager.load(Const.MAIN_MENU_SOUND_LOCATION, Music.class);
		this.assetManager.load(Const.START_GAME_OPTION_LOCATION, Texture.class);
		this.assetManager.load(Const.EXIT_OPTION_LOCATION, Texture.class);
		this.assetManager.load(Const.START_GAME_OPTION_SEL_LOCATION, Texture.class);
		this.assetManager.load(Const.EXIT_OPTION_SEL_LOCATION, Texture.class);
		this.assetManager.load(Const.MAIN_CHAR_LOCATION, Texture.class);
		this.assetManager.load(Const.MAIN_CHAR_RUN_LOCATION, Texture.class);
		this.assetManager.load(Const.BACKGROUND_LOCATION, Texture.class);
		
		this.assetManager.finishLoading();
		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
		for (String a : assetManager.getAssetNames())
			Gdx.app.debug(TAG, "asset: " + a);
		
		Texture mainTitleTexture = this.assetManager.get(Const.MAIN_TITLE_LOCATION);
		this.mainTitleAsset = new MainTitleAsset(mainTitleTexture);
		Texture startGameTexture = this.assetManager.get(Const.START_GAME_OPTION_LOCATION);
		this.startGameOptionAsset = new StartGameOptionAsset(startGameTexture);
		Texture exitTexture = this.assetManager.get(Const.EXIT_OPTION_LOCATION);
		this.exitOptionAsset = new ExitOptionAsset(exitTexture);
		
		// selected
		
		Texture startGameSelTexture = this.assetManager.get(Const.START_GAME_OPTION_SEL_LOCATION);
		this.startGameOptionSelAsset = new StartGameOptionSelAsset(startGameSelTexture);
		Texture exitSelTexture = this.assetManager.get(Const.EXIT_OPTION_SEL_LOCATION);
		this.exitOptionSelAsset = new ExitOptionSelAsset(exitSelTexture);
		
		Music mainMenuMusicM = this.assetManager.get(Const.MAIN_MENU_SOUND_LOCATION);
		this.mainMenuMusic = new MainMenuMusic(mainMenuMusicM);
		
		Texture mainCharTexture = this.assetManager.get(Const.MAIN_CHAR_LOCATION);
		this.mainCharAsset = new MainCharAsset(mainCharTexture);
		Texture mainCharRunTexture = this.assetManager.get(Const.MAIN_CHAR_RUN_LOCATION);
		this.mainCharRunAsset = new MainCharRunAsset(mainCharRunTexture);
		
		// background
		Texture backgroundTexture = this.assetManager.get(Const.BACKGROUND_LOCATION);
		this.backgroundAsset = new BackgroundAsset(backgroundTexture);
	}
	
	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	// Inner classes
	public class MainTitleAsset {
		public final Texture resource;
		
		public MainTitleAsset(Texture mainTitleTexture) {
			this.resource = mainTitleTexture;
		}
	}
	
	public class StartGameOptionAsset {
		public final Texture resource;
		
		public StartGameOptionAsset(Texture resource) {
			this.resource = resource;
		}
	}
	
	public class StartGameOptionSelAsset {
		public final Texture resource;
		
		public StartGameOptionSelAsset(Texture resource) {
			this.resource = resource;
		}
	}
	
	public class ExitOptionAsset {
		public final Texture resource;
		
		public ExitOptionAsset(Texture resource) {
			this.resource = resource;
		}
	}
	
	public class ExitOptionSelAsset {
		public final Texture resource;
		
		public ExitOptionSelAsset(Texture resource) {
			this.resource = resource;
		}
	}
	
	public class MainMenuMusic {
		public final Music resource;
		
		public MainMenuMusic(Music mainMenuMusicM) {
			this.resource = mainMenuMusicM;
		}
	}
	
	public class MainCharAsset {
		public final Texture resource;
		
		public MainCharAsset(Texture resource) {
			this.resource = resource;
		}
	}
	
	public class MainCharRunAsset {
		public final Texture resource;
		
		public MainCharRunAsset(Texture resource) {
			this.resource = resource;
		}
	}
	
	public class BackgroundAsset {
		public final Texture resource;
		
		public BackgroundAsset(Texture resource) {
			this.resource = resource;
		}
	}
}

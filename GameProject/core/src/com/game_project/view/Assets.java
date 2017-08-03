package com.game_project.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
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
	
	public MainTitleAsset mainTitleAsset;
	
	public void init (AssetManager assetManager) {
		this.assetManager = assetManager;
		// setting asset manager error handler;
		// this class implements AssetErrorListener
		this.assetManager.setErrorListener(this);
		
		// Load resources
		this.assetManager.load(Const.MAIN_TITLE_LOCATION, Texture.class);
		// ... more resources
		
		this.assetManager.finishLoading();
		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
		for (String a : assetManager.getAssetNames())
			Gdx.app.debug(TAG, "asset: " + a);
		
		Texture mainTitleTexture = this.assetManager.get(Const.MAIN_TITLE_LOCATION);
		
		this.mainTitleAsset = new MainTitleAsset(mainTitleTexture);
		
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
		public final Texture mainTitleTexture;
		
		public MainTitleAsset(Texture mainTitleTexture) {
			this.mainTitleTexture = mainTitleTexture;
		}
	}
}

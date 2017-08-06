package com.game_project.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game_project.view.Assets;

public class MainCharacter extends AbstractGameObject {

	public static final String TAG = MainCharacter.class.getName();
	
	private final float JUMP_TIME_MAX = 0.3f;
	private final float JUMP_TIME_MIN = 0.1f;
	private final float JUMP_TIME_OFFSET_FLYING = JUMP_TIME_MAX - 0.018f;
	
	// Declaring enums
	
	public enum VIEW_DIRECTION { LEFT, RIGHT }
	
	public enum JUMP_STATE {
		GROUNDED, FALLING, JUMP_RISING, JUMP_FALLING
	}
	
	private Texture regCharacter;
	
	public VIEW_DIRECTION viewDirection;
	public float timeJumping;
	public JUMP_STATE jumpState;
	public boolean isRunning;
	public float runningTime;
	
	public MainCharacter () {
		init();
	}
	
	public void init() {
		dimension.set(1,1);
		regCharacter = Assets.instance.mainCharAsset.resource;
		// to be continued...
	};
	public void setJumping (boolean jumpKeyPressed) {};
	public void setRunning (boolean runKeyPressed) {};
	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub

	}

}

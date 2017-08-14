package com.game_project.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game_project.view.Assets;

public class MainCharacter extends AbstractGameObject {

	public static final String TAG = MainCharacter.class.getName();
	
	private final float JUMP_TIME_MAX = 0.3f;
	private final float JUMP_TIME_MIN = 0.1f;
	private final float JUMP_TIME_OFFSET_FLYING = JUMP_TIME_MAX - 0.018f;
	
	private final int RUN_FRAME_ROWS = 1;
	private final int RUN_FRAME_COLS = 4;
	
	// Declaring enums
	
	public enum VIEW_DIRECTION { LEFT, RIGHT }
	
	public enum JUMP_STATE {
		GROUNDED, FALLING, JUMP_RISING, JUMP_FALLING
	}
	
	private Texture regCharacter;
	private Texture regRunChar;
	
	private TextureRegion currentTexture;
	
	private Animation<TextureRegion> runAnimation;
	
	public VIEW_DIRECTION viewDirection;
	public float timeJumping;
	public JUMP_STATE jumpState;
	public boolean isRunning;
	public float runningTime;
	private float baseY;
	
	public MainCharacter () {
		init();
	}
	
	public void init() {
		dimension.set(1,1);
		
		regCharacter = Assets.instance.mainCharAsset.resource;
		regRunChar = Assets.instance.mainCharRunAsset.resource;
		TextureRegion[][] tmp = TextureRegion.split(regRunChar,
				regRunChar.getWidth() / RUN_FRAME_COLS,
				regRunChar.getHeight() / RUN_FRAME_ROWS);
		
		TextureRegion[] runFrames = new TextureRegion[RUN_FRAME_COLS * RUN_FRAME_ROWS];
		
		int index = 0;
		for (int i = 0; i < RUN_FRAME_ROWS; i++) {
			for (int j = 0; j < RUN_FRAME_COLS; j++) {
				runFrames[index++] = tmp[i][j];
			}
		}
		
		this.runAnimation = new Animation<TextureRegion>(0.15f, runFrames);
		
		isRunning = false;
		runningTime = 0f;
		// the main character is initially grounded
		jumpState = JUMP_STATE.GROUNDED;
		timeJumping = 0f;
		
		position = new Vector2(100f, 100f);
		dimension = new Vector2();
		origin = new Vector2();
		scale = new Vector2(1,1);
		rotation = 0;
		
		velocity = new Vector2();
		terminalVelocity = new Vector2(1,1);
		friction = new Vector2();
		acceleration = new Vector2();
		bounds = new Rectangle();
		baseY = 100f;
		
	};
	
	public void update (float deltaTime) {
		super.update(deltaTime);
		
		isRunning = true;
		this.runningTime += deltaTime;
		if (this.runningTime > 0.60f) {
			this.runningTime = 0f;
		}
		if (isRunning) {
			this.currentTexture = this.runAnimation.getKeyFrame(this.runningTime);
		} else {
//			this.currentTexture = regCharacter;
		}
	}
	
	public void setJumping (boolean jumpKeyPressed) {};
	public void setRunning (boolean runKeyPressed) {};
	@Override
	public void render(SpriteBatch batch) {
		update(Gdx.graphics.getDeltaTime());
		batch.draw(this.currentTexture, position.x, position.y + baseY);
	}

}

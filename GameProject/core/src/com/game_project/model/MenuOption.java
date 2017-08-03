package com.game_project.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuOption implements MenuItem {
	
	public static final int START = 0;
	public static final int EXIT = 1;
	public static final int START_S = 2;
	public static final int EXIT_S = 3;
	
	public int option_type = 0;
	
	
	public void draw(SpriteBatch batch, Object resource) {
		switch (this.option_type) {
		case MenuOption.START:
			batch.draw((Texture)resource,  300, 250, 170, 45);
			break;
		case MenuOption.EXIT:
			batch.draw((Texture)resource,  350, 180, 80, 45);
			break;
		case MenuOption.START_S:
			batch.draw((Texture)resource,  270, 250, 200, 45);
			break;
		case MenuOption.EXIT_S:
			batch.draw((Texture)resource,  320, 180, 110, 45);
			break;
		}
	}
	
	public void setItem(int option_type) {
		this.option_type = option_type;
	}
}

package com.game_project.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuOption implements MenuItem {
	
	public static final int START = 0;
	public static final int EXIT = 1;
	
	public int option_type = 0;
	
	public boolean is_selected = false;
	
	public void draw(SpriteBatch batch, Object resource) {
		switch (this.option_type) {
		case MenuOption.START:
			batch.draw((Texture)resource,  300, 300, 170, 45);
			break;
		case MenuOption.EXIT:
			batch.draw((Texture)resource,  350, 230, 80, 45);
			break;
		}
	}
	
	public void setItem(int option_type) {
		this.option_type = option_type;
	}
	
	public void setSelected() {
		this.is_selected = true;
	}
	
	public void setSelected(boolean selected) {
		this.is_selected = selected;
	}
}

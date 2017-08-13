package com.game_project.handlers;

import com.badlogic.gdx.InputProcessor;
import com.game_project.MainMenuScreen;

public class MainMenuKeyboardHandler implements InputProcessor {
	
	MainMenuScreen mainMenuScreen;
	
	public MainMenuKeyboardHandler(MainMenuScreen mainMenuScreen) {
		this.mainMenuScreen = mainMenuScreen;
	}
	
	public boolean keyDown (int keycode) {
		System.out.println("BUTTON PRESSED: " + keycode);
		switch (keycode) {
		case 19: {
			mainMenuScreen.selected_menu_item = 0;
		}
		break;
		case 20: {
			mainMenuScreen.selected_menu_item = 1;
		}
		break;
		case 66: {
			if (mainMenuScreen.selected_menu_item == 0) {
				mainMenuScreen.start_game = true;
			} else if (mainMenuScreen.selected_menu_item == 1) {
				mainMenuScreen.exit_game = true;
			}
		}
		break;
		}
		return true;
	}
	
	public boolean keyUp(int keycode) {
		return false;
	}
	
	public boolean keyTyped(char character) {
		return false;
	}
	
	public boolean touchDown(int x, int y, int pointer, int button) {
		return false;
	}
	
	public boolean touchUp (int x, int y, int pointer, int button) {
		return false;
	}
	
	public boolean touchDragged (int x, int y, int pointer) {
		return false;
	}
	
	public boolean mouseMoved (int x, int y) {
		return false;
	}
	
	public boolean scrolled (int amount) {
		return false;
	}
}

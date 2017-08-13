package com.game_project.handlers;

import com.badlogic.gdx.InputProcessor;

public class MainMenuKeyboardHandler implements InputProcessor {
	
	public boolean keyDown (int keycode) {
		System.out.println("KEY DOWN");
		return false;
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

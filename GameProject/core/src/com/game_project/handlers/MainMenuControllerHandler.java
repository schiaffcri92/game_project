package com.game_project.handlers;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;
import com.game_project.MainMenuScreen;

public class MainMenuControllerHandler extends ControllerAdapter {
	
	MainMenuScreen mainMenuScreen;
	
	public MainMenuControllerHandler(MainMenuScreen mainMenuScreen) {
		this.mainMenuScreen = mainMenuScreen;
	}
	
	public void connected(Controller controller) {
		System.out.println("CONTROLLER CONNECTED");
	}
	
	public boolean buttonDown(Controller controller, int buttonCode) {
		System.out.println("BUTTON PRESSED: " + buttonCode);
		if (mainMenuScreen.selected_menu_item == 0) {
			mainMenuScreen.start_game = true;
		} else if (mainMenuScreen.selected_menu_item == 1) {
			mainMenuScreen.exit_game = true;
		}
		return true;
	}
	
	public boolean axisMoved(Controller controller, int axisIndex, float value) {
		System.out.println("AXIS MOVED");
		return true;
	}
	
	public boolean povMoved (Controller controller, int povIndex, PovDirection value) {
		System.out.println("POV MOVED");
		if (value == PovDirection.south) {
			mainMenuScreen.selected_menu_item = 1;
		} else if (value == PovDirection.north) {
			mainMenuScreen.selected_menu_item = 0;
		}
		return false;
	}
}

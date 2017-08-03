package com.game_project.handlers;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;

public class MainMenuControllerHandler extends ControllerAdapter {
	public void connected(Controller controller) {
		System.out.println("CONTROLLER CONNECTED");
	}
	
	public boolean buttonDown(Controller controller, int buttonCode) {
		System.out.println("BUTTON PRESSED: " + buttonCode);
		return true;
	}
	
	public boolean axisMoved(Controller controller, int axisIndex, float value) {
		System.out.println("AXIS MOVED");
		return true;
	}
	
	public boolean povMoved (Controller controller, int povIndex, PovDirection value) {
		System.out.println("POV MOVED");
		return false;
	}
}

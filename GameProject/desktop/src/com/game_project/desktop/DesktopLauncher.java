package com.game_project.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game_project.GameProject;
import com.game_project.utils.Const;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Const.APP_WIDTH;
		config.height = Const.APP_HEIGHT;
		new LwjglApplication(new GameProject(), config);
	}
}

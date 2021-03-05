package com.genetic.bots.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.genetic.bots.Main;

public class DesktopLauncher {
	public static LwjglApplication application;
	public static Main main;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;

		config.resizable = false;
		config.title = "SmartGen";

		main = new Main();
		application = new LwjglApplication(main, config);
	}
}

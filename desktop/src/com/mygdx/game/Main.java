package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Tetris");
		config.setWindowedMode(800, 800);
		config.useVsync(true);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new Game(), config);
	}

}
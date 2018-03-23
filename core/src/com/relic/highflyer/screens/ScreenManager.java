package com.relic.highflyer.screens;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Disposable;
import com.relic.highflyer.GameEngine;

/**
 * This class manages the transition from one level to another.
 */
public class ScreenManager implements Disposable {

	private static final ScreenManager INSTANCE = new ScreenManager();

	private GameEngine game;
	private Map<String, Screen> screens = new HashMap<>();

	private ScreenManager() {
	}

	public static void init(GameEngine game) {
		INSTANCE.game = game;
	}

	public static ScreenManager instance() {
		return INSTANCE;
	}

	public Screen getInitial() {
		Screen screen = new Level1(game);
		screens.put(Level1.class.getSimpleName(), screen);
		return screen;
	}
	public void setScreen(AbstractLevel level ) {
		game.setScreen(level);
	}
	
	

	@Override
	public void dispose() {
	}
}

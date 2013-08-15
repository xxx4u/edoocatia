package id.ac.ui.edoocatia.util;

import id.ac.ui.edoocatia.screen.MenuScreen;
import id.ac.ui.edoocatia.screen.feature.PauseScreen;

public class ScreenPool {

	private static MenuScreen menuScreen;
	private static PauseScreen pauseScreen;

	public static MenuScreen getMenuScreen() {
		if (menuScreen == null) {
			menuScreen = new MenuScreen();
		}
		return menuScreen;
	}

	public static void setMenuScreen(MenuScreen menuScreen) {
		ScreenPool.menuScreen = menuScreen;
	}

	public static PauseScreen getPauseScreen() {
		if (pauseScreen == null) {
			pauseScreen = new PauseScreen(null);
		}
		return pauseScreen;
	}

	public static void setPauseScreen(PauseScreen pauseScreen) {
		ScreenPool.pauseScreen = pauseScreen;
	}
}

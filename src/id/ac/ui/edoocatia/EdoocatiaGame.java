package id.ac.ui.edoocatia;

import id.ac.ui.edoocatia.screen.MenuScreen;
import id.ac.ui.edoocatia.screen.SplashScreen;
import id.ac.ui.edoocatia.util.Log;
import id.ac.ui.edoocatia.util.ScreenPool;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

/**
 * The main class of the game.
 * <p>
 * This class has responsibility for handling screens flow and global game constants.
 * 
 * @author Fikrul
 * 
 */
public class EdoocatiaGame extends Game {

	/** Log tag for this application, specific to game. */
	public static final String LOG_TAG = "EdoocatiaGame";
	
	public static final String MODULE1 = "mod1";
	public static final String MODULE2 = "mod2";
	public static final String MODULE3 = "mod3";
	public static final String INTRO = "intro";
	public static final String JELAJAH = "jelajah";
	public static final String FORUM = "forum";
	public static final String JUARA = "juara";
	
	/**
     * Holds all our assets
     */
    public AssetManager manager = new AssetManager();
    
	/** Action resolver to deal with platform dependent task (e.g. string resource). */
	//public static AndroidActionResolver actionResolver;

	// CONSTRUCTORS
	
	public EdoocatiaGame() {
		;
	}
	
	public EdoocatiaGame(ActionResolver ar) {
		//actionResolver = (AndroidActionResolver) ar;
	}
	
	// METHODS

	@Override
	public void create() {
		//setScreen(new Module1EasyScreen());
		setScreen(new SplashScreen());
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render() {
		super.render();

		AbstractScreen screen = (AbstractScreen) getScreen();
		if (screen.nextScreenSign != AbstractScreen.SCREEN_NONE) {
			//AbstractScreen prevScreen = (AbstractScreen) getScreen();
			switch (screen.nextScreenSign) {
			case AbstractScreen.SCREEN_MENU:
				Log.d("ganti ke screen menu");
				MenuScreen ms = ScreenPool.getMenuScreen();
				setScreen(ms);
				screen.dispose();
				break;
			case AbstractScreen.SCREEN_CUSTOM:
				Log.d("ganti screen custom");
				setScreen(screen.nextScreenCustom);
				if (screen.disposeScreen)
					screen.dispose();
				break;
			case AbstractScreen.SCREEN_PAUSE:
				setScreen(ScreenPool.getPauseScreen());
				break;
			}
			
		}
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
	
}
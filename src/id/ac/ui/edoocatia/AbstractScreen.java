package id.ac.ui.edoocatia;


import id.ac.ui.edoocatia.model.Profile;
import id.ac.ui.edoocatia.service.ProfileService;
import id.ac.ui.edoocatia.util.Log;

import java.util.ResourceBundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * The superclass for all Edunesia game screen.
 * 
 * @author Fikrul
 * @author Yahya M.
 */
public abstract class AbstractScreen implements Screen {

	/** Absolute dimension of the screen viewport in pixel. */
	public static final int VIEWPORT_WIDTH = 320, VIEWPORT_HEIGHT = 240;
	//public static final float VIEWPORT_WIDTH = 10f, VIEWPORT_HEIGHT = 6f;
	
	/**
	 * Do not change the screen.
	 * @see #startScreen(int, AbstractScreen)
	 */
	protected static final int SCREEN_NONE = 0;
	
	/**
	 * Go to custom screen.
	 * @see #startScreen(int, AbstractScreen)
	 */
	protected static final int SCREEN_CUSTOM = 1;
	
	/**
	 * Go to Pause screen.
	 * @see #startScreen(int, AbstractScreen)
	 */
	protected static final int SCREEN_PAUSE = 2;
	
	/**
	 * Go to Menu screen.
	 * @see #startScreen(int, AbstractScreen)
	 */
	protected static final int SCREEN_MENU = 3;
	
	/** Base name for resources specific for this screen. This field is used only if necessary. */
	protected final String resourceBase;
	
	/** The stage used for this screen. */
	protected Stage stage;
	
	/** Asset manager for this screen. Make sure all assets are loaded by using asset manager. */
	protected static AssetManager asset = new AssetManager();
	
	/** Texture atlas for this screen, loaded from {@link #asset}. */
	protected final TextureAtlas textureAtlas;
	
	/** Skin for this screen, loaded from {@link #asset}. */
	protected final Skin skin;
	
	/** Multi-language support for this screen. */
	protected final ResourceBundle lang;
	
	/** Next screen signature/signal. */
	protected int nextScreenSign;
	protected boolean disposeScreen = false;
	
	/** Next custom screen (only relevant if <code>nextScreenSign</code> is custom. */
	protected AbstractScreen nextScreenCustom;
	
	protected Profile profile;

	// CONSTRUCTOR

	/**
	 * Create the screen and initiate the resources.
	 * 
	 * @param resourceBase
	 *            base name for resources specific for this screen (e.g.
	 *            "mod1" means all specific resources prefixed with
	 *            "mod1/").
	 */
	public AbstractScreen(String resourceBase) {
		Log.d("SCREEN <CONSTRUCT>");
		
		/* Apa yang diinisiasi disini, di-dispose di method dispose. */
		
		this.resourceBase = resourceBase;
		
		this.stage = new Stage(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, true);
		
		asset.load("img/pack.atlas", TextureAtlas.class);
		asset.load("skin/uiskin.json", Skin.class);
		asset.finishLoading();
		
		this.textureAtlas = asset.get("img/pack.atlas", TextureAtlas.class);
		this.skin = asset.get("skin/uiskin.json", Skin.class);
		this.profile = ProfileService.get().getProfile();
		if(resourceBase != null && resourceBase.equals(EdoocatiaGame.MODULE1) 
				|| resourceBase.equals(EdoocatiaGame.JELAJAH))
			this.lang = ResourceBundle.getBundle(resourceBase, profile.getPreferredLanguage());
		else
			this.lang = null;
	}
	
	// METHODS
	
	@Override
	public void render(float delta) {
		stage.act(delta);
		
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		Log.d("SCREEN RESIZE to " + width + "x" + height);
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		Log.d("SCREEN SHOW");
		Gdx.input.setInputProcessor(stage);
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setCatchMenuKey(true);
	}

	@Override
	public void hide() {
		Log.d("SCREEN HIDE");
		Gdx.input.setInputProcessor(null);
		nextScreenSign = SCREEN_NONE;
	}

	@Override
	public void pause() {
		Log.d("SCREEN PAUSE");
	}

	@Override
	public void resume() {
		Log.d("SCREEN RESUME");
	}

	@Override
	public void dispose() {
		Log.d("SCREEN DISPOSE");
		stage.dispose();
	}
	
	/**
	 * Start screen.
	 * <p>
	 * Actual swithing is done in the next loop.
	 * @param screen next screen sign (e.g. <code>SCREEN_MENU</code>)
	 * @param customScreen custom screen if <code>screen</code> is <code>SCREEN_CUSTOM</code>
	 */
	protected void startScreen(int screen, AbstractScreen customScreen) {
		nextScreenSign = screen;
		if (screen == SCREEN_CUSTOM)
			nextScreenCustom = customScreen;
	}
}

package id.ac.ui.edoocatia.screen.intro;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;

public abstract class IntroScene {
	protected Texture texture;
	protected Group group;
	protected Action lastAction;
	protected AssetManager manager;
	
	public final static String INTRO1 = "img/intro1.png";
	public final static String INTRO2 = "img/intro2.png";
	public final static String INTRO3 = "img/intro3.png";
	public final static String INTRO4 = "img/intro4.png";
	public final static String INTRO4B = "img/intro4b.png";
	public final static String INTRO5 = "img/intro5.png";
	public final static String INTRO5B = "img/intro5b.png";
	public final static String INTRO_CHAR = "img/intro-char.png";
	
	public IntroScene(AssetManager mgr){
		manager = mgr;
		group = new Group();
	}
	
	public abstract Group build(int width, int height);
	
	public void setLastAction(Action action) {
		this.lastAction = action;
	}
	
	protected void updateTexture(String path) {
		texture = manager.get(path, Texture.class);
        texture.setFilter(TextureFilter.Linear,TextureFilter.Linear);
	}
}

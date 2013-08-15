package id.ac.ui.edoocatia.screen;

import id.ac.ui.edoocatia.screen.scene.Scene;
import id.ac.ui.edoocatia.service.ProfileService;
import id.ac.ui.edoocatia.util.Log;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Array;

/**
 * This class encapsulates {@link ModuleScreen} attributes for used by {@link Scene}.
 * 
 * @author Fikrul
 *
 */
public class SceneKit {

	private ModuleScreen screen;
	
	public SceneKit(ModuleScreen screen) {
		this.screen = screen;
	}
	
	public final TextureAtlas getAtlas() {
		return screen.getTextureAtlas();
	}
	
	public final AtlasRegion findRegion(String name) {
		return screen.getTextureAtlas().findRegion(name);
	}
	
	public final Array<AtlasRegion> findRegions(String name) {
		return screen.getTextureAtlas().findRegions(name);
	}

	public final CharSequence getString(String key) {
		return screen.getLang().getString(key);
	}

	public final void startText(CharSequence text, Action completeAction, boolean waitUser) {
		screen.tickerText.startText(text, completeAction, waitUser);
	}

	public final boolean isTextFinished() {
		return screen.tickerText.isFinished();
	}
	
	public final void startScene(Scene nextScene) {
		screen.startScene(nextScene);
	}

	public final Action nextSceneAction(Scene scene) {
		return screen.getStartSceneAction(scene);
	}
	
	public int getPlayerScore() {
		return ProfileService.get().getProfile().getScore();
	}
	
	public void addPlayerScore(int deltaScore) {
		ProfileService.get().getProfile().addScore(deltaScore);
		Log.d("Score: " + getPlayerScore());
	}
}

package id.ac.ui.edoocatia.screen.scene;

import id.ac.ui.edoocatia.screen.SceneKit;
import id.ac.ui.edoocatia.util.SceneUtil;

import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Superclass for scenes used in module screens.
 * 
 * @author Fikrul
 *
 */
public abstract class Scene extends Group {

	/** The scene kit for communication between scene and its screen. */
	protected final SceneKit kit;
	
	/**
	 * Create a new instance of scene. Do not do heavy-weight task (such as
	 * loading assets) in constructor when inheriting this class, do it in
	 * {@link #create()}.
	 * @param kit
	 */
	public Scene(SceneKit kit) {
		this.kit = kit;
	}
	
	/**
	 * Do final task of the scene.
	 * <p>
	 * This method will be called when the scene will be switched to another
	 * scene. Default implementation of this method clears actions recursively
	 * (scene and children) and removes itself from the parent. So, when you
	 * override this method always call <code>super</code>'s one.
	 */
	public void dispose() {
		SceneUtil.clearAllActions(this);
		remove();
	}
	
	/**
	 * This method will be called at the time the scene loaded to the screen.
	 * <p>
	 * Implement this method for doing initialization, such as loading assets
	 * and adding actors along with their actions.
	 * @see SceneKit#startScene(Scene)
	 */
	public abstract void create();
}

package id.ac.ui.edoocatia.screen.scene;

import id.ac.ui.edoocatia.screen.SceneKit;
import id.ac.ui.edoocatia.util.SceneUtil;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * A scene displaying the professor explaining something.
 * 
 * @author Fikrul
 *
 */
public class ProfessorScene extends Scene {

	private String resKey;
	private Scene nextScene;
	
	public ProfessorScene(SceneKit kit, String resKey, Scene nextScene) {
		super(kit);
		this.resKey = resKey;
		this.nextScene = nextScene;
	}

	@Override
	public void create() {
		final Image professor = new Image(kit.findRegion("mod1/scene1/professor"));
		SceneUtil.addActorAligned(this, professor, 0.5f, 0.5f);
		
		kit.startText(kit.getString(resKey), kit.nextSceneAction(nextScene), true);
	}

}

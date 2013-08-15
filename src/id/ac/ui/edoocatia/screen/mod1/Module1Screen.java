package id.ac.ui.edoocatia.screen.mod1;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.rotateTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.screen.ModuleScreen;
import id.ac.ui.edoocatia.screen.scene.ChoiceScene;
import id.ac.ui.edoocatia.screen.scene.ChoiceScene.Choice;
import id.ac.ui.edoocatia.screen.scene.ProfessorScene;
import id.ac.ui.edoocatia.screen.scene.Scene;
import id.ac.ui.edoocatia.util.SceneUtil;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Screen for Module 1 - Easy level.
 * 
 * @author Fikrul
 *
 */
public class Module1Screen extends ModuleScreen {
	
	private static final int CORRECT_SCORE = 100;
	private static final int WRONG_SCORE = -20;
	
	private Scene scene6o4 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText(
					"wow, kamu cerdas! Hydrogen adalah bahan bakar pesawat luar angkasa. " +
					"Selamat menikmati perjalanan luar angkasa!. " +
					"Tapi hati-hati dengan benda-benda luar angkasa. " +
					"Jaga keselamatan. Selamat jalaaaan!",
					null, true);
		}
	};
	
	private Scene scene6o3 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText("balon udara yang mana yang dapat memberikan energy untuk pesawat?",
					getStartSceneAction(scene6o4), true);
		}
	};
	
	private Scene scene6o2 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText("ups, Pesawatmu membutuhkan energy agar dapat bekerja. Ayo beri dia energy!",
					getStartSceneAction(scene6o3), true);
		}
	};
	
	private Scene scene6o1 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText("Tokoh naik ke pesawat dan menghidupkan mesin. Mesin tidak dapat hidup.",
					getStartSceneAction(scene6o2), true);
		}
	};

	private Scene scene6 = new ProfessorScene(sceneKit, "scene6.intro", scene6o1);
	
	private Scene scene5o2 = new ProfessorScene(sceneKit, "scene5.answer", scene6);
	
	private Scene scene5o1 = new ChoiceScene(sceneKit, "scene5.question", 2,
			scene5o2, CORRECT_SCORE,
			"scene5.question.wrong", WRONG_SCORE,
			"mod1/scene5/cekung", "mod1/scene5/datar", "mod1/scene5/cembung");
	
	private Scene scene5 = new ProfessorScene(sceneKit, "scene5.professor", scene5o1);
	
	private Scene scene4o4 = new ProfessorScene(sceneKit, "scene4.answer", scene5);
	
	private Scene scene4o3 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText("Jawaban benar, tapi gambarnya belum ada, jadi dibayangkan saja",
					getStartSceneAction(scene4o4), true);
		}
	};
	
	private Scene scene4o2 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText("Tokoh menarik badan pesawat, tapi gambarnya belum ada, jadi dibayangkan saja",
					getStartSceneAction(scene4), true);
		}
	};
	
	private Scene scene4o1 = new Scene(sceneKit) {
		@Override
		public void create() {
			kit.startText("Tokoh mendorong sayap, tapi gambarnya belum ada, jadi dibayangkan saja",
					getStartSceneAction(scene4), true);
		}
	};
	
	private Scene scene4 = new ChoiceScene(sceneKit, "scene4.question", ChoiceScene.FLAG_CUSTOM_POSITION).
			addChoice(new Choice("mod1/scene3/gunting", null, scene4o1, WRONG_SCORE).
					setPosition(0f, 1f)).
			addChoice(new Choice("mod1/scene3/gunting", null, scene4o2, WRONG_SCORE).
					setPosition(0.5f, 0.5f)).
			addChoice(new Choice("mod1/scene3/gunting", null, scene4o3, CORRECT_SCORE).
					setPosition(1f, 0f));
	
	private Scene scene3o2 = new Scene(sceneKit) {
		@Override
		public void create() {
			final InputListener hammerListener = new InputListener() {
				private int count = 0;
				
				@Override
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					Actor actor = event.getListenerActor();
					if (actor.getActions().size != 0)
						return false;
					SequenceAction action = sequence(
							rotateTo(0f, 0.5f, Interpolation.pow4In),
							rotateTo(60f, 0.6f, Interpolation.pow2In));
					if (++count == 3)
							action.addAction(getStartSceneAction(scene4));
					actor.addAction(action);
					return true;
				}
			};
			
			final Image besi = new Image(textureAtlas.findRegion("mod1/scene2/besi"));
			SceneUtil.addActorAligned(this, besi, 0.5f, 0.5f);
		
			final Image palu = new Image(textureAtlas.findRegion("mod1/scene3/palu"));
			palu.setOrigin(0.1f * palu.getWidth(), 0.1f * palu.getHeight());
			palu.setRotation(60f);
			SceneUtil.align(palu, 0.75f, 0f, besi, 0.5f, 0.6f);
			this.addActor(palu);
			palu.addListener(hammerListener);
			
			kit.startText(kit.getString("scene3.hammer"), null, false);
		}
	};
	
	private Scene scene3o1 = new ProfessorScene(sceneKit, "scene3.answer", scene3o2);
	
	private Scene scene3 = new ChoiceScene(sceneKit, "scene3.question", 2,
			scene3o1, CORRECT_SCORE,
			"scene3.question.wrong", WRONG_SCORE,
			"mod1/scene3/gunting", "mod1/scene3/palu", "mod1/scene3/tang");
	
	private Scene scene2o1 = new ProfessorScene(sceneKit, "scene2.answer", scene3);

	private Scene scene2 = new ChoiceScene(sceneKit, "scene2.question", 0,
			scene2o1, CORRECT_SCORE,
			"scene2.question.wrong", WRONG_SCORE,
			"mod1/scene2/besi", "mod1/scene2/kayu", "mod1/scene2/plastik");

	private Scene scene1 = new ProfessorScene(sceneKit, "scene1.welcome", scene2);

	// CONSTRUCTORS
	
	public Module1Screen() {
		super(EdoocatiaGame.MODULE1);
	}
	
	public Module1Screen(AssetManager manager) {
		this();
		this.asset = manager;
	}
	
	// METHODS
	
	@Override
	public void show() {
		super.show();
		startScene(scene1);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}

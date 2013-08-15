package id.ac.ui.edoocatia.screen.scene;

import id.ac.ui.edoocatia.screen.SceneKit;
import id.ac.ui.edoocatia.util.SceneUtil;

import java.util.LinkedList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * A scene displaying choices for the player.
 * 
 * @author Fikrul
 *
 */
public class ChoiceScene extends Scene {
	
	public static class Choice {
		public final String assetName;
		public final String messageKey;
		public final Scene nextScene;
		public final int score;
		private float positionRatioX;
		private float positionRatioY;
		
		public Choice(String assetName, String messageKey, Scene nextScene, int score) {
			this.assetName = assetName;
			this.messageKey = messageKey;
			this.nextScene = nextScene;
			this.score = score;
		}
		
		public final boolean isCorrect() {
			return score > 0;
		}
		
		public final boolean isWrong() {
			return score < 0;
		}
		
		public Choice setPosition(float ratioX, float ratioY) {
			this.positionRatioX = ratioX;
			this.positionRatioY = ratioY;
			return this;
		}
	}

	private final class ChoiceListener extends InputListener {
		
		private int index;
		
		public ChoiceListener(int index) {
			this.index = index;
		}
		
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			
			if (canAnswer()) {
				choose(choices.get(index));
				return true;
			}
			return false;
		}
	};
	
	// FIELDS

	public static final int FLAG_CUSTOM_POSITION = 1;
	
	private int featureFlag = 0;
	
	private LinkedList<Choice> choices = new LinkedList<Choice>();
	
	private String messageKey;
	
	// CONSTRUCTORS
	
	public ChoiceScene(SceneKit kit, String messageKey) {
		super(kit);
		this.messageKey = messageKey;
	}
	

	public ChoiceScene(SceneKit kit, String messageKey, int featureFlag) {
		this(kit, messageKey);
		this.featureFlag = featureFlag;
	}
	
	public ChoiceScene(SceneKit kit, String messageKey, int correctChoice,
			Scene correctScene, int rightScore,
			String wrongMessageKey, int wrongScore,
			String... choiceAssetNames) {
		this(kit, messageKey);
		
		for (int i = 0; i < choiceAssetNames.length; ++i) {
			if (i == correctChoice)
				addChoice(choiceAssetNames[i], null, correctScene, rightScore);
			else
				addChoice(choiceAssetNames[i], wrongMessageKey, null, wrongScore);
		}
	}

	// METHODS
	
	@Override
	public void create() {
		addActorsToScene();
		
		kit.startText(kit.getString(messageKey), null, false);
	}
	
	public ChoiceScene addChoice(Choice choice) {
		choices.add(choice);
		return this;
	}

	public ChoiceScene addChoice(String assetName, String messageKey, Scene nextScene, int score) {
		choices.add(new Choice(assetName, messageKey, nextScene, score));	
		return this;
	}
	
	public ChoiceScene setFeature(int flag, boolean value) {
		if (value)
			featureFlag |= flag;
		else
			featureFlag &= ~flag;
		return this;
	}
	
	public boolean getFeature(int flag) {
		return (featureFlag & flag) == flag;
	}

	protected boolean canAnswer() {
		return kit.isTextFinished();
	}

	protected void choose(Choice chosen) {
		kit.addPlayerScore(chosen.score);
		
		if (chosen.messageKey == null) {
			if (chosen.nextScene != null)
				kit.startScene(chosen.nextScene);
		} else {
			kit.startText(kit.getString(chosen.messageKey),
					chosen.nextScene != null ? kit.nextSceneAction(chosen.nextScene) : null,
					chosen.nextScene != null);
		}
	}
	
	protected Actor createActor(String assetName) {
		return new Image(kit.findRegion(assetName));
	}
	
	protected void addActorsToScene() {
		Actor[] choiceActors = new Actor[choices.size()];
		
		for (int i = 0; i < choiceActors.length; ++i) {
			Actor actor = createActor(choices.get(i).assetName);
			actor.addListener(new ChoiceListener(i));
			
			choiceActors[i] = actor;
		}
		
		if (getFeature(FLAG_CUSTOM_POSITION)) {
			
			for (int i = 0; i < choiceActors.length; ++i) {
				addActor(choiceActors[i]);
				SceneUtil.align(choiceActors[i], choices.get(i).positionRatioX,
						choices.get(i).positionRatioY);
			}
			
		} else {
			SceneUtil.addActorsDistributed(this, 0f, 0.5f, 1f, 0.5f, choiceActors);
		}
	}
}

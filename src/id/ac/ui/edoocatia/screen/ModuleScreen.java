package id.ac.ui.edoocatia.screen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.screen.act.TickerText;
import id.ac.ui.edoocatia.screen.scene.Scene;
import id.ac.ui.edoocatia.util.ModalActor;

import java.util.ResourceBundle;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Abstract superclass for all module (game play) screens.
 * 
 * @author Fikrul
 *
 */
public abstract class ModuleScreen extends AbstractScreen {
	
	public enum GameState {
		PLAY, PAUSE, PAUSED, FINISH;
	}
	
	protected GameState gameState;
	
	private final class StartSceneRunnable implements Runnable {
		private Scene scene;

		@Override
		public void run() {
			startScene(this.scene);
		}
	}
	
	TickerText tickerText;
	
	private Group sceneContainer;
	private Scene prevScene = null;
	private Scene currentScene = null;
	private Scene nextScene = null;
	private StartSceneRunnable startSceneRunnable;
	protected SceneKit sceneKit;
	
	// CONSTRUCTORS
	
	public ModuleScreen(String resourceBase) {
		super(resourceBase);
		gameState = GameState.PLAY;
		
		stage = new Stage() {
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Keys.BACK) {
					pause();
					return true;
				}
				return super.keyDown(keyCode);
			}
		};
		
		tickerText = new TickerText(skin);
		tickerText.setWidth(stage.getWidth());
		
		sceneKit = new SceneKit(this);
		
		sceneContainer = new Group();

		stage.addActor(sceneContainer);
		stage.addActor(tickerText);
	}
	
	// METHODS
	
	@Override
	public void render(float delta) {		
		// For debug mode
		Table.drawDebug(stage);
		
		/* Check switch scene request */
		
		if (gameState == GameState.PLAY && nextScene != null) {
			if (currentScene != null)
				currentScene.dispose();
			
			currentScene = nextScene;
			nextScene = null;
			
			currentScene.setSize(stage.getWidth(), stage.getHeight());
			currentScene.create();
			sceneContainer.addActor(currentScene);
		}
		
		if (gameState == GameState.PAUSE) {
			gameState = GameState.PAUSED;
			prevScene = currentScene;
			currentScene = getPauseScene();
			currentScene.setSize(stage.getWidth(), stage.getHeight());
			currentScene.create();
			sceneContainer.addActor(currentScene);
			prevScene.toBack();
			currentScene.toFront();
		}

		super.render(delta);
	}

	@Override
	public void pause() {
		super.pause();
		if (gameState != GameState.PAUSED)
			gameState = GameState.PAUSE;
	}

	private Scene getPauseScene() {
		Scene scene = new Scene(sceneKit) {
			@Override
			public void create() {
				Window window = new Window("Paused", skin);
				window.setModal(true);
				
				TextButton resumeButton = new TextButton("Lanjutkan main", skin);
		        resumeButton.addListener( new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						currentScene.dispose();
						currentScene = prevScene;
						prevScene = null;
						gameState = GameState.PLAY;
					}
		        });
		        window.row();
		        window.add(resumeButton).expand();
		        
		        TextButton menuButton = new TextButton("Ke Main Menu", skin);
		        menuButton.addListener( new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						dispose();
						startScreen(SCREEN_MENU, null);
					}
		        });
		        window.row();
		        window.add(menuButton).expand();
		        float xPos = stage.getWidth() / 2 - window.getWidth() / 2;
		        float yPos = stage.getHeight() / 2 - window.getHeight() / 2;
				window.setPosition(xPos, yPos);
		        window.toFront();
		        addActor(new ModalActor());
		        addActor(window);
			}
		};
		//scene.toFront();
		return scene;
	}

	public void startScene(Scene nextScene) {
		this.nextScene = nextScene;
	}

	protected RunnableAction getStartSceneAction(Scene scene) {
		if (startSceneRunnable == null)
			startSceneRunnable = new StartSceneRunnable();
		
		startSceneRunnable.scene = scene;
		return run(startSceneRunnable);
	}

	final TextureAtlas getTextureAtlas() {
		return textureAtlas;
	}

	final ResourceBundle getLang() {
		return lang;
	}
}

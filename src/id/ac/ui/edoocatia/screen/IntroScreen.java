package id.ac.ui.edoocatia.screen;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.screen.intro.CharacterScene;
import id.ac.ui.edoocatia.screen.intro.IntroScene;
import id.ac.ui.edoocatia.screen.intro.Scene1;
import id.ac.ui.edoocatia.screen.intro.Scene2;
import id.ac.ui.edoocatia.screen.intro.Scene3;
import id.ac.ui.edoocatia.screen.intro.Scene4;
import id.ac.ui.edoocatia.screen.intro.Scene5;
import id.ac.ui.edoocatia.screen.intro.Scene6;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.matsemann.libgdxloadingscreen.screen.ModuleLoadingScreen;

public class IntroScreen extends AbstractScreen {

	private Texture splashTexture;
	private AssetManager manager;
	
	public IntroScreen() {
		super(EdoocatiaGame.INTRO);
		manager = new AssetManager();
	}

	public IntroScreen(AssetManager asset) {
		this();
		manager = asset;
	}

	@Override
    public void show()
    {
        super.show();
        // load the texture with the splash image
        splashTexture = new Texture("button/skip.png");
        // set the linear texture filter to improve the image stretching
        splashTexture.setFilter(TextureFilter.Linear,TextureFilter.Linear);
    }

    @Override
    public void resize(final int width, final int height)
    {
        super.resize(width,height);
        Action act;
        // let's make sure the stage is clear
        stage.clear();
        
      //skip
        TextureRegion splashRegion = new TextureRegion(splashTexture, 0, 0, 128, 30);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        final Image skipButton = new Image(textureDraw, Scaling.fill, Align.center);
        
        skipButton.setWidth(width / 6);
        skipButton.setHeight(height / 12);
        skipButton.setPosition(width * 5 / 6, 0);
        skipButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				disposeScreen = true;
				startScreen(SCREEN_CUSTOM, new ModuleLoadingScreen());
				//super.clicked(event, x, y);
			}
        });
        
        IntroScene scn7 = new CharacterScene(manager);
        scn7.setLastAction(new Action() {
			@Override
			public boolean act(float delta) {
				disposeScreen = true;
				startScreen(SCREEN_CUSTOM, new ModuleLoadingScreen());
				return true;
			}
		});
        final Group gr7 = scn7.build(width, height);
        
        act = new Action() {
			@Override
			public boolean act(float delta) {
				stage.addActor(gr7);
				stage.addActor(skipButton);
				getActor().getParent().remove();
				return true;
			}
        };
        
        IntroScene scn6 = new Scene6(manager);
        scn6.setLastAction(act);
        final Group gr6 = scn6.build(width, height);
        
        act = new Action() {
			@Override
			public boolean act(float delta) {
				stage.addActor(gr6);
				stage.addActor(skipButton);
				getActor().getParent().remove();
				return true;
			}
        };
        
        IntroScene scn5 = new Scene5(manager);
        scn5.setLastAction(act);
        final Group gr5 = scn5.build(width, height);
        
        act = new Action() {
			@Override
			public boolean act(float delta) {
				stage.addActor(gr5);
				stage.addActor(skipButton);
				getActor().getParent().remove();
				return true;
			}
        };
        
        IntroScene scn4 = new Scene4(manager);
        scn4.setLastAction(act);
        final Group gr4 = scn4.build(width, height);
        
        act = new Action() {
			@Override
			public boolean act(float delta) {
				stage.addActor(gr4);
				stage.addActor(skipButton);
				getActor().getParent().remove();
				return true;
			}
        };
        
        IntroScene scn3 = new Scene3(manager);
        scn3.setLastAction(act);
        final Group gr3 = scn3.build(width, height);
        
        act = new Action() {
			@Override
			public boolean act(float delta) {
				stage.addActor(gr3);
				stage.addActor(skipButton);
				getActor().getParent().remove();
				return true;
			}
        };
        
        IntroScene scn2 = new Scene2(manager);
        scn2.setLastAction(act);
        final Group gr2 = scn2.build(width, height);
        
        act = new Action() {
			@Override
			public boolean act(float delta) {
				stage.addActor(gr2);
				stage.addActor(skipButton);
				getActor().getParent().remove();
				return true;
			}
        };
        
        IntroScene scn1 = new Scene1(manager);
        scn1.setLastAction(act);
        
        stage.addActor(scn1.build(width, height));
        
        stage.addActor(skipButton);
    }

    @Override
    public void dispose()
    {
        super.dispose();
        splashTexture.dispose();
    }
}

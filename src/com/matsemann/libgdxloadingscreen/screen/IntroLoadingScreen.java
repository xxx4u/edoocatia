package com.matsemann.libgdxloadingscreen.screen;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.screen.IntroScreen;
import id.ac.ui.edoocatia.screen.intro.IntroScene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.matsemann.libgdxloadingscreen.LoadingBar;

/**
 * @author Mats Svensson
 */
public class IntroLoadingScreen extends AbstractScreen {

    private Stage stage;

    private Image logo;
    private Image loadingFrame;
    private Image loadingBarHidden;
    private Image screenBg;
    private Image loadingBg;

    private float startX, endX;
    private float percent;

    private Actor loadingBar;

    public IntroLoadingScreen() {
        super(EdoocatiaGame.MODULE1);
    }

    @Override
    public void show() {
        // Tell the manager to load assets for the loading screen
        asset.load("data/loading.pack", TextureAtlas.class);
        // Wait until they are finished loading
        asset.finishLoading();

        // Initialize the stage where we will place everything
        stage = new Stage();

        // Get our textureatlas from the manager
        TextureAtlas atlas = asset.get("data/loading.pack", TextureAtlas.class);

        // Grab the regions from the atlas and create some images
        logo = new Image(atlas.findRegion("edoocatia-logo"));
        loadingFrame = new Image(atlas.findRegion("loading-frame"));
        loadingBarHidden = new Image(atlas.findRegion("loading-bar-hidden"));
        screenBg = new Image(atlas.findRegion("screen-bg"));
        loadingBg = new Image(atlas.findRegion("loading-frame-bg"));

        // Add the loading bar animation
        Animation anim = new Animation(0.05f, atlas.findRegions("loading-bar-anim") );
        anim.setPlayMode(Animation.LOOP_REVERSED);
        loadingBar = new LoadingBar(anim);

        // Or if you only need a static bar, you can do
        // loadingBar = new Image(atlas.findRegion("loading-bar1"));

        // Add all the actors to the stage
        stage.addActor(screenBg);
        stage.addActor(loadingBar);
        stage.addActor(loadingBg);
        stage.addActor(loadingBarHidden);
        stage.addActor(loadingFrame);
        stage.addActor(logo);

        // Add everything to be loaded, for instance:
        // game.manager.load("data/assets1.pack", TextureAtlas.class);
        // game.manager.load("data/assets2.pack", TextureAtlas.class);
        // game.manager.load("data/assets3.pack", TextureAtlas.class);
        asset.load(IntroScene.INTRO1, Texture.class);
        asset.load(IntroScene.INTRO2, Texture.class);
        asset.load(IntroScene.INTRO3, Texture.class);
        asset.load(IntroScene.INTRO4, Texture.class);
        asset.load(IntroScene.INTRO4B, Texture.class);
        asset.load(IntroScene.INTRO5, Texture.class);
        asset.load(IntroScene.INTRO5B, Texture.class);
        asset.load(IntroScene.INTRO_CHAR, Texture.class);
    }

    @Override
    public void resize(int width, int height) {
        // Set our screen to always be XXX x 480 in size
        width = 480 * width / height;
        height = 480;
        stage.setViewport(width , height, false);

        // Make the background fill the screen
        screenBg.setSize(width, height);

        // Place the logo in the middle of the screen and 100 px up
        logo.setX((width - logo.getWidth()) / 2);
        logo.setY((height - logo.getHeight()) / 2 + 50);

        // Place the loading frame in the middle of the screen -200
        loadingFrame.setX((stage.getWidth() - loadingFrame.getWidth()) / 2);
        loadingFrame.setY((stage.getHeight() - loadingFrame.getHeight()) / 2 - 100);

        // Place the loading bar at the same spot as the frame, adjusted a few px
        loadingBar.setX(loadingFrame.getX() + 15);
        loadingBar.setY(loadingFrame.getY() + 5);

        // Place the image that will hide the bar on top of the bar, adjusted a few px
        loadingBarHidden.setX(loadingBar.getX() + 35);
        loadingBarHidden.setY(loadingBar.getY() - 3);
        // The start position and how far to move the hidden loading bar
        startX = loadingBarHidden.getX();
        endX = 440;

        // The rest of the hidden bar
        loadingBg.setSize(450, 50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 3);
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // Interpolate the percentage to make it more smooth
        percent = Interpolation.linear.apply(percent, asset.getProgress(), 0.1f);

        // Update positions (and size) to match the percentage
        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setWidth(450 - 450 * percent);
        loadingBg.invalidate();

        // Show the loading screen
        stage.act();
        stage.draw();
        
        if (asset.update()) {
        	disposeScreen = true;
            startScreen(SCREEN_CUSTOM, new IntroScreen(asset));
        }
    }

    @Override
    public void hide() {
        // Dispose the loading assets as we no longer need them
    	asset.unload("data/loading.pack");
    }
}

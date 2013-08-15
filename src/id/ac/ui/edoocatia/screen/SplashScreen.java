package id.ac.ui.edoocatia.screen;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.util.Log;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

/**
 * Shows a splash image and moves on to the next screen.
 */
public class SplashScreen extends AbstractScreen
{
    private Texture splashTexture;
    Image splashImage;
    private boolean lastAct = false;

    public SplashScreen()
    {
        super(EdoocatiaGame.MODULE1);
    }

    @Override
    public void show()
    {
        super.show();

        // load the texture with the splash image
        splashTexture = new Texture("img/splash.png");

        // set the linear texture filter to improve the image stretching
        splashTexture.setFilter(TextureFilter.Linear,TextureFilter.Linear);
        
        asset.load("img/menu.pack", TextureAtlas.class);
        asset.load("sound/touch.mp3", Sound.class);
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize( width, height );

        // let's make sure the stage is clear
        stage.clear();

        // in the image atlas, our splash image begins at (0,0) of the
        // upper-left corner and has a dimension of 512x301
        TextureRegion splashRegion = new TextureRegion(splashTexture, 0, 0, 512, 360);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        // here we create the splash image actor and set its size
        splashImage = new Image( textureDraw, Scaling.fill, Align.center);
        
        splashImage.setWidth(width);
        splashImage.setHeight(height);

        // this is needed for the fade-in effect to work correctly; we're just
        // making the image completely transparent
        splashImage.getColor().a = 0f;

        // configure the fade-in/out effect on the splash image
        SequenceAction actions = Actions.sequence(Actions.fadeIn(1.0f), Actions.delay(1.0f, Actions.fadeOut(1.0f)));
        actions.addAction(new Action() {
			@Override
			public boolean act(float delta) {
				lastAct = true;
				return true;
			}
        });
        splashImage.addAction(actions);

        // and finally we add the actors to the stage, on the correct order
        stage.addActor(splashImage);
    }

    @Override
    public void dispose()
    {
        super.dispose();
        splashTexture.dispose();
    }

	@Override
	public void render(float delta) {
		super.render(delta);
		if (asset.update() && lastAct) {
			Log.d("asset updated: " + asset);
			startScreen(SCREEN_MENU, null);
		}
	}
}
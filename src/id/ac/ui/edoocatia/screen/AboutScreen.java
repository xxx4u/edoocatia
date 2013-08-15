package id.ac.ui.edoocatia.screen;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class AboutScreen extends AbstractScreen {

	private Texture splashTexture;
	
	public AboutScreen() {
		super(EdoocatiaGame.JELAJAH);
		/*stage = new Stage() {
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Keys.BACK || keyCode == Keys.ESCAPE) {
					pause();
					return true;
				}
				return super.keyDown(keyCode);
			}
		};*/
	}

	@Override
    public void show()
    {
        super.show();

        // load the texture with the splash image
        splashTexture = new Texture("img/aboutus.png");

        // set the linear texture filter to improve the image stretching
        splashTexture.setFilter(TextureFilter.Linear,TextureFilter.Linear);
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize( width, height );
        Log.d("AboutScreen resize");
        // let's make sure the stage is clear
        stage.clear();

        // in the image atlas, our splash image begins at (0,0) of the
        // upper-left corner and has a dimension of 512x301
        TextureRegion splashRegion = new TextureRegion(splashTexture, 0, 0, 512, 360);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        // here we create the splash image actor and set its size
        Image aboutImage = new Image(textureDraw, Scaling.fill, Align.center);
        
        aboutImage.setWidth(width);
        aboutImage.setHeight(height);

        // this is needed for the fade-in effect to work correctly; we're just
        // making the image completely transparent
        aboutImage.getColor().a = 0f;

        // configure the fade-in effect on the splash image
        aboutImage.addAction(Actions.fadeIn(1.0f));

        // and finally we add the actors to the stage, on the correct order
        stage.addActor(aboutImage);
        
        TextButton linkButton = new TextButton("Know More >", skin );
        linkButton.setPosition(width * 7 / 12, height / 12);
        /*linkButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				FetchUrl fetch = EdoocatiaGame.actionResolver.getFetcher();
				fetch.openURL("http://project.yahya.mn/edoocatia");
			}
        });*/
        linkButton.addAction(Actions.sequence(
        		Actions.hide(), Actions.delay(1.0f), Actions.show()));
        stage.addActor(linkButton);
    }
    
    @Override
	public void render(float delta) {
		super.render(delta);
		if(Gdx.input.isKeyPressed(Keys.ESCAPE) || Gdx.input.isKeyPressed(Keys.BACK))
			pause();
	}

	@Override
	public void pause() {
		super.pause();
		startScreen(SCREEN_CUSTOM, new MenuScreen());
	}

    @Override
    public void dispose()
    {
        super.dispose();
        splashTexture.dispose();
    }

}

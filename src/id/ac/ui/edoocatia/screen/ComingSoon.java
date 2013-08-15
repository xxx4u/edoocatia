package id.ac.ui.edoocatia.screen;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class ComingSoon extends AbstractScreen {

	public ComingSoon() {
		super(EdoocatiaGame.INTRO);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

		stage.clear();
		Texture texture = asset.get("img/coming.png", Texture.class);
		TextureRegion bgRegion = new TextureRegion(texture, 0, 0, 512, 360);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(bgRegion);
        // here we create the splash image actor and set its size
        Image bg = new Image(textureDraw, Scaling.fill, Align.center);
        bg.setHeight(height);
        bg.setWidth(width);
        stage.addActor(bg);
		
		TextButton button = new TextButton("Ke Menu Utama", skin);
		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				startScreen(SCREEN_MENU, null);
			}
		});
		button.setPosition(width/ 10, height / 10);
		stage.addActor(button);
	}

	@Override
	public void show() {
		super.show();
		asset.load("img/coming.png", Texture.class);
		asset.finishLoading();
	}
}

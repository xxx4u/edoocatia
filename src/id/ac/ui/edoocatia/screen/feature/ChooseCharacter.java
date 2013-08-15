package id.ac.ui.edoocatia.screen.feature;

import id.ac.ui.edoocatia.AbstractScreen;
import id.ac.ui.edoocatia.EdoocatiaGame;
import id.ac.ui.edoocatia.screen.ComingSoon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class ChooseCharacter extends AbstractScreen {

	private TextureAtlas atlas;
	private AtlasRegion region;
	
	public ChooseCharacter() {
		super(EdoocatiaGame.MODULE1);
		//asset = manager;
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stage.clear();
		//momo
		region = atlas.findRegion("momo-bg");
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(region);
		Image bg = new Image(textureDraw, Scaling.fill, Align.center);
		bg.setWidth(height/2);
		bg.setHeight(width/2);
		bg.setPosition(bg.getHeight(), 0);
		bg.rotate(90f);
		stage.addActor(bg);
		
		region = atlas.findRegion("momo-show");
        textureDraw = new TextureRegionDrawable(region);
		Image momo = new Image(textureDraw, Scaling.fill, Align.center);
		momo.setWidth(width/4);
		momo.setHeight(height/2);
		momo.setPosition(20, 0);
		stage.addActor(momo);
		
		//alta
		atlas = asset.get("char/alta.atlas", TextureAtlas.class);
		region = atlas.findRegion("alta-bg");
        textureDraw = new TextureRegionDrawable(region);
		bg = new Image(textureDraw, Scaling.fill, Align.center);
		bg.setWidth(width/2);
		bg.setHeight(height/2);
		bg.setPosition(0, bg.getHeight());
		stage.addActor(bg);
		
		region = atlas.findRegion("alta-show");
        textureDraw = new TextureRegionDrawable(region);
		Image alta = new Image(textureDraw, Scaling.fill, Align.center);
		alta.setWidth(width/4);
		alta.setHeight(height/2);
		alta.setPosition(20, height / 2);
		stage.addActor(alta);
		
		//azmo
		atlas = asset.get("char/azmo.atlas", TextureAtlas.class);
		region = atlas.findRegion("azmo-bg");
        textureDraw = new TextureRegionDrawable(region);
		bg = new Image(textureDraw, Scaling.fill, Align.center);
		bg.setWidth(width/2);
		bg.setHeight(height/2);
		bg.setPosition(bg.getWidth(), bg.getHeight());
		stage.addActor(bg);
		
		region = atlas.findRegion("azmo-show");
        textureDraw = new TextureRegionDrawable(region);
		Image azmo = new Image(textureDraw, Scaling.fill, Align.center);
		azmo.setWidth(width/4);
		azmo.setHeight(height/2);
		azmo.setPosition(width / 2 + azmo.getWidth(), height / 2);
		stage.addActor(azmo);
		
		//azmo
		atlas = asset.get("char/tsarina.atlas", TextureAtlas.class);
		region = atlas.findRegion("tsarina-bg");
        textureDraw = new TextureRegionDrawable(region);
		bg = new Image(textureDraw, Scaling.fill, Align.center);
		bg.setWidth(width/2);
		bg.setHeight(height/2);
		bg.setPosition(bg.getWidth(), 0);
		stage.addActor(bg);
		
		region = atlas.findRegion("tsarina-show");
        textureDraw = new TextureRegionDrawable(region);
		Image tsarina = new Image(textureDraw, Scaling.fill, Align.center);
		tsarina.setWidth(width/4);
		tsarina.setHeight(height/2);
		tsarina.setPosition(width / 2 + tsarina.getWidth(), 0);
		stage.addActor(tsarina);
	}

	@Override
	public void show() {
		super.show();
		atlas = asset.get("char/momo.pack", TextureAtlas.class);
	}

	@Override
	public void render(float delta) {
		if(Gdx.input.isTouched()) {
			startScreen(SCREEN_CUSTOM, new ComingSoon());
			if (profile.isSoundEnable()) {
	        	Sound snd = asset.get("sound/transisi2.mp3", Sound.class);
	        	snd.play();
        	}
		}
		super.render(delta);
	}
}

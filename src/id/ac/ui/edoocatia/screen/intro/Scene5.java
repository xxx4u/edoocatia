package id.ac.ui.edoocatia.screen.intro;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Scene5 extends IntroScene {
	
	public Scene5(AssetManager mgr) {
		super(mgr);
		updateTexture(INTRO5);
	}

	@Override
	public Group build(int width, int height) {
        TextureRegion splashRegion = new TextureRegion(texture, 0, 0, 512, 384);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        final Image first = new Image( textureDraw, Scaling.fill, Align.center);
        first.setHeight(height);
        first.setWidth(width);
        
        splashRegion = new TextureRegion(texture, 513, 0, 512, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image second = new Image(textureDraw, Scaling.fill, Align.center);
        second.setHeight(height);
        second.setWidth(width);
        
        updateTexture(INTRO5B);
        splashRegion = new TextureRegion(texture, 0, 0, 512, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image fourth = new Image( textureDraw, Scaling.fill, Align.center);
        fourth.setHeight(height);
        fourth.setWidth(width);
        
        updateTexture(INTRO1);
        splashRegion = new TextureRegion(texture, 513, 0, 512, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image third = new Image(textureDraw, Scaling.fill, Align.center);
        third.setHeight(height);
        third.setWidth(width);
        
        Action actions = Actions.sequence(Actions.delay(2),Actions.fadeOut(2));
        first.addAction(actions);
        
        actions = Actions.sequence(Actions.delay(2),Actions.fadeIn(2));
        second.addAction(actions);
        second.addAction(Actions.after(Actions.delay(2, new Action() {
			@Override
			public boolean act(float delta) {
				group.addActor(fourth);
				group.addActor(third);
				return true;
			}
		})));
        
        actions = Actions.sequence(Actions.delay(2),Actions.fadeOut(2));
        third.addAction(actions);
        
        actions = Actions.sequence(Actions.delay(2),Actions.fadeIn(2));
        fourth.addAction(actions);
        fourth.addAction(Actions.after(Actions.delay(2, lastAction)));
                
        group.addActor(second);
        group.addActor(first);
		return group;
	}

}

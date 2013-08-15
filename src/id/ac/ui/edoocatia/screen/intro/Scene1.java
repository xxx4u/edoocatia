package id.ac.ui.edoocatia.screen.intro;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Scene1 extends IntroScene {
	
	public Scene1(AssetManager mgr) {
		super(mgr);
		updateTexture(INTRO1);
	}

	@Override
	public Group build(int width, int height) {
		TextureRegion splashRegion = new TextureRegion(texture, 0, 0, 512, 341);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        // here we create the splash image actor and set its size
        final Image first = new Image(textureDraw, Scaling.fill, Align.center);
        first.setHeight(height);
        first.setWidth(width);
        
        splashRegion = new TextureRegion(texture, 512, 0, 512, 341);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image second = new Image( textureDraw, Scaling.fill, Align.center);
        second.setHeight(height);
        second.setWidth(width);
        
        updateTexture(INTRO5);
        splashRegion = new TextureRegion(texture, 0, 0, 512, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image third = new Image( textureDraw, Scaling.fill, Align.center);
        third.setHeight(height);
        third.setWidth(width);
        
        Action actions = Actions.sequence(Actions.delay(3f,Actions.parallel(
        		Actions.scaleBy(2, 2, 5f),Actions.moveBy(-width/2, -height/2, 5f))),
        		Actions.fadeOut(2f, Interpolation.circleIn),
        		Actions.after(new Action() {
        			@Override
        			public boolean act(float delta) {
        				group.addActor(second);
        				return true;
        			}
        		}));
        first.addAction(actions);
        
        actions = Actions.sequence(Actions.fadeIn(1f, Interpolation.circleOut),
        		Actions.delay(2f,Actions.parallel(Actions.scaleBy(2, 2, 5f),Actions.moveBy(-width,-height,5f))),
        		Actions.fadeOut(2f, Interpolation.circleIn),
        		Actions.after(new Action() {
        			@Override
        			public boolean act(float delta) {
        				group.addActor(third);
        				return true;
        			}
        		}));
        second.addAction(actions);
        
        actions = Actions.sequence(Actions.fadeIn(1f, Interpolation.circleOut),
        		Actions.delay(2f),
        		Actions.after(lastAction));
        third.addAction(actions);
        
        group.addActor(first);
		return group;
	}

}

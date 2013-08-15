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

public class Scene3 extends IntroScene {
	
	public Scene3(AssetManager mgr) {
		super(mgr);
		updateTexture(INTRO3);
	}

	@Override
	public Group build(int width, int height) {
        TextureRegion splashRegion = new TextureRegion(texture, 0, 0, 512, 384);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        final Image first = new Image( textureDraw, Scaling.fill, Align.center);
        first.setHeight(height);
        first.setWidth(width);
        first.setPosition(width, 0);
        
        splashRegion = new TextureRegion(texture, 513, 0, 321, 431);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image alien = new Image(textureDraw, Scaling.fill, Align.center);
        alien.setHeight(height);
        alien.setPosition(width/2, -height / 3);
        
        Action actions = Actions.sequence(Actions.moveTo(0, 0, 2f),
        		Actions.delay(2f),
        		Actions.after(new Action() {
        			@Override
        			public boolean act(float delta) {
        				group.addActor(alien);
        				return true;
        			}
        		}));
        first.addAction(actions);
        
        actions = Actions.sequence(Actions.fadeIn(2f),Actions.parallel(
        		Actions.scaleTo((float)0.25, (float)0.25, 4f), Actions.moveTo(width/4, height/8, 4f)),
        		lastAction);
        alien.addAction(actions);
                
        group.addActor(first);
		return group;
	}

}

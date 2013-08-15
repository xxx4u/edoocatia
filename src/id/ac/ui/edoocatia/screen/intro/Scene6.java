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

public class Scene6 extends IntroScene {
	
	public Scene6(AssetManager mgr) {
		super(mgr);
		updateTexture(INTRO4B);
	}

	@Override
	public Group build(int width, int height) {
        TextureRegion splashRegion = new TextureRegion(texture, 0, 0, 512, 384);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        final Image first = new Image( textureDraw, Scaling.fill, Align.center);
        first.setHeight(height);
        first.setWidth(width);
        
        splashRegion = new TextureRegion(texture, 513, 0, 241, 328);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image prof = new Image(textureDraw, Scaling.fit, Align.center);
        prof.setWidth(width/2);
        prof.setPosition(width/4, -height);
        
        Action actions = Actions.sequence(Actions.delay(1), Actions.moveBy(0, height * 4 / 5 , 2),
        		Actions.delay(2, lastAction));
        prof.addAction(actions);
        
        group.addActor(first);
        group.addActor(prof);
		return group;
	}

}

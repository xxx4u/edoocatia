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

public class Scene4 extends IntroScene {
	
	public Scene4(AssetManager mgr) {
		super(mgr);
		updateTexture(INTRO4);
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
        final Image redMon = new Image(textureDraw, Scaling.fill, Align.center);
        redMon.setHeight(height);
        redMon.setWidth(width);
        
        updateTexture(INTRO4B);
        splashRegion = new TextureRegion(texture, 755, 0, 255, 328);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image prof = new Image(textureDraw, Scaling.fit, Align.center);
        prof.setHeight(height);
        prof.setPosition(width/5, -height);
        
        Action actions = Actions.forever(Actions.sequence(
        		Actions.delay(1, Actions.hide()), Actions.delay(1, Actions.show())));
        redMon.addAction(actions);
        
        actions = Actions.sequence(Actions.delay(3), Actions.moveBy(0, height * 4 / 5 , 1),
        		Actions.delay(3, lastAction));
        prof.addAction(actions);
                
        group.addActor(first);
        group.addActor(redMon);
        group.addActor(prof);
		return group;
	}

}

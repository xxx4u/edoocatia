package id.ac.ui.edoocatia.screen.intro;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class CharacterScene extends IntroScene {
	
	public CharacterScene(AssetManager mgr) {
		super(mgr);
        updateTexture(INTRO_CHAR);
    }

    public Group build(int width, int height) {
        // in the image atlas, our splash image begins at (0,0) of the
        // upper-left corner and has a dimension of 512x301
        TextureRegion splashRegion = new TextureRegion(texture, 0, 0, 128, 384);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        // here we create the splash image actor and set its size
        final Image first = new Image( textureDraw, Scaling.fit, Align.center);
        first.setHeight(height);
        first.setPosition(-first.getWidth(), 0);
        
        splashRegion = new TextureRegion(texture, 130, 0, 128, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image second = new Image( textureDraw, Scaling.fit, Align.center);
        second.setHeight(height);
        second.setPosition(width/4, -height);
        
        splashRegion = new TextureRegion(texture, 261, 0, 122, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        Image third = new Image( textureDraw, Scaling.fit, Align.center);
        third.setHeight(height);
        third.setPosition(width/2, height);
        
        splashRegion = new TextureRegion(texture, 385, 0, 127, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image fourth = new Image( textureDraw, Scaling.fit, Align.center);
        fourth.setHeight(height);
        fourth.setPosition(width, 0);
        		
        SequenceAction actions = Actions.sequence(
        		Actions.moveBy(0, -height, 0.5f),
        		Actions.delay(2.5f),
        		Actions.sequence(Actions.scaleTo((float)1.5, (float)1.5, 0.5f), Actions.scaleTo(1, 1, 0.5f)));
        third.addAction(actions);
        
        actions = Actions.sequence(
        		Actions.delay(0.5f),Actions.moveBy(0, height, 0.5f),
        		Actions.delay(1.5f),
        		Actions.sequence(Actions.scaleTo((float)1.5, (float)1.5, 0.5f), Actions.scaleTo(1, 1, 0.5f)));
        second.addAction(actions);
        
        actions = Actions.sequence(Actions.delay(1f),
        		Actions.moveBy(first.getWidth(), 0, 0.5f),
        		Actions.delay(0.5f),
        		Actions.sequence(Actions.scaleTo((float)1.5, (float)1.5, 0.5f), Actions.scaleTo(1, 1, 0.5f)));
        first.addAction(actions);
        
        actions = Actions.sequence(
        		Actions.delay(1.5f),
        		Actions.moveBy(-fourth.getWidth(), 0, 0.5f),
        		Actions.delay(3f),
        		Actions.sequence(Actions.scaleTo((float)1.5, (float)1.5, 0.5f), Actions.scaleTo(1, 1, 0.5f)));
        fourth.addAction(actions);
        fourth.addAction(Actions.after(lastAction));
        
        group.addActor(fourth);
        group.addActor(third);
        group.addActor(second);
        group.addActor(first);
        
        return group;
    }    
}

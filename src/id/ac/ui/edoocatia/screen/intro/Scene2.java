package id.ac.ui.edoocatia.screen.intro;

import id.ac.ui.edoocatia.util.Log;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Scene2 extends IntroScene {
	
	public Scene2(AssetManager mgr) {
		super(mgr);
		updateTexture(INTRO2);
	}

	@Override
	public Group build(int width, int height) {
        TextureRegion splashRegion = new TextureRegion(texture, 0, 0, 512, 384);
        TextureRegionDrawable textureDraw = new TextureRegionDrawable(splashRegion);
        final Image firstA = new Image( textureDraw, Scaling.fill, Align.center);
        firstA.setHeight(height);
        firstA.setWidth(width);
        firstA.setPosition(0, height);
        
        splashRegion = new TextureRegion(texture, 512, 0, 512, 384);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image firstB = new Image( textureDraw, Scaling.fill, Align.center);
        firstB.setHeight(height);
        firstB.setWidth(width);
        
        splashRegion = new TextureRegion(texture, 0, 384, 68, 74);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image rock = new Image(textureDraw, Scaling.fit, Align.center);
        rock.setHeight(height/5);
        rock.setPosition(-rock.getWidth(), height/4);
        
        splashRegion = new TextureRegion(texture, 68, 385, 188, 128);
        textureDraw = new TextureRegionDrawable(splashRegion);
        final Image alien = new Image(textureDraw, Scaling.fill, Align.center);
        alien.setHeight(height/2);
        alien.setPosition(width/2, 0);
        
        Action actions = Actions.sequence(Actions.moveTo(0, 0, 2f),
        		Actions.delay(2f),
        		Actions.after(new Action() {
        			@Override
        			public boolean act(float delta) {
        				group.addActor(alien);
        				return true;
        			}
        		}));
        firstA.addAction(actions);
        
        actions = Actions.sequence(Actions.fadeIn(2f),Actions.parallel(
        		Actions.forever(Actions.sequence(Actions.alpha(100, 150f),Actions.alpha(50, 150f))),
        		Actions.sequence(Actions.delay(3f),
        				new Action() {
        					@Override
        					public boolean act(float delta) {
        						group.addActor(rock);
        						return true;
        					}
        			})));
        alien.addAction(actions);
        
        actions = Actions.sequence(Actions.moveTo(width * 2 /5, height * 2 /5, 1f),
        		new Action() {
        			@Override
        			public boolean act(float delta) {
        				group.addActorAfter(firstA, firstB);
        				//group.removeActor(firstA);
        				Action ra = null;
        				for (Action ac : alien.getActions()) {
        					if (ac instanceof RepeatAction) {
        						ra = ac;
        						break;
        					}
        				}
        				if (ra != null)
        					alien.removeAction(ra);
        				Log.d("Harusnya fadeout dulu.");
        				alien.addAction(Actions.fadeOut(2f));
        				return true;
        			}
        		}, Actions.sequence(Actions.delay(2f),lastAction));
        rock.addAction(actions);
        
        group.addActor(firstA);
		return group;
	}

}

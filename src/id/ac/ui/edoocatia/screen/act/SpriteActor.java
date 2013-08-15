package id.ac.ui.edoocatia.screen.act;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

/**
 * An actor which is similar to a sprite.
 * 
 * @author Fikrul
 *
 */
public class SpriteActor extends Actor {

	private TextureRegion region;
	private Animation animation;
	private float animationTime = 0f;
	
	// CONSTRUCTORS
	
	public SpriteActor(TextureRegion region) {
		this.region = region;
		setSize(region.getRegionWidth(), region.getRegionHeight());
	}
	
	public SpriteActor(float frameDuration, int playMode, TextureRegion... regions) {
		this.animation = new Animation(frameDuration, regions);
		this.animation.setPlayMode(playMode);
		this.region = animation.getKeyFrame(0f);
		
		setSize(region.getRegionWidth(), region.getRegionHeight());
	}
	
	public SpriteActor(float frameDuration, int playMode, Array<? extends TextureRegion> regions) {
		this.animation = new Animation(frameDuration, regions);
		this.animation.setPlayMode(playMode);
		this.region = animation.getKeyFrame(0f);
		
		setSize(region.getRegionWidth(), region.getRegionHeight());
	}
	
	// METHODS

	@Override
	public void act(float delta) {
		super.act(delta);
		
		if (animation != null) {
			animationTime += delta;
			region = animation.getKeyFrame(animationTime);
		}
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		Color batchColor = batch.getColor();

		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		batch.draw(this.region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
				getScaleX(), getScaleY(), getRotation());
		
		batch.setColor(batchColor);
	}
}

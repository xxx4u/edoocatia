package id.ac.ui.edoocatia.screen.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MenuButton extends Actor {
	private TextureRegion clicked;
	private TextureRegion normal;
	public boolean isNormal;
	
	public MenuButton(TextureRegion normal, TextureRegion click) {
		this.normal = normal;
		this.clicked = click;
		isNormal = true;
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		if (isNormal)
			batch.draw(normal, getX(), getY(), getWidth(), getHeight());
		else
			batch.draw(clicked, getX(), getY(), getWidth(), getHeight());
		//super.draw(batch, parentAlpha);
	}
}

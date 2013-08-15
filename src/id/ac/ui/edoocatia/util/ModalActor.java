package id.ac.ui.edoocatia.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ModalActor extends Actor {

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		ShapeRenderer render = new ShapeRenderer();
		render.begin(ShapeType.FilledRectangle);
		Color col = new Color(Color.DARK_GRAY);
		col.a = 10;
		render.setColor(col);
		render.filledRect(0, 0, getWidth(), getHeight());
		render.end();
	}

	@Override
	public float getWidth() {
		return getStage().getWidth();
	}

	@Override
	public float getHeight() {
		return getStage().getHeight();
	}
}

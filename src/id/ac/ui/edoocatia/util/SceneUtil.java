package id.ac.ui.edoocatia.util;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Utility used for scene2d-based game (e.g. actor positioning).
 * 
 * @author Fikrul
 *
 */
public abstract class SceneUtil {

	public static final void addActorAligned(Group parent, Actor actor, float x, float y) {
		actor.setPosition((parent.getWidth() - actor.getWidth()) * x,
				(parent.getHeight() - actor.getHeight()) * y);
		parent.addActor(actor);
	}

	public static void addActorsDistributed(Group parent, float x1, float y1,
			final float x2, final float y2, Actor... actors) {
		if (actors.length > 1) {
			float stepX = (x2 - x1) / (actors.length - 1);
			float stepY = (y2 - y1) / (actors.length - 1);
			for (int i = 0; i < actors.length; ++i) {
				addActorAligned(parent, actors[i], x1, y1);
				x1 += stepX;
				y1 += stepY;
			}
		} else if (actors.length == 1) {
			addActorAligned(parent, actors[0], (x2 - x1) / 2, (y2 - y1) / 2);
		}
	}
	
	public static final void align(Actor actor, float x, float y) {
		Group parent = actor.getParent();
		actor.setPosition((parent.getWidth() - actor.getWidth()) * x,
				(parent.getHeight() - actor.getHeight()) * y);
	}

	public static void align(Actor actor, float x, float y, Actor ref, float refX,
			float refY) {
		float absRefX = ref.getX() + refX * ref.getWidth();
		float absRefY = ref.getY() + refY * ref.getHeight();
		actor.setPosition(absRefX - x * actor.getWidth(), absRefY - y * actor.getHeight());
	}

	public static void clearAllActions(Actor actor) {
		actor.clearActions();
		
		if (actor instanceof Group) {
			for (Actor child : ((Group) actor).getChildren())
				clearAllActions(child);
		}
	}
}

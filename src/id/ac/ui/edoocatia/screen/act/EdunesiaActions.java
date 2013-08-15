package id.ac.ui.edoocatia.screen.act;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Actions collection.
 * 
 * @author Fikrul
 *
 */
public abstract class EdunesiaActions extends Actions {

	public static TickerAction ticker(CharSequence text, float avgDuration) {
		TickerAction action = action(TickerAction.class);
		action.setText(text);
		action.setDuration(avgDuration * text.length());
		return action;
	}
}

package id.ac.ui.edoocatia.screen.act;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * A ticker text used commonly in all Edunesia's screen.
 * 
 * @author Fikrul
 *
 */
public class TickerText extends Table {
	
	private final Label label;
	private final Button button;
	
	private boolean userFinished;
	
	private Action waitUserAction = new Action() {

		@Override
		public boolean act(float delta) {
			return userFinished;
		}
		
	};

	public TickerText(Skin skin) {
		
		label = new Label("", skin);
		label.setWrap(true);
		
		button = new TextButton(">>", skin);
		button.addListener(new InputListener() {
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				userFinished = true;
				return true;
			}
		});
		
		this.bottom();
		this.add(label).expandX().fill();
		this.add(button).bottom();
		
//		this.debug();
	}
	
	/**
	 * Start the ticker text.
	 * @param text text to type (tick)
	 * @param completeAction action should be triggered after ticker finished; can be <code>null</code>
	 * @param waitUser whether waiting for player action (e.g. pressing button) to continue (finish)
	 */
	public void startText(CharSequence text, Action completeAction, boolean waitUser) {
		label.clearActions();
		
		SequenceAction action = sequence(EdunesiaActions.ticker(text, 0.03f));
		if (waitUser) {
			action.addAction(waitUserAction);
		}
		if (completeAction != null)
			action.addAction(completeAction);
		label.addAction(action);
		
		userFinished = !waitUser;
	}
	
	/**
	 * Whether ticker has finished or not, and player has confirmed (if
	 * <code>waitUser</code> specified when calling
	 * {@link #startText(CharSequence, Action, boolean)}).
	 * @return boolean
	 */
	public final boolean isFinished() {
		return userFinished && label.getActions().size == 0;
	}

}

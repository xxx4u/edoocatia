package id.ac.ui.edoocatia.screen.act;

import com.badlogic.gdx.scenes.scene2d.actions.IntAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Action that manipulates a {@link Label} so that it behaves like a ticker text.
 * <p>
 * Caution: using actor other than label may cause {@link ClassCastException}.
 * 
 * @author Fikrul
 *
 */
public class TickerAction extends IntAction {

	private CharSequence text;
	
	@Override
	protected void begin() {
		super.setStart(0);
		super.setEnd(text.length());
		super.begin();
	}
	
	@Override
	protected void update(float percent) {
		int oldLen = getValue();
		super.update(percent);
		
		if (getValue() != oldLen) {
			getLabel().setText(text.subSequence(0, getValue()));
			getLabel().invalidateHierarchy();
		}
	}
	
	public final Label getLabel() {
		return (Label) getActor();
	}

	public final CharSequence getText() {
		return text;
	}

	public final void setText(CharSequence text) {
		this.text = text;
	}
}

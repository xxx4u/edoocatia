package id.ac.ui.edoocatia.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Player's profile model (POJO).
 * 
 * @author Fikrul
 *
 */
public class Profile implements Serializable {

	public enum GameCharacter {
		AZMO, ALTA, TSARINA, MOMO;
	}
	
	private static final long serialVersionUID = 1L;
	
	/** The score. */
	private int score;
	
	/** Preferred language. */
	private Locale preferredLanguage;
	
	private boolean soundEnable;
	private boolean musicEnable;
	private GameCharacter gameChar;

	/** Get the score. */
	public final int getScore() {
		return score;
	}

	/** Set the score. */
	public final void setScore(int score) {
		this.score = score;
	}
	
	/** Add score value to the current score. Use negative for substraction. */
	public final void addScore(int delta) {
		this.score += delta;
	}

	/** Get the preferred language. */
	public final Locale getPreferredLanguage() {
		return preferredLanguage;
	}

	/** Set the preferred language. */
	public final void setPreferredLanguage(Locale preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	
	@Override
	public String toString() {
		return String.format("{score: %s, preferredLanguage: %s}", score, preferredLanguage);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Profile))
			return false;
		
		Profile x = (Profile) o;
		return score == x.score && preferredLanguage.equals(x.preferredLanguage);
	}
	
	@Override
	public int hashCode() {
		return score * preferredLanguage.hashCode();
	}

	public boolean isSoundEnable() {
		return soundEnable;
	}

	public void setSoundEnable(boolean soundEnable) {
		this.soundEnable = soundEnable;
	}

	public boolean isMusicEnable() {
		return musicEnable;
	}

	public void setMusicEnable(boolean musicEnable) {
		this.musicEnable = musicEnable;
	}

	public GameCharacter getGameChar() {
		return gameChar;
	}

	public void setGameChar(GameCharacter gameChar) {
		this.gameChar = gameChar;
	}
}

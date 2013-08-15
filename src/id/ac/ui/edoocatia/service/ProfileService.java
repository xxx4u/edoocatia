package id.ac.ui.edoocatia.service;

import id.ac.ui.edoocatia.model.Languages;
import id.ac.ui.edoocatia.model.Profile;

/**
 * A global service providing access to player's profile.
 * 
 * @author Fikrul
 *
 */
public class ProfileService {

	private static ProfileService singleton;
	
	private Profile profile;
	
	private ProfileService() {
		profile = new Profile();
		
		// TODO benerin
		profile.setScore(0);
		profile.setPreferredLanguage(Languages.ID);
	}
	
	public static ProfileService get() {
		if (singleton == null)
			singleton = new ProfileService();
		return singleton;
	}

	public Profile getProfile() {
		return profile;
	}
}

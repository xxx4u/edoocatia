package id.ac.ui.edoocatia.feature;

import id.ac.ui.edoocatia.feature.user.Account;

import java.util.Hashtable;

public class UserTransaction extends Connector {

	protected final String URI = BASE_URL + "user/";
	protected final String LOGIN = URI + "login";
	protected final String PROFILE_GET = URI + "profile";
	protected final String PROFILE_CREATE = URI + "new_user";
	protected final String PROFILE_UPDATE = URI + "update";
	protected final String REGISTERED = URI + "registered";
	private final String KEY_USERNAME = "username";
	private final String KEY_USER_ID = "id";
	private final String KEY_FULLNAME = "fullname";
	private final String KEY_PASSWORD = "password";
	private final String KEY_BIRTHDAY = "birthday";
	private final String KEY_GENDER = "gender";
	
	private static UserTransaction utrans;
	
	public static UserTransaction getInstance() {
		if (utrans == null) {
			utrans = new UserTransaction();
		}
		return utrans;
	}
	
	public boolean login(String username, String password) {
		return false;
	}
	
	public String getProfile(String username) {
		params = new Hashtable<String, String>();
		params.put(KEY_USERNAME, username);
		String json = getPage(PROFILE_GET, params);
		//Log.d("edunesia", json);
		return json;
	}
	
	public String createProfile(Account newAcc) {
		params = new Hashtable<String, String>();
		params.put(KEY_USERNAME, newAcc.getUsername());
		params.put(KEY_FULLNAME, newAcc.getFullname());
		params.put(KEY_BIRTHDAY, newAcc.getBirthday());
		params.put(KEY_PASSWORD, newAcc.getUsername());
		params.put(KEY_GENDER, Character.toString(newAcc.getGender()));
		return getPage(PROFILE_CREATE, params);
	}
	
	public boolean isRegistered(String username) {
		params = new Hashtable<String, String>();
		params.put(KEY_USERNAME, username);
		return (getPage(REGISTERED, params).equalsIgnoreCase("true"));
	}
	
	public String updateProfile(String id, Account updateAcc) {
		params = new Hashtable<String, String>();
		params.put(KEY_USER_ID, updateAcc.getUserId());
		return getPage(PROFILE_UPDATE, params);
	}
}

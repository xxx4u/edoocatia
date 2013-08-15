package id.ac.ui.edoocatia.feature.user;

/**
 * Informasi seputar pengguna. <br>
 * Di luar dari package ini, kelas ini bersifat immutable. Perubahan hanya
 * dilakukan oleh {@link Session}.
 * 
 */
public class Account {

	private String userId;
	private String username;
	private String fullname;
	private String birthday;
	private String joinDate;
	private char gender;
	private int score;

	public Account(String name) {
		this.fullname = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

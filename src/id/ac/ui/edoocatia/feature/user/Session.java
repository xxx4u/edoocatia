package id.ac.ui.edoocatia.feature.user;

import java.util.Map;

/**
 * Kelas yang berhubungan dengan session, mulai dari membuat session, hingga
 * mendapatkan dan mengubah informasi yang berkaitan dengan pengguna yang
 * memiliki session tersebut. <br>
 * Sebagian besar operasi dalam kelas ini dilakukan dengan koneksi internet,
 * sehingga tidak boleh dipanggil dari main/UI thread.
 * 
 */
public class Session {

	public Session(String name, String password)
			throws NotAuthenticatedException {
		/*
		 * Login? Ambo tidak tahu design pattern untuk aplikasi yang ada session
		 * dan login-nya, tetapi ini meniru daripada kelas-kelas stream di Java,
		 * dimana membuka stream (atau memulai koneksi jika dia remote)
		 * dilakukan dengan instansiyasi, dan throw exception jika gagal.
		 */
		// TODO
	}

	public Session(String name, String password, Map<String, Object> info) {
		/*
		 * Membuat akun baru kali ye..
		 */
		// TODO
	}

	public Account getUser() {
		/* Pengguna yang sedang login */
		// TODO
		return null;
	}
	
	public void setUserName() {
		// TODO hanya contoh
	}
	
	public void submitScore(Object... lalala) {
		// TODO hanya contoh
	}
}

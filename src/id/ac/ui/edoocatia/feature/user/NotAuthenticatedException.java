package id.ac.ui.edoocatia.feature.user;

/**
 * Mengindikasikan kegagalan dalam session, misalnya gagal untuk login atau
 * session sudah kadaluwarsa. <br>
 * Informasi lebih spesifik bisa didapatkan dari {@link #errorCode()} dan
 * konstanta yang ada pada {@link Session}.
 * 
 * @author Fikrul
 * 
 */
public class NotAuthenticatedException extends Exception {

	private static final long serialVersionUID = 1L;

	private int error;

	public NotAuthenticatedException(String detailMessage, int errorCode) {
		super(detailMessage);
		this.error = errorCode;
	}

	public int errorCode() {
		return error;
	}
}

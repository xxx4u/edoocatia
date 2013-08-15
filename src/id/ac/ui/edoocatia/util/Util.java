package id.ac.ui.edoocatia.util;

public class Util {

	/**
	 * calculate proper height for given before and after width
	 * @param initVal
	 * @param percentage
	 * @return
	 */
	public static float properHeight(float wBefore, float hBefore, float wAfter) {
		float floatRatio = wAfter / wBefore;
		float hasil = hBefore * floatRatio;
		return hasil;
	}
}

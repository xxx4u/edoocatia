package id.ac.ui.edoocatia.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * A utility class used for probing resource bundle file names.
 * 
 * @author Fikrul
 *
 */
public abstract class ResourceBundleProber {

	public static final String DEFAULT_POSTFIX = ".properties";
	private static final char __ = '_';
	
	public static List<FileHandle> internal(String baseName, Locale locale) {
		return probe(baseName, locale, FileType.Internal, DEFAULT_POSTFIX);
	}
	
	public static List<FileHandle> probe(String baseName, Locale locale, FileType type) {
		return probe(baseName, locale, type, DEFAULT_POSTFIX);
	}
	
	public static List<FileHandle> probe(String baseName, Locale locale, FileType type, String postfix) {
		/* Daftar file yang bisa diambil, indeks ke-0 adalah yang paling
		 * spesifik, berikutnya adalah yang menjadi parent.
		 */
		List<FileHandle> results = new ArrayList<FileHandle>(4);
		
		if (locale.getVariant().length() != 0) {
			FileHandle file = Gdx.files.getFileHandle(baseName + __ +
					locale.getLanguage() + __ + locale.getCountry() + __ + locale.getVariant() +
					postfix, type);
			if (file.exists())
				results.add(file);
		}
		
		if (locale.getCountry().length() != 0) {
			FileHandle file = Gdx.files.getFileHandle(baseName + __ +
					locale.getLanguage() + __ + locale.getCountry() +
					postfix, type);
			if (file.exists())
				results.add(file);
		}
		
		if (locale.getLanguage().length() != 0) {
			FileHandle file = Gdx.files.getFileHandle(baseName + __ +
					locale.getLanguage() +
					postfix, type);
			if (file.exists())
				results.add(file);
		}
		
		FileHandle file = Gdx.files.getFileHandle(baseName + postfix, type);
		if (file.exists())
			results.add(file);
		
		return results;
	}

}

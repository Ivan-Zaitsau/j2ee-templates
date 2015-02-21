package dao.util;

/**
 * Utility class which contains number of general purpose methods.
 * 
 * @author Ivan Zaitsau
 */
public final class CommonUtil {
	
	public static <T> T castToType(Object value, Class<T> type) {
    	return (value == null) ? null : type.cast(value);
	}

	private CommonUtil() {}
}

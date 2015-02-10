package dao.util;

/**
 * 
 * @author Ivan Zaitsau
 */
public class CommonUtil {
	
	public static <T> T castToType(Object value, Class<T> type) {
    	return (value == null) ? null : type.cast(value);
	}

}

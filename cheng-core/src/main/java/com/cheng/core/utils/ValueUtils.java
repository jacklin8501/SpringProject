/**
 * 
 */
package com.cheng.core.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author jack.lin
 *
 */
public class ValueUtils {

	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return Boolean.valueOf(true);
		if (obj instanceof String) {
			if (((String) obj).length() != 0) {
				return Boolean.valueOf(false);
			}

		} else if (obj instanceof Collection) {
			if (((Collection) obj).size() != 0) {
				return Boolean.valueOf(false);
			}
		} else if (obj instanceof Map) {
			if (((Map) obj).size() != 0) {
				return Boolean.valueOf(false);
			}
		} else {
			if (obj.getClass().isArray()) {
				Class ct = obj.getClass().getComponentType();
				if (ct.isPrimitive()) {
					//return Boolean.valueOf(PrimitiveArrayUtil.getSize(obj) == 0);
				}

				return Boolean.valueOf(((Object[]) (Object[]) obj).length == 0);
			}

			return Boolean.valueOf(false);
		}

		return Boolean.valueOf(true);
	}
	
	public static boolean isNotEmpty(Object obj) {
		return !ValueUtils.isEmpty(obj);
	}
}

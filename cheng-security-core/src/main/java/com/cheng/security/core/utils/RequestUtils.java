/**
 * 
 */
package com.cheng.security.core.utils;

import static com.cheng.core.utils.EmptyUtils.isEmpty;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.cheng.core.holder.SpringContextHolder;
import com.cheng.core.properties.ChengProperties;

/**
 * @author jack.lin
 *
 */
public final class RequestUtils {

	public static boolean isAjaxRequest(HttpServletRequest request) {
		if (isEmpty(request)) {
			return false;
		}
		ChengProperties cheng = SpringContextHolder.getBean(ChengProperties.class);
		String xmlHeader = request.getHeader(cheng.getWeb().getAjaxRequestKey());
		if (isEmpty(xmlHeader) || !StringUtils.equals(cheng.getWeb().getAjaxRequestValue(), xmlHeader)) {
			return false;
		}
		return true;
	}
	
	public static String calculateUri(HttpServletRequest request) {
		if (isEmpty(request)) {
			return null;
		}
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (StringUtils.startsWith(uri, contextPath)) {
			return StringUtils.substring(uri, contextPath.length());
		}
		return uri;
	}
	
}

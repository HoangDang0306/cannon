package template;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.click.Page;
import org.apache.commons.lang.StringUtils;

import utility.GameLog;

public class PageBase extends Page {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void onInit() {
		logRequest(0);
	}
	
	public HttpServletRequest getContextRequest() {
		return getContext().getRequest();
	}
	
	public String getRequestParam(String name) {
		return getContext().getRequestParameter(name);
	}
	
	public void logRequest(int playerId) {
		String method = getContextRequest().getMethod();
		String playerIdStr = (playerId > 0) ? "[CAT:" + playerId + "] " : "";
				
		StringBuilder paramString = new StringBuilder();
		Map<String, String[]> params = getContextRequest().getParameterMap();
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			if (StringUtils.isEmpty(paramString.toString())) {
				paramString.append("?" + entry.getKey() + "=" + getRequestParam(entry.getKey()));
			} else {
				paramString.append("&" + entry.getKey() + "=" + getRequestParam(entry.getKey()));
			}
		}
		
		GameLog.getInstance().info("[" + method + "] " + playerIdStr + getContextRequest().getRequestURL() + paramString.toString());
	}

}

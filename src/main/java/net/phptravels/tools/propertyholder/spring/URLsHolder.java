package net.phptravels.tools.propertyholder.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A container for all AUT's page URLs. Spring bean is used, see
 * func_tests.config.xml.
 */
public class URLsHolder {
	private static final Logger logger = LoggerFactory.getLogger(URLsHolder.class);

	private static URLsHolder holder;

	private URLsHolder() {
	}

	public static URLsHolder getHolder() {
		if (null == holder) {
			try {
				holder = (URLsHolder) AppContext.getContext().getBean("urls");
			} catch (Exception e) {
				logger.error("Cannot init URLs Holder.", e);
			}
		}
		return holder;
	}

	private String baseUrl;
	private String pageAdmin;
	private String pageAccount;
	private String pageLogin;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getPageAdmin() {
		return pageAdmin;
	}

	public void setPageAdmin(String pageAdmin) {
		this.pageAdmin = pageAdmin;
	}

	public String getPageAccount() {
		return pageAccount;
	}

	public void setPageAccount(String pageAccount) {
		this.pageAccount = pageAccount;
	}

	public String getPageLogin() {
		return pageLogin;
	}

	public void setPageLogin(String pageLogin) {
		this.pageLogin = pageLogin;
	}
	
	/*
	 * ENVIRONMENT SETTINGS-----------------------------------------------------------
	 */
	private String environmentName;
	
	public String getEnvironmentName(){
		return environmentName;
	}
	
	public void setEnvironmentName(String environmentName){
		this.environmentName = environmentName;
	}
}
package net.phptravels.tools.propertyholder.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A container for configurable data: user names, passwords etc.
 * Spring bean is used, see smoke_tests.config.xml.
 */
public class DataHolder {
    private static final Logger logger = LoggerFactory.getLogger(DataHolder.class);

    private static DataHolder holder;

    private DataHolder(){}

    public static DataHolder getHolder()
    {
        if (null == holder){
            try {
                holder = (DataHolder) AppContext.getContext().getBean("data"); 
            } catch (Exception e) {
                logger.error("Cannot init Data Holder.", e);
            }
        }
        return holder;
    }

    private String adminName;
    private String adminAccountName;
    private String adminAccountPassword;
    private String userName;
    private String userAccountName;
    private String userAccountPassword;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    public String getAdminAccountName() {
        return adminAccountName;
    }

    public void setAdminAccountName(String adminAccountName) {
        this.adminAccountName = adminAccountName;
    }

    public String getAdminAccountPassword() {
        return adminAccountPassword;
    }

    public void setAdminAccountPassword(String adminAccountPassword) {
        this.adminAccountPassword = adminAccountPassword;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

	public String getUserAccountPassword() {
		return userAccountPassword;
	}

	public void setUserAccountPassword(String userAccountPassword) {
		this.userAccountPassword = userAccountPassword;
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
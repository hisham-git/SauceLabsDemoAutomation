package net.phptravels.data.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * A container for constants.  
 *
 */
public class Constants {	
	
	/**
	 * A date formatter for logging sub-system.
	 */
	public static final DateFormat DATE_FORMAT_LOG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * A date formatter for file/directory name timestamps.
	 */
	public static final DateFormat DATE_FORMAT_FILE = new SimpleDateFormat("yyyy_MM_dd-HHmmss");

    /**
     * A date formatter for form date fields.
     */
    public static final DateFormat DATE_FORMAT_FORM_DATES = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
}
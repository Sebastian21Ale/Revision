/**
 * 
 */
package co.com.claro.schema.util;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 * General Validation or Conversion Methods class
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
public class GeneralMethods {

	private static final Logger logger = Logger.getLogger(GeneralMethods.class);

	/**
	 * String validation method
	 * 
	 * @param value
	 * @return
	 */
	public Boolean validString(String value) {
		try {
			if (value != null && !value.isEmpty() && !value.equals("")) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			String message = "GeneralMetodos validString" + e.getMessage() + e.getCause();
			logger.error(message);
			return Boolean.FALSE;
		}

	}

	/**
	 * String to Timestamp conversion method
	 * 
	 * @param value
	 * @return Timestamp
	 */
	public Timestamp fechaTimestamp(String value) {
		Date date = new Date();
		Timestamp timestamp2 = new Timestamp(date.getTime());
		try {
			return Timestamp.valueOf(value);
		} catch (Exception e) {
			String message = "GeneralMetodos validString" + e.getMessage() + e.getCause();
			logger.error(message);
			return timestamp2;
		}
	}
	
	/**
	 * String validation method
	 * 
	 * @param value
	 * @return
	 */
	public Boolean validNumber(Integer value) {
		try {
			if (value != null) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			String message = "GeneralMetodos validNumber" + e.getMessage() + e.getCause();
			logger.error(message);
			return Boolean.FALSE;
		}
		
	}
	
	public Double getBetween(LocalTime start, LocalTime end) {
		return Double.valueOf(start.until(end, ChronoUnit.SECONDS));
	}
}

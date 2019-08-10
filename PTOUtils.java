
import java.util.Arrays;
import java.util.HashSet;


/**
 * @author Md Nazmul Karim
 * this call holds all the declared holidays
 * this class has a method to check whether a given date is a holiday and returns a boolean
 */
public class PTOUtils {
	
	static String arr[] = {"2019-01-10", "2019-02-21","2019-12-25" };	
	public static HashSet<String> declaredHolidays = new HashSet<String>(Arrays.asList(arr));
	
	
	public static boolean checkIfAvailable(String date) {
		if(declaredHolidays.contains(date))
			return true;
		else
			 return false;
	}
	

}

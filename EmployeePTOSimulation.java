
import java.text.ParseException;

public class EmployeePTOSimulation
{
	
	
	public static void main(String[] args) {
		
		EmployeePTO employeePto = new EmployeePTO();
		employeePto.setEmployeeId(20190101);
		
		employeePto.accrueMorePTO();
		employeePto.accrueMorePTO();

		System.out.println("Total Accrued PTO:"+ employeePto.amountAccrued());
		System.out.println("Total Used PTO:"+ employeePto.amountUsed());
		
		try {
			System.out.println(employeePto.takePTO(PTO_Type.SICK, "2019-08-3", 2));
		}catch(ParseException ex) {
			ex.printStackTrace();
		}
		
		
		employeePto.accrueMorePTO();
		employeePto.accrueMorePTO();
		
		
		try {
			System.out.println(employeePto.takePTO(PTO_Type.HOLIDAY, "2019-12-25", 2));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		 
		try {
			System.out.println(employeePto.takePTO(PTO_Type.VACATION, "2019-09-10", 2));
		}catch(ParseException ex) {
			ex.printStackTrace();
		}
		
		try {
			System.out.println(employeePto.takePTO(PTO_Type.PERSONAL, "2019-12-25", 2));
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Total Accrued PTO:"+ employeePto.amountAccrued());
		System.out.println("Total Used PTO:"+ employeePto.amountUsed());
		
	}
	

}

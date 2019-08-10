
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Md Nazmul Karim
 *
 */
public class EmployeePTO {
	
	private int employeeId;
	
	private int vacationPTOAccrued;
	private int sickPTOAccrued;
	private int personalPTOAccrued;
	private int holidayPTOAccrued;
	
	
	private int vacationPTOUsed;
	private int sickPTOUsed;
	private int personalPTOUsed;
	private int holidayPTOUsed;
	
	
	public EmployeePTO() {
		vacationPTOAccrued = 0;
		sickPTOAccrued = 0;
		personalPTOAccrued = 0;
		holidayPTOAccrued = 0;

		vacationPTOUsed = 0;
		sickPTOUsed = 0;
		personalPTOUsed = 0;
		holidayPTOUsed = 0;

	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * This method accrues 2 hours each to each vacation and personal PTO
	 * This method accrues 3 hours each to each sick and holiday PTO
	 */
	public void accrueMorePTO() {
		vacationPTOAccrued += 2;
		sickPTOAccrued += 3;
		personalPTOAccrued += 2;
		holidayPTOAccrued += 3;
	}
	
	
	/**
	 * @param type of the PTP
	 * @param date as yyyy-mm-dd string format
	 * @param hours of vacation
	 * @return approval/disapproval message
	 * @throws ParseException
	 */
	public String takePTO(PTO_Type type , String date , int hours ) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date leaveDate = sdf.parse(date);
		Date currentDate = new Date();
		
		String returnMessage = "";
		
		switch(type) {
			
		case VACATION:			
			
			if(leaveDate.compareTo(currentDate)<=0)
				returnMessage = "Not eligible";
			else {
				if(vacationPTOAccrued >= hours) {
					
					//log in data base the date and hour   but for simplicity this is not done here
					
					vacationPTOAccrued -= hours;
					vacationPTOUsed += hours;
					returnMessage = "Approved vacation leave.";
					
				} else {
					returnMessage = "Do not have enough vacation hours.";
				}
			}
			break;
			
		case PERSONAL:			
			
			if(leaveDate.compareTo(currentDate)<=0)
				returnMessage = "Not eligible";
			else {
				if(personalPTOAccrued >= hours) {
					
					//log in data base the date and hour   but for simplicity this is not done here
					
					personalPTOAccrued -= hours;
					personalPTOUsed += hours;
					returnMessage = "Approved personal leave.";
					
				} else {
					returnMessage = "Do not have enough personal hours.";
				}
			}
			break;
			
		case SICK:			
			
			if(leaveDate.compareTo(currentDate)>=0)
				returnMessage = "Not eligible";
			else {
				if(sickPTOAccrued >= hours) {
					
					//log in data base the date and hour   but for simplicity this is not done here
					
					sickPTOAccrued -= hours;
					sickPTOUsed += hours;
					returnMessage = "Approved sick leave.";
					
				} else {
					returnMessage = "Do not have enough sick hours.";
				}
			}
			break;	
			
		case HOLIDAY:			
			
			if(leaveDate.compareTo(currentDate)<=0)
				returnMessage = "Not eligible";
			else if(!PTOUtils.checkIfAvailable(date)) {
				returnMessage = "Not eligible";
			}
			else {
				if(holidayPTOAccrued >= hours) {
					
					//log in data base the date and hour   but for simplicity this is not done here
					
					holidayPTOAccrued -= hours;
					holidayPTOUsed += hours;
					returnMessage = "Approved holiday leave.";
					
				} else {
					returnMessage = "Do not have enough holiday hours.";
				}
			}
			break;	
		
		}
		
		return returnMessage;
	}
	
	public int amountAccrued() {
		return vacationPTOAccrued + sickPTOAccrued + personalPTOAccrued + holidayPTOAccrued;
	}
	
	public int amountUsed() {
		return vacationPTOUsed + sickPTOUsed  + personalPTOUsed + holidayPTOUsed;
	}
	
	
	
	
	
	
	

}

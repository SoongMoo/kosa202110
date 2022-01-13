package springBootTest2.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {
	Integer empNum;
	String empName; 
	String empId;
	String empPw; 
	Date empHireDate;
	String empEmail;
	Integer empSalary;
    String empPhone;
}

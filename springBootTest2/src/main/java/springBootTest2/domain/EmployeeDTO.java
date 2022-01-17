package springBootTest2.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("employeeDTO")
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

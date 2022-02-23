package kosaShoppingMall.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "empDTO")
public class EmployeeDTO {
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empPhone;
	String empEmail;
	
	List<EducationDTO> educations;	
}

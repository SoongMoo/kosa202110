package kosaShoppingMall.domain;

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
}

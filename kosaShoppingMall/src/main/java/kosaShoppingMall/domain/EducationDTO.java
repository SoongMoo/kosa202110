package kosaShoppingMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("educationDTO")
public class EducationDTO {
	String empId;
	Date schoolYear;
	String school;
}

package kosaShoppingMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "authInfo")
public class AuthInfo {
	String userId;
	String grade;
	String userPw;
	String phone;
	String memberOk;
}
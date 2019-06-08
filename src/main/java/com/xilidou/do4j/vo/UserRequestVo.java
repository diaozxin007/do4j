package com.xilidou.do4j.vo;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
@ToString
public class UserRequestVo {

	private String name;

	@Length(max = 100)
	private String username;

	@Length(min = 6,message = "密码需要大于6位")
	private String password;

	@Email
	private String email;

}

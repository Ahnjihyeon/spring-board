package io.millionware.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.millionware.service.SignUpService;

@Controller
@RequestMapping(value="/sign/*")
public class SignUpController {
	
	
	SignUpService service;
	
	//회원 가입 화면
	public void signupView() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "drewAhn"); //HashMap에서 재정의된 함수만 사용 가능
		map.put("email","1234@1234.com");
	}
	

}

package io.millionware.service;

import io.millionware.vo.MemberVO;

public interface SignUpService {
	//회원 가입
	public void signup(MemberVO memberVO) throws Exception;
	
	
}

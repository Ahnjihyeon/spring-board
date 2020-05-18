package io.millionware.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminVO {
	
	Logger log = LoggerFactory.getLogger(AdminVO.class);
	
	//필드
	public BoardVO freeBoard = new BoardVO();
	public BoardVO infoBoard = new BoardVO();
	public BoardVO imgBoard = new BoardVO();
	
	public MemberVO adminMember = new MemberVO();
	public MemberVO customerMember = new MemberVO();
	
	//메소드
	public void control() {
		log.info("ADMIN::::::I do control something to do.");
	}
}

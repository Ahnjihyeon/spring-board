package io.millionware.service;

import io.millionware.vo.AdminVO;
import io.millionware.vo.BoardVO;

public class AdminServiceImpl implements AdminService {

	@Override
	public void test() throws Exception {
		AdminVO myAdmin = new AdminVO();
		
		myAdmin.freeBoard = new BoardVO();
		myAdmin.infoBoard = new BoardVO();
	}

}

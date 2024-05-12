package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class modfiyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setBoardNO(Integer.parseInt(bno));
		
		if(svc.modifyBoard(vo)) {
			System.out.println("수정성공");
			resp.sendRedirect("main.do?page="+page); // 페이지만 지정
		}else {
			System.out.println("수정실패");
		}
	}

}

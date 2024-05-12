package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface BoardService {
	//게시판
	List<BoardVO> boardList(int page);
	boolean addBoard(BoardVO board);
	BoardVO getBoard(int boardNo);
	int addViewCnt(int boardNo);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	
	int getTotal(int cnt);
	
	//로그인
	MemberVO login(String id, String pw);
	MemberVO checkMember(String id);
}

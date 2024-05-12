package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class BoardServiceImpl implements BoardService{
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	
	// 게시판
	@Override
	public List<BoardVO> boardList(int page) {
		return mapper.boardListPaging(page);
	}

	@Override
	public boolean addBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		
		return mapper.selectBoard(boardNo);
	}

	@Override
	public int addViewCnt(int boardNo) {
		return mapper.updateViewCnt(boardNo);
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo) == 1;
	}

	
	
	// 로그인
	@Override
	public MemberVO login(String id, String pw) {
		// TODO Auto-generated method stub
		return mapper.selectMember(id, pw);
	}

	@Override
	public MemberVO checkMember(String id) {
		// TODO Auto-generated method stub
		return mapper.selectMember2(id);
	}

	@Override
	public int getTotal(int cnt) {
		// TODO Auto-generated method stub
		return mapper.getTotalCnt(cnt);
	}
}

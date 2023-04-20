package com.gdu.app06.service;

import java.util.List;

import com.gdu.app06.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();		// 목록보기
	public BoardDTO getBoardByNo(int board_no);	// 상세보기
	public int addBoard(BoardDTO board);		// 삽입
	public int modifyBoard(BoardDTO board);		// 수정
	public int removeBoard(int board_no);		// 삭제
	public void testTx();		// 트랜잭션
}

package com.gdu.app07.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.selectBoardList();
	}

	@Override
	public BoardDTO getBoardByNo(HttpServletRequest request) {
		// 파라미터 boardNo가 없으면(null, "") 0을 사용한다.
		
		// Optional은 null값만 처리가능하다. 빈문자열은 처리 불가능하다. 아래처럼 처리하면 된다.
			/*
			Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
			int boardNo = Integer.parseInt(opt.orElse("0"));
			return boardDAO.selectBoardByNo(boardNo);
			 */
		
		// 빈문자열과 같이 처리하려면 고전방식으로 아래 코드처럼 작성하면된다.
		String strBoardNo = request.getParameter("boardNo");
		int boardNo = 0;	// null, 빈문자열이 올때 0값을 사용하기위한 선언이다!
		if(strBoardNo != null && strBoardNo.isEmpty() == false) { // 자바는 빈문자열 처리시 .isEmpty()를 사용한다. (기본은 비어있다라는 말!)
			boardNo = Integer.parseInt(strBoardNo);
		}
		return boardDAO.selectBoardByNo(boardNo);
	}

	@Override
	public int addBoard(HttpServletRequest request) {
		try {
			// 파라미터 title, content, writer를 받아온다.
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			// BoardDAO로 전달할 BoardDTO를 만든다.
			BoardDTO board = new BoardDTO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			
			return boardDAO.insertBoard(board);
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int modifyBoard(HttpServletRequest request) {
		try {
			// 파라미터 title, content, boardNo를 받아온다.
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			// BoardDAO로 전달할 BoardDTO를 만든다.
			BoardDTO board = new BoardDTO();
			board.setTitle(title);
			board.setContent(content);
			board.setBoardNo(boardNo);
			
			return boardDAO.updateBoard(board);
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int removeBoard(HttpServletRequest request) {
		try {
			// 파라미터 boardNo를 받아온다.
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			
			return boardDAO.deleteBoard(boardNo);
		}catch(Exception e) {
			return 0;
		}
	}
	
	
	// 트랜잭션 확인
	@Transactional
	@Override
	public void testTx() {
		boardDAO.insertBoard(new BoardDTO(0, "타이틀", "콘텐트", "작성자", null, null));
		boardDAO.insertBoard(new BoardDTO());
		
	}
	
	
	
	
	
	
	

}

package com.gdu.app07.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app07.domain.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NS = "mybatis.mapper.board.";
	
	public List<BoardDTO> selectBoardList() {
		return sqlSessionTemplate.selectList(NS +"selectBoardList");
	}
	
	public BoardDTO selectBoardByNo(int boardNo) {
		return sqlSessionTemplate.selectOne(NS + "selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) { // board.xml에 삽입, 수정, 삭제는 반환값이 0아니면 1이기 때문에 반환타입은 int이고, 0, 1은 commit할때 삽입이되면 1 미삽입시 0을 반환한다. 
		return sqlSessionTemplate.insert(NS + "insertBoard", board);
	}
	
	public int updateBoard(BoardDTO board) {
		return sqlSessionTemplate.update(NS + "updateBoard", board);
	}
	
	public int deleteBoard(int boardNo) {
		return sqlSessionTemplate.delete(NS + "deleteBoard", boardNo);
	}
	
	
	
	
	
	

}

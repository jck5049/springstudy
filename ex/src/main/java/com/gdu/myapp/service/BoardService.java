package com.gdu.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gdu.myapp.domain.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> list();
	public BoardDTO detail1(int boardNo);
	public BoardDTO datail2(HttpServletRequest request);
	public void datail3(Model model);
	

}

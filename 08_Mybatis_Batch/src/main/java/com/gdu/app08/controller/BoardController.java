package com.gdu.app08.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app08.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/*
	 	데이터(속성) 저장 방법
	 	1. forward  : Model에 attribute로 저장한다.
	 	2. redirect : RedirectAttributes에 flashAttribute로 저장한다.
	*/
	
	
	// 호랑이 시절 ModelAndView 클래스 (이런코드가 있었다라고 알려주신거)
	/*
	@GetMapping("/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardService.getBoardList());
		mav.setViewName("board/list");
		return mav;
	}
	 */
	
	// getBoardList() 서비스가 반환한 List<BoardDTO>를 board/list.jsp로 전달한다.
	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}
	
	// getBoardByNo() 서비스가 반환한 BoardDTO를 board/detail.jsp로 전달한다.
	@GetMapping("/detail.do")
	public String detail(HttpServletRequest request, Model model) {
		model.addAttribute("b" , boardService.getBoardByNo(request));
		return "board/detail";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	
	// addBoard() 서비스 내부에 location.href를 이용한 /board/list.do 이동이 있기 때문에 응답할 View를 반환하지 않는다.
	@PostMapping("/add.do")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		boardService.addBoard(request, response);
	}
	
	
	// modifyBoard() 서비스 내부에 location.href를 이용한 /board/detail.do 이동이 있기 때문에 응답할 View를 반환하지 않는다.
	@PostMapping("/modify.do")
	public void modify(HttpServletRequest request, HttpServletResponse response) {
		boardService.modifyBoard(request, response);
	}
	
	// removeBoard() 서비스 내부에 location.href를 이용한 /board/list.do 이동이 있기 때문에 응답할 View를 반환하지 않는다.
	@PostMapping("/remove.do")
	public void remove(HttpServletRequest request, HttpServletResponse response) {
		boardService.removeBoard(request, response);
	}
	
	
	@PostMapping("/removeList.do")
	public void removeList(HttpServletRequest request, HttpServletResponse response) {
		boardService.removeBoardList(request, response);
		
	}
	
	/* 위 참고용 코드
	String[] boardNoList = request.getParameterValues("boardNoList");
	for(int i = 0; i < boardNoList.length; i++) {
		boardService.removeBoard(request, response);
	}
	*/
	
	
}

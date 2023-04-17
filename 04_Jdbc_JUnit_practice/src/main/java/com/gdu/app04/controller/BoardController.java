package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/list.do")
	public String list(Model model) {
		
		return "board/list";
	}

}

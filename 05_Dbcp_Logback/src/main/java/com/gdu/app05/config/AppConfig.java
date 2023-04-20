package com.gdu.app05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app05.repository.BoardDAO;
import com.gdu.app05.service.BoardService;
import com.gdu.app05.service.BoardServiceImpl;

@Configuration
public class AppConfig {

	@Bean	// BoardServiceImpl에 @Service 애너테이션 역할
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
	
	@Bean	// BoardDAO에 @Repository 애너테이션 역할
	public BoardDAO boardDAO() {
		return new BoardDAO();
	}
	
	
	
	
}

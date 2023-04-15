package com.gdu.app02.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {

	/*
	 	* 요청 파라미터를 받는 방법(메소드)
	 	
		1. public String detail(HttpServletRequest request) { }
		2. public String detail(@RequestParam("name") String name, @RequestParam("age") int age) { }
		3. public String detail(Person p) { }
	 */
	
	@GetMapping("/post/detail.do")
	public String detail(HttpServletRequest request) throws Exception {	// name, age 파라미터가 있다.
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("/post/detail.do");
		System.out.println("name: " + name + ", age: " + age);
		
		
		// return "redirect:이동경로";  => return할때 리다이렉트 하는 방법
		return "redirect:/post/list.do?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age;	// /post/list.do 매핑으로 이동하시오! name, age 파라미터를 다시 붙인다(필수)!                 
		 
		
		
		
		 // -지원이 필기-
		 // name과 age가 전달안됐음. 전달하는 건 포워드밖에 없음. 이건 리다이렉트로 했기 때문에 전달 안 된 것. 위의 매핑(redirect:/post/list.do)에 파라미터가 없잖아~
         // name과 age 파라미터를 붙이고자 한다면 ? 붙이고 파라미터 붙여야함  return "redirect:/post/list.do?name" + name + "&age=" + age; <- 필요하면 갖다 붙여야 함. 
	}
	
	
	@GetMapping("/post/list.do")
	public String list(HttpServletRequest request, 	// name, age 파라미터가 있다.
					   Model model) {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		//	/WEB-INF/view/post/list.jsp로 forward 하겠다!
		return "post/list";
		
	}
	
	
	@GetMapping("/post/detail.me")
	public String detailMe(HttpServletRequest request, 
						   RedirectAttributes redirectAttributes) {	// RedirectAttributes : 리다이렉트 할때 속성(Attribute)을 전달해주는 스프링 인터페이스이다!
	
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// Redirect 경로까지 전달되는 속성 : Flash Attribute
		redirectAttributes.addFlashAttribute("name", name);	 // addAttribute()가 아님을 주의하세요!
		redirectAttributes.addFlashAttribute("age", age);
		
		return "redirect:/post/list.me";
	
	}
	
	@GetMapping("/post/list.me")
	public String listMe() {	// Flash Attribute는 파라미터가 Redirect 경로까지 자동으로 전달되므로 별도의 코드가 필요하지 않다.
		return "post/list";
		
	}
	
	
	
}

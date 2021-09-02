package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// RestController(데이터 리턴)
// Controller(파일 리턴)

@Controller
public class FrontController {// 서버 실행시
	
	// http://localhost:8080/home
	// 디스패서 서블릿 /home 파싱
	// loC 컨데이너에 @Controller @RestController로 생성된 객체만 찾는다.
	// 메서드를 호출한다
	
	@GetMapping("/home")
	public String home(Model model) { // request == model
		// ViewResolver 클래스
		// src/main/resources/templates(prefix)
		// .mustache(suffix)
		
		String name = "박민영";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목3"));
		boards.add(new Board(2, "제목4"));
		
		model.addAttribute("boards", boards);
		
		return "home"; // RequestDispatcher가 자동 작동
	}

}

package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//1.URL과 페이지 매핑 방법

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@GetMapping("/") //URL창에 board로 치고들어가면 main.jsp출력 
	public String main() {
		return "board/main";
	}
	
	@GetMapping("/content")
	public String content() {
		return "board/content";
	}
	
	//2.뷰(jsp)에 데이터 전달
	
	//Model객체로 뷰에 데이터를 전달하면 내부적으로는 ModelAndView와 같은 방식으로 컴파일된다.
	//방법1
	@GetMapping("/content_view")
	public String content_view(Model model) { //Model = 뷰에 데이터를 넘겨주는 객체 
		model.addAttribute("id", 30); //request.setAttribute()와 같은 기능
		model.addAttribute("pw", "1234");
		return "board/content";
	}
	
	//방법2
	@GetMapping("/reply")
	public ModelAndView model_view () {  
		//ModelAndView는 키 value값으로 데이터를 가져올 수 있고 바로 view페이지에 데이터를 출력시킬 수 있다
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 50); 
		mv.addObject("pw", "1234");
		mv.setViewName("board/reply");
		
		return mv;
	}

}

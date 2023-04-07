package edu.global.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//어떻게 URL를 설정하여 jsp를 보여주는지(URL과 페이지 매핑 방법)

@Controller //import해야된다 @Controller는 FrontController부분, view
public class TestController {
	
	//@GetMapping는 버전4부터 지원
	@GetMapping("/test") //import해야된다 //URL창에 get방식으로 test로 치고들어가면(request) test()를 실행시킨다.
	public String test() { //함수이름을 위의 /뒤와 동일하게 하는 경우가 많다
		return "test"; //test.jsp를 불러온다. /WEB-INF/views경로를 타서 test.jsp를 찾아 브라우저에 출력하라
	}
	
	@GetMapping("/test2") //URL창에 test2치면 test2.jsp를 출력
	public String test2() {
		return "test/test2"; //경로는 자동으로 서버가 찾기 때문에 URL창에서는 test2로 치고들어가야된다.
	}
	
	@GetMapping("/test/test3") //URL 
	public String test3() {
		return "test/test3"; //경로는 자동으로 서버가 찾기 때문에 URL창에서는 test2로 치고들어가야된다.
	}
	
	@RequestMapping("/test4") 
	public String test4() {
		return "test/test4";
	}
	
	
	//jsp문법, @, Java문법은 서버가 처리하고 HTML, Javascript등은 jsp파일에남겨둔다.
}

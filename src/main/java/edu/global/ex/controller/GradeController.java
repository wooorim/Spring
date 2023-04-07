package edu.global.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.vo.GradeVO;

@RequestMapping("/grade")
@Controller //import해야된다 @Controller는 FrontController부분, view
public class GradeController {
	//get방식으로 받을 때는 GetMapping, post방식으로 받을 때는 PostMapping
	@GetMapping("/")
	public String kem_form() {
		return "kem_form"; //kem_form.jsp불러오기
	}
	
	//현업에서는 별로 사용 안하는 방법
	@PostMapping("/total")
	public String kem_form(HttpServletRequest request, Model model) { //커멘드 객체
		int kor = Integer.valueOf(request.getParameter("kor"));
		int eng = Integer.valueOf(request.getParameter("eng"));
		int math = Integer.valueOf(request.getParameter("math"));
		
		int total = kor + eng + math;
		double avg = total / 3.0;
		
		GradeVO grade = new GradeVO(kor, eng, math);
		
		model.addAttribute("grade", grade);
		model.addAttribute("total", grade);
		
		return "grade"; //kem_form.jsp불러오기
	}
	
	//스프링 = 약속된 프레임워크를 사용, 커멘드 객체
	//GradeVO gradeVO = new GradeVO(), kem_form(GradeVO gradeVO부분)-> GradeVO객체는 default생성자로 객체생성한다. default생성자는 반드시 있어야한다.
	@PostMapping("/total2")
	public String kem_form(GradeVO gradeVO, Model model) { //커멘드 객체
		
//		내부적인 호출
//		gradeVO.setKor(80);
//		gradeVO.setEng(70);
//		gradeVO.setMath(90);
		model.addAttribute("grade", gradeVO);
		
		return "grade"; //kem_form.jsp불러오기
	}
}

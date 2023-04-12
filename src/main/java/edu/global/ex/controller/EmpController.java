package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//1.URL과 페이지 매핑 방법

import edu.global.ex.service.EmpService;
import edu.global.ex.vo.EmpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/emp/*")
@Controller
@RequiredArgsConstructor
public class EmpController {
	
	@Autowired
	private final EmpService empService; 
	
	@GetMapping("/emp_list") //URL창에 board로 치고들어가면 main.jsp출력 
	public String list(Model model) {
		log.info("list()..");
		
		model.addAttribute("emps", empService.getList());
		
		return "/emp/emp_list";
	}
	
	@GetMapping("/emp_info") //URL창에 board로 치고들어가면 main.jsp출력 
	public String info(EmpVO empVO, Model model) {
		log.info("info()..");
		
		int empno = empVO.getEmpno();
		
		empVO = empService.get(empno);
		model.addAttribute("emp_info", empVO);
		
		return "/emp/emp_info";
	}
	
	
}

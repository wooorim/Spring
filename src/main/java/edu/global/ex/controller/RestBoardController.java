package edu.global.ex.controller;
import java.util.List;

//RESTful사용
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 사용을 위한 롬복이 임폴트
@RequestMapping("/rboard/*")
@RequiredArgsConstructor // 간단한 방법으로 생성자 주입
@RestController //RESTful전용 컨트롤러, 기존의 컨트롤러의 문법과는 완전히 달라짐.

public class RestBoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String rboard() {
		return "<h1>이제는 restful이다.</h1>"; //기존 컨트롤러에서는 JSP파일 이름. 
	}
	
	@GetMapping("/list")
	public List<BoardVO> list() {
		log.info("list()..");
		
		return boardService.getList(); //JSON으로 리턴
	}
	
	@DeleteMapping("/{bid}") // ex) URL:/rboard/1054 로 받아온다.
	public int rest_delete(BoardVO boardVO) {
		log.info("rest_delete()..");
		
		return boardService.remove(boardVO); 
	}

}

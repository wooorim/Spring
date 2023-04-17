package edu.global.ex.controller;
import java.util.List;

//RESTful사용
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	/*
	 * @DeleteMapping("/{bid}") // ex) URL:/rboard/1054 로 받아온다. 
	 * public int rest_delete(BoardVO boardVO) { log.info("rest_delete()..");
	 * 
	 * return boardService.remove(boardVO); }
	 */
	 
	
	   @DeleteMapping("/{bid}")
	   public ResponseEntity<String> rest_delete(BoardVO boardVO, Model model) { //현업에서는 ResponseEntity를 사용하는 경우가 많다.
	      
	      ResponseEntity<String> entity = null;
	      log.info("rest_delete..");
	      
	      try {
	            int rn = boardService.remove(boardVO);
	            // 삭제가 성공하면 성공 상태메시지 저장
	            log.info("delete 넘어온 숫자:::::" + rn);
	            
	         entity = new ResponseEntity<>(String.valueOf(rn), HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         // 댓글 삭제가 실패하면 실패 상태메시지 저장
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }
	      // 삭제 처리 HTTP 상태 메시지 리턴
	      return entity;
	   }
	   
	@GetMapping("/{bid}") // ex) URL:/rboard/1054 로 받아온다.
	public BoardVO rest_conent_view(BoardVO boardVO) {
		log.info("rest_conent_view()..");
		
		return boardService.get(boardVO.getBid()); 
	}

	//@RequestBody : JSON을 자바 객체로 변환하는 에너테이션
	@PutMapping("/{bid}") // ex) URL:/rboard/1054 로 받아온다.
	public int rest_update(@RequestBody BoardVO boardVO) {
		log.info("rest_update()..");
		
		return boardService.modify(boardVO); 
	}
}

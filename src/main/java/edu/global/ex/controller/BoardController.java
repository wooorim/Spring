package edu.global.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.global.ex.page.Criteria;
import edu.global.ex.page.PageVO;
import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import edu.global.ex.vo.GradeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 사용을 위한 롬복이 임폴트
@Controller
//@Component + 의미 기능 -> BoardController boardController = new BoardController(); 객체이름을 지정안하면 자동으로 앞자리가 소문자로 된 이름이 자동으로 만들어진다.
//@Controller("board")
@RequestMapping("/jboard/*")
@RequiredArgsConstructor // 간단한 방법으로 생성자 주입

public class BoardController {

	@Autowired // 필드 주입
	private BoardService boardService; // BoardService boardService = new BoardService();

	@Autowired
	private GradeVO gradeVO;

	@GetMapping("/list")
	public String view_list(Model model) {
		log.info("view_list().."); // 디버깅 코드
		System.out.println(gradeVO);

		model.addAttribute("boards", boardService.getList());

		System.out.println(boardService.getList());

		return "/board/list";
	}

	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view().."); // 디버깅 코드

		int bid = boardVO.getBid();

		boardVO = boardService.get(bid);
		model.addAttribute("content_view", boardVO);

		return "/board/content_view";
	}

	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) {
		log.info("modify().."); // 디버깅 코드

		int rn = boardService.modify(boardVO);
		log.info("modify().. result number::" + rn); // 디버깅 코드

		return "redirect:list"; // 유저로 하여금 list페이지로 다시 치고 돌아가라
	}

//	<a href="delete?bid=${content_view.bid}">삭제</a> ?가 달린 것은 GET방식
	@GetMapping("/delete") // content_view.jsp에서 삭제 링크가 delete로 걸려있기 때문에 맞춰준다.
	public String remove(BoardVO boardVO, Model model) {
		log.info("delete()..");

		int rn = boardService.remove(boardVO);

		return "redirect:list";
	}

	@GetMapping("/write_view") // content_view.jsp에서 삭제 링크가 delete로 걸려있기 때문에 맞춰준다.
	public String write_view() {
		log.info("write_view()..");

		return "/board/write_view";
	}

	@PostMapping("/write")
	public String write(BoardVO boardVO, Model model) {
		log.info("write().."); // 디버깅 코드

		int rn = boardService.register(boardVO);

		return "redirect:list"; // 유저로 하여금 list페이지로 다시 치고 돌아가라
	}

	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view().."); // 디버깅 코드

		model.addAttribute("reply_view", boardService.get(boardVO.getBid()));
		return "/board/reply_view"; // 유저로 하여금 list페이지로 다시 치고 돌아가라
	}

	@PostMapping("/reply")
	public String reply(BoardVO boardVO, Model model) {
		log.info("reply().."); // 디버깅 코드

		boardService.registerReply(boardVO);
		return "redirect:list"; // 로직 수행한 후 list로 redirect
	}

	@GetMapping("/list2") // URL창에 list2를 치고들어오면 먼저 Controller에서 해당 함수를 실행
	public String list2(Criteria cri, Model model) { // Criteria객체(커멘드 객체)를 생성
		log.info("list2()..");
		log.info("list2() Criteria" + cri);

		// 게시글 10개 가져오는 코드
		model.addAttribute("boards", boardService.getList(cri));

		// 페이징을 위한 처리
		int total = boardService.getTotal();
		log.info("total" + total);

		model.addAttribute("pageMaker", new PageVO(cri, total));

		return "/board/list2";
	}

}

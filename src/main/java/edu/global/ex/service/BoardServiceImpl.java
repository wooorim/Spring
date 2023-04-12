package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 사용하기 위한 임폴트
@Service // 핵심코드
@RequiredArgsConstructor

public class BoardServiceImpl implements BoardService { // Impl = implement약자

	@Autowired
	private final BoardMapper mapper;

//	@Autowired
//	private GradeVO gradeVO;

//	@Autowired //생성자 주입 -> 추천!
//	public BoardServiceImpl(GradeVO gradeVO) {
//		this.gradeVO = gradeVO;
//	}
//	
//	@Autowired //수정자 setter 주입
//	public void setGradeVO(GradeVO gradeVO) {
//		this.gradeVO = gradeVO;
//	}
//	
	@Override
	public List<BoardVO> getList() {
		log.info("getList()..");

		return mapper.getList();

	}

	@Override
	public BoardVO get(int bid) {
		log.info("get()..");

		return mapper.read(bid);
	}

	@Override
	public int modify(BoardVO board) {
		log.info("modify()..");
		
		return mapper.update(board);
	}
	
	@Override
	public int remove(BoardVO board) {
		log.info("remove()..");
		
		return mapper.delete(board);
	}
	
	@Override
	public int register(BoardVO board) {
		log.info("register()..");
		
		return mapper.insert(board);
	}
	
	@Transactional
	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply()..");
		
		mapper.updateShape(board); //댓글의 위치를 먼저 잡아준 후
		mapper.insertReply(board); //댓글을 등록한다.
	}

}

package edu.global.ex.service;

import java.util.List;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getList(); //public abstract 생략가능. 리스트 보기 
	
	public BoardVO get(int bid); //글 보기 메소드
	
	int modify(BoardVO board); //글 수정
	
	int remove(BoardVO board); //글 삭제
	
	int register(BoardVO board); //글 작성
	
	void registerReply(BoardVO board); //댓글 작성
	
	//페이징
	int getTotal();
	public List<BoardVO> getList(Criteria cri); //리스트 메소트. 함수 오버로딩 = 같은 함수이름에 파라미터가 다른 것
	

}

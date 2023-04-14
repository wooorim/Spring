package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	@Select("select * from mvc_board order by bgroup desc, bstep asc")
	public List<BoardVO> getList();
	
	public BoardVO read(int bno); //파라미터는 url로 넘어오는 bid값을 의미
	public int update(BoardVO board); //글 수정
	public int delete(BoardVO board); //글 삭제
	public int insert(BoardVO board); //글 작성
	
	//댓글 관련
	void updateShape(BoardVO board); //댓글 위치
	void insertReply(BoardVO board); //댓긓 등록
	
	//페이징 관련
	int getTotalCount();
	public List<BoardVO> getListWithPaging(Criteria cri);
	
}

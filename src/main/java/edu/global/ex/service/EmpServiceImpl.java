package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.global.ex.mapper.EmpMapper;
import edu.global.ex.repository.EmpDAO;
import edu.global.ex.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor

public class EmpServiceImpl implements EmpService{

	//@Autowired 서비스 단에서는 DAO를 가져와야하기 때문에 객체생성
	//private final EmpDAO dao; //@RequiredArgsConstructor사용해서 생성자 주입을 할 떄는 final을 붙여준다!
	
	@Autowired
	private final EmpMapper mapper;
	
	
	public List<EmpVO> getList(){
		log.info("getList()..");
		
		return mapper.getList();
	}
	
	public EmpVO get(int empno) {
		log.info("get()..");
		
		return mapper.read(empno);
	}
	
}

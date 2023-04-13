package edu.global.ex.service;

import java.util.List;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.EmpDeptVO;
import edu.global.ex.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> getList();
	
	public EmpVO get(int empno);
	
	int getTotal();
	public List<EmpVO> getList(Criteria cri);
	
	//1:N
	public List<EmpDeptVO> getEmpDeptOneVOList();
} 

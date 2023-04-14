package edu.global.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DeptVO {

	   private String deptno; //부서번호
	   private String dname; //부서이름
	   private String loc; //지역
	   
	   List<EmpVO> empList; //자바에서의 1(Dpet) : N(Emp)  자바에서는 자식 리스트를 갖는 쪽이 1, 자식 리스트가 N

}

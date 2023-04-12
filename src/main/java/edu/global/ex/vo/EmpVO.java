package edu.global.ex.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter //lombok이를 설치하고 @를 사용해 import하게되면 자동으로 컴파일 할 때 getter함수를 만들어준다
@Setter
@NoArgsConstructor //default생성자
@AllArgsConstructor
@ToString

public class EmpVO {

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptno;
}

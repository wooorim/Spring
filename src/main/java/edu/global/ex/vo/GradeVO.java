package edu.global.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter //lombok이를 설치하고 @를 사용해 import하게되면 자동으로 컴파일 할 때 getter함수를 만들어준다
@Setter
@NoArgsConstructor //default생성자
@AllArgsConstructor
@ToString
@Data //@Data하나만으로 getter/setter, defalt생성자 등을 @로 삽입안해도 자동으로 만들어진다. but @AllArgsConstructor는 잡을 수 없어서 선언해줘야 함.
public class GradeVO {

	private int kor;
	private int eng;
	private int math;
	
	//개발자가 함수를 만들면 lombok으로 만들어진 함수보다 우선적으로 실행된다.
	public int getTotal() {
		return kor + eng + math;
	}
	public double getAvg() {
		return getTotal()/3.0;
	}
	public char getGrade() {
		double avg = getAvg();
		char ch = '가';
		if(avg >= 90) 
			ch = '수';
		else if(avg >= 80)
			ch = '우';
		else if(avg >= 70)
			ch = '미';
		else if(avg >= 60)
			ch = '양';
		else 
			ch = '가';
		
		return ch;
		}
}

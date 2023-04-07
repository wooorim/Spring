<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8282/grade/total?kor=70&eng=80&math=90 get방식을 허용했기 때문에 URl창에 입력내용 포함-->
<form action="/grade/total" method="post">
	국어: <input type="text" name="kor"><br>
	영어: <input type="text" name="eng"><br>
	수학: <input type="text" name="math"><br>
	<button type="submit">입력</button>
	<button type="reset">취소</button>
	</form>
 <!-- 스프링 프레임워크 사용(GradeController의 커맨드 객체부분) -->
	<form action="/grade/total2" method="post">
	국어: <input type="text" name="kor"><br>
	영어: <input type="text" name="eng"><br>
	수학: <input type="text" name="math"><br>
	<button type="submit">입력</button>
	<button type="reset">취소</button>
	</form>
</body>
</html>
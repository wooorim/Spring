<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="700" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>사원번호</td>
			<td>이름</td>
			<td>직업</td>
			<td>메니져</td>
			<td>입사</td>
			<td>급여</td>
			<td>보너스</td>
			<td>부서번호</td>
		</tr>
		<c:forEach var="emp" items="${emps}">
			<tr>
				<td><c:forEach begin="1" end="${emp.empno}"></c:forEach> 
				<a href="/emp/emp_info?empno=${emp.empno}">${emp.empno}</a>
				</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.mgr}</td>
				<td>${emp.hireDate}</td>
				<td>${emp.sal}</td>
				<td>${emp.comm}</td>
				<td>${emp.deptno}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#emp-table .emp{
		text-align: center;
	}
</style>
<body>
	<table id="emp-table" width="500" cellpadding="0" cellspacing="0" border="1">
      <form action="modify" method="post">
         <input type="hidden" name="empno" value="${emp_info.empno}">
         <tr>
            <td class="emp"> 사원번호 </td>
            <td> ${emp_info.empno} </td>
         </tr>
         <tr>
            <td class="emp"> 이름 </td>
            <td> ${emp_info.ename} </td>
         </tr>
         <tr>
            <td class="emp"> 직업 </td>
            <td> ${emp_info.job} </td>
         </tr>
         <tr>
            <td class="emp"> 메니져 </td>
            <td> ${emp_info.mgr} </td>
         </tr>
         <tr>
            <td class="emp"> 입사 </td>
            <td> ${emp_info.hireDate} </td>
         </tr>
         <tr>
            <td class="emp"> 급여 </td>
            <td> ${emp_info.sal} </td>
         </tr>
         <tr>
            <td class="emp"> 보너스 </td>
            <td> ${emp_info.comm} </td>
         </tr>
         <tr>
            <td class="emp"> 부서번호 </td>
            <td> ${emp_info.deptno} </td>
         </tr>
         
         <tr>
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="emp_list">목록보기</a> &nbsp;&nbsp; <a id="a-delete">삭제</a> &nbsp;&nbsp; <a href="reply_view?empno=${info.empno}">답변</a></td>
         </tr>
      </form>
   </table>
</body>
</html>
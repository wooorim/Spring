package edu.global.ex.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.global.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmpDAO {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";

	public EmpDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<EmpVO> empSelect() {
		List<EmpVO> emp = new ArrayList<EmpVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		try {
	         String sql = "select * from emp";
	         
	         con = DriverManager.getConnection(url, uid, upw);         
	         stmt = con.createStatement();
	         resultSet = stmt.executeQuery(sql);
	         
	         while(resultSet.next()) {
	            int empno = resultSet.getInt("empno");
	            
	            String ename = resultSet.getString("ename");
	            String job = resultSet.getString("job");
	            int mgr = resultSet.getInt("mgr");
	            
	            Date hireDate = resultSet.getDate("hireDate");
	                  
	            int sal = resultSet.getInt("sal");
	            int comm = resultSet.getInt("comm");
	            int deptno = resultSet.getInt("deptno");
	            
	            EmpVO vo = new EmpVO(empno, ename, job, mgr, hireDate, sal, comm, deptno);
	            emp.add(vo);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(resultSet != null) 
	               resultSet.close();
	            
	            if(stmt != null) 
	               stmt.close();
	            
	            if(con != null) 
	               con.close();
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return emp;      

}
	
	public EmpVO infoView(int empno){
	      EmpVO empVO = null;
	      
	      Connection connection = null;
	      PreparedStatement preparedStatement = null;
	      ResultSet resultSet = null;
	      
	      try {
	         String query = "select * from emp where empno = ?"; 
	         
	         connection = DriverManager.getConnection(url,uid, upw);
	         preparedStatement = connection.prepareStatement(query);
	         
	         preparedStatement.setInt(1, empno);         
	         resultSet = preparedStatement.executeQuery();
	         
	         while(resultSet.next()) {
	            
	            int no = resultSet.getInt("empno");
	            
	            String ename = resultSet.getString("ename");
	            String job = resultSet.getString("job");
	            int mgr = resultSet.getInt("mgr");
	            
	            Date hireDate = resultSet.getDate("hireDate");
	                  
	            int sal = resultSet.getInt("sal");
	            int comm = resultSet.getInt("comm");
	            int deptno = resultSet.getInt("deptno");
	            
	            empVO = new EmpVO(no, ename, job, mgr, hireDate, sal, comm, deptno);
	         }   
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         
	         try {
	            if(resultSet != null) 
	               resultSet.close();
	            
	            if(preparedStatement != null) 
	               preparedStatement.close();
	            
	            if(connection != null) 
	               connection.close();
	            
	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }   
	      
	      return empVO;      
	   }
}	


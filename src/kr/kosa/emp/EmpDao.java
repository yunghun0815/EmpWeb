package kr.kosa.emp;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import kr.kosa.web.EmpVo;



public class EmpDao {
	public EmpDao(ServletContext application) {
		this.url = application.getInitParameter("OracleURL");
		this.id = application.getInitParameter("OracleId");
		this.pwd = application.getInitParameter("OralcePwd");
	}
	
	DataSource dataSource;
	public EmpDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource) initCtx.lookup("java:comp/env/dbcp_myoracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			System.out.println("드라이버 클래스가 로드되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스 로드 실패");
			e.printStackTrace();
		}
	}
	*/
	private String url; // = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id; // = "hr";
	private String pwd; // = "hr";
	
	public int getEmpCount() {
		int count = 0;
		// Connection 생성
		Connection con = null;
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			con = dataSource.getConnection();
			System.out.println(con);
			String sql = "select count(*) from employees";
			PreparedStatement stmt = con.prepareStatement(sql); //객체 생성
			ResultSet rs = stmt.executeQuery(); //executeQuery의 return 값은 ResultSet
			if(rs.next()) {
				count = rs.getInt(1); //첫 번째 select 절에 있는 값
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return count;
	}
	
	public int getEmpCount(int deptno) {
		int count = 0;
		// Connection 생성
		Connection con = null;
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			con = dataSource.getConnection();
			System.out.println(con);
			String sql = "select count(*) from employees where department_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql); //객체 생성
			stmt.setInt(1, deptno);
			ResultSet rs = stmt.executeQuery(); //executeQuery의 return 값은 ResultSet
			if(rs.next()) {
				count = rs.getInt(1); //첫 번째 select 절에 있는 값
			}
			System.out.println("사원의 수 : " + count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return count;
	}
	
	
	
	
	//테이블 테스트
	public ResultSet getEmployeeId(){
		
		Connection con = null;
		ResultSet rs = null;
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			con = dataSource.getConnection();
			String sql = "select employee_id, first_name, salary, department_id from employees";
			PreparedStatement stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	public int getAverageSalaryByDepartment() {
		int count = 0;
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select avg(salary) from employees";
			PreparedStatement stmt = con.prepareStatement(sql); //객체 생성
			ResultSet rs = stmt.executeQuery(); //executeQuery의 return 값은 ResultSet
			if(rs.next()) {
				count = rs.getInt(1); //첫 번째 select 절에 있는 값
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		
		return count;
	}
	public int getAverageSalaryByDepartment(int deptno) {
		int count = 0;
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select avg(salary) from employees where department_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql); //객체 생성
			stmt.setInt(1, deptno);
			ResultSet rs = stmt.executeQuery(); //executeQuery의 return 값은 ResultSet
			if(rs.next()) {
				count = rs.getInt(1); //첫 번째 select 절에 있는 값
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		
		return count;
	}
	/*public int getSalaryByEmployeeId(int empId) {
		int result = 0;
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select salary from employees where employee_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql); //객체 생성
			stmt.setInt(1, empId);
			ResultSet rs = stmt.executeQuery(); //executeQuery의 return 값은 ResultSet
			if(rs.next()) {
				result = rs.getInt(1); //첫 번째 select 절에 있는 값
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		
		return result;
	}*/
	
	public int getSalaryByEmployeeId(int empid) {
		int result= 0;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select salary from employees where employee_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, empid);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {if(con!=null)try{con.close();}catch(Exception e) {}}
		return result;
	}
	
	public String getDepartmentNameByEmployeeId(int empid) {
		String result = null;
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			//String sql = "select first_name from employees where employee_id = ?";
			String sql = "select d.department_name from employees e join departments d on e.department_id = d.department_id where employee_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, empid);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public EmpVo getEmpDetails(int empid) {
		EmpVo emp = new EmpVo();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary,"
					+ " commission_pct, manager_id, department_id from employees where employee_id = ?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, empid);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}else {
				emp = null;
			}
		}catch(Exception e){
			throw new RuntimeException();
		}finally {
			if(con!=null)try { con.close();}catch(Exception e) {}
		}
		return emp;
	}
}


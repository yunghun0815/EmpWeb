package kr.kosa.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.kosa.web.EmpVo;



public class EmpCrudDao {
	
	private String url; 
	private String id; 
	private String pwd; 
	
	DataSource dataSource;
	
	public EmpCrudDao() {
		try {
			Context initCtx = new InitialContext();
			dataSource = (DataSource) initCtx.lookup("java:comp/env/dbcp_myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<EmpVo> getAllEmps(){
		List<EmpVo> list = new ArrayList();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from employees";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				EmpVo vo = new EmpVo();
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setLastName(rs.getString("last_name"));
				vo.setCommissionPct(rs.getDouble("commission_pct"));
				vo.setDepartmentId(rs.getInt("department_id"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getDate("hire_date"));
				vo.setJobId(rs.getString("job_id"));
				vo.setManagerId(rs.getInt("manager_id"));
				vo.setPhoneNumber(rs.getString("phone_number"));
				vo.setSalary(rs.getDouble("salary"));
				list.add(vo);
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e){}
		}
		
		return list;
	}
	
	public void insertEmp(EmpVo vo) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, vo.getEmployeeId());
			stmt.setString(2, vo.getFirstName());
			stmt.setString(3, vo.getLastName());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getPhoneNumber());
			stmt.setDate(6, vo.getHireDate());
			stmt.setString(7, vo.getJobId());
			stmt.setDouble(8, vo.getSalary());
			stmt.setDouble(9, vo.getCommissionPct());
			stmt.setInt(10, vo.getManagerId());
			stmt.setInt(11, vo.getDepartmentId());
			stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("error");
		}finally {
			if(con!=null) try {con.close();} catch(Exception e){}
		}
	}
	
	public List<Map<String, Object>> getJobId(){
		List<Map<String, Object>> jobIdList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select job_id, job_title from jobs";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String jobId = rs.getString("job_id");
				String jobTitle = rs.getString("job_title");
				Map<String, Object> map = new HashMap<>();
				map.put("jobId", jobId);
				map.put("jobTitle", jobTitle);
				jobIdList.add(map);
				
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return jobIdList;
	}
	
	public List<Map<String, Object>> getEmpId(){
		List<Map<String, Object>> empIdList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select employee_id, first_name || ' ' || last_name as name from employees";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String empId = rs.getString("employee_id");
				String name = rs.getString("name");
				Map<String, Object> map = new HashMap<>();
				map.put("empId", empId);
				map.put("name", name);
				empIdList.add(map);
				
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return empIdList;
	}
	
	public List<Map<String, Object>> getDeptId(){
		List<Map<String, Object>> deptIdList = new ArrayList<>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select department_id, department_name from departments";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String deptId = rs.getString("department_id");
				String deptName = rs.getString("department_name");
				Map<String, Object> map = new HashMap<>();
				map.put("deptId", deptId);
				map.put("deptName", deptName);
				deptIdList.add(map);
				
			}
		}catch(Exception e) {
			throw new RuntimeException();
		}finally {
			if(con!=null) try {con.close();} catch(Exception e) {}
		}
		return deptIdList;
	}

	public void updateEmp(EmpVo vo) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "update employees set"
					+ " first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, "
					+ "salary = ?, commission_pct = ?, manager_id = ?, department_id = ? "
					+ "where employee_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, vo.getFirstName());
			stmt.setString(2, vo.getLastName());
			stmt.setString(3, vo.getEmail());
			stmt.setString(4, vo.getPhoneNumber());
			stmt.setDate(5, vo.getHireDate());
			stmt.setString(6, vo.getJobId());
			stmt.setDouble(7, vo.getSalary());
			stmt.setDouble(8, vo.getCommissionPct());
			stmt.setInt(9, vo.getManagerId());
			stmt.setInt(10, vo.getDepartmentId());
			stmt.setInt(11, vo.getEmployeeId());
			stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("error");
		}finally {
			if(con!=null) try {con.close(); } catch(Exception e){}
		}
	}

	public void deleteEmp(int empid, String email) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql0 = "delete job_history where employee_id = ?";
			PreparedStatement stmt0 = con.prepareStatement(sql0);
			stmt0.setInt(1, empid);
			stmt0.executeUpdate();
			
			String sql = "delete from employees where employee_id = ? and email = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, empid);
			stmt.setString(2, email);
			stmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("error");
		}finally {
			if(con!=null) try {con.close(); } catch(Exception e){}
		}
		
	}
	
}
package kr.kosa.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosa.emp.EmpDao;

/**
 * Servlet implementation class EmpServlet
 */
//@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDao dao = new EmpDao();
	String email = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
	//	email = config.getInitParameter("email");
	//	System.out.println("이메일 주소 : " + email);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String view = "/";  
		
		if("empcount".equals(cmd)) {
			//사원의 수 조회
			String deptStr = request.getParameter("deptid");
			if(deptStr==null) {
				int empcount = dao.getEmpCount();
				request.setAttribute("empcount", empcount);
			}else {
				int deptid = Integer.parseInt(deptStr);
				request.setAttribute("empcount", dao.getEmpCount(deptid));
			}
			view = "/emp/empcount.jsp";
		}else if("getdept".equals(cmd)) {
			//사원의 부서이름 조회
			String empStr = request.getParameter("empid");
			if(empStr !=null) {
				int empid = Integer.parseInt(empStr);
				request.setAttribute("result", dao.getDepartmentNameByEmployeeId(empid));
			}else {
				request.setAttribute("result", "사원번호가 전달되어야 합니다.");
			}
			view = "/emp/getdept.jsp";
		}else if("avgsal".equals(cmd)) {
			//부서의 평균 급여 조회
			String deptStr = request.getParameter("deptid");
			if(deptStr != null) {
				int deptid = Integer.parseInt(deptStr);
				request.setAttribute("result", dao.getAverageSalaryByDepartment(deptid));
			}else {
				request.setAttribute("result", "부서번호가 전달되어야 합니다.");
			}
			view = "/emp/avgsal.jsp";
		}else if("empsal".equals(cmd)) {
			//사원의 급여 조회
			String empStr = request.getParameter("empid");
			if(empStr != null) {
				int empid = Integer.parseInt(empStr);
				request.setAttribute("result", dao.getSalaryByEmployeeId(empid));
			}else {
				request.setAttribute("result", "사원번호가 전달되어야 합니다.");
			}
			view = "/emp/empsal.jsp";
		}else if("empdetail".equals(cmd)) {
			String empStr = request.getParameter("empid");
			if(empStr != null) {
				int empid = Integer.parseInt(empStr);
				request.setAttribute("result", dao.getEmpDetails(empid));
			}else {
				request.setAttribute("result", "사원번호가 전달되어야 합니다.");
			}
			view = "/emp/empdetail.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}
}

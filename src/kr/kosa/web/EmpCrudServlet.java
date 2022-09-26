package kr.kosa.web;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kosa.emp.EmpCrudDao;
import kr.kosa.emp.EmpDao;

public class EmpCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpCrudDao dao = new EmpCrudDao();
	EmpDao empdao = new EmpDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		
		String view = "/index.jsp";
		
		
		if("/EmpList.do".equals(path)) { 
			//모든 사원의 정보 조회
			//DAO 메서드 호출
			//request에 정보 저장
			request.setAttribute("list", dao.getAllEmps());
			//뷰로 포워드(뷰 경로를 저장)
			view = "/WEB-INF/view/empcrud/emplist.jsp";
		}else if("/EmpInsert.do".equals(path)) {
			request.setAttribute("jobIdList", dao.getJobId());
			request.setAttribute("empIdList", dao.getEmpId());
			request.setAttribute("deptIdList", dao.getDeptId());
			view = "/WEB-INF/view/empcrud/empform.jsp";
		}else if("/EmpUpdate.do".equals(path)) {
			String empidStr = request.getParameter("empid");
			int empid = Integer.parseInt(empidStr);
			request.setAttribute("jobIdList", dao.getJobId());
			request.setAttribute("empIdList", dao.getEmpId());
			request.setAttribute("deptIdList", dao.getDeptId());
			request.setAttribute("emp", empdao.getEmpDetails(empid));
			view = "/WEB-INF/view/empcrud/updateform.jsp";
		}else if("/EmpDelete.do".equals(path)) {
			view = "/WEB-INF/view/empcrud/empdeleteform.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String path = uri.substring(lastIndex);
		String view = "index.jsp";
		if("/EmpInsert.do".equals(path)) {
			EmpVo vo = new EmpVo();
			vo.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			vo.setFirstName(request.getParameter("firstName"));
			vo.setLastName(request.getParameter("lastName"));
			vo.setEmail(request.getParameter("email"));
			vo.setPhoneNumber(request.getParameter("phoneNumber"));
			vo.setHireDate(Date.valueOf(request.getParameter("hireDate"))); // jdk 1.8버전부터 가능
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// new Date(sdf.parse(hireDate).getTime()); -> String 
			vo.setJobId(request.getParameter("jobId"));
			vo.setSalary(Double.parseDouble(request.getParameter("salary")));
			vo.setCommissionPct(Double.parseDouble(request.getParameter("commissionPct")));
			vo.setManagerId(Integer.parseInt(request.getParameter("managerId")));
			vo.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
			dao.insertEmp(vo);
			
			response.sendRedirect("EmpList.do");
		}else if("/EmpUpdate.do".equals(path)) {
			//입력 처리
			EmpVo vo = new EmpVo();
			vo.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			vo.setFirstName(request.getParameter("firstName"));
			vo.setLastName(request.getParameter("lastName"));
			vo.setEmail(request.getParameter("email"));
			vo.setPhoneNumber(request.getParameter("phoneNumber"));
			vo.setHireDate(Date.valueOf(request.getParameter("hireDate"))); // jdk 1.8버전부터 가능
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// new Date(sdf.parse(hireDate).getTime()); -> String 
			vo.setJobId(request.getParameter("jobId"));
			vo.setSalary(Double.parseDouble(request.getParameter("salary")));
			vo.setCommissionPct(Double.parseDouble(request.getParameter("commissionPct")));
			vo.setManagerId(Integer.parseInt(request.getParameter("managerId")));
			vo.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
			System.out.println(vo.toString());
			
			dao.updateEmp(vo);
			
			response.sendRedirect("emp?cmd=empdetail&empid="+vo.getEmployeeId());
		}else if("/EmpDelete.do".equals(path)) {
			int empid = Integer.parseInt(request.getParameter("empid"));
			String email = request.getParameter("email");
			dao.deleteEmp(empid, email);
			
			response.sendRedirect("EmpList.do");
		}
		
	}
}
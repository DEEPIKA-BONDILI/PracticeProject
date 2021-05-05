package com.deptservlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dept.dao.Department;
import com.dept.dao.DepartmentDAOImpl;
import com.dept.dao.exception.DepartmentAlreadyExistException;
import com.dept.dao.exception.NoDepartmentFoundException;

/**
 * Servlet implementation class DeptPara
 */
public class DeptPara extends GenericServlet {
	private static final long serialVersionUID = 1L;
       DepartmentDAOImpl ddi = new DepartmentDAOImpl();
       /**
     * @see GenericServlet#GenericServlet()
     */
    public DeptPara() {
        super();
        System.out.println("Deptpara constructor");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method...");
		System.out.println("init called..");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy...");
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Department servlet...service()..called");
		/*int dno = Integer.parseInt(request.getParameter("v_deptno"));
		String dname = request.getParameter("v_dname");
		String dloc = request.getParameter("v_deptloc");
		PrintWriter pw = response.getWriter();
		pw.println("<table border=5 cellpadding=10 cellspacing=10>");
		pw.println("<tr>");
		    pw.println("<td>"+dno+"</td>");
		    pw.println("<td>"+dname+"</td>");
		    pw.println("<td>"+dloc+"</td>");
		pw.println("</table>");   */
		
		String buttonValue = request.getParameter("submit");
		PrintWriter pw = response.getWriter();
		pw.println("Button clicked value is "+buttonValue);
		
		if(buttonValue.equals("submit Info"))
		{
			int dno = Integer.parseInt(request.getParameter("v_deptno")); 
			String dnm = request.getParameter("v_dname");
			String dloc = request.getParameter("v_deptloc");
		
			Department deptObj = new Department(); 
			deptObj.setDepartmentName(dnm); 
			deptObj.setDepartmentLocation(dloc); 
		    try {
			ddi.addDepartment(deptObj);
			pw.println("<h4>Department is added to the database</h4>");
		    }
		    catch(DepartmentAlreadyExistException e)
		    {
		    	pw.println("<h4>Department add issue : "+e.getMessage()+"<h4>");
		    }
		}
		else if (buttonValue.equals("Find Dept"))
		{
			int dno = Integer.parseInt(request.getParameter("v_deptno")); 
			try {
			Department deptObj = ddi.findDepartment(dno);
			pw.println("<table border=5 cellpadding=10 cellspacing=10>");
			pw.println("<tr>");
				pw.println("<td>"+deptObj.getDepartmentNumber()+"</td>");
				pw.println("<td>"+deptObj.getDepartmentName()+"</td>");
				pw.println("<td>"+deptObj.getDepartmentLocation()+"</td>");
			pw.println("</tr>");
			pw.println("</table>");
		}
			catch(Exception e)
		    {
		    	//pw.println("<h4>Department Finding issue : "+e.getMessage()+"<h4>");
				pw.println("<h4>Department modify issue:Department cannot found"+"</h4>");
		    }
	}
		
		
		else if(buttonValue.equals("Find All Depts")) 
		{
			pw.println("<table border=1 cellspacing=10 cellpadding=10>");
			pw.println("<th>");		pw.println("DEPT NO");	pw.println("</th>");
			pw.println("<th>");		pw.println("DEPT NAME");pw.println("</th>");
			pw.println("<th>");		pw.println("LOCATION"); pw.println("</th>");
			List<Department> deptList = ddi.findDepartments();
			Iterator<Department> deptIter = deptList.iterator();
			
				while(deptIter.hasNext()) {
					Department deptObj = deptIter.next();
					pw.println("<tr>");
					
							pw.println("<td>");
								pw.println(deptObj.getDepartmentNumber());
							pw.println("</td>");
					
							pw.println("<td>");
								pw.println(deptObj.getDepartmentName());
							pw.println("</td>");

							pw.println("<td>");
								pw.println(deptObj.getDepartmentLocation());
							pw.println("</td>");
							
					pw.println("</tr>");
				}
			pw.println("</table>");
		}
		else if (buttonValue.equals("Modify Dept"))
		{
			
			int dno = Integer.parseInt(request.getParameter("v_deptno"));  
			String dnm = request.getParameter("v_dname");
			String dloc = request.getParameter("v_loc");
			Department deptObj = new Department(); 
			deptObj.setDepartmentNumber(dno);
			deptObj.setDepartmentName(dnm);
			deptObj.setDepartmentLocation(dloc);
			try {
			ddi.modifyDepartment(deptObj);
			pw.println("<h4> Department is modified</h4>");
			}
			catch(NoDepartmentFoundException e)
		    {
		    	pw.println("<h4>Finding Department issue : "+e.getMessage()+"<h4>");
		    }
		}
			
		else if (buttonValue.equals("Delete Dept"))
		{
			int dno = Integer.parseInt(request.getParameter("v_deptno"));  
			
			Department deptObj = new Department(); 
			deptObj.setDepartmentNumber(dno);
			try {
			ddi.removeDepartment(deptObj);
			pw.println("<h4> Department is deleted</h4>");
		   }
		catch(NoDepartmentFoundException e)
	    {
	    	pw.println("<h4>Finding Department issue : "+e.getMessage()+"<h4>");
	    }
		pw.println("<a href='http://localhost:8080/DepartmentParametersProject/'> Back to Welcome </a>");
				
	}
 }
}

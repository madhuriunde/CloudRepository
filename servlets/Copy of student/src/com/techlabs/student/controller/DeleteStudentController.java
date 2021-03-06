package com.techlabs.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.student.model.AddService;
import com.techlabs.student.model.DeleteService;
import com.techlabs.student.model.Student;

@WebServlet("/DeleteStudentController")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStudentController() {
		super();
	}

	private AddService addStudent = new AddService();

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DeleteService deleteStud = new DeleteService();

		RequestDispatcher rd = request
				.getRequestDispatcher("views/Delete.jsp");
		rd.include(request, response);

		String id = request.getParameter("studentID");
		deleteStud.deleteStudent(id);

		System.out.println("Record Deleted");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

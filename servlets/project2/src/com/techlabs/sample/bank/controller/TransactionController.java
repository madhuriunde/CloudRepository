package com.techlabs.sample.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.sample.bank.exception.InsufficientBalanceException;
import com.techlabs.sample.bank.model.Transaction;
import com.techlabs.sample.bank.model.TransactionService;

@WebServlet("/makeTransaction")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransactionService transactionService;

	public TransactionController() {
		super();
		transactionService = new TransactionService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/maketransaction.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String name = (String) request.getSession().getAttribute("name");

		try {
			transactionService
					.makeTransaction(new Transaction(name, amount, type));
			response.sendRedirect("displayTransactions");
		} catch (InsufficientBalanceException ex) {
			request.setAttribute("errorMsg", ex.getMessage());
			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/maketransaction.jsp");
			view.forward(request, response);
		}
	}

}

package demoJSTL;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoJSTL.model.Book;
import demoJSTL.services.BookService;

@WebServlet("/encontre")
public class FindController extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("encontre.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		
		BookService bs = new BookService();
		Book book = bs.fetchBook(nome);
		
		request.setAttribute("book", book);
		
		RequestDispatcher rd = request.getRequestDispatcher("encontre.jsp");
		rd.forward(request, response);
	}
}

package demoJSTL;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demoJSTL.model.Book;
import demoJSTL.services.BookService;

@WebServlet("/livros")
public class BookController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		
		Book book = new Book();
		book.setNome(nome);
		book.setAutor(autor);
		
		BookService bs = new BookService();
		bs.insertBook(book);
		response.sendRedirect("livros");
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bs = new BookService();
		List<Book> bookies = bs.fetchBookies();
		
		request.setAttribute("bookies", bookies);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
}

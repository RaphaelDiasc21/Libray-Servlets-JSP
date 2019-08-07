package demoJSTL.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import demoJSTL.dao.BookDAO;
import demoJSTL.model.Book;

public class BookService {
	private BookDAO bd;
	private List<Book> lb;
	
	public BookService() {
		this.bd = new BookDAO();
	}
	public void insertBook(Book book) {
		this.bd.insert(book);	
	}
	public List<Book> fetchBookies() {
		this.lb = this.bd.fetch();	
		return this.lb;
	}
	
	public Book fetchBook(String nome) {
		System.out.println("Dentro do service");
		return this.bd.findBook(nome);
	}
}

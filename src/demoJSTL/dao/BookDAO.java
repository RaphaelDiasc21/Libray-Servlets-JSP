package demoJSTL.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demoJSTL.model.Book;

public class BookDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private Statement stmts;

	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?useTimezone=true&serverTimezone=UTC", "root", "8625251@Ra");

			System.out.println("Connected");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insert(Book book) {
		try {
			this.stmt = this.conn.prepareStatement("INSERT INTO livros(nome,autor)VALUES(?,?)");
			this.stmt.setString(1, book.getNome());
			this.stmt.setString(2, book.getAutor());
			
			this.stmt.execute();
			this.stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Book> fetch(){
		ResultSet rs;
		List<Book> listBook = new ArrayList();
		try {
			this.stmts = this.conn.createStatement();
			rs = this.stmts.executeQuery("SELECT* from livros");
			System.out.println(rs);
			
			listBook = this.castList(rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				this.stmts.close();
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
		
		return listBook;
	}
	
	public Book findBook(String nome) {
		ResultSet rs;
		Book book = null;
		
		try {
			this.stmt = this.conn.prepareStatement("SELECT nome, autor FROM livros WHERE nome = ?");
			this.stmt.setString(1, nome);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				String titulo = result.getString("nome");
				String autor = result.getString("autor");
				
				System.out.println(autor);
				System.out.println(titulo);
				
				book = new Book();
				
				book.setAutor(autor);
				book.setNome(titulo);
			}

			
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return book;
	}
	
	private Book returnBook(ResultSet rs) {
		Book b = new Book();
		
		try {
			while(rs.next()) {
				String title = rs.getString("nome");
				String autor = rs.getString("autor");
							
				b.setNome(title);
				b.setAutor(autor);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.getAutor());
		return b;
	}
	
	private List<Book> castList(ResultSet rs){
		List<Book> listBook = new ArrayList();
		try {
			while(rs.next()) {
				String title = rs.getString("nome");
				String autor = rs.getString("autor");
				
				Book b = new Book();
				b.setNome(title);
				b.setAutor(autor);
				
				listBook.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listBook);
		return listBook;
	}
}

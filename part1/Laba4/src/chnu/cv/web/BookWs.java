package chnu.cv.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookWs {
	private Connection getConnection() throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true", 
	        		"root",
	                "1234");
	        return conn;
	}
	
	
	public List<Book> getBooks() {
		try {
			List<Book> books = new ArrayList<>();
			Connection connection = getConnection();
			
			ResultSet rs = connection.createStatement().executeQuery("SELECT b.id, b.name\r\n" + 
					"FROM books as b\r\n" + 
					"INNER JOIN authors as a\r\n" + 
					"    ON b.id = a.id\r\n" + 
					"INNER JOIN book_author bk\r\n" + 
					"    ON a.id = bk.fk_author\r\n" + 
					"group BY `name`\r\n" + 
					"ORDER BY COUNT(*) DESC");
			
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(getAuthorByBookId(rs.getLong("id")));
				books.add(book);
			}
			rs.close();
			connection.close();
			
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Set<Author> getAuthorByBookId(Long id) {
		try {
			Set<Author> authors = new HashSet<>();
			Connection connection = getConnection();
			
			ResultSet rs = connection.createStatement().executeQuery("SELECT authors.id, authors.name\r\n" + 
					"  FROM authors, books, book_author\r\n" + 
					"  WHERE book_author.fk_book = books.id \r\n" + 
					"  AND book_author.fk_author = authors.id\r\n" + 
					"  AND books.id = '" + id + "'");
			
			while (rs.next()) {
				Author author = new Author();
				author.setName(rs.getString("name"));
				authors.add(author);
			}
			rs.close();
			connection.close();
			
			return authors;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Book> getBooksByAuthor(String author) {
		try {
			List<Book> books = new ArrayList<>();
			Connection connection = getConnection();
			
			ResultSet rs = connection.createStatement().executeQuery("SELECT books.id, books.name\r\n" + 
					"  FROM authors, books, book_author\r\n" + 
					"  WHERE book_author.fk_book = books.id \r\n" + 
					"  AND book_author.fk_author = authors.id\r\n" + 
					"  AND authors.name = '" + author + "'");
					
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				
				books.add(book);
			}
			
			rs.close();
			connection.close();
			
			return books;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
}

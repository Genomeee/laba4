package chnu.cv.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import chnu.cv.web.BookWsStub.Book;
import chnu.cv.web.BookWsStub.GetBooksByAuthor;

import java.util.Arrays;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
    	
    	String author = request.getParameter("author");
    	
    	BookWsStub bookWsStub = new BookWsStub("http://localhost:8080/Laba4/services/BookWs?wsdl");
    	GetBooksByAuthor getBooksByAuthor = new GetBooksByAuthor();
    	getBooksByAuthor.setAuthor(author);
    	
    	Book[] books = bookWsStub.getBooksByAuthor(getBooksByAuthor).get_return();
    	request.setAttribute("booksByAuthor", Arrays.asList(books));
    
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
    	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

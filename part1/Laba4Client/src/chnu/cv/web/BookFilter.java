package chnu.cv.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chnu.cv.web.BookWsStub.Book;
import chnu.cv.web.BookWsStub.GetBooks;

/**
 * Servlet Filter implementation class BooksFilter
 */
public class BookFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BookFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		BookWsStub bookWsStub = new BookWsStub("http://localhost:8080/Laba4/services/BookWs?wsdl");
		
		GetBooks getBooks = new GetBooks();
		
		Book[] booksArray = bookWsStub.getBooks(getBooks).get_return();
		
		request.setAttribute("books", Arrays.asList(booksArray));
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

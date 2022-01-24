package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRA_App;
import datatypes.TimeData;


public class RUserGUIaddMovie extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		 
		request.setAttribute("navtype", "registered user");
		request.setAttribute("pagetitle", "Add Movie");

		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageRUser.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "registered user");

		// Check whether the call is insertOffer or not
		if (request.getParameter("action").equals("Add Movie")) {

			// Append parameter of request
			String title = (String) request.getParameter("title");
			String director = (String) request.getParameter("director");
			String actors =(String) request.getParameter("actors");
			TimeData publishingDate = (String) request.getParameter("publishingDate");
			
		  
			if(new MRA_App().forwardAddNewMovie(title, director, actors, publishingDate)==true) {
 
		   try {
	 		    request.setAttribute("pagetitle", "Add Movie");
			    request.setAttribute("message", "Add success");
				request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}}
			
			if(new MRA_App().forwardAddNewMovie(title, director, actors, publishingDate)==false) {
				 
				   try {
			 		    request.setAttribute("pagetitle", "add");
					    request.setAttribute("message", "AddMovie failed");
						request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request, response);

					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}}
			
					
			
		} else
			doGet(request, response);

	}
}
	
	
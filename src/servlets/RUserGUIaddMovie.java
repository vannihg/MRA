package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRAApplication;
import datatypes.TimeData;

public class RUserGUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("navtype", "registereduser");
		request.setAttribute("pagetitle", "addmovie");
		
		try {
			request.getRequestDispatcher("/templates/defaultWebpageRUser.ftl").forward(request, response);
			
		}
		catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("navtype", "registereduser");

	
	if (request.getParameter("action").equals("addmovie")) {
		String title = (String) request.getParameter("title");
		String director = (String) request.getParameter("director");
		String actors = (String) request.getParameter("actors");
		String daystr = (String) request.getParameter("day");
		int day = Integer.parseInt(daystr);
		String monthstr = (String) request.getParameter("month");
		int month = Integer.parseInt(monthstr);
		String yearstr = (String) request.getParameter("year");
		int year = Integer.parseInt(yearstr);
		String midstr = (String) request.getParameter("mid");
		int mid =Integer.parseInt(midstr);
		
		if (new MRAApplication().forwardAddNewMovie(title, director, actors, new TimeData(day, month,year), mid) == true) {
			try {
				request.setAttribute("pagetitle", "addmovie");
			    request.setAttribute("message", "Add Movie OK");
				request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);
			}
			catch (ServletException | IOException e) {
				e.printStackTrace();
				
			}
		}
		
		if (new MRAApplication().forwardAddNewMovie(title, director, actors, new TimeData(day, month,year), mid) == false) {
			try {
				request.setAttribute("pagetitle", "addmovie");
			    request.setAttribute("message", "Add Movie Failed");
				request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request, response);
			}
			catch (ServletException | IOException e) {
				e.printStackTrace();
			}
				
			}
	
} else {
	doGet(request, response);
}
}
}
	

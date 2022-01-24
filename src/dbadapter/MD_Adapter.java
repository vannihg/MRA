package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import datatypes.TimeData;
import interfaces.IMovieDatabase;

public class MD_Adapter implements IMovieDatabase {
	private static MD_Adapter instance;
	
	/**
	 * Constructor which loads the corresponding driver for the chosen database type
	 */
	private MD_Adapter() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MD_Adapter getInstance() {
		if (instance == null) {
			instance = new MD_Adapter();
		}

		return instance;
	}

	public static void setInstance(MD_Adapter dbfacade) {
		instance = dbfacade;
	}
	
	
	
	public boolean rate(int rating, int uid, int mid, String comment) {
		 
		String sqlInsert = "INSERT INTO mydb01.rate (rating,uid,mid,comment) VALUES (?,?,?,?)";
        
		Boolean valid=check_rate(rating,uid,mid,comment);
		if(valid)
		{
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mydb01")) {
            
			try (PreparedStatement ps = connection.prepareStatement(sqlInsert)) {
				ps.setInt(1, rating);
				ps.setInt(2, uid);
				ps.setInt(3, mid);
				ps.setString(3, comment);
				ps.executeUpdate();
				 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  } catch (Exception e) {
			  e.printStackTrace();}
		  return true;
		}else {
		return false;}
		 
}
	
	
	public boolean check_rate(int rating, int uid, int mid, String comment){
		 if(rating == 0 & comment == ""){ 
			 return true;
			 }
		 else
			 return false;
		 
		}
	
	
	
	public boolean addMovie(String title, String director, String actors, TimeData publishingDate, int mid) {
		String sqlInsert = "INSERT INTO mydb.01.movie (title, director, actors, publishingDate, mid) VALUES (?,?,?,?,?)";
		
		Boolean notExist = check_movie(title, director, actors, publishingDate, mid);
		if (notExist) {
			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/mydb01")){
				try (PreparedStatement ps = connection.prepareStatement(sqlInsert)) {
					ps.setString(1, title);
					ps.setString(2, director);
					ps.setString(3, actors);
					ps.setInt(4, publishingDate.getDay());
					ps.setInt(5, publishingDate.getMonth());
					ps.setInt(6, publishingDate.getYear());
					ps.setInt(7, mid);
					ps.executeUpdate();
				}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
				return true;
			
		} else {
			return false;
		}
		
		
		
	}
	
	public boolean check_movie(String title, String director, String actors, TimeData publishingDate, int mid) {
		if(publishingDate.getDay() == 0 & title == "") {
			return true;
			
		}
		else
			return false;
	}
}

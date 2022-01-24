package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interfaces.IUserDatabase;

public class UD_Adapter implements IUserDatabase{
	private static UD_Adapter instance;

	/**
	 * Constructor which loads the corresponding driver for the chosen database type
	 */
	private UD_Adapter() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static UD_Adapter getInstance() {
		if (instance == null) {
			instance = new UD_Adapter();
		}

		return instance;
	}

	public static void setInstance(UD_Adapter dbfacade) {
		instance = dbfacade;
	}

	
	public boolean addUser(String name, int age, String email) {
		 
		String sqlInsert = "INSERT INTO mydb01.user (name,age,email) VALUES (?,?,?)";
        
		Boolean valid=check_registration(age);
		if(valid)
		{
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mydb01")) {
            
			try (PreparedStatement ps = connection.prepareStatement(sqlInsert)) {
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, email);
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
    
	
	public boolean check_registration(int age) 
	{
		 if(age>=18)
		 { return true;}
		 else
			 return false;
		 
		}
}


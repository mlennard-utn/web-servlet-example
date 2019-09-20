package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionDB {

	public static void main(String[] args) {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "java", "Javaweb1!");) {
			
			//Statement stmt = connection.createStatement();
			//String query_no_param = "SELECT * FROM alumnos where edad";
			String query = "SELECT * FROM city where ID > ? and population < ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, 30);
			pstmt.setInt(2, 100000);
			
			ResultSet rs = pstmt.executeQuery();
			//ResultSet rs = stmt.executeQuery(query_no_param);
			
			int id, poblacion;
			String nombre;
			
			int numCols = rs.getMetaData().getColumnCount();
			String[] tipoDatos = new String[numCols];
			String[] nombreColumnas = new String[numCols];
			
			for (int i = 0; i < numCols; i++) {
				tipoDatos[i] = rs.getMetaData().getColumnTypeName(i+1);
				nombreColumnas[i] = rs.getMetaData().getColumnName(i+1);
			}
			
			for (int i = 0; i < numCols; i++) {
				System.out.println(nombreColumnas[i] + " es " + tipoDatos[i] );
			}
			
			while(rs.next()) {
				id = rs.getInt("ID");
	            nombre = rs.getString("Name");
	            
	            poblacion = rs.getInt("population");
	            System.out.println(String.format("id: %d, nombre: %s, poblacion: %d" , id, nombre, poblacion));  

			}
		
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} 	
			
		} catch (SQLException ex) {
			while(ex != null) {
		         System.out.println("SQLState:  " + ex.getSQLState());
		         System.out.println("Error Code:" + ex.getErrorCode());
		         System.out.println("Message:   " + ex.getMessage());
		         Throwable t = ex.getCause();
		         while(t != null) {
		             System.out.println("Cause:" + t);
		             t = t.getCause();
		         }
		         ex = ex.getNextException();
		    }

			return;
		}

		
	}

}
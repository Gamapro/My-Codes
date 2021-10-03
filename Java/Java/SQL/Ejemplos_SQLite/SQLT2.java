//Crear una tabla
import java.sql.*;

public class SQLT2
{
	public static void main(String args[])
	{
		Connection c = null;
		Statement stmt = null;
      
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Base de datos disponible");

			stmt = c.createStatement();
			String sql = "CREATE TABLE compania " +
							"(ID INT PRIMARY KEY     NOT NULL," +
							" nombre         TEXT    NOT NULL, " + 
							" edad           INT     NOT NULL, " + 
							" dir        	 CHAR, " + 
							" salario        REAL)"; 
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			System.out.println("Tabla creada exitosamente");
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return;
		}
	}
}
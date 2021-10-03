//Búsqueda
import java.sql.*;

public class SQLT4
{
	public static void main(String args[])
	{
		Connection c = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			System.out.println("Base de datos disponible");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM compania;" );

			while (rs.next())
			{
				int id = rs.getInt("id");
				String  name = rs.getString("nombre");
				int age  = rs.getInt("edad");
				String  address = rs.getString("dir");
				float salary = rs.getFloat("salario");
			 
				System.out.println( "ID = " + id );
				System.out.println( "Nombre = " + name );
				System.out.println( "Edad = " + age );
				System.out.println( "Direccion = " + address );
				System.out.println( "Salario = " + salary );
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			c.close();
			
			System.out.println("Lectura exitosa");
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return;
		}		
	}
}
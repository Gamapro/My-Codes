//Inserción
import java.sql.*;

public class SQLT3
{
	public static void main( String args[] )
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
			String sql = "INSERT INTO compania (ID,nombre,edad,dir,salario) " +
						"VALUES (1, 'Juan', 32, 'Tacambaro', 20000.00 );"; 
			stmt.executeUpdate(sql);

			sql = "INSERT INTO compania (ID,nombre,edad,dir,salario) " +
				  "VALUES (2, 'Luis', 25, 'San Miguel de Allende', 15000.00 );"; 
			stmt.executeUpdate(sql);

			sql = "INSERT INTO compania (ID,nombre,edad,dir,salario) " +
				  "VALUES (3, 'Tomas', 23, 'Aguascalientes', 20000.00 );"; 
			stmt.executeUpdate(sql);

			sql = "INSERT INTO compania (ID,nombre,edad,dir,salario) " +
				  "VALUES (4, 'Gustavo', 25, 'Cosio', 65000.00 );"; 
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return;
		}
			System.out.println("Registros insertados");
		}
}

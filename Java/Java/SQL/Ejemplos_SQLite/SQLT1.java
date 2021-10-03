// Primera conexión con la base de datos a través de JDBC
import java.sql.*;

public class SQLT1
{
	public static void main(String args[])
	{
		Connection c = null;
    
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Base de datos disponible");
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return;
		}
   }
}

// java -classpath ".;sqlite-jdbc-3.30.1.jar" SQLT    <adaptar según la versión>
// O extraer carpeta /org/

import java.sql.*;

public class añadir{

	public static void main(String args[]){
		Connection c = null;
		Statement stmt = null;

		try{
			Class.forName("org.sqlite.JDBC");  // Dar de alta el driver
			c = DriverManager.getConnection("jdbc:sqlite:iia.db");
			c.setAutoCommit(false);
			System.out.println("Conectado :D");
			stmt = c.createStatement();
			
			String datos = "INSERT INTO info (ID,nombres,apellidos,hobby,sabor) " +
						   "VALUES (0223826,'David Gamaliel','Arcos Bravo','Leer','Galleta');";
			stmt.executeUpdate(datos);
			stmt.close();
			c.commit();
			c.close();
			System.out.println("Datos insertados exitosamente");
		}catch(Exception err){
			System.err.println(err.getClass().getName() + ": " + err.getMessage());
		}

	}

}

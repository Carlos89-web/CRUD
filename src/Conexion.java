import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
	
	// Desarrollamos las variables

	private static final String URL = "jdbc:mysql://localhost:3306";
	private static final String USUARIO = "root";
	private static final String CLAVE = "968574";
	Connection conexion = null;
	Statement s = null;
	ResultSet rs = null;

	// Desarrollamos un método que nos permita establecer una conexión con nuestra base de datos

	public Conexion() {

		// Comenzamos creado una conexión con MySQL estableciendo URL, usuario y contraseña

		try {

			DriverManager.getConnection(URL, USUARIO, CLAVE);
			//System.out.println("Estamos conectados a la base de datos\n");

		} catch (SQLException e) {
			System.out.println("No hemos podido conectar con nuestra BD");
			e.printStackTrace();
		}

	}

	// Creamos un CRUD

	public boolean C(Producto pro, String tabla) {
		
		boolean rs = false;
		String consulta = "";

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", USUARIO, CLAVE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			s = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			consulta = "INSERT INTO "+tabla+" (id, nombre, precio, cantidad) " + "VALUES ('"+pro.getId()+"','"+pro.getNombre()+"','"+pro.getPrecio()+"','"+pro.getCantidad()+"')";
			
			rs = s.execute(consulta);
		} catch (SQLException e) {
			System.out.println("\nYa existe un producto con ese ID\n");
		}
		
		return rs;

	}

	public ArrayList<Producto> R(String consulta) {
		
		ArrayList<Producto> alu = new ArrayList<Producto>();
		Producto p = null;

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", USUARIO, CLAVE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			s = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			rs = s.executeQuery("SELECT * FROM productos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			while (rs.next()) {	
				
				p = new Producto(0, 0, consulta, 0);
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setCantidad(rs.getInt("cantidad"));
				p.setPrecio(rs.getFloat("precio"));
				
				alu.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alu;
	}

	public boolean U(Producto pro, String tabla) {
		
		boolean rs = false;
		String consulta = "";
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", USUARIO, CLAVE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			s = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			consulta = "UPDATE "+tabla+" SET id= '"+pro.getId()+"', nombre= '"+pro.getNombre()+"', precio= '"+pro.getPrecio()+"', cantidad= '"+pro.getCantidad()+"' WHERE id="+pro.getId();
			rs = s.execute(consulta);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;

	}

	public boolean D(String consulta) {
		
		boolean rs = false;
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", USUARIO, CLAVE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			s = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs = s.execute(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;

	}

}

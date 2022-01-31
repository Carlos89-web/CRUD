import java.util.ArrayList;
import java.util.Scanner;

public class Start {

	public static void insertarProductos(Conexion db) {

		// Creamos las variables para el método de creación de productos

		Scanner entrada = new Scanner(System.in);
		Producto pro = new Producto(0, 0, null, 0);

		System.out.println("Introduzca el identificador del producto: ");
		pro.setId(entrada.nextInt());
		System.out.println("Introduzca el nombre del producto: ");
		entrada.nextLine();
		pro.setNombre(entrada.nextLine());
		System.out.println("Introduzca el precio unitario del producto: ");
		pro.setPrecio(entrada.nextFloat());
		System.out.println("Introduzca la cantidad del producto: ");
		pro.setCantidad(entrada.nextInt());

		// Conectamos con la base de datos y le pasamos el producto

		if (db.C(pro, "productos")) {
			System.out.println("Producto creado correctamente\n");
		} 

	}

	public static void leerProductos(Conexion db) {
		
		// Creamos las variables para el método de creación de productos

		int i = 0;

		ArrayList<Producto> pro = new ArrayList<Producto>();
		
		// Conectamos con la base de datos y le pasamos el producto

		pro = db.R("SELECT * FROM productos");

		for (i = 0; i < pro.size(); i++) {

			System.out.println(
					"ID: " + pro.get(i).getId() + " | " + "Producto: " + pro.get(i).getNombre() + " | " + "Precio: "
							+ pro.get(i).getPrecio() + " € | " + "Cantidad: " + pro.get(i).getCantidad() + " unidades");

		}

	}

	public static void modificarProductos(Conexion db) {

		// Creamos las variables para el método de modificación de productos

		Scanner entrada = new Scanner(System.in);
		Producto pro = new Producto(0, 0, null, 0);

		System.out.println("Introduzca el identificador del producto: ");
		pro.setId(entrada.nextInt());
		System.out.println("Introduzca el nombre del producto: ");
		entrada.nextLine();
		pro.setNombre(entrada.nextLine());
		System.out.println("Introduzca el precio unitario del producto: ");
		pro.setPrecio(entrada.nextFloat());
		System.out.println("Introduzca la cantidad del producto: ");
		pro.setCantidad(entrada.nextInt());

		// Conectamos con la base de datos y le pasamos el producto modificado

		if (db.U(pro, "productos")) {

			System.out.println("Producto modificado correctamente\\n");
		}

		else {

			System.out.println("El producto no se ha podido modificar");
		}

	}

	public static void borrarProductos(Conexion db) {

		// Creamos las variables para el método de modificación de productos

		Scanner entrada = new Scanner(System.in);
		int id = 0;

		System.out.println("Introduzca el identificador del producto a eliminar: ");
		id = entrada.nextInt();

		// Conectamos con la base de datos y le pasamos el producto borrado

		if (db.D("DELETE FROM productos WHERE id = " + id)) {

			System.out.println("Producto borrado correctamente");
		}

		else {
			System.out.println("El producto no pudo ser eliminado");
		}

	}

	public static void main(String[] args) {

		// Creamos las variables para el menú

		Scanner entrada = new Scanner(System.in);
		int operacion = 0;

		// Leer productos

		Conexion db = new Conexion();

		do {

			System.out.println("------------------------------------");
			System.out.println("---------GESTOR DE TIENDA-----------");
			System.out.println("------------------------------------\n");

			System.out.println("Elija una opción");
			System.out.println("");
			System.out.println("1) Crear un nuevo producto");
			System.out.println("2) Listar todos los producto");
			System.out.println("3) Modificar producto");
			System.out.println("4) Borrar producto");
			System.out.println("0) Salir del programa");

			System.out.println("\nOpción: ");

			operacion = entrada.nextInt();

			if (operacion == 1) {

				// Crear producto

				insertarProductos(db);

			} else if (operacion == 2) {

				// Listar productos
				System.out.println("------------------------");
				leerProductos(db);
				System.out.println("------------------------\n");

			} else if (operacion == 3) {

				// Modificar producto

				System.out.println("\n------------------------");
				leerProductos(db);
				System.out.println("------------------------\n");
				modificarProductos(db);

			} else if (operacion == 4) {

				// Borrar producto

				System.out.println("\n------------------------");
				leerProductos(db);
				System.out.println("------------------------\n");
				borrarProductos(db);

			}

			else if (operacion != 0) {

				System.out.println("Opción errónea");
				System.out.println("");

			}

		} while (operacion != 0);

		System.out.println("------------------------");
		System.out.println("Programa finalizado.");
		System.out.println("------------------------\n");

	}

}

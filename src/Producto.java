
public class Producto {

	private int id;
	private float precio;
	private String nombre;
	private int cantidad;

	public Producto(int id, float precio, String nombre, int cantidad) {
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void C(Producto p) {
		
	}

}
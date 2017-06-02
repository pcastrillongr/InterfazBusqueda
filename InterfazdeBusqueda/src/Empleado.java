
public class Empleado {

	
	private String nombre;
	private float salario;
	private int antiguedad;
	private String puesto;
	
	public Empleado(){
		
		
	}
	
	public Empleado(String nombre, float salario, int antiguedad, String puesto) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.antiguedad = antiguedad;
		this.puesto = puesto;
	}

	public String getNombre() {
		return nombre;
	}

	public float getSalario() {
		return salario;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + ", antiguedad=" + antiguedad + ", puesto="
				+ puesto + "]";
	}
	
	
}

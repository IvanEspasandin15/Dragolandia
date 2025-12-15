package dragolandia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bosque")
public class Bosque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String nombre;
	
	private int nivelPeligro;
	
	@OneToOne
	private Monstruo monstruoJefe;
	
// Constructores ==================================================================================
	public Bosque() {}
	
	public Bosque(String nombre, int nivelPeligro, Monstruo monstruoJefe) {
		this.nombre = nombre;
		this.nivelPeligro = nivelPeligro;
		this.monstruoJefe = monstruoJefe;
	}
	
// Getters y Setters ==============================================================================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelPeligro() {
		return nivelPeligro;
	}

	public void setNivelPeligro(int nivelPeligro) {
		this.nivelPeligro = nivelPeligro;
	}

	public Monstruo getMonstruoJefe() {
		return monstruoJefe;
	}

	public void setMonstruoJefe(Monstruo monstruoJefe) {
		this.monstruoJefe = monstruoJefe;
	}
	
// To String ======================================================================================
	@Override
	public String toString() {
		return this.id + "-" + this.nombre + "-" + this.nivelPeligro;
	}
	
// Mostrar Jefe ===================================================================================
	public void mostrarJefe() {
		System.out.println("Jefe:");
		System.out.println(this.monstruoJefe);
	}
	
// CambiarJefe ====================================================================================
	public void cambiarJefe(Monstruo nuevoJefe) {
		this.monstruoJefe = nuevoJefe;
	}
}
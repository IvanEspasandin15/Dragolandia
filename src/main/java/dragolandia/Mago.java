package dragolandia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mago")
public class Mago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String nombre;
	
	private int vida;
	private int nivelMagia;
	
// Constructores ==================================================================================
	public Mago() {}
	
	public Mago(String nombre, int vida, int nivelMagia) {
		this.nombre = nombre;
		
		if (vida < 0) this.vida = 0;
		else this.vida = vida;
		
		if (nivelMagia < 0) this.nivelMagia = 0;
		else this.nivelMagia = nivelMagia;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if (vida < 0) this.vida = 0;
		else this.vida = vida;
	}

	public int getNivelMagia() {
		return nivelMagia;
	}

	public void setNivelMagia(int nivelMagia) {
		if (nivelMagia < 0) this.nivelMagia = 0;
		else this.nivelMagia = nivelMagia;
	}
	
// To String ======================================================================================
	@Override
	public String toString() {
		return this.id + "-" + this.nombre + "-" + this.vida + "-" + this.nivelMagia;
	}
	
// Lanzar Hechizo =================================================================================
	public void lanzarHechizo(Monstruo monstruo) {
		monstruo.setVida(monstruo.getVida() - this.nivelMagia);
	}
}
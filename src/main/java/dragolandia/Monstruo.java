package dragolandia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="monstruo")
public class Monstruo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String nombre;
	
	private int vida;
	private Tipo tipo;
	private int fuerza;
	
// Constructores ==================================================================================
	public Monstruo() {}
	
	public Monstruo(String nombre, int vida, Tipo tipo, int fuerza) {
		this.nombre = nombre;
		
		if (vida < 0) this.vida = 0;
		else this.vida = vida;
		
		this.tipo = tipo;
		
		if (fuerza < 0) this.fuerza = 0;
		else this.fuerza = fuerza;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		if (fuerza < 0) this.fuerza = 0;
		else this.fuerza = fuerza;
	}
	
// To String ======================================================================================
	@Override
	public String toString() {
		return this.id + "-" + this.nombre + "-" + this.vida + "-" + this.tipo + "-" + this.fuerza;
	}
	
// Atacar =========================================================================================
	public void atacar(Mago mago) {
		mago.setVida(mago.getVida() - this.fuerza);
	}
}
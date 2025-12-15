package dragolandia;

public enum Tipo {
	ogro,
	troll,
	espectro;
	
	@Override
    public String toString() {
        String nombre = name().toLowerCase();
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
    }
}
package dragolandia;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mago mago = new Mago();
		Monstruo monstruo = new Monstruo();
		boolean batallaAcabada = false;
		
// Crear Mago =====================================================================================
		System.out.print("Nombre del mago: ");
		mago.setNombre(sc.nextLine());
		System.out.print("Vida del mago: ");
		mago.setVida(sc.nextInt());
		System.out.print("Nivel de magia del mago: ");
		mago.setNivelMagia(sc.nextInt());
		sc.nextLine();
		System.out.println("\n");
		
// Crear Monstruo =================================================================================
		System.out.print("Nombre del monstruo: ");
		monstruo.setNombre(sc.nextLine());
		System.out.print("Vida del monstruo: ");
		monstruo.setVida(sc.nextInt());
		sc.nextLine();
		System.out.print("Tipo del monstruo (ogro, troll o espectro): ");
		String tipo = sc.nextLine();
		monstruo.setTipo(Tipo.valueOf(tipo));
		System.out.print("Fuerza del monstruo: ");
		monstruo.setFuerza(sc.nextInt());
		sc.nextLine();
		System.out.println("\n");
		
// Crear Bosque ===================================================================================
		System.out.print("Nombre del bosque: ");
		String nombreBosque = sc.nextLine();
		System.out.print("Nivel de peligro del bosque: ");
		int nivelPeligro = sc.nextInt();
		Bosque bosque = new Bosque(nombreBosque, nivelPeligro, monstruo);
		sc.close();
		System.out.println("\n");
		
// Batalla ========================================================================================
		System.out.println("¡Comienza la batalla!");
		System.out.println("===============================================================");
		System.out.println("");
		while (!batallaAcabada) {
			System.out.println(mago.getNombre() + " lanza un hechizo a " + bosque.getMonstruoJefe().getNombre() + ".");
			mago.lanzarHechizo(bosque.getMonstruoJefe());
			System.out.println(bosque.getMonstruoJefe().getNombre() + " tiene " + bosque.getMonstruoJefe().getVida() + " puntos de vida restantes.");
			if (bosque.getMonstruoJefe().getVida() == 0) {
				System.out.println(mago.getNombre() + " ha sobrevivido y domina el bosque de " + bosque.getNombre() + ".");
				batallaAcabada = true;
			}else {
				System.out.println("");
				System.out.println(bosque.getMonstruoJefe().getNombre() + " ataca a " + mago.getNombre() + ".");
				bosque.getMonstruoJefe().atacar(mago);
				System.out.println(mago.getNombre() + " tiene " + mago.getVida() + " puntos de vida restantes.");
				if (mago.getVida() == 0) {
					System.out.println(bosque.getMonstruoJefe().getNombre() + " ha sobrevivido y sigue siendo el jefe del bosque " + bosque.getNombre() + ".");
					batallaAcabada = true;
				}
			}
			System.out.println("");
			System.out.println("===============================================================");
			System.out.println("");
		}
		System.out.println("FIN DE LA BATALLA");
	}
}
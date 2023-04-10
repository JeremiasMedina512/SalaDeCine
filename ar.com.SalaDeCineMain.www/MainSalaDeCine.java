import java.util.Scanner;

public class MainSalaDeCine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ingresoTecla = new Scanner(System.in);
		int opciones = 0;
		
		SalaDeCine cinemax = new SalaDeCine();
		
		do {
			menu();
			opciones = ingresoTecla.nextInt();
			switch (opciones) {
			case 1:
				salaDeCineVacia(cinemax);
				break;
			case 2:
				consultarSiLaButacaSeEncuentraCopada(cinemax, ingresoTecla);
				break;
			case 3:
				seccionParaReservarButaca(cinemax, ingresoTecla);
				break;
			case 4:
				consultarCantidadDeAseintosOcupados(cinemax);
			default:
				break;
			}
		} while (opciones != 7);
	}

	private static void consultarCantidadDeAseintosOcupados(SalaDeCine cinemax) {
		// TODO Auto-generated method stub
		System.out.println("La cantidad de butacas ocupadas hasta ahora son: "+ cinemax.consultarCantidadDeButacasOcupadas());
	}

	private static void seccionParaReservarButaca(SalaDeCine cinemax, Scanner ingresoTecla) {
		// TODO Auto-generated method stub
		int filaRenglon = 0;
		int filaCalumna = 0;
		Persona persona = null;
		String nombre = " ";
		
		System.out.println("Ingrese los el numero de fila y asiento a reservar:");
		System.out.println("Numero de fila: ");
		filaRenglon = ingresoTecla.nextInt();
		System.out.println("Numero de columa");
		filaCalumna = ingresoTecla.nextInt();
		System.out.println("Ingrese el nombre de la persona");
		nombre = ingresoTecla.next();
		persona = new Persona (nombre);
		if (cinemax.ocuparButaca(filaRenglon, filaCalumna, persona)) {
			System.out.println("Asiento reservado");
		} else {
			System.out.println("No se puede reservar porque ya fue ocupado");
		}
		
		
		
	}

	private static void consultarSiLaButacaSeEncuentraCopada(SalaDeCine cinemax, Scanner ingresoTecla) {
		// TODO Auto-generated method stub
		int filaRenglon = 0;
		int filaCalumna = 0;

		System.out.println("Ingrese:");
		System.out.println("Numero de fila: ");
		filaRenglon = ingresoTecla.nextInt();
		System.out.println("Numero de columa");
		filaCalumna = ingresoTecla.nextInt();
		if (cinemax.elAsientoSeEncuenTraOcupado(filaRenglon, filaCalumna) == true) {
			System.out.println("El asiento se encuentra LIBRE");
		} else {
			System.out.println("El asiento se encuentra OCUPADO");
		}
	}

	private static void salaDeCineVacia(SalaDeCine cinemax) {
		// TODO Auto-generated method stub
		if (cinemax.laSalaSeEncuentraVacia() == true) {
			System.out.println("La encuentra se encuentra vacia");
		} else {
			System.out.println("La sala no se encuentra vacia");
		}

	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		System.out.println("Bienvenido a su Sala de Cine");
		System.out.println("Seleccione una Opcion");
		System.out.println("1 - Consultar si la sala esta vacia");
		System.out.println("2 - Consultar si la butaca esta vacia");
		System.out.println("3 - Ocupar butaca");
		System.out.println("4 - Consultar la cantidad de butacas ocupadas");
		System.out.println("0 - Salir");

	}

}

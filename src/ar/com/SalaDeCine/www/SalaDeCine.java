package ar.com.SalaDeCine.www;
public class SalaDeCine {
	private final int asientosMaximoEnHorizontal = 5;
	private final int asientosMaximosEnVertical = 5;
	Persona personaIntegrada;
	/*
	 * el primer cuadro corresponde al renglo y el segundo corresponde a las filas
	 */
	Persona asientosDeLaSalaDeCine[][];

	public SalaDeCine() {
		this.asientosDeLaSalaDeCine = new Persona [asientosMaximoEnHorizontal][asientosMaximosEnVertical];
	}

	public SalaDeCine(Persona personaIntegrada) {
		this();
		this.personaIntegrada = personaIntegrada;
	}
	
	public Persona[][] getAsientosDeLaSalaDeCine(){
		return this.asientosDeLaSalaDeCine;
	}

	public boolean laSalaSeEncuentraVacia() {
		// ITERAMOS RENGLONES Y COLUMNAS - SI EN ALGUNA COLUMNA ES DISTINTA DE NULL
		// LA SALA NO SE ENTRUENTA VACIA
		boolean estaVacia = false;
		for (int i = 0; i < asientosDeLaSalaDeCine.length; i++) {
			for (int j = 0; j < asientosDeLaSalaDeCine[i].length; j++) {
				if (asientosDeLaSalaDeCine[i][j] != null) {
					return estaVacia;
				}else if (i == asientosDeLaSalaDeCine.length -1 && j == asientosDeLaSalaDeCine[i].length-1 ) {
					estaVacia = true;
//					La condicion dentro de este else if SOLO se evalua y ejecuta cuando el for anidado llega a la
//					ultima ubicacion(en este caso : i = 4; j = 4).
//					Si se llega a este bloque eso quiere decir que la condicion del "for j" jamas se cumple
//					y por lo tanto jamas devulve "estaVacia" con el valor false.
				}
			}
		
		}
		return estaVacia;

	}

	public boolean elAsientoSeEncuenTraOcupado(int fila, int columna) {
		// ITERAMOS RENGLONES DE FILAS Y COLUMNAS
		// SI EL ASIENTO INDICADO SE ENCUENTRA ACUOPADO RETORNA TRUE
		if (asientosDeLaSalaDeCine[fila][columna] != null) {
			return true;
		}else {
			return false;
		}

	}

	public boolean ocuparButaca(int fila, int columna, Persona persona) {
		// ITEREAMOS NUEVAMENTE RENGLONES Y FILAS
		// SI EL ASIENTO NO ESTA OCUPADO LE ASIGNAMOS UN NUMERO AlEATORIO QUE ASEEJA UN
		// DENI
		for (int renglones = 0; renglones < asientosDeLaSalaDeCine.length; renglones++) {
			for (int filas = 0; filas < asientosDeLaSalaDeCine[renglones].length; filas++) {
				if (asientosDeLaSalaDeCine[fila][columna] == null) {
					this.asientosDeLaSalaDeCine[fila][columna] = persona;
					// retorna True para saber si se asigno un dato al array
					return true;
				}

			}
		}

		return false;
	}

	public int consultarCantidadDeButacasOcupadas() {
		int contadorDeColumnasUsadas = 0;
		for (int renglones = 0; renglones < asientosDeLaSalaDeCine.length; renglones++) {
			for (int columnas = 0; columnas < asientosDeLaSalaDeCine.length; columnas++) {
				if(asientosDeLaSalaDeCine[renglones][columnas] != null) {
					contadorDeColumnasUsadas++;
				}
			}
		}
		
		return contadorDeColumnasUsadas;
	}

}

package ENTREGAR;
import java.util.Scanner;
import java.util.Arrays;
public class ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DECLARAMOS VARIABLES
		Scanner sc = new Scanner(System.in);
		String[] burguers = {"Mexicana","Alioli","Cheeseburguer","Barbacoa"};
		for (int i = 0; i < 4; i++) {
			burguers[i] = burguers[i].toUpperCase();
		}
		String[] ingredients = {"carne , tomate, picante, pimiento",
								"carne, lechuga, bacon, alioli", 
								"carne,  cebolla, cheddar, lechuga, tomate, mahonesa",
								"carne, bacon, cebolla,cheddar, lechuga,tomate, mayonesa,barbacoa"
								};
		Double[] price = {8.50, 11.00, 12.50, 14.00};
		int[] stock = {12,8,23,15};
		int opcion;
		boolean salir = false;
		
		//HACEMOS EL MENU CON UN WHILE
		System.out.println("HAMBURGUESAS DISPONIBLES: " + Arrays.toString(burguers));

		while (!salir) {
			System.out.println("\n1.PEDIDO");
			System.out.println("2.LA HAMBURGUESA MAS BARATA");
			System.out.println("3.INFORMACION HAMBURGUESA");
			System.out.println("4.BUSCAR INGREDIENTES");
			System.out.println("5.DISMINUIR STOCK");
			System.out.println("6.HAMBURGUESAS POR PERSONA");
			System.out.println("7.SALIR \n");
			System.out.println("Elija una opcion");
			opcion=sc.nextInt();
			
		//CON EL SWITCH VAMOS A EJECUTAR OPERACIONES EN CADA OPCION QUE ELIJA
			switch (opcion) {
			case 1:
				//DEFINIMOS LAS VARIABLES QUE VAMOS A USAR
				String burga;
				String BURGA;
				int cantidad = 0;
				double preciofinal = 0;
				int posicion;
				boolean esta = false;
				while(true) {
				System.out.println("OPCION 1:\n");
				System.out.println("Dime que hamburguesa quieres");
				//AL PEDIR EL NOMBRE DE LA HAMBURGUESA, LA CONVERTIMOS EN MAYUSCULAS PARA MAS COMODIDAD
				burga=sc.next();
				BURGA=burga.toUpperCase();
				;
				//CON EL FOR RECORREMOS EL ARRAY DE HAMBURGUESAS
				//CON EL IF VERIFICAMOS SI LA HAMBURGUESA QUE PIDIO EL USUARIO SE ENCUENTRA EN NUESTRO MENÚ
				for (posicion = 0; posicion<burguers.length; posicion++) {
					if (BURGA.equals(burguers[posicion])) {
						System.out.println("Cuantas " + burguers[posicion] + " quieres?");
						cantidad=sc.nextInt();
						//PARA CALCULAR EL PRECIO DEL PEDIDO, MULTIPLICAMOS LA CANTIDAD QUE PIDE POR EL PRECIO DE LA HAMBURGUESA
						preciofinal=(cantidad*price[posicion]);
						esta=true;
						
						}
					}
				//EL USO DE BOOLEAN ES PARA MANTENERSE EN EL PROCESO POR SI INTRODUCE UN VALOR INCORRECTO
				if(esta == true) {
					System.out.println("Su pedido es de: " + preciofinal);
					break;
				}
				else {
					System.out.println("Esa hamburguesa no esta en el menu, intenta de nuevo\n");
				}
				}
				break;
				
			case 2:
				//AQUI SOLO MOSTRAMOS LA POSICIÓN DE LA HAMBURGUESA MAS BARATA
				System.out.println("OPCION 2:\n");
				System.out.println("La hamburguesa " + burguers[0] + " es la mas barata, cuesta: " + price[0]);
				break;
				
			case 3:
				System.out.println("OPCION 3:\n");
				while (true) {
				String burguer;
				String BURGUER;
				boolean encontrada = false;
				System.out.println("Dime la hamburguesa de la cual quieras saber sus ingredientes");
				burguer=sc.next();
				BURGUER=burguer.toUpperCase();
				//RECORREMOS EL ARRAY DE HAMBURGUESAS Y CON EL IF VERIFICAMOS QUE LA HAMBURGUESA QUE INGRESÓ, 
				//SE ENCUENTRA DENTRO DEL ARRAY
				for (int r = 0; r < burguers.length; r++) {
					if(BURGUER.equals(burguers[r])) {
						System.out.println("Sus ingredientes son: " + ingredients[r]);
						encontrada=true;
						break;
					}
				}
				if (encontrada) {
					break;
				}
					else {	
					System.out.println("Esa hamburguesa no esta en el menu, intenta de nuevo\n");
				}
			}
				break;
			case 4:
				System.out.println("OPCION 4:\n");
				//DEFINIMOS VARIABLES
				boolean search=false;
				String search2 = "";
				int i = 0;
				String buscaringre;
				boolean ingredientesi = false;
				while(true) {
				System.out.println("Ingrese un ingrediente");
				buscaringre=sc.next();
				//UTILIZAMOS UN FOR QUE RECORRA EL ARRAY DE LAS HAMBURGUESAS
				for ( i = 0; i < burguers.length; i++) {
					//OTRO FOR PARA QUE LA POSICION DEL ARRAY DE LAS HAMBURGUESAS, SE GUARDEN PARA COMPARARSE LUEGO CON EL DE LOS INGREDIENTES
					for (int j = 0; j < ingredients[i].length(); j++)
						//CON EL IF VERIFICAMOS SI EL INGREDIENTE QUE INGRESO EL USUARIO SE ENCUENTRA EN EL ARRAY
						//EN EL CASO DE AFIRMATIVO, LE DAMOS UN VALOR TRUE AL BOOLEANO
						if(ingredients[i].contains(buscaringre)) {
							search=true;
							search2=search2+" "+burguers[i];
							ingredientesi = true;
							break;
						}
				}
				//CON EL IF SI EL BOOLEANO ES VERDADERO, SIGNIFICA QUE EL INGREDIENTE SE ENCONTRO, Y VA A MOSTRAR EN
				//QUE HAMBURGUESAS SE ENCUENTRA ESE INGREDIENTE
				if (search==true) {
					System.out.println("Si, hay hamburguesas con ese ingrediente y son: " + search2);
					break;
				}
				else {
					System.out.println("No hay hamburguesas con ese ingrediente");
				}
				}
				break;
			case 5:
				System.out.println("OPCION 5:\n");
				String burgas;
				String BURGAS;
				int cantidades = 0;
				int nuevacant = 0;
				int f;
				boolean verificado = false;
				while (true) {
				System.out.println("Elija una hamburguesa");
				burgas=sc.next();
				BURGAS=burgas.toUpperCase();
				//VERIFICAMOS QUE LA HAMBURGUESA SE ENCUENTRE EN EL MENU
				for (f = 0; f < burguers.length; f++) {
					if (BURGAS.equals(burguers[f])) {
						System.out.println("Cuantas vas a querer?");
						cantidades=sc.nextInt();
						//AL PEDIR LA CANTIDAD, EN UNA NUEVA VARIABLE, LE ASIGNAMOS EL VALOR DE LA RESTA ENTRE
						//EL ARRAY STOCK Y LA CANTIDAD QUE INGRESO
						nuevacant=(stock[f]-cantidades);
						verificado=true;
						break;
					}
				}
				if (verificado==true) {
					System.out.println("Ahora quedan: " + nuevacant + " de " + burguers[f]);
					break;
				}
				else {
					System.out.println("No tenemos esa hamburguesa");
				}
				}
				break;
			case 6:
				int numero;
				int media;
				int suma = 0;
				System.out.println("OPCION 6:\n");
				System.out.println("Cuantos comensales son: ");
				numero=sc.nextInt();
				//GUARDAMOS EL VALOR DE LOS COMENSALES QUE VAN A COMER
				//UTILIZAMOS UN FOR QUE SUME TODOS LOS ELEMENTOS DEL ARRAY STOCK
				for (int d = 0; d<stock.length; d++) {
					suma = suma + stock[d];
				}
				//FUERA DEL FOR, CON ESTE PROCESO SACAMOS LA MEDIA
				media = suma / numero;
				System.out.println("La media para cada comensal es de: " + media);
				break;
			case 7:
				//EN EL CASO DE QUE EL USUARIO INGRESE LA OPCION 7, AL DARLE EL VALOR TRUE AL BOOLEANO SALIR
				//ESTE TERMINA EL PROCESO DEL WHILE Y FINALIZARA EL PROGRAMA.
				salir = true;
				System.out.println("Saliendo...");
				break;
				}
		}
	}

}

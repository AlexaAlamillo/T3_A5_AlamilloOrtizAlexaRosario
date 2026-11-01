import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Nodo{
	
	 private Temperatura temperatura;
	    private Nodo temperaturaSiguiente;

	    public Nodo(Temperatura temperatura) {
	        this.temperatura = temperatura;
	        this.temperaturaSiguiente = null;
	    }
	    public Temperatura getTemperatura() {
	        return temperatura;
	    }

	    public Nodo getTemperaturaSiguiente() {
	        return temperaturaSiguiente;
	    }

	    public void setTemperaturaSiguiente(Nodo siguiente) {
	        this.temperaturaSiguiente = siguiente;
	    }
	
	
	
}

//Esta es la clase temperatura que nos pide el segundo ejercicio 
class Temperatura{
	private double temperatura;
    private LocalDate fechaRegistro;

    public Temperatura(double temperatura, LocalDate fechaRegistro) {
        this.temperatura = temperatura;
        this.fechaRegistro = fechaRegistro;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
	
}
	

class ListaTemperaturas{
	Nodo nodoInicio;
	Nodo nodoFin;
	double promedio;
	//crear listaTemperaturas 
	public ListaTemperaturas() {
		nodoFin = nodoInicio = null;
	}
	
	//Agregar temperatura al inicio
	public void agregarTemperaturaAlInicio(Temperatura tem) {
		Nodo nuevoNodo = new Nodo(tem);
		if(nodoInicio == null) {
			System.out.println("La lista de temperaturas esta vacia");
			nodoInicio = nodoFin=nuevoNodo;
		}else {
			System.out.println("Se agrego una nueva temperatura al inicio");
			
			nuevoNodo.setTemperaturaSiguiente(nodoInicio);
			nodoInicio=nuevoNodo;
		}
		
	}
	
	//Agregar temperatura al final
	public void agregarTemperaturaAlFinal(Temperatura tem) {
		Nodo nuevoNodo= new Nodo(tem);
		if(nodoInicio == null) {
			System.out.println("La lista esta vacia");
			nodoInicio = nodoFin = nodoInicio;
		}else {
			System.out.println("Se agrego la temperatura al final");
			nodoFin.setTemperaturaSiguiente(nuevoNodo);
			nodoFin =nuevoNodo;
		}
	}
	
	//Eliminar temperatura al inicio
	
	public void eliminarTemperaturaAlInicio() {
		if(nodoInicio==null) {
			System.out.println("La lista esta vacia");
		}else {
			
			nodoInicio=nodoInicio.getTemperaturaSiguiente();
			
		}
	}
	
	//Eliminar temperatura al final
	public void eliminarTemperaturaAlFinal() {
		Nodo nodoAnterior ;
		if(nodoInicio == null) {
			System.out.println("La lista esta vacia , por favor agregue elementos a la lista");
			
		}else {
			
		    nodoAnterior = nodoInicio;
		   

	        while(nodoAnterior.getTemperaturaSiguiente() != nodoFin) {

	            nodoAnterior = nodoAnterior.getTemperaturaSiguiente();

	        }

	        nodoAnterior.setTemperaturaSiguiente(null);
	        nodoFin = nodoAnterior;
		}
	}
	
	//Eliminar nodo en posicion especifica
	public void eliminarEnPosicionEspecifica(int posicion) {
		  if(nodoInicio == null) {

		        System.out.println("La lista esta vacia");

		    } else if(posicion < 0) {

		        System.out.println("La posicion no existe");

		    } else if(posicion == 0) {

		        nodoInicio = nodoInicio.getTemperaturaSiguiente();

		       

		    } else {

		        Nodo nodoActual = nodoInicio;
		        Nodo nodoAnterior = null;
		        int contador = 0;

		        while(nodoActual != null && contador < posicion) {

		            nodoAnterior = nodoActual;
		            nodoActual = nodoActual.getTemperaturaSiguiente();
		            contador++;

		        }

		        if(nodoActual == null) {

		            System.out.println("La posición no existe");

		        } else {
		        	System.out.println("La posicion se elimino");

		            nodoAnterior.setTemperaturaSiguiente( nodoActual.getTemperaturaSiguiente() );

		            if(nodoActual == nodoFin) {
		                nodoFin = nodoAnterior;
		            }

		        }
		    }
	}
		  
		  //Promedio de temperaturas en un rango de fechas
		  public void promedioPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {

		        if (nodoInicio == null) {

		            System.out.println("La lista esta vacia");
		            return;
		        }

		        if (fechaInicio.isAfter(fechaFin)) {

		            System.out.println("La fecha inicial no puede ser posterior a la fecha final");

		            return;
		        }

		        Nodo nodoActual = nodoInicio;

		        double suma = 0;
		        int contador = 0;

		        while (nodoActual != null) {

		            Temperatura tem = nodoActual.getTemperatura();

		            LocalDate fecha = tem.getFechaRegistro();

		            if (!fecha.isBefore(fechaInicio)&& !fecha.isAfter(fechaFin)) {

		                suma += tem.getTemperatura();

		                contador++;
		            }

		            nodoActual = nodoActual.getTemperaturaSiguiente();
		        }

		        if (contador == 0) {

		            System.out.println("No existen temperaturas en ese rango de fechas");

		        } else {

		            promedio = suma / contador;

		            System.out.println("\n===== RESULTADO DEL RANGO =====");

		            System.out.println("Fecha inicial: " + fechaInicio);
		            System.out.println("Fecha final: " + fechaFin);

		            System.out.println("Cantidad de registros: " + contador);

		            System.out.println( "Suma de temperaturas: " + suma);

		            System.out.println("Promedio de temperaturas: " + promedio);
		            nivelDeTemperatura();
		        }
		    }
	
	

	
	//MostrarDatos
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual!=null) {
			System.out.print("["+nodoActual.getTemperatura()+"] ==>");
			nodoActual = nodoActual.getTemperaturaSiguiente();
			
			
		}
	}
	//Eliminar Temperatura especifica
	public void eliminarTemperaturaEspecifico(double datoBuscado) {
		if (nodoInicio == null) {

            System.out.println("La lista esta vacia");
            return;
        }

        Nodo nodoActual = nodoInicio;
        Nodo nodoAnterior = null;

        while (nodoActual != null) {

            if (nodoActual.getTemperatura().getTemperatura()== datoBuscado) {

                if (nodoAnterior == null) {

                    nodoInicio =
                        nodoActual.getTemperaturaSiguiente();

                } else {

                    nodoAnterior.setTemperaturaSiguiente(
                        nodoActual.getTemperaturaSiguiente()
                    );
                }

                if (nodoActual == nodoFin) {
                    nodoFin = nodoAnterior;
                }

                System.out.println("Temperatura eliminada");
                return;
            }

            nodoAnterior = nodoActual;

            nodoActual =
                nodoActual.getTemperaturaSiguiente();
        }

        System.out.println("Temperatura no encontrada");
		
	}
	
	//promedio de temperaturas
	public void promedioTemperaturas() {
		 if(nodoInicio == null) {
		        System.out.println("La lista esta vacia");
		    }
		 
		    Nodo nodoActual = nodoInicio;
		    double suma = 0;
		    int contador = 0;
		    while(nodoActual != null) {

		        suma += nodoActual.getTemperatura().getTemperatura();//de esta forma se llaman a los dos get tanto para el onjeto temperatura como el que es de tipo double
		        contador++;

		        nodoActual = nodoActual.getTemperaturaSiguiente();
		    }

		    promedio = suma / contador;

		   System.out.println("El promedio es: "+ promedio);
		
	}
	
	//Mostrar nivel de temperatura por promedio 
	
	public void nivelDeTemperatura() {
		if(promedio <=10.0) {
			System.out.println("Congelacion");
		}else if(promedio<=20.0) {
			System.out.println("Frio");
		}else if(promedio <=30.0) {
			System.out.println("Normal");
			
		}else {
			System.out.println("Alta");
		}
	}
		
}

	
	

//ShellSort


public class EjercicioListasEnlazadas {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int opcion=0;
		ListaTemperaturas lt = new ListaTemperaturas();
		 DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		
		do {
			System.out.println();
			System.out.println("======Menu de opciones=====");
			System.out.println("1) Agregar temperatura al inicio");
			System.out.println("2) Agregar temperatura al final ");
			System.out.println("3) Eliminar Temperatura al inicio");
			System.out.println("4) Eliminar Temperatura al final ");
			System.out.println("5) Eliminar en posicion especifica");
			System.out.println("6) Eliminar temperatura especifica");
			System.out.println("7) Mostrar Datos ");
			System.out.println("8) Mostrar promedio de las temperaturas ");
			System.out.println("9: Mostrar Niveles de temperatura ");
			 System.out.println("10) Promedio por rango de fechas");
			System.out.println("11)Salir");
			System.out.println(" seleccionar Opcion: ");
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.print("Ingrese temperatura: ");
	            double tem = sc.nextDouble();

	            System.out.print("Ingrese fecha (dd/MM/yyyy): ");
	            String fechaTexto = sc.next();

	            LocalDate fecha = LocalDate.parse(fechaTexto, DateTimeFormatter.ofPattern("dd/MM/uuuu"));

	            lt.agregarTemperaturaAlInicio( new Temperatura(tem, fecha));
				break;
			case 2:
				 System.out.print("Ingrese temperatura: ");
		            double temperatura = sc.nextDouble();

		            System.out.print("Ingrese fecha (dd/MM/yyyy): ");
		            String fechaFinalTexto = sc.next();

		            LocalDate fechaFinal = LocalDate.parse(fechaFinalTexto,DateTimeFormatter.ofPattern("dd/MM/uuuu"));

		            lt.agregarTemperaturaAlFinal(
		                    new Temperatura(temperatura, fechaFinal));
				break;
			case 3:
				System.out.println("Se elimino la temperatura en la posicion inicial");
				lt.eliminarTemperaturaAlInicio();
				break;
			case 4:
				System.out.println("Se elimino la temperatura en la posicion final");
				lt.eliminarTemperaturaAlFinal();
				break;
			case 5:
				System.out.println("Ingrese posicion a eliminar");
				int posicion = sc.nextInt();
				lt.eliminarEnPosicionEspecifica(posicion);
				
				break;
			case 6:
				System.out.println("Ingrese temperatura especifica:");
				  System.out.print("Ingrese la temperatura a eliminar: ");
		            double temperaturaEsp = sc.nextDouble();
		            lt.eliminarTemperaturaEspecifico(temperaturaEsp); 
				break;
			case 7:
				System.out.println("=====MOSTRANDO LA LISTA DE TEMPERATURAS====");
				lt.mostrarElementos();
				break;
			case 8:
				lt.promedioTemperaturas();
				break;
			case 9:
				System.out.println("===NIVEL DE TEMPERATURA====");
				lt.nivelDeTemperatura();
				
				break;
			case 10:
				 System.out.print("Ingrese la fecha inicial (dd/MM/yyyy): ");
		            String inicio = sc.next();

		            System.out.print("Ingrese la fecha final (dd/MM/yyyy): ");
		            String fin = sc.next();

		            LocalDate fechaInicio = LocalDate.parse(inicio,DateTimeFormatter.ofPattern("dd/MM/uuuu"));

		            LocalDate fechaFin = LocalDate.parse(fin,DateTimeFormatter.ofPattern("dd/MM/uuuu"));

		            if (fechaInicio.isAfter(fechaFin)) {
		                System.out.println("La fecha inicial no puede ser posterior a la fecha final");
		            } else {
		                lt.promedioPorRangoDeFechas(fechaInicio, fechaFin);
		            }
				break;
			case 11:
				System.out.println("Saliendo del programa...");
				break;
				default:
					System.out.println("Seleccione otra opcion..");
					break;
			}
		}while(opcion!= 11);

	}

}

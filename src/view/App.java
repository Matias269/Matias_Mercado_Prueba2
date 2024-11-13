package view;

import controllers.Controller;
import models.Carpa;
import models.DatosClientes;
import models.Hotel;
import models.Cabagna;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.iniciar();
    }

    private Controller controlador;
    private Scanner scanner;

    public App() {
        this.controlador = new Controller();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Alojamientos ---");
            System.out.println("1. Agregar Alojamiento");
            System.out.println("2. Mostrar Alojamientos");
            System.out.println("3. Mostrar Alojamiento de un Cliente");
            System.out.println("4. Calcular Total Adicional");
            System.out.println("5. Calcular Total Bono Descuento");
            System.out.println("6. Calcular Valor a Cancelar por un Cliente");
            System.out.println("7. Aplicar Incremento en Valor Base");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de alojamiento (Hotel, Cabaña o Carpa): ");
                    String tipoAlojamiento = scanner.nextLine();

                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el RUT del cliente: ");
                    String rut = scanner.nextLine();

                    DatosClientes datosCliente = new DatosClientes(nombre, Integer.parseInt(rut));

                    if (tipoAlojamiento.equalsIgnoreCase("Hotel")) {
                        System.out.print("¿Incluye desayuno? (true/false): ");
                        boolean conDesayuno = scanner.nextBoolean();
                        scanner.nextLine(); // Consumir la nueva línea

                        System.out.print("Ingrese el valor base por noche: ");
                        double valorBaseNoche = scanner.nextDouble();

                        System.out.print("Ingrese la capacidad de la habitación: ");
                        int capacidad = scanner.nextInt();

                        System.out.print("Ingrese la cantidad de noches: ");
                        int cantidadNoches = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                        String tipoTemporada = scanner.nextLine();

                        System.out.print("¿Es fumador? (true/false): ");
                        boolean esFumador = scanner.nextBoolean();
                        scanner.nextLine();

                        System.out.print("Ingrese la cantidad de Personas: ");
                        int cantPersonas = scanner.nextInt();
                        scanner.nextLine();

                        // Crear el objeto `Hotel` con los 8 parámetros requeridos
                        Hotel hotel = new Hotel(valorBaseNoche, datosCliente,tipoTemporada, cantidadNoches,capacidad,esFumador,conDesayuno,cantPersonas);
                        controlador.agregarAlojamiento(hotel);
                    } else if (tipoAlojamiento.equalsIgnoreCase("Cabaña")) {
                        System.out.print("Ingrese la capacidad de la cabaña: ");
                        int capacidad = scanner.nextInt();

                        System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                        String tipoDeTemporada = scanner.nextLine();
                        scanner.nextLine();

                        System.out.print("Ingrese la cantidad de noches: ");
                        int cantidadNoches = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("¿Es fumador? (true/false): ");
                        boolean esFumador = scanner.nextBoolean();
                        scanner.nextLine();

                        System.out.print("¿Tiene chimenea? (true/false): ");
                        boolean chimenea = scanner.nextBoolean();

                        System.out.print("Ingrese la cantidad de Personas: ");
                        int cantPersonas = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el valor base por noche: ");
                        int valorBaseNoche = scanner.nextInt();

                        Cabagna cabagna = new Cabagna(valorBaseNoche, datosCliente, tipoDeTemporada, cantidadNoches, esFumador, cantPersonas, chimenea);
                        controlador.agregarAlojamiento(cabagna);

                    } else if(tipoAlojamiento.equalsIgnoreCase("Carpa")){
                            System.out.print("Ingrese la capacidad de la carpa: ");
                            int capacidad = scanner.nextInt();

                            System.out.print("Ingrese el tipo de temporada (alta, media, baja): ");
                            String tipoDeTemporada = scanner.nextLine();
                            scanner.nextLine();

                            System.out.print("Ingrese la cantidad de noches: ");
                            int cantidadNoches = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ingrese la cantidad de Personas: ");
                            int cantPersonas = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ingrese el valor base por noche: ");
                            int valorBaseNoche = scanner.nextInt();

                        Carpa carpa = new Carpa(valorBaseNoche, datosCliente, tipoDeTemporada, cantidadNoches, cantPersonas);
                        controlador.agregarAlojamiento(carpa);
                    } else {
                        System.out.println("Tipo de alojamiento no válido.");
                    }
                    break;
                case 2: controlador.mostrarAlojamientos();break;
                case 3: System.out.print("Ingrese el RUT del cliente: ");
                    String rutCliente = scanner.nextLine();
                    controlador.mostrarAlojamientoCliente(rutCliente);
                    break;
                case 4: controlador.calcularTotalAdicional(); break;
                case 5: controlador.calcularTotalBonoDescuento(); break;
                case 6: System.out.print("Ingrese el RUT del cliente para calcular el valor a cancelar: ");
                    String rutValor = scanner.nextLine();
                    controlador.calcularValorACancelarCliente(rutValor);
                    break;
                case 7: controlador.aplicarIncrementoValorBase(); break;
                case 8: salir = true; System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }



}


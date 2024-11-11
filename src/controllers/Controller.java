package controllers;

import models.Cabagna;
import models.MedioDeAlojamiento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<MedioDeAlojamiento> alojamientos;

    public Controller() {
        this.alojamientos = new ArrayList<>();
    }

    public boolean agregarAlojamiento(MedioDeAlojamiento alojamiento) {
        for (MedioDeAlojamiento a : alojamientos) {
            if (a.getDatosClientes().getRut() == alojamiento.getDatosClientes().getRut()) {
                System.out.println("El cliente ya tiene un alojamiento registrado.");
                return false;
            }
        }
        alojamientos.add(alojamiento);
        System.out.println("Alojamiento agregado correctamente.");
        return true;
    }

    public void mostrarAlojamientos() {
        if (alojamientos.isEmpty()) {
            System.out.println("No hay alojamientos registrados.");
        } else {
            for (MedioDeAlojamiento alojamiento : alojamientos) {
                System.out.println(alojamiento.toString());
            }
        }
    }

    public void mostrarAlojamientoCliente(String rut) {
        int rutInt = Integer.parseInt(rut); // Cambiamos el nombre a rutInt
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento.getDatosClientes().getRut() == rutInt) {
                System.out.println("Cliente encontrado: " + alojamiento.getDatosClientes().getName());
                System.out.println("Datos del alojamiento: " + alojamiento.toString());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public double calcularTotalAdicional() {
        double total = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            total += alojamiento.adicional();
        }
        return total;
    }

    public double calcularTotalBonoDescuento() {
        double total = 0;
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            total += alojamiento.bonoDescuento();
        }
        return total;
    }

    public double calcularValorACancelarCliente(String rut) {
        int rutInt = Integer.parseInt(rut);
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento.getDatosClientes().getRut() == rutInt) {
                return alojamiento.valorACancelar();
            }
        }
        System.out.println("Cliente no encontrado.");
        return 0;
    }

    public void aplicarIncrementoValorBase() {
        for (MedioDeAlojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Cabagna) {
                Cabagna cabagna = (Cabagna) alojamiento;
                if (cabagna.getCantPersonas() > 5) {
                    double nuevoValorBase = cabagna.getValorBaseNoche() * 1.18;
                    cabagna.setValorBaseNoche(nuevoValorBase);
                    System.out.println("Incremento aplicado a la cabaña del cliente " + cabagna.getDatosClientes().getName());
                }
            }
        }
    }
}

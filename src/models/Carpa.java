package models;

public class Carpa extends MedioDeAlojamiento {
    protected int cantidadPersonas;

    public Carpa(int valorBaseNoche, DatosClientes datosClientes, String tipoDeTemporada, int cantidadNoches, int cantidadPersonas) {
        super(valorBaseNoche, datosClientes, tipoDeTemporada, cantidadNoches);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public double adicional() {
        return 0; // Carpa no tiene adicionales especificados
    }
}

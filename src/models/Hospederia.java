package models;

public abstract class Hospederia extends MedioDeAlojamiento {
    int capacidad;
    boolean esFumador;

    public Hospederia(double valorBaseNoche, DatosClientes datosClientes, String tipoDeTemporada, int cantidadNoches, int capacidad, boolean esFumador) {
        super(valorBaseNoche, datosClientes, tipoDeTemporada, cantidadNoches);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoDeTemporada() {
        return tipoDeTemporada;
    }

    public void setTipoDeTemporada(String tipoDeTemporada) {
        this.tipoDeTemporada = tipoDeTemporada;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public boolean getEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }


}

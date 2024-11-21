package models;

public class Cabagna extends MedioDeAlojamiento {
    protected boolean esFumador;
    protected int cantPersonas;
    boolean chimenea;

    public Cabagna(int valorBaseNoche, DatosClientes datosClientes, String tipoDeTemporada, int cantidadNoches, boolean esFumador, int cantPersonas, boolean chimenea) {
        super(valorBaseNoche, datosClientes, tipoDeTemporada, cantidadNoches);
        this.esFumador = esFumador;
        this.cantPersonas = cantPersonas;
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public void setValorBaseNoche(double valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    //Funciones===========================================================

    @Override
    public double adicional() {
        return 0;
    }


}

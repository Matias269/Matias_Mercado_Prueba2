package models;

public class Hotel extends Hospederia{
    boolean conDesayuno;
    protected int cantPersonas;

    public Hotel(double valorBaseNoche, DatosClientes datosClientes, String tipoDeTemporada, int cantidadNoches, int capacidad, boolean esFumador, boolean conDesayuno, int cantPersonas) {
        super(valorBaseNoche, datosClientes, tipoDeTemporada, cantidadNoches, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
        this.cantPersonas = cantPersonas;
    }

    public boolean getConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    //devolverá el valor adicional, que corresponde al 30% del subtotal si es Fumador y con desayuno.

    @Override
    public double adicional() {
        esFumador = getEsFumador();
        conDesayuno = getConDesayuno();
        double adicional = 0;

        if (esFumador == true && conDesayuno == true){
            adicional = (double) (this.subtotal() * 30) /  100;
        }
        return adicional;
    }

}

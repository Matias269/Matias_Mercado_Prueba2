package models;

public abstract class MedioDeAlojamiento {
    protected double valorBaseNoche;
    protected models.DatosClientes datosClientes;
    protected String tipoDeTemporada;
    protected int cantidadNoches;

    public MedioDeAlojamiento(double valorBaseNoche, models.DatosClientes datosClientes, String tipoDeTemporada, int cantidadNoches) {
        this.valorBaseNoche = valorBaseNoche;
        this.datosClientes = datosClientes;
        this.tipoDeTemporada = tipoDeTemporada;
        this.cantidadNoches = cantidadNoches;
    }

    public double getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNohe(double valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public models.DatosClientes getDatosClientes() {
        return datosClientes;
    }

    public void setDatosClientes(models.DatosClientes datosClientes) {
        this.datosClientes = datosClientes;
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

    //Funciones=================================================

    public double subtotal(){
        double subtotal = this.getCantidadNoches() * this.getValorBaseNoche() ;

        return subtotal;
    }

    public abstract double adicional();

    public double bonoDescuento() {
        double subtotal = subtotal();
        if (tipoDeTemporada.equalsIgnoreCase("baja")) {
            return subtotal * 0.25;
        } else if (tipoDeTemporada.equalsIgnoreCase("media")) {
            return subtotal * 12.5/100;
        } else {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "MedioDeAlojamiento" + "\n"+
                "Valor Base por Noche= " + valorBaseNoche + "\n"+
                ", Datos del Cliente=" + datosClientes.getName() +" "+ datosClientes.getRut()+ "\n"+
                ", Temporada = " + tipoDeTemporada + '\'' + "\n"+
                ", Cantidad de Noches=" + cantidadNoches + "\n"+
                '.';
    }

    public double valorACancelar() {
        return subtotal() - bonoDescuento() + adicional();
    }


}

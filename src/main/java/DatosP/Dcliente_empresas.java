package DatosP;

public class Dcliente_empresas {

    public int idcliente;
    public String placa;
    public String tipo_vehiculo;
    public String cliente;
    public String telefono;
    public String tipo_servicio;
    public String estado;
    public String observaciones;

    public Dcliente_empresas() {
    }

    public Dcliente_empresas(int idcliente, String placa, String tipo_vehiculo, String cliente, String telefono, String tipo_servicio, String estado, String observaciones) {
        this.idcliente = idcliente;
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
        this.cliente = cliente;
        this.telefono = telefono;
        this.tipo_servicio = tipo_servicio;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    



    
}

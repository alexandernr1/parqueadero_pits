
package DatosP;


public class Dtarifas {
    
    public int idtarifas;
    public String tipo_servicio;
    public int precio;

    public Dtarifas() {
    }

    public Dtarifas(int idtarifas, String tipo_servicio, int precio) {
        this.idtarifas = idtarifas;
        this.tipo_servicio = tipo_servicio;
        this.precio = precio;
    }

    public int getIdtarifas() {
        return idtarifas;
    }

    public void setIdtarifas(int idtarifas) {
        this.idtarifas = idtarifas;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    
    
    
}

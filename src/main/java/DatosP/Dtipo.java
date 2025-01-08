package DatosP;

public class Dtipo {

    public int idtipo;
    public String tipo_servicio;
    public String tipo_convenio;
    public String valor;
    

    public Dtipo() {
    }

    public Dtipo(int idtipo, String tipo_servicio, String tipo_convenio, String valor) {
        this.idtipo = idtipo;
        this.tipo_servicio = tipo_servicio;
        this.tipo_convenio = tipo_convenio;
        this.valor = valor;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getTipo_convenio() {
        return tipo_convenio;
    }

    public void setTipo_convenio(String tipo_convenio) {
        this.tipo_convenio = tipo_convenio;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

  
    



    
}

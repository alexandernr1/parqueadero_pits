
package DatosP;


public class Dzona {
    public int idzona;
    public String estado;
    public String numero;
    public String calle;

    public Dzona() {
    }

    public Dzona(int idzona, String estado, String numero, String calle) {
        this.idzona = idzona;
        this.estado = estado;
        this.numero = numero;
        this.calle = calle;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    
    
}

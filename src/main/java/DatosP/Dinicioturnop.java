package DatosP;

public class Dinicioturnop {

    public int idturno;
    public String fecha_inicio;
    public String turno;
    public int numero_turno;
    public String estado;
    public String empleado;

    public Dinicioturnop() {
    }

    public Dinicioturnop(int idturno, String fecha_inicio, String turno, int numero_turno, String estado, String empleado) {
        this.idturno = idturno;
        this.fecha_inicio = fecha_inicio;
        this.turno = turno;
        this.numero_turno = numero_turno;
        this.estado = estado;
        this.empleado = empleado;
    }

    public Dinicioturnop(int numeroturnop, int idturno) {
        this.numero_turno = numeroturnop;
        this.idturno = idturno;
    }
    
     public Dinicioturnop(int numeroturnop, String empleado) {
     this.numero_turno = numeroturnop;
     this.empleado = empleado;
    }
     
    public int getNumeroTurno() {
        return this.numero_turno;
    }

    public int getIdInicioTurno() {
        return this.idturno;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getNumero_turno() {
        return numero_turno;
    }

    public void setNumero_turno(int numero_turno) {
        this.numero_turno = numero_turno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

}

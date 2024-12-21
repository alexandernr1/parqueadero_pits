package DatosP;

public class Dabonosp {

    public int idabonos;
    public String fecha;
    public String cliente;
    public int valor_abonos;
    public int efectivo;
    public int tarjeta;
    public int transferencia;
    public int total;
    public int saldo;
    public String numturno;
    public String responsable;
    public String turno;

    public Dabonosp() {
    }

    public Dabonosp(int idabonos, String fecha, String cliente, int valor_abonos, int efectivo, int tarjeta, int transferencia, int total, int saldo, String numturno, String responsable, String turno) {
        this.idabonos = idabonos;
        this.fecha = fecha;
        this.cliente = cliente;
        this.valor_abonos = valor_abonos;
        this.efectivo = efectivo;
        this.tarjeta = tarjeta;
        this.transferencia = transferencia;
        this.total = total;
        this.saldo = saldo;
        this.numturno = numturno;
        this.responsable = responsable;
        this.turno = turno;
    }

    public int getIdabonos() {
        return idabonos;
    }

    public void setIdabonos(int idabonos) {
        this.idabonos = idabonos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getValor_abonos() {
        return valor_abonos;
    }

    public void setValor_abonos(int valor_abonos) {
        this.valor_abonos = valor_abonos;
    }

    public int getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(int efectivo) {
        this.efectivo = efectivo;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(int transferencia) {
        this.transferencia = transferencia;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getNumturno() {
        return numturno;
    }

    public void setNumturno(String numturno) {
        this.numturno = numturno;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    

}

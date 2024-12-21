package DatosP;

public class Dsalidap {

    public int idsalida;
    public int idingreso;
    public String placa;
    public String tipovehiculo;
    public String tiposervicio;
    public String cliente;
    public String fechaentrada;
    public String fechasalida;
    public String zona;
    public String numfactura;
    public String numrecibo;
    public int dias;
    public int horas;
    public int minutos;
    public int valor;
    public int antesiva;
    public int iva19;
    public int subtotal;
    public int impuesto9;
    public int efectivo;
    public int tarjeta;
    public int transferencia;
    public int total;
    public String turno;
    public String turnoentrada;
    public String empleadoentrada;
    public String turnosalida;
    public String empleadosalida;
    public int descuento;
    public String totalautos;
    public String totalmotos;
    

    public Dsalidap() {
    }

    public Dsalidap(int idsalida, int idingreso, String placa, String tipovehiculo, String tiposervicio, String cliente, String fechaentrada, String fechasalida, String zona, String numfactura, String numrecibo, int dias, int horas, int minutos, int valor, int antesiva, int iva19, int subtotal, int impuesto9, int efectivo, int tarjeta, int transferencia, int total, String turno, String turnoentrada, String empleadoentrada, String turnosalida, String empleadosalida, int descuento, String totalautos, String totalmotos) {
        this.idsalida = idsalida;
        this.idingreso = idingreso;
        this.placa = placa;
        this.tipovehiculo = tipovehiculo;
        this.tiposervicio = tiposervicio;
        this.cliente = cliente;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.zona = zona;
        this.numfactura = numfactura;
        this.numrecibo = numrecibo;
        this.dias = dias;
        this.horas = horas;
        this.minutos = minutos;
        this.valor = valor;
        this.antesiva = antesiva;
        this.iva19 = iva19;
        this.subtotal = subtotal;
        this.impuesto9 = impuesto9;
        this.efectivo = efectivo;
        this.tarjeta = tarjeta;
        this.transferencia = transferencia;
        this.total = total;
        this.turno = turno;
        this.turnoentrada = turnoentrada;
        this.empleadoentrada = empleadoentrada;
        this.turnosalida = turnosalida;
        this.empleadosalida = empleadosalida;
        this.descuento = descuento;
        this.totalautos = totalautos;
        this.totalmotos = totalmotos;
    }

  
    public int getIdsalida() {
        return idsalida;
    }

    public void setIdsalida(int idsalida) {
        this.idsalida = idsalida;
    }

    public int getIdingreso() {
        return idingreso;
    }

    public void setIdingreso(int idingreso) {
        this.idingreso = idingreso;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public String getNumrecibo() {
        return numrecibo;
    }

    public void setNumrecibo(String numrecibo) {
        this.numrecibo = numrecibo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAntesiva() {
        return antesiva;
    }

    public void setAntesiva(int antesiva) {
        this.antesiva = antesiva;
    }

    public int getIva19() {
        return iva19;
    }

    public void setIva19(int iva19) {
        this.iva19 = iva19;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getImpuesto9() {
        return impuesto9;
    }

    public void setImpuesto9(int impuesto9) {
        this.impuesto9 = impuesto9;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurnoentrada() {
        return turnoentrada;
    }

    public void setTurnoentrada(String turnoentrada) {
        this.turnoentrada = turnoentrada;
    }

    public String getEmpleadoentrada() {
        return empleadoentrada;
    }

    public void setEmpleadoentrada(String empleadoentrada) {
        this.empleadoentrada = empleadoentrada;
    }

    public String getTurnosalida() {
        return turnosalida;
    }

    public void setTurnosalida(String turnosalida) {
        this.turnosalida = turnosalida;
    }

    public String getEmpleadosalida() {
        return empleadosalida;
    }

    public void setEmpleadosalida(String empleadosalida) {
        this.empleadosalida = empleadosalida;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getTotalautos() {
        return totalautos;
    }

    public void setTotalautos(String totalautos) {
        this.totalautos = totalautos;
    }

    public String getTotalmotos() {
        return totalmotos;
    }

    public void setTotalmotos(String totalmotos) {
        this.totalmotos = totalmotos;
    }

    
   

}

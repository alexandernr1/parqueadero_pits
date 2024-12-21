package PresentacionP;

import LogicaP.ActualizadorColoresp;
import LogicaP.Finicioturnop;
import LogicaP.Fzonap;
import java.awt.Color;
import java.awt.Component;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class Jmenuparqueadero extends javax.swing.JInternalFrame {

    public static Boolean sesionIniciada = false;

    
    private Jingresop ingresoFormulario;
    private Jsalidap salidaFormulario;
    private Jabonosp pagoFormulario;
    private Jfinturnop salidaturno;
    public Fzonap fcn;

    public Jmenuparqueadero() {
        initComponents();
        this.fcn = new Fzonap();
        ActualizadorColoresp actualizador = new ActualizadorColoresp(this);
        Thread thread = new Thread(actualizador);
        actualizador.iniciarHilo();
        thread.start();
        lblidinicioturno.setVisible(false);

    }

    static void actualizarDatosUsuario1(String fecha, String turno, String empleado, String estado, String numero_turno, String idinicioturno) {
        lblfecha.setText(fecha);
        lblturnos.setText(turno);
        lblempleado.setText(empleado);
        lblestado.setText(estado);
        lblnumeroturno.setText(numero_turno);
        lblidinicioturno.setText(idinicioturno);

    }

    public static void limpiarDatosUsuario() {
        lblfecha.setText("");
        lblturnos.setText("");
        lblempleado.setText("");
        lblestado.setText("");
        lblidinicioturno.setText("");
    }

    // Métodos para actualizar los JLabel
    public static void actualizarFecha(String fecha) {
        lblfecha.setText(fecha);
    }

    public static void actualizarTurno(String turno) {
        lblturnos.setText(turno);
    }

    public static void actualizarEmpleado(String empleado) {
        lblempleado.setText(empleado);
    }

    public static void actualizarEstado(String estado) {
        lblestado.setText(estado);
    }

    public static void actualizarnnumero_turno(String numero_turno) {
        lblnumeroturno.setText(numero_turno);
    }
    
    public static void actualizaridinicioturno(String idinicioturno) {
        lblidinicioturno.setText(idinicioturno);
    }

    public static int idusuario;

    public void metodoDondeSeNecesitaFormLogin() {
        // Inicialización de formLogin
        Jinicioturnop formLogin = new Jinicioturnop();

        // Intento de deshabilitar formLogin
        formLogin.setEnabled(false);
    }

    public void actualizarColoresBotones() {

        Component[] componentes = pnlBotones.getComponents();
        Pattern pattern = Pattern.compile("\\d+"); // Patrón para solo números

        for (Component componente : componentes) {
            if (componente instanceof JToggleButton boton) {
                String nombreBoton = boton.getText();
                if (pattern.matcher(nombreBoton).matches()) { // Verifica si el texto es solo números
                    int idzona = Integer.parseInt(nombreBoton);
                    String estadoZona = fcn.obtenerEstadozona(idzona);

                    switch (estadoZona) {
                        case "Disponible" ->
                            boton.setBackground(new Color(144, 238, 144)); // Light green
                        case "Ocupado" ->
                            boton.setBackground(new Color(255, 99, 71)); // Light coral (soft red)
                        case "Reserva" ->
                            boton.setBackground(new Color(255, 255, 102)); // Light yellow
                        case "Mantenimiento" ->
                            boton.setBackground(new Color(255, 165, 79)); // Light orange
                        case "Limpieza" ->
                            boton.setBackground(new Color(0, 204, 255)); // Light sky blue
                        default ->
                            boton.setBackground(Color.WHITE);
                    }

                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        lblfecha = new javax.swing.JLabel();
        lblempleado = new javax.swing.JLabel();
        lblestado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblturnos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblnumeroturno = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlBotones = new javax.swing.JPanel();
        jToggleButton153 = new javax.swing.JToggleButton();
        jToggleButton154 = new javax.swing.JToggleButton();
        jToggleButton155 = new javax.swing.JToggleButton();
        jToggleButton156 = new javax.swing.JToggleButton();
        jToggleButton157 = new javax.swing.JToggleButton();
        jToggleButton158 = new javax.swing.JToggleButton();
        jToggleButton159 = new javax.swing.JToggleButton();
        jToggleButton160 = new javax.swing.JToggleButton();
        jToggleButton161 = new javax.swing.JToggleButton();
        jToggleButton162 = new javax.swing.JToggleButton();
        jToggleButton163 = new javax.swing.JToggleButton();
        jToggleButton164 = new javax.swing.JToggleButton();
        jToggleButton165 = new javax.swing.JToggleButton();
        jToggleButton166 = new javax.swing.JToggleButton();
        jToggleButton167 = new javax.swing.JToggleButton();
        jToggleButton168 = new javax.swing.JToggleButton();
        jToggleButton169 = new javax.swing.JToggleButton();
        jToggleButton170 = new javax.swing.JToggleButton();
        jToggleButton171 = new javax.swing.JToggleButton();
        jToggleButton172 = new javax.swing.JToggleButton();
        jToggleButton173 = new javax.swing.JToggleButton();
        jToggleButton174 = new javax.swing.JToggleButton();
        jToggleButton175 = new javax.swing.JToggleButton();
        jToggleButton176 = new javax.swing.JToggleButton();
        jToggleButton177 = new javax.swing.JToggleButton();
        jToggleButton178 = new javax.swing.JToggleButton();
        jToggleButton179 = new javax.swing.JToggleButton();
        jToggleButton180 = new javax.swing.JToggleButton();
        jToggleButton181 = new javax.swing.JToggleButton();
        jToggleButton182 = new javax.swing.JToggleButton();
        jToggleButton183 = new javax.swing.JToggleButton();
        jToggleButton184 = new javax.swing.JToggleButton();
        jToggleButton185 = new javax.swing.JToggleButton();
        jToggleButton186 = new javax.swing.JToggleButton();
        jToggleButton187 = new javax.swing.JToggleButton();
        jToggleButton188 = new javax.swing.JToggleButton();
        jToggleButton189 = new javax.swing.JToggleButton();
        jToggleButton190 = new javax.swing.JToggleButton();
        jToggleButton191 = new javax.swing.JToggleButton();
        jToggleButton192 = new javax.swing.JToggleButton();
        jToggleButton193 = new javax.swing.JToggleButton();
        jToggleButton194 = new javax.swing.JToggleButton();
        jToggleButton195 = new javax.swing.JToggleButton();
        jToggleButton196 = new javax.swing.JToggleButton();
        jToggleButton197 = new javax.swing.JToggleButton();
        jToggleButton198 = new javax.swing.JToggleButton();
        jToggleButton199 = new javax.swing.JToggleButton();
        jToggleButton200 = new javax.swing.JToggleButton();
        jToggleButton201 = new javax.swing.JToggleButton();
        jToggleButton202 = new javax.swing.JToggleButton();
        jToggleButton203 = new javax.swing.JToggleButton();
        jToggleButton204 = new javax.swing.JToggleButton();
        jToggleButton205 = new javax.swing.JToggleButton();
        jToggleButton206 = new javax.swing.JToggleButton();
        jToggleButton207 = new javax.swing.JToggleButton();
        jToggleButton208 = new javax.swing.JToggleButton();
        jToggleButton209 = new javax.swing.JToggleButton();
        jToggleButton210 = new javax.swing.JToggleButton();
        jToggleButton211 = new javax.swing.JToggleButton();
        jToggleButton212 = new javax.swing.JToggleButton();
        jToggleButton213 = new javax.swing.JToggleButton();
        jToggleButton214 = new javax.swing.JToggleButton();
        jToggleButton215 = new javax.swing.JToggleButton();
        jToggleButton216 = new javax.swing.JToggleButton();
        jToggleButton217 = new javax.swing.JToggleButton();
        jToggleButton218 = new javax.swing.JToggleButton();
        jToggleButton219 = new javax.swing.JToggleButton();
        jToggleButton220 = new javax.swing.JToggleButton();
        jToggleButton221 = new javax.swing.JToggleButton();
        jToggleButton222 = new javax.swing.JToggleButton();
        jToggleButton223 = new javax.swing.JToggleButton();
        jToggleButton224 = new javax.swing.JToggleButton();
        jToggleButton225 = new javax.swing.JToggleButton();
        jToggleButton226 = new javax.swing.JToggleButton();
        jToggleButton227 = new javax.swing.JToggleButton();
        jToggleButton228 = new javax.swing.JToggleButton();
        jToggleButton229 = new javax.swing.JToggleButton();
        jToggleButton230 = new javax.swing.JToggleButton();
        jToggleButton231 = new javax.swing.JToggleButton();
        jToggleButton232 = new javax.swing.JToggleButton();
        jToggleButton233 = new javax.swing.JToggleButton();
        jToggleButton234 = new javax.swing.JToggleButton();
        jToggleButton235 = new javax.swing.JToggleButton();
        jToggleButton236 = new javax.swing.JToggleButton();
        jToggleButton300 = new javax.swing.JToggleButton();
        jToggleButton301 = new javax.swing.JToggleButton();
        jToggleButton302 = new javax.swing.JToggleButton();
        jToggleButton303 = new javax.swing.JToggleButton();
        jToggleButton304 = new javax.swing.JToggleButton();
        jToggleButton305 = new javax.swing.JToggleButton();
        jToggleButton279 = new javax.swing.JToggleButton();
        jToggleButton280 = new javax.swing.JToggleButton();
        jToggleButton281 = new javax.swing.JToggleButton();
        jToggleButton282 = new javax.swing.JToggleButton();
        jToggleButton283 = new javax.swing.JToggleButton();
        jToggleButton284 = new javax.swing.JToggleButton();
        jToggleButton285 = new javax.swing.JToggleButton();
        jToggleButton286 = new javax.swing.JToggleButton();
        jToggleButton287 = new javax.swing.JToggleButton();
        jToggleButton288 = new javax.swing.JToggleButton();
        jToggleButton289 = new javax.swing.JToggleButton();
        jToggleButton290 = new javax.swing.JToggleButton();
        jToggleButton291 = new javax.swing.JToggleButton();
        jToggleButton292 = new javax.swing.JToggleButton();
        jToggleButton293 = new javax.swing.JToggleButton();
        jToggleButton294 = new javax.swing.JToggleButton();
        jToggleButton295 = new javax.swing.JToggleButton();
        jToggleButton296 = new javax.swing.JToggleButton();
        jToggleButton297 = new javax.swing.JToggleButton();
        jToggleButton298 = new javax.swing.JToggleButton();
        jToggleButton299 = new javax.swing.JToggleButton();
        jToggleButton314 = new javax.swing.JToggleButton();
        jToggleButton315 = new javax.swing.JToggleButton();
        jToggleButton316 = new javax.swing.JToggleButton();
        jToggleButton317 = new javax.swing.JToggleButton();
        jToggleButton318 = new javax.swing.JToggleButton();
        jToggleButton319 = new javax.swing.JToggleButton();
        jToggleButton320 = new javax.swing.JToggleButton();
        jToggleButton321 = new javax.swing.JToggleButton();
        jToggleButton322 = new javax.swing.JToggleButton();
        jToggleButton323 = new javax.swing.JToggleButton();
        jToggleButton324 = new javax.swing.JToggleButton();
        jToggleButton325 = new javax.swing.JToggleButton();
        jToggleButton326 = new javax.swing.JToggleButton();
        jToggleButton327 = new javax.swing.JToggleButton();
        jToggleButton328 = new javax.swing.JToggleButton();
        jToggleButton329 = new javax.swing.JToggleButton();
        jToggleButton330 = new javax.swing.JToggleButton();
        jToggleButton331 = new javax.swing.JToggleButton();
        jToggleButton332 = new javax.swing.JToggleButton();
        jToggleButton333 = new javax.swing.JToggleButton();
        jToggleButton334 = new javax.swing.JToggleButton();
        jToggleButton335 = new javax.swing.JToggleButton();
        jToggleButton336 = new javax.swing.JToggleButton();
        jToggleButton337 = new javax.swing.JToggleButton();
        jToggleButton338 = new javax.swing.JToggleButton();
        jToggleButton339 = new javax.swing.JToggleButton();
        jToggleButton340 = new javax.swing.JToggleButton();
        jToggleButton306 = new javax.swing.JToggleButton();
        jToggleButton341 = new javax.swing.JToggleButton();
        jToggleButton342 = new javax.swing.JToggleButton();
        jToggleButton343 = new javax.swing.JToggleButton();
        jToggleButton344 = new javax.swing.JToggleButton();
        jToggleButton345 = new javax.swing.JToggleButton();
        jToggleButton346 = new javax.swing.JToggleButton();
        jToggleButton347 = new javax.swing.JToggleButton();
        jToggleButton348 = new javax.swing.JToggleButton();
        jToggleButton349 = new javax.swing.JToggleButton();
        jToggleButton350 = new javax.swing.JToggleButton();
        jToggleButton307 = new javax.swing.JToggleButton();
        jToggleButton308 = new javax.swing.JToggleButton();
        jToggleButton309 = new javax.swing.JToggleButton();
        jToggleButton310 = new javax.swing.JToggleButton();
        jToggleButton311 = new javax.swing.JToggleButton();
        jToggleButton312 = new javax.swing.JToggleButton();
        jToggleButton313 = new javax.swing.JToggleButton();
        jToggleButton351 = new javax.swing.JToggleButton();
        jToggleButton352 = new javax.swing.JToggleButton();
        jToggleButton353 = new javax.swing.JToggleButton();
        jToggleButton354 = new javax.swing.JToggleButton();
        jToggleButton355 = new javax.swing.JToggleButton();
        jToggleButton356 = new javax.swing.JToggleButton();
        jToggleButton357 = new javax.swing.JToggleButton();
        jToggleButton358 = new javax.swing.JToggleButton();
        jToggleButton359 = new javax.swing.JToggleButton();
        jToggleButton360 = new javax.swing.JToggleButton();
        jToggleButton361 = new javax.swing.JToggleButton();
        jToggleButton362 = new javax.swing.JToggleButton();
        jToggleButton363 = new javax.swing.JToggleButton();
        jToggleButton364 = new javax.swing.JToggleButton();
        jToggleButton365 = new javax.swing.JToggleButton();
        jToggleButton366 = new javax.swing.JToggleButton();
        jToggleButton367 = new javax.swing.JToggleButton();
        jToggleButton368 = new javax.swing.JToggleButton();
        jToggleButton369 = new javax.swing.JToggleButton();
        jToggleButton370 = new javax.swing.JToggleButton();
        jToggleButton371 = new javax.swing.JToggleButton();
        jToggleButton372 = new javax.swing.JToggleButton();
        jToggleButton373 = new javax.swing.JToggleButton();
        jToggleButton374 = new javax.swing.JToggleButton();
        jToggleButton375 = new javax.swing.JToggleButton();
        jToggleButton376 = new javax.swing.JToggleButton();
        jToggleButton377 = new javax.swing.JToggleButton();
        jToggleButton378 = new javax.swing.JToggleButton();
        jToggleButton379 = new javax.swing.JToggleButton();
        jToggleButton380 = new javax.swing.JToggleButton();
        jToggleButton381 = new javax.swing.JToggleButton();
        jToggleButton382 = new javax.swing.JToggleButton();
        jToggleButton383 = new javax.swing.JToggleButton();
        jToggleButton384 = new javax.swing.JToggleButton();
        jToggleButton385 = new javax.swing.JToggleButton();
        jToggleButton386 = new javax.swing.JToggleButton();
        jToggleButton387 = new javax.swing.JToggleButton();
        jToggleButton388 = new javax.swing.JToggleButton();
        jToggleButton389 = new javax.swing.JToggleButton();
        jToggleButton390 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lblidinicioturno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnregistrovehiculo = new javax.swing.JButton();
        btnsalidap = new javax.swing.JButton();
        btnentregaturnop = new javax.swing.JButton();
        btnpagosp = new javax.swing.JButton();
        btnregistro4 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        lblfecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblfecha.setText("fecha");

        lblempleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblempleado.setText("empleado");

        lblestado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblestado.setText("estado");

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel9.setText("Estado:");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel8.setText("Empleado:");

        lblturnos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblturnos.setText("turnos");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel10.setText("Turno:");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("Fecha:");

        lblnumeroturno.setText("numero_turno");

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel11.setText("N°turno:");

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));

        jToggleButton153.setText("42");

        jToggleButton154.setText("1");

        jToggleButton155.setText("41");

        jToggleButton156.setText("2");

        jToggleButton157.setText("40");

        jToggleButton158.setText("3");

        jToggleButton159.setText("39");

        jToggleButton160.setText("4");

        jToggleButton161.setText("38");

        jToggleButton162.setText("5");

        jToggleButton163.setText("37");

        jToggleButton164.setText("6");

        jToggleButton165.setText("36");

        jToggleButton166.setText("7");

        jToggleButton167.setText("35");

        jToggleButton168.setText("8");

        jToggleButton169.setText("34");

        jToggleButton170.setText("9");

        jToggleButton171.setText("33");

        jToggleButton172.setText("10");

        jToggleButton173.setText("32");

        jToggleButton174.setText("11");

        jToggleButton175.setText("31");

        jToggleButton176.setText("12");

        jToggleButton177.setText("30");

        jToggleButton178.setText("13");

        jToggleButton179.setText("29");

        jToggleButton180.setText("14");

        jToggleButton181.setText("28");

        jToggleButton182.setText("15");

        jToggleButton183.setText("27");

        jToggleButton184.setText("16");

        jToggleButton185.setText("26");

        jToggleButton186.setText("17");

        jToggleButton187.setText("25");

        jToggleButton188.setText("18");

        jToggleButton189.setText("24");

        jToggleButton190.setText("19");

        jToggleButton191.setText("23");

        jToggleButton192.setText("20");

        jToggleButton193.setText("22");

        jToggleButton194.setText("21");

        jToggleButton195.setText("43");
        jToggleButton195.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton195ActionPerformed(evt);
            }
        });

        jToggleButton196.setText("90");

        jToggleButton197.setText("44");

        jToggleButton198.setText("89");

        jToggleButton199.setText("88");

        jToggleButton200.setText("45");

        jToggleButton201.setText("46");

        jToggleButton202.setText("87");

        jToggleButton203.setText("86");

        jToggleButton204.setText("47");

        jToggleButton205.setText("48");

        jToggleButton206.setText("85");

        jToggleButton207.setText("84");

        jToggleButton208.setText("49");

        jToggleButton209.setText("50");

        jToggleButton210.setText("83");

        jToggleButton211.setText("82");

        jToggleButton212.setText("51");

        jToggleButton213.setText("81");

        jToggleButton214.setText("52");

        jToggleButton215.setText("53");

        jToggleButton216.setText("80");

        jToggleButton217.setText("79");

        jToggleButton218.setText("54");

        jToggleButton219.setText("55");

        jToggleButton220.setText("78");

        jToggleButton221.setText("77");

        jToggleButton222.setText("56");

        jToggleButton223.setText("57");

        jToggleButton224.setText("76");

        jToggleButton225.setText("75");

        jToggleButton226.setText("58");

        jToggleButton227.setText("59");

        jToggleButton228.setText("74");

        jToggleButton229.setText("73");

        jToggleButton230.setText("60");

        jToggleButton231.setText("61");

        jToggleButton232.setText("72");

        jToggleButton233.setText("71");

        jToggleButton234.setText("62");

        jToggleButton235.setText("63");

        jToggleButton236.setText("70");

        jToggleButton300.setText("64");

        jToggleButton301.setText("65");

        jToggleButton302.setText("66");

        jToggleButton303.setText("67");
        jToggleButton303.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton303ActionPerformed(evt);
            }
        });

        jToggleButton304.setText("68");

        jToggleButton305.setText("69");

        jToggleButton279.setText("91");
        jToggleButton279.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton279ActionPerformed(evt);
            }
        });

        jToggleButton280.setText("160");

        jToggleButton281.setText("159");

        jToggleButton282.setText("92");

        jToggleButton283.setText("93");

        jToggleButton284.setText("158");

        jToggleButton285.setText("157");

        jToggleButton286.setText("94");

        jToggleButton287.setText("95");

        jToggleButton288.setText("156");

        jToggleButton289.setText("155");

        jToggleButton290.setText("96");

        jToggleButton291.setText("97");

        jToggleButton292.setText("154");

        jToggleButton293.setText("98");

        jToggleButton294.setText("153");

        jToggleButton295.setText("152");

        jToggleButton296.setText("99");

        jToggleButton297.setText("100");

        jToggleButton298.setText("151");

        jToggleButton299.setText("150");

        jToggleButton314.setText("101");

        jToggleButton315.setText("102");

        jToggleButton316.setText("149");

        jToggleButton317.setText("148");

        jToggleButton318.setText("103");

        jToggleButton319.setText("104");

        jToggleButton320.setText("105");

        jToggleButton321.setText("106");

        jToggleButton322.setText("107");

        jToggleButton323.setText("108");

        jToggleButton324.setText("109");

        jToggleButton325.setText("110");

        jToggleButton326.setText("111");

        jToggleButton327.setText("112");

        jToggleButton328.setText("113");

        jToggleButton329.setText("114");

        jToggleButton330.setText("137");
        jToggleButton330.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton330ActionPerformed(evt);
            }
        });

        jToggleButton331.setText("138");

        jToggleButton332.setText("139");

        jToggleButton333.setText("140");

        jToggleButton334.setText("141");

        jToggleButton335.setText("142");

        jToggleButton336.setText("143");

        jToggleButton337.setText("144");

        jToggleButton338.setText("145");

        jToggleButton339.setText("146");
        jToggleButton339.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton339ActionPerformed(evt);
            }
        });

        jToggleButton340.setText("147");

        jToggleButton306.setText("115");

        jToggleButton341.setText("116");

        jToggleButton342.setText("117");

        jToggleButton343.setText("118");

        jToggleButton344.setText("119");

        jToggleButton345.setText("120");

        jToggleButton346.setText("121");

        jToggleButton347.setText("122");

        jToggleButton348.setText("123");

        jToggleButton349.setText("124");

        jToggleButton350.setText("125");

        jToggleButton307.setText("136");
        jToggleButton307.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton307ActionPerformed(evt);
            }
        });

        jToggleButton308.setText("135");

        jToggleButton309.setText("134");

        jToggleButton310.setText("133");

        jToggleButton311.setText("132");

        jToggleButton312.setText("131");

        jToggleButton313.setText("130");

        jToggleButton351.setText("129");

        jToggleButton352.setText("128");

        jToggleButton353.setText("127");

        jToggleButton354.setText("126");

        jToggleButton355.setText("161");

        jToggleButton356.setText("162");

        jToggleButton357.setText("163");

        jToggleButton358.setText("164");

        jToggleButton359.setText("165");

        jToggleButton360.setText("166");

        jToggleButton361.setText("167");

        jToggleButton362.setText("168");

        jToggleButton363.setText("169");

        jToggleButton364.setText("170");

        jToggleButton365.setText("171");

        jToggleButton366.setText("172");

        jToggleButton367.setText("173");

        jToggleButton368.setText("174");

        jToggleButton369.setText("175");

        jToggleButton370.setText("176");

        jToggleButton371.setText("177");

        jToggleButton372.setText("178");

        jToggleButton373.setText("179");

        jToggleButton374.setText("180");

        jToggleButton375.setText("181");

        jToggleButton376.setText("182");

        jToggleButton377.setText("183");

        jToggleButton378.setText("184");
        jToggleButton378.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton378ActionPerformed(evt);
            }
        });

        jToggleButton379.setText("185");
        jToggleButton379.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton379ActionPerformed(evt);
            }
        });

        jToggleButton380.setText("186");

        jToggleButton381.setText("187");

        jToggleButton382.setText("188");

        jToggleButton383.setText("189");

        jToggleButton384.setText("190");

        jToggleButton385.setText("191");

        jToggleButton386.setText("192");

        jToggleButton387.setText("193");

        jToggleButton388.setText("194");

        jToggleButton389.setText("196");

        jToggleButton390.setText("195");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CALLE 1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("CALLE 2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("CALLE 3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CALLE 4");

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton165))
                            .addComponent(jToggleButton153)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton161))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton159))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton157))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton163))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jToggleButton155))))
                        .addGap(38, 38, 38)
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jToggleButton189))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jToggleButton183))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton173))
                            .addComponent(jToggleButton169)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton171))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton179))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton177))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jToggleButton187))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton181))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jToggleButton185))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(480, 480, 480)
                                .addComponent(jToggleButton193))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton175))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(jToggleButton191))))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jToggleButton167))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addComponent(jToggleButton154, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(680, 680, 680)
                                .addComponent(jToggleButton190))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(jToggleButton178))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(760, 760, 760)
                                .addComponent(jToggleButton194))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(560, 560, 560)
                                .addComponent(jToggleButton184))
                            .addComponent(jToggleButton156, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(720, 720, 720)
                                .addComponent(jToggleButton192))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton160, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton162, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(480, 480, 480)
                                .addComponent(jToggleButton180))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jToggleButton174))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jToggleButton176))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton158, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jToggleButton172))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(520, 520, 520)
                                .addComponent(jToggleButton182))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(600, 600, 600)
                                .addComponent(jToggleButton186))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton168, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(640, 640, 640)
                                .addComponent(jToggleButton188))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton164, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jToggleButton170, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton166, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton195)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton205))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton204, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton201))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton200))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton197)))
                        .addGap(38, 38, 38)
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton209)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jToggleButton227))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton215))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(520, 520, 520)
                                .addComponent(jToggleButton235))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(600, 600, 600)
                                .addComponent(jToggleButton301))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton214))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(480, 480, 480)
                                .addComponent(jToggleButton234))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(560, 560, 560)
                                .addComponent(jToggleButton300))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton218))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton212))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton222))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jToggleButton230))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(jToggleButton231))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jToggleButton223))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(640, 640, 640)
                                .addComponent(jToggleButton302))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jToggleButton226))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton219))))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jToggleButton208))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(440, 440, 440)
                                .addComponent(jToggleButton217))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jToggleButton216))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton203))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton199))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton202))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(480, 480, 480)
                                .addComponent(jToggleButton220))
                            .addComponent(jToggleButton196)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton207))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton198))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton206))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jToggleButton213))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jToggleButton211))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jToggleButton210))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(520, 520, 520)
                                .addComponent(jToggleButton221))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(560, 560, 560)
                                .addComponent(jToggleButton224)))
                        .addGap(38, 38, 38)
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jToggleButton303))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton305))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton233))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton236))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton232))
                            .addComponent(jToggleButton228)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jToggleButton229))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton304))))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(jToggleButton225))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jToggleButton296))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(jToggleButton291))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jToggleButton293))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jToggleButton290))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jToggleButton286))
                            .addComponent(jToggleButton279)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jToggleButton287, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jToggleButton297))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jToggleButton283))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jToggleButton282))))
                        .addComponent(jToggleButton314, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jToggleButton315)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton318, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton319, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jToggleButton320)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton321)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton322)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton323)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton324)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton325)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton326)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton327)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton328)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton329)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton306)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton341)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton342)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton343)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton344)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton345)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton346)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton347)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton348)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton349)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton350))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addComponent(jToggleButton280)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton281)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton284)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton285)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton288)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton289)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton292)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton294)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton295)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton298)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton299)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton316)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton317)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton340)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton339)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton338)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton337)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton336)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton335)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton334)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton333)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton332)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton331)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton330)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton307)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton308)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton309)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton310)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton311)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton312)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton313)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton351)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton352)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton353)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton354))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addComponent(jToggleButton355)
                                .addGap(2, 2, 2)
                                .addComponent(jToggleButton356))
                            .addGroup(pnlBotonesLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4)))
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton357)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton358)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton359)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton360)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton361)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton362)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton363)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton364)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton365)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton366)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton367)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton368)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton369)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton370)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton371)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton372)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton373)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton374)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton375)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton376)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton377)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton378)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton379)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton380)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton381)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton382)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton383)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton384)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton385)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton386)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton387)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton388)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton390)
                        .addGap(2, 2, 2)
                        .addComponent(jToggleButton389)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton154)
                    .addComponent(jToggleButton190)
                    .addComponent(jToggleButton178)
                    .addComponent(jToggleButton194)
                    .addComponent(jToggleButton184)
                    .addComponent(jToggleButton156)
                    .addComponent(jToggleButton192)
                    .addComponent(jToggleButton160)
                    .addComponent(jToggleButton162)
                    .addComponent(jToggleButton180)
                    .addComponent(jToggleButton174)
                    .addComponent(jToggleButton176)
                    .addComponent(jToggleButton158)
                    .addComponent(jToggleButton172)
                    .addComponent(jToggleButton182)
                    .addComponent(jToggleButton186)
                    .addComponent(jToggleButton168)
                    .addComponent(jToggleButton188)
                    .addComponent(jToggleButton164)
                    .addComponent(jToggleButton170)
                    .addComponent(jToggleButton166))
                .addGap(7, 7, 7)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton165)
                    .addComponent(jToggleButton153)
                    .addComponent(jToggleButton161)
                    .addComponent(jToggleButton159)
                    .addComponent(jToggleButton157)
                    .addComponent(jToggleButton163)
                    .addComponent(jToggleButton155)
                    .addComponent(jToggleButton189)
                    .addComponent(jToggleButton183)
                    .addComponent(jToggleButton173)
                    .addComponent(jToggleButton169)
                    .addComponent(jToggleButton171)
                    .addComponent(jToggleButton179)
                    .addComponent(jToggleButton177)
                    .addComponent(jToggleButton187)
                    .addComponent(jToggleButton181)
                    .addComponent(jToggleButton185)
                    .addComponent(jToggleButton193)
                    .addComponent(jToggleButton175)
                    .addComponent(jToggleButton191)
                    .addComponent(jToggleButton167))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton195)
                    .addComponent(jToggleButton205)
                    .addComponent(jToggleButton204)
                    .addComponent(jToggleButton201)
                    .addComponent(jToggleButton200)
                    .addComponent(jToggleButton197)
                    .addComponent(jToggleButton209)
                    .addComponent(jToggleButton227)
                    .addComponent(jToggleButton215)
                    .addComponent(jToggleButton235)
                    .addComponent(jToggleButton301)
                    .addComponent(jToggleButton214)
                    .addComponent(jToggleButton234)
                    .addComponent(jToggleButton300)
                    .addComponent(jToggleButton218)
                    .addComponent(jToggleButton212)
                    .addComponent(jToggleButton222)
                    .addComponent(jToggleButton230)
                    .addComponent(jToggleButton231)
                    .addComponent(jToggleButton223)
                    .addComponent(jToggleButton302)
                    .addComponent(jToggleButton226)
                    .addComponent(jToggleButton219)
                    .addComponent(jToggleButton208))
                .addGap(7, 7, 7)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton217)
                    .addComponent(jToggleButton216)
                    .addComponent(jToggleButton203)
                    .addComponent(jToggleButton199)
                    .addComponent(jToggleButton202)
                    .addComponent(jToggleButton220)
                    .addComponent(jToggleButton196)
                    .addComponent(jToggleButton207)
                    .addComponent(jToggleButton198)
                    .addComponent(jToggleButton206)
                    .addComponent(jToggleButton213)
                    .addComponent(jToggleButton211)
                    .addComponent(jToggleButton210)
                    .addComponent(jToggleButton221)
                    .addComponent(jToggleButton224)
                    .addComponent(jToggleButton303)
                    .addComponent(jToggleButton305)
                    .addComponent(jToggleButton233)
                    .addComponent(jToggleButton236)
                    .addComponent(jToggleButton232)
                    .addComponent(jToggleButton228)
                    .addComponent(jToggleButton229)
                    .addComponent(jToggleButton304)
                    .addComponent(jToggleButton225))
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton296)
                    .addComponent(jToggleButton291)
                    .addComponent(jToggleButton293)
                    .addComponent(jToggleButton290)
                    .addComponent(jToggleButton286)
                    .addComponent(jToggleButton282)
                    .addComponent(jToggleButton279)
                    .addComponent(jToggleButton287)
                    .addComponent(jToggleButton297)
                    .addComponent(jToggleButton283)
                    .addComponent(jToggleButton314)
                    .addComponent(jToggleButton315)
                    .addComponent(jToggleButton318)
                    .addComponent(jToggleButton319)
                    .addComponent(jToggleButton320)
                    .addComponent(jToggleButton321)
                    .addComponent(jToggleButton322)
                    .addComponent(jToggleButton323)
                    .addComponent(jToggleButton324)
                    .addComponent(jToggleButton325)
                    .addComponent(jToggleButton326)
                    .addComponent(jToggleButton327)
                    .addComponent(jToggleButton328)
                    .addComponent(jToggleButton329)
                    .addComponent(jToggleButton306)
                    .addComponent(jToggleButton341)
                    .addComponent(jToggleButton342)
                    .addComponent(jToggleButton343)
                    .addComponent(jToggleButton344)
                    .addComponent(jToggleButton345)
                    .addComponent(jToggleButton346)
                    .addComponent(jToggleButton347)
                    .addComponent(jToggleButton348)
                    .addComponent(jToggleButton349)
                    .addComponent(jToggleButton350))
                .addGap(7, 7, 7)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton280)
                    .addComponent(jToggleButton281)
                    .addComponent(jToggleButton284)
                    .addComponent(jToggleButton285)
                    .addComponent(jToggleButton288)
                    .addComponent(jToggleButton289)
                    .addComponent(jToggleButton292)
                    .addComponent(jToggleButton294)
                    .addComponent(jToggleButton295)
                    .addComponent(jToggleButton298)
                    .addComponent(jToggleButton299)
                    .addComponent(jToggleButton316)
                    .addComponent(jToggleButton317)
                    .addComponent(jToggleButton340)
                    .addComponent(jToggleButton339)
                    .addComponent(jToggleButton338)
                    .addComponent(jToggleButton337)
                    .addComponent(jToggleButton336)
                    .addComponent(jToggleButton335)
                    .addComponent(jToggleButton334)
                    .addComponent(jToggleButton333)
                    .addComponent(jToggleButton332)
                    .addComponent(jToggleButton331)
                    .addComponent(jToggleButton330)
                    .addComponent(jToggleButton307)
                    .addComponent(jToggleButton308)
                    .addComponent(jToggleButton309)
                    .addComponent(jToggleButton310)
                    .addComponent(jToggleButton311)
                    .addComponent(jToggleButton312)
                    .addComponent(jToggleButton313)
                    .addComponent(jToggleButton351)
                    .addComponent(jToggleButton352)
                    .addComponent(jToggleButton353)
                    .addComponent(jToggleButton354))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton355)
                    .addComponent(jToggleButton356)
                    .addComponent(jToggleButton357)
                    .addComponent(jToggleButton358)
                    .addComponent(jToggleButton359)
                    .addComponent(jToggleButton360)
                    .addComponent(jToggleButton361)
                    .addComponent(jToggleButton362)
                    .addComponent(jToggleButton363)
                    .addComponent(jToggleButton364)
                    .addComponent(jToggleButton365)
                    .addComponent(jToggleButton366)
                    .addComponent(jToggleButton367)
                    .addComponent(jToggleButton368)
                    .addComponent(jToggleButton369)
                    .addComponent(jToggleButton370)
                    .addComponent(jToggleButton371)
                    .addComponent(jToggleButton372)
                    .addComponent(jToggleButton373)
                    .addComponent(jToggleButton374)
                    .addComponent(jToggleButton375)
                    .addComponent(jToggleButton376)
                    .addComponent(jToggleButton377)
                    .addComponent(jToggleButton378)
                    .addComponent(jToggleButton379)
                    .addComponent(jToggleButton380)
                    .addComponent(jToggleButton381)
                    .addComponent(jToggleButton382)
                    .addComponent(jToggleButton383)
                    .addComponent(jToggleButton384)
                    .addComponent(jToggleButton385)
                    .addComponent(jToggleButton386)
                    .addComponent(jToggleButton387)
                    .addComponent(jToggleButton388)
                    .addComponent(jToggleButton390)
                    .addComponent(jToggleButton389))
                .addGap(27, 27, 27))
        );

        jScrollPane1.setViewportView(pnlBotones);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        lblidinicioturno.setText("ID");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen pits.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo luci.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblnumeroturno)
                                .addGap(75, 75, 75)
                                .addComponent(lblidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel10)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblturnos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblestado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblempleado)
                                                .addGap(0, 0, 0)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblnumeroturno)
                                                .addGap(4, 4, 4)
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel6)
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(lblturnos))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblfecha)))
                                    .addComponent(jLabel9)
                                    .addComponent(lblestado)))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblidinicioturno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistrovehiculo.setBackground(new java.awt.Color(204, 204, 204));
        btnregistrovehiculo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnregistrovehiculo.setForeground(new java.awt.Color(0, 0, 102));
        btnregistrovehiculo.setText("INGRESO VEHICULO");
        btnregistrovehiculo.setActionCommand("     REGISTRO");
        btnregistrovehiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnregistrovehiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnregistrovehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrovehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistrovehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        btnsalidap.setBackground(new java.awt.Color(204, 204, 204));
        btnsalidap.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnsalidap.setForeground(new java.awt.Color(0, 0, 102));
        btnsalidap.setText("SALIDA VEHICULO");
        btnsalidap.setActionCommand("     REGISTRO");
        btnsalidap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalidap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalidap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidapActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalidap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 30));

        btnentregaturnop.setBackground(new java.awt.Color(204, 204, 204));
        btnentregaturnop.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnentregaturnop.setForeground(new java.awt.Color(0, 0, 102));
        btnentregaturnop.setText("ENTREGA TURNO");
        btnentregaturnop.setActionCommand("     REGISTRO");
        btnentregaturnop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnentregaturnop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnentregaturnop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentregaturnopActionPerformed(evt);
            }
        });
        jPanel1.add(btnentregaturnop, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 130, 30));

        btnpagosp.setBackground(new java.awt.Color(204, 204, 204));
        btnpagosp.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnpagosp.setForeground(new java.awt.Color(0, 0, 102));
        btnpagosp.setText("ABONOS");
        btnpagosp.setActionCommand("     REGISTRO");
        btnpagosp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnpagosp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnpagosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpagospActionPerformed(evt);
            }
        });
        jPanel1.add(btnpagosp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 130, 30));

        btnregistro4.setBackground(new java.awt.Color(204, 204, 204));
        btnregistro4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnregistro4.setForeground(new java.awt.Color(0, 0, 102));
        btnregistro4.setText("OTROS");
        btnregistro4.setActionCommand("     REGISTRO");
        btnregistro4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnregistro4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnregistro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistro4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 130, 30));

        desktopPane.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrovehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrovehiculoActionPerformed

        if (ingresoFormulario == null || !ingresoFormulario.isVisible()) {
            // Si no está abierto, crea una nueva instancia o usa el Singleton
            ingresoFormulario = new Jingresop(); // Usando Singleton
            ingresoFormulario.setVisible(true);
        } else {
            // Si ya está abierto, enfócalo
            ingresoFormulario.setExtendedState(JFrame.NORMAL); // Restaurar si está minimizado
            ingresoFormulario.toFront(); // Traer al frente
            ingresoFormulario.requestFocus(); // Solicitar foco
        }
        Jingresop.txtempleado.setText(lblempleado.getText());
        Jingresop.lblturnos.setText(lblturnos.getText());
        Jingresop.txtnumeroturno.setText(lblnumeroturno.getText());
        Jingresop.txtidinicio_turno.setText(lblidinicioturno.getText());
    }//GEN-LAST:event_btnregistrovehiculoActionPerformed

    private void btnsalidapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidapActionPerformed

        if (salidaFormulario == null || !salidaFormulario.isVisible()) {
            // Si no está abierto, crea una nueva instancia o usa el Singleton
            salidaFormulario = new Jsalidap();
            salidaFormulario.setVisible(true);
        } else {
            // Si ya está abierto, enfócalo
            salidaFormulario.setExtendedState(JFrame.NORMAL); // Restaurar si está minimizado
            salidaFormulario.toFront(); // Traer al frente
            salidaFormulario.requestFocus(); // Solicitar foco
        }
        Jsalidap.txtempleadosalida.setText(lblempleado.getText());
        Jsalidap.lblturno.setText(lblturnos.getText());
        Jsalidap.txtturnosalida.setText(lblnumeroturno.getText());
    }//GEN-LAST:event_btnsalidapActionPerformed

    private void btnentregaturnopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentregaturnopActionPerformed

        Finicioturnop finicio = new Finicioturnop();

        if (sesionIniciada) {
            // Si la sesión no está iniciada, mostrar el formulario de inicio de sesión

            Jfinturnop formTurnos = new Jfinturnop();
            formTurnos.toFront();
            formTurnos.setVisible(true);
            if (salidaturno == null || !salidaturno.isVisible()) {
                // Si no está abierto, crea una nueva instancia o usa el Singleton
                salidaturno = new Jfinturnop(); // Usando Singleton
                salidaturno.setVisible(true);
            } else {
                // Si ya está abierto, enfócalo
                salidaturno.setExtendedState(JFrame.NORMAL); // Restaurar si está minimizado
                salidaturno.toFront(); // Traer al frente
                salidaturno.requestFocus(); // Solicitar foco
            }

            metodoDondeSeNecesitaFormLogin();
        } else {
            if (finicio.hayTurnoActivo()) {
                JOptionPane.showMessageDialog(null, "Hay un turno activo. Debe finalizar el turno actual antes de iniciar uno nuevo.");
                Jfinturnop formTurnos = new Jfinturnop();
                formTurnos.toFront();
                formTurnos.setVisible(true);

            } else {
                Jinicioturnop formLogin = new Jinicioturnop();
                formLogin.toFront();
                formLogin.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnentregaturnopActionPerformed

    private void btnpagospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpagospActionPerformed

        if (pagoFormulario == null || !pagoFormulario.isVisible()) {
            // Si no está abierto, crea una nueva instancia o usa el Singleton
            pagoFormulario = new Jabonosp(); // Usando Singleton
            pagoFormulario.setVisible(true);
        } else {
            // Si ya está abierto, enfócalo
            pagoFormulario.setExtendedState(JFrame.NORMAL); // Restaurar si está minimizado
            pagoFormulario.toFront(); // Traer al frente
            pagoFormulario.requestFocus(); // Solicitar foco
        }
        Jabonosp.txtempleado.setText(lblempleado.getText());
        Jabonosp.lblturnos.setText(lblturnos.getText());
    }//GEN-LAST:event_btnpagospActionPerformed

    private void btnregistro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistro4ActionPerformed

    }//GEN-LAST:event_btnregistro4ActionPerformed

    private void jToggleButton303ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton303ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton303ActionPerformed

    private void jToggleButton195ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton195ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton195ActionPerformed

    private void jToggleButton279ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton279ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton279ActionPerformed

    private void jToggleButton330ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton330ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton330ActionPerformed

    private void jToggleButton307ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton307ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton307ActionPerformed

    private void jToggleButton378ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton378ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton378ActionPerformed

    private void jToggleButton379ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton379ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton379ActionPerformed

    private void jToggleButton339ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton339ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton339ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jmenuparqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jmenuparqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jmenuparqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jmenuparqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jmenuparqueadero().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnentregaturnop;
    private javax.swing.JButton btnpagosp;
    private javax.swing.JButton btnregistro4;
    private javax.swing.JButton btnregistrovehiculo;
    private javax.swing.JButton btnsalidap;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToggleButton jToggleButton153;
    private javax.swing.JToggleButton jToggleButton154;
    private javax.swing.JToggleButton jToggleButton155;
    private javax.swing.JToggleButton jToggleButton156;
    private javax.swing.JToggleButton jToggleButton157;
    private javax.swing.JToggleButton jToggleButton158;
    private javax.swing.JToggleButton jToggleButton159;
    private javax.swing.JToggleButton jToggleButton160;
    private javax.swing.JToggleButton jToggleButton161;
    private javax.swing.JToggleButton jToggleButton162;
    private javax.swing.JToggleButton jToggleButton163;
    private javax.swing.JToggleButton jToggleButton164;
    private javax.swing.JToggleButton jToggleButton165;
    private javax.swing.JToggleButton jToggleButton166;
    private javax.swing.JToggleButton jToggleButton167;
    private javax.swing.JToggleButton jToggleButton168;
    private javax.swing.JToggleButton jToggleButton169;
    private javax.swing.JToggleButton jToggleButton170;
    private javax.swing.JToggleButton jToggleButton171;
    private javax.swing.JToggleButton jToggleButton172;
    private javax.swing.JToggleButton jToggleButton173;
    private javax.swing.JToggleButton jToggleButton174;
    private javax.swing.JToggleButton jToggleButton175;
    private javax.swing.JToggleButton jToggleButton176;
    private javax.swing.JToggleButton jToggleButton177;
    private javax.swing.JToggleButton jToggleButton178;
    private javax.swing.JToggleButton jToggleButton179;
    private javax.swing.JToggleButton jToggleButton180;
    private javax.swing.JToggleButton jToggleButton181;
    private javax.swing.JToggleButton jToggleButton182;
    private javax.swing.JToggleButton jToggleButton183;
    private javax.swing.JToggleButton jToggleButton184;
    private javax.swing.JToggleButton jToggleButton185;
    private javax.swing.JToggleButton jToggleButton186;
    private javax.swing.JToggleButton jToggleButton187;
    private javax.swing.JToggleButton jToggleButton188;
    private javax.swing.JToggleButton jToggleButton189;
    private javax.swing.JToggleButton jToggleButton190;
    private javax.swing.JToggleButton jToggleButton191;
    private javax.swing.JToggleButton jToggleButton192;
    private javax.swing.JToggleButton jToggleButton193;
    private javax.swing.JToggleButton jToggleButton194;
    private javax.swing.JToggleButton jToggleButton195;
    private javax.swing.JToggleButton jToggleButton196;
    private javax.swing.JToggleButton jToggleButton197;
    private javax.swing.JToggleButton jToggleButton198;
    private javax.swing.JToggleButton jToggleButton199;
    private javax.swing.JToggleButton jToggleButton200;
    private javax.swing.JToggleButton jToggleButton201;
    private javax.swing.JToggleButton jToggleButton202;
    private javax.swing.JToggleButton jToggleButton203;
    private javax.swing.JToggleButton jToggleButton204;
    private javax.swing.JToggleButton jToggleButton205;
    private javax.swing.JToggleButton jToggleButton206;
    private javax.swing.JToggleButton jToggleButton207;
    private javax.swing.JToggleButton jToggleButton208;
    private javax.swing.JToggleButton jToggleButton209;
    private javax.swing.JToggleButton jToggleButton210;
    private javax.swing.JToggleButton jToggleButton211;
    private javax.swing.JToggleButton jToggleButton212;
    private javax.swing.JToggleButton jToggleButton213;
    private javax.swing.JToggleButton jToggleButton214;
    private javax.swing.JToggleButton jToggleButton215;
    private javax.swing.JToggleButton jToggleButton216;
    private javax.swing.JToggleButton jToggleButton217;
    private javax.swing.JToggleButton jToggleButton218;
    private javax.swing.JToggleButton jToggleButton219;
    private javax.swing.JToggleButton jToggleButton220;
    private javax.swing.JToggleButton jToggleButton221;
    private javax.swing.JToggleButton jToggleButton222;
    private javax.swing.JToggleButton jToggleButton223;
    private javax.swing.JToggleButton jToggleButton224;
    private javax.swing.JToggleButton jToggleButton225;
    private javax.swing.JToggleButton jToggleButton226;
    private javax.swing.JToggleButton jToggleButton227;
    private javax.swing.JToggleButton jToggleButton228;
    private javax.swing.JToggleButton jToggleButton229;
    private javax.swing.JToggleButton jToggleButton230;
    private javax.swing.JToggleButton jToggleButton231;
    private javax.swing.JToggleButton jToggleButton232;
    private javax.swing.JToggleButton jToggleButton233;
    private javax.swing.JToggleButton jToggleButton234;
    private javax.swing.JToggleButton jToggleButton235;
    private javax.swing.JToggleButton jToggleButton236;
    private javax.swing.JToggleButton jToggleButton279;
    private javax.swing.JToggleButton jToggleButton280;
    private javax.swing.JToggleButton jToggleButton281;
    private javax.swing.JToggleButton jToggleButton282;
    private javax.swing.JToggleButton jToggleButton283;
    private javax.swing.JToggleButton jToggleButton284;
    private javax.swing.JToggleButton jToggleButton285;
    private javax.swing.JToggleButton jToggleButton286;
    private javax.swing.JToggleButton jToggleButton287;
    private javax.swing.JToggleButton jToggleButton288;
    private javax.swing.JToggleButton jToggleButton289;
    private javax.swing.JToggleButton jToggleButton290;
    private javax.swing.JToggleButton jToggleButton291;
    private javax.swing.JToggleButton jToggleButton292;
    private javax.swing.JToggleButton jToggleButton293;
    private javax.swing.JToggleButton jToggleButton294;
    private javax.swing.JToggleButton jToggleButton295;
    private javax.swing.JToggleButton jToggleButton296;
    private javax.swing.JToggleButton jToggleButton297;
    private javax.swing.JToggleButton jToggleButton298;
    private javax.swing.JToggleButton jToggleButton299;
    private javax.swing.JToggleButton jToggleButton300;
    private javax.swing.JToggleButton jToggleButton301;
    private javax.swing.JToggleButton jToggleButton302;
    private javax.swing.JToggleButton jToggleButton303;
    private javax.swing.JToggleButton jToggleButton304;
    private javax.swing.JToggleButton jToggleButton305;
    private javax.swing.JToggleButton jToggleButton306;
    private javax.swing.JToggleButton jToggleButton307;
    private javax.swing.JToggleButton jToggleButton308;
    private javax.swing.JToggleButton jToggleButton309;
    private javax.swing.JToggleButton jToggleButton310;
    private javax.swing.JToggleButton jToggleButton311;
    private javax.swing.JToggleButton jToggleButton312;
    private javax.swing.JToggleButton jToggleButton313;
    private javax.swing.JToggleButton jToggleButton314;
    private javax.swing.JToggleButton jToggleButton315;
    private javax.swing.JToggleButton jToggleButton316;
    private javax.swing.JToggleButton jToggleButton317;
    private javax.swing.JToggleButton jToggleButton318;
    private javax.swing.JToggleButton jToggleButton319;
    private javax.swing.JToggleButton jToggleButton320;
    private javax.swing.JToggleButton jToggleButton321;
    private javax.swing.JToggleButton jToggleButton322;
    private javax.swing.JToggleButton jToggleButton323;
    private javax.swing.JToggleButton jToggleButton324;
    private javax.swing.JToggleButton jToggleButton325;
    private javax.swing.JToggleButton jToggleButton326;
    private javax.swing.JToggleButton jToggleButton327;
    private javax.swing.JToggleButton jToggleButton328;
    private javax.swing.JToggleButton jToggleButton329;
    private javax.swing.JToggleButton jToggleButton330;
    private javax.swing.JToggleButton jToggleButton331;
    private javax.swing.JToggleButton jToggleButton332;
    private javax.swing.JToggleButton jToggleButton333;
    private javax.swing.JToggleButton jToggleButton334;
    private javax.swing.JToggleButton jToggleButton335;
    private javax.swing.JToggleButton jToggleButton336;
    private javax.swing.JToggleButton jToggleButton337;
    private javax.swing.JToggleButton jToggleButton338;
    private javax.swing.JToggleButton jToggleButton339;
    private javax.swing.JToggleButton jToggleButton340;
    private javax.swing.JToggleButton jToggleButton341;
    private javax.swing.JToggleButton jToggleButton342;
    private javax.swing.JToggleButton jToggleButton343;
    private javax.swing.JToggleButton jToggleButton344;
    private javax.swing.JToggleButton jToggleButton345;
    private javax.swing.JToggleButton jToggleButton346;
    private javax.swing.JToggleButton jToggleButton347;
    private javax.swing.JToggleButton jToggleButton348;
    private javax.swing.JToggleButton jToggleButton349;
    private javax.swing.JToggleButton jToggleButton350;
    private javax.swing.JToggleButton jToggleButton351;
    private javax.swing.JToggleButton jToggleButton352;
    private javax.swing.JToggleButton jToggleButton353;
    private javax.swing.JToggleButton jToggleButton354;
    private javax.swing.JToggleButton jToggleButton355;
    private javax.swing.JToggleButton jToggleButton356;
    private javax.swing.JToggleButton jToggleButton357;
    private javax.swing.JToggleButton jToggleButton358;
    private javax.swing.JToggleButton jToggleButton359;
    private javax.swing.JToggleButton jToggleButton360;
    private javax.swing.JToggleButton jToggleButton361;
    private javax.swing.JToggleButton jToggleButton362;
    private javax.swing.JToggleButton jToggleButton363;
    private javax.swing.JToggleButton jToggleButton364;
    private javax.swing.JToggleButton jToggleButton365;
    private javax.swing.JToggleButton jToggleButton366;
    private javax.swing.JToggleButton jToggleButton367;
    private javax.swing.JToggleButton jToggleButton368;
    private javax.swing.JToggleButton jToggleButton369;
    private javax.swing.JToggleButton jToggleButton370;
    private javax.swing.JToggleButton jToggleButton371;
    private javax.swing.JToggleButton jToggleButton372;
    private javax.swing.JToggleButton jToggleButton373;
    private javax.swing.JToggleButton jToggleButton374;
    private javax.swing.JToggleButton jToggleButton375;
    private javax.swing.JToggleButton jToggleButton376;
    private javax.swing.JToggleButton jToggleButton377;
    private javax.swing.JToggleButton jToggleButton378;
    private javax.swing.JToggleButton jToggleButton379;
    private javax.swing.JToggleButton jToggleButton380;
    private javax.swing.JToggleButton jToggleButton381;
    private javax.swing.JToggleButton jToggleButton382;
    private javax.swing.JToggleButton jToggleButton383;
    private javax.swing.JToggleButton jToggleButton384;
    private javax.swing.JToggleButton jToggleButton385;
    private javax.swing.JToggleButton jToggleButton386;
    private javax.swing.JToggleButton jToggleButton387;
    private javax.swing.JToggleButton jToggleButton388;
    private javax.swing.JToggleButton jToggleButton389;
    private javax.swing.JToggleButton jToggleButton390;
    public static javax.swing.JLabel lblempleado;
    public static javax.swing.JLabel lblestado;
    public static javax.swing.JLabel lblfecha;
    public static javax.swing.JLabel lblidinicioturno;
    public static javax.swing.JLabel lblnumeroturno;
    public static javax.swing.JLabel lblturnos;
    private javax.swing.JPanel pnlBotones;
    // End of variables declaration//GEN-END:variables

}


package vista;

import controlador.Controlador_FRM_Iniciar;
import controlador.Controlador_FRM_Ventana;
import javax.swing.ButtonGroup;

public class FRM_Iniciar extends javax.swing.JFrame {

    public Controlador_FRM_Iniciar controlador_FRM_Inicio;
    Controlador_FRM_Ventana controlador_FRM_VentanaPrincipal;
    ButtonGroup botones= new ButtonGroup();
    public String opcion="";
    
    public FRM_Iniciar(Controlador_FRM_Ventana controlador_FRM_VentanaPrincipal) {
        initComponents();
        setLocation(370,220);
        this.controlador_FRM_VentanaPrincipal=controlador_FRM_VentanaPrincipal;
        botones.add(jrb_BaseDatos);
        botones.add(jrb_XML);
        botones.add(jrb_ArchivosPlanos);
        controlador_FRM_Inicio= new Controlador_FRM_Iniciar(this);
        agregarEventos(controlador_FRM_Inicio);
    }
    public void agregarEventos(Controlador_FRM_Iniciar controlador)
    {
        this.btn_Iniciar.addActionListener(controlador);
        this.jrb_BaseDatos.addActionListener(controlador);
        this.jrb_XML.addActionListener(controlador);
        this.jrb_ArchivosPlanos.addActionListener(controlador);
    }
    public void habilitarIniciar()
    {
        this.btn_Iniciar.setEnabled(true);
    }
    public void opcionSeleccionada(String opcion)
    {
        this.opcion=opcion;
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Seleccionar = new javax.swing.JLabel();
        jrb_BaseDatos = new javax.swing.JRadioButton();
        jrb_XML = new javax.swing.JRadioButton();
        jrb_ArchivosPlanos = new javax.swing.JRadioButton();
        btn_Iniciar = new javax.swing.JButton();
        jl_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_Seleccionar.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jl_Seleccionar.setText("Seleccione un metodo de almacenamiento:");
        getContentPane().add(jl_Seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        jrb_BaseDatos.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jrb_BaseDatos.setText("Base de Datos");
        jrb_BaseDatos.setContentAreaFilled(false);
        getContentPane().add(jrb_BaseDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 170, 30));

        jrb_XML.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jrb_XML.setText("XML");
        jrb_XML.setContentAreaFilled(false);
        getContentPane().add(jrb_XML, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 30));

        jrb_ArchivosPlanos.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jrb_ArchivosPlanos.setText("Archivos Planos");
        jrb_ArchivosPlanos.setContentAreaFilled(false);
        getContentPane().add(jrb_ArchivosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 30));

        btn_Iniciar.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        btn_Iniciar.setText("Iniciar");
        btn_Iniciar.setEnabled(false);
        getContentPane().add(btn_Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, 30));
        getContentPane().add(jl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controlador_FRM_VentanaPrincipal.iniciar();
        controlador_FRM_VentanaPrincipal.inicio(opcion);
    }//GEN-LAST:event_formComponentHidden

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Iniciar;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JLabel jl_Seleccionar;
    private javax.swing.JRadioButton jrb_ArchivosPlanos;
    private javax.swing.JRadioButton jrb_BaseDatos;
    private javax.swing.JRadioButton jrb_XML;
    // End of variables declaration//GEN-END:variables
}

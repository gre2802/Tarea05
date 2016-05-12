
package vista;

import controlador.Controlador_FRM_Inicio;
import controlador.Controlador_FRM_VentanaPrincipal;
import javax.swing.ButtonGroup;

public class FRM_Inicio extends javax.swing.JFrame {

    public Controlador_FRM_Inicio controlador_FRM_Inicio;
    Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    ButtonGroup grupoBotones= new ButtonGroup();
    public String fuente="";
    
    public FRM_Inicio(Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal) {
        initComponents();
        setLocation(370,220);
        this.controlador_FRM_VentanaPrincipal=controlador_FRM_VentanaPrincipal;
        grupoBotones.add(jrb_BaseDatos);
        grupoBotones.add(jrb_XML);
        grupoBotones.add(jrb_ArchivosPlanos);
        controlador_FRM_Inicio= new Controlador_FRM_Inicio(this);
        agregarEventos(controlador_FRM_Inicio);
    }
    public void agregarEventos(Controlador_FRM_Inicio controlador)
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
    public void fuenteSeleccionada(String fuente)
    {
        this.fuente=fuente;
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

        jl_Seleccionar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jl_Seleccionar.setForeground(new java.awt.Color(0, 0, 0));
        jl_Seleccionar.setText("Seleccione la fuente con la que desea trabajar:");
        getContentPane().add(jl_Seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jrb_BaseDatos.setForeground(new java.awt.Color(0, 0, 0));
        jrb_BaseDatos.setText("Base de Datos");
        jrb_BaseDatos.setContentAreaFilled(false);
        getContentPane().add(jrb_BaseDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 120, -1));

        jrb_XML.setForeground(new java.awt.Color(0, 0, 0));
        jrb_XML.setText("XML");
        jrb_XML.setContentAreaFilled(false);
        getContentPane().add(jrb_XML, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 120, -1));

        jrb_ArchivosPlanos.setForeground(new java.awt.Color(0, 0, 0));
        jrb_ArchivosPlanos.setText("Archivos Planos");
        jrb_ArchivosPlanos.setContentAreaFilled(false);
        getContentPane().add(jrb_ArchivosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btn_Iniciar.setText("Iniciar");
        btn_Iniciar.setEnabled(false);
        getContentPane().add(btn_Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jl_Fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN1\\Documents\\UCR\\Progra 2\\img\\fondo - copia.jpg")); // NOI18N
        getContentPane().add(jl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controlador_FRM_VentanaPrincipal.iniciar();
        controlador_FRM_VentanaPrincipal.inicio(fuente);
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

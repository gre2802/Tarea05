
package vista;

import controlador.Controlador_FRM_MantenimientoUsuarios;
import javax.swing.JOptionPane;

public class FRM_MantenimientoUsuarios extends javax.swing.JFrame {

    public Controlador_FRM_MantenimientoUsuarios controlador_FRM_MantenimientoUsuarios;
    FRM_Inicio frm_Inicio;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    
    public FRM_MantenimientoUsuarios(FRM_Inicio frm_Inicio,FRM_VentanaPrincipal frm_VentanaPrincipal) {
        super("Mantenimiento de Usuarios");
        initComponents();
        this.setLocation(250, 200);
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        this.frm_Inicio=frm_Inicio;
        controlador_FRM_MantenimientoUsuarios= new Controlador_FRM_MantenimientoUsuarios(frm_Inicio,this);
        this.panel_Botones1.agregarEventos(controlador_FRM_MantenimientoUsuarios);
        cargarTipoUsuario();
    }
    public void cargarTipoUsuario() 
    {
      this.jcb_Tipo.removeAllItems();
      this.jcb_Tipo.addItem("Administrador");
      this.jcb_Tipo.addItem("Docente");
      this.jcb_Tipo.addItem("Estudiante");
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_NombreCompleto.setText(arreglo[0]);
        this.jt_NombreUsuario.setText(arreglo[1]);
        this.jpf_Contraseña.setText(arreglo[2]);
        
        if(arreglo[3].equals("Administrador"))
            this.jcb_Tipo.setSelectedIndex(0);
        if(arreglo[3].equals("Docente"))
            this.jcb_Tipo.setSelectedIndex(1);
        if(arreglo[3].equals("Estudiante"))
            this.jcb_Tipo.setSelectedIndex(2);
    }
    public String[] devolverInformacion()
    {
        String informacion[]=new String[5];
        informacion[0]=this.jt_Cedula.getText();
        informacion[1]=this.jt_NombreCompleto.getText();
        informacion[2]=this.jt_NombreUsuario.getText();
        informacion[3]=this.jpf_Contraseña.getText();
        informacion[4]=""+this.jcb_Tipo.getSelectedItem();
        
        return informacion;
    }
    public String devolverCedula() 
    {
        return this.jt_Cedula.getText();
    }
    public void habilitarEdicion()
    {
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_NombreUsuario.setEnabled(false);
        this.jpf_Contraseña.setEnabled(true);
        this.jpf_RepetirContraseña.setEnabled(true);
        this.jcb_Tipo.setEnabled(true);
        this.panel_Botones1.habilitarEdicion();
    }
    public void habilitarAgregar() 
    {
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_NombreUsuario.setEnabled(true);
        this.jpf_Contraseña.setEnabled(true);
        this.jpf_RepetirContraseña.setEnabled(true);
        this.jcb_Tipo.setEnabled(true);
        this.panel_Botones1.habilitarAgregar();
    }
    public void resetearGUI()
    {
        this.jt_Cedula.setText("");
        this.jt_Cedula.setEnabled(true);
        this.jt_NombreCompleto.setText("");
        this.jt_NombreCompleto.setEnabled(false);
        this.jt_NombreUsuario.setText("");
        this.jt_NombreUsuario.setEnabled(false);
        this.jpf_Contraseña.setText("");
        this.jpf_Contraseña.setEnabled(false);
        this.jpf_RepetirContraseña.setText("");
        this.jpf_RepetirContraseña.setEnabled(false);
        this.jcb_Tipo.setSelectedIndex(0);
        this.jcb_Tipo.setEnabled(false);
        this.panel_Botones1.deshabilitarAgregar();
        this.panel_Botones1.deshabilitarModificar();
        this.panel_Botones1.deshabilitarEliminar();
    }
    public void limpiarRepetirContraseña() {
        this.jpf_RepetirContraseña.setText("");
    }
    public boolean verificarContraseñas() {
        
        boolean iguales=false;
        
        if(this.jpf_Contraseña.getText().equals(this.jpf_RepetirContraseña.getText()))
            iguales=true;
        
        return iguales;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_NombreCompleto = new javax.swing.JLabel();
        jl_NombreUsuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jl_RepetirContraseña = new javax.swing.JLabel();
        jl_Tipo = new javax.swing.JLabel();
        jpf_RepetirContraseña = new javax.swing.JPasswordField();
        jpf_Contraseña = new javax.swing.JPasswordField();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreCompleto = new javax.swing.JTextField();
        jt_NombreUsuario = new javax.swing.JTextField();
        jcb_Tipo = new javax.swing.JComboBox<>();
        panel_Botones1 = new vista.Panel_Botones();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jl_Cedula.setText("Cédula");

        jl_NombreCompleto.setText("Nombre Completo");

        jl_NombreUsuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        jl_RepetirContraseña.setText("Repetir Contraseña");

        jl_Tipo.setText("Tipo");

        jpf_RepetirContraseña.setEnabled(false);

        jpf_Contraseña.setEnabled(false);

        jt_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_CedulaKeyPressed(evt);
            }
        });

        jt_NombreCompleto.setEnabled(false);

        jt_NombreUsuario.setEnabled(false);

        jcb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_Tipo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_RepetirContraseña)
                            .addComponent(jl_Contraseña)
                            .addComponent(jl_Cedula)
                            .addComponent(jl_NombreCompleto)
                            .addComponent(jl_NombreUsuario)
                            .addComponent(jl_Tipo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpf_RepetirContraseña)
                            .addComponent(jpf_Contraseña)
                            .addComponent(jt_Cedula)
                            .addComponent(jt_NombreCompleto)
                            .addComponent(jt_NombreUsuario)
                            .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cedula)
                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreUsuario)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contraseña)
                    .addComponent(jpf_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_RepetirContraseña)
                    .addComponent(jpf_RepetirContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_Tipo)
                    .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_CedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_CedulaKeyPressed
        
        if(evt.getKeyCode()==10)
        {
            if(frm_Inicio.fuente.equals("AP"))
               this.controlador_FRM_MantenimientoUsuarios.buscarAP();
        }
    }//GEN-LAST:event_jt_CedulaKeyPressed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            this.controlador_FRM_MantenimientoUsuarios.metodosUsuarios.escribirInformacionEnElArchivo();
            this.frm_VentanaPrincipal.show();
            resetearGUI();
        }
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcb_Tipo;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_NombreUsuario;
    private javax.swing.JLabel jl_RepetirContraseña;
    private javax.swing.JLabel jl_Tipo;
    private javax.swing.JPasswordField jpf_Contraseña;
    private javax.swing.JPasswordField jpf_RepetirContraseña;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_NombreUsuario;
    private vista.Panel_Botones panel_Botones1;
    // End of variables declaration//GEN-END:variables
}

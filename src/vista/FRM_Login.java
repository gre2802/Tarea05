
package vista;

import controlador.Controlador_FRM_Login;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.MetodosUsuarios;

public class FRM_Login extends javax.swing.JFrame {

    Controlador_FRM_Login controlador_FRM_Login;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    public MetodosUsuarios metodosUsuarios;
    
    public FRM_Login(FRM_Inicio frm_Inicio,FRM_VentanaPrincipal frm_VentanaPrincipal,MetodosUsuarios metodosUsuarios,ConexionBD conexion,FRM_MantenimientoUsuarios frm_MantenimientoUsuarios) {
        super("Login");
        initComponents();
        this.setLocation(500, 250);
        this.metodosUsuarios=metodosUsuarios;
        controlador_FRM_Login= new Controlador_FRM_Login(frm_Inicio,this,frm_VentanaPrincipal,conexion,frm_MantenimientoUsuarios);
        agregarEventos(controlador_FRM_Login);
    }
    
    public void agregarEventos(Controlador_FRM_Login controlador)
    {
        this.btn_Ingresar.addActionListener(controlador);
        this.btn_Salir.addActionListener(controlador);
    }
    public String devolverNombreUsuario() 
    {
        return this.jt_NombreUsuario.getText();
    }
    public String devolverContraseña() 
    {
        return this.jpf_Contraseña.getText();
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void limpiarCampoContraseña() 
    {
        this.jpf_Contraseña.setText("");
    }
    public void resetearGUI() 
    {
        this.jt_NombreUsuario.setText("");
        this.jpf_Contraseña.setText("");
    }
    public void habilitarIngreso() 
    {
        this.jt_NombreUsuario.setEnabled(true);
        this.jpf_Contraseña.setEnabled(true);
        this.btn_Ingresar.setEnabled(true);
        this.btn_Salir.setEnabled(false);
    }
    public void deshabilitarIngreso() 
    {
        this.jt_NombreUsuario.setEnabled(false);
        this.jpf_Contraseña.setEnabled(false);
        this.btn_Ingresar.setEnabled(false);
        this.btn_Salir.setEnabled(true);
    }
              
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_TituloLogin = new javax.swing.JLabel();
        jl_NombreUsuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jt_NombreUsuario = new javax.swing.JTextField();
        jpf_Contraseña = new javax.swing.JPasswordField();
        btn_Ingresar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();

        jl_TituloLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_TituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jl_TituloLogin.setText("Login");

        jl_NombreUsuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        btn_Ingresar.setText("Ingresar");

        btn_Salir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_TituloLogin)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_NombreUsuario)
                                    .addComponent(jl_Contraseña))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpf_Contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(jt_NombreUsuario))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btn_Ingresar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Salir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_TituloLogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreUsuario)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contraseña)
                    .addComponent(jpf_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Ingresar)
                    .addComponent(btn_Salir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_NombreUsuario;
    private javax.swing.JLabel jl_TituloLogin;
    private javax.swing.JPasswordField jpf_Contraseña;
    private javax.swing.JTextField jt_NombreUsuario;
    // End of variables declaration//GEN-END:variables
}

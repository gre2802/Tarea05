
package vista;

import controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MetodosMatricula;

public class FRM_Matricula extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Controlador_FRM_Matricula controlador_FRM_Matricula;
    MetodosMatricula metodosMatricula;
    FRM_Inicio frm_Inicio;
    
    public FRM_Matricula(FRM_Inicio frm_Inicio,FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos frm_MantenimientoCursos) {
        super("Matricula");
        initComponents();
        this.setLocation(250, 200);
        this.frm_Inicio=frm_Inicio;
        controlador_FRM_Matricula= new Controlador_FRM_Matricula(frm_Inicio,this,frm_MantenimientoEstufiantes,frm_MantenimientoCursos);
        metodosMatricula=controlador_FRM_Matricula.metodosMatricula;
        modelo= new DefaultTableModel();
        colocarTitulosTabla();
        agregarEventos();
    }
    public void agregarEventos()
    {
        this.btn_BuscarEstudiante.addActionListener(controlador_FRM_Matricula);
        this.btn_BuscarCurso.addActionListener(controlador_FRM_Matricula);
        this.btn_Finalizar.addActionListener(controlador_FRM_Matricula);
        this.panel_Botones1.agregarEventos(controlador_FRM_Matricula);
    }
    public void colocarTitulosTabla()
    {
        this.tbl_Tabla.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre Estudiante");
        modelo.addColumn("Sigla");
    }
    public void colocarCodigo()
    {
        this.jt_CodigoMatricula.setText(metodosMatricula.devolverCodigo());
    }
    public int getCantidadFilas()
    {
        return modelo.getRowCount();
    }
    public String devolverCedula()
    {
        return jt_Cedula.getText();
    }
    public String devolverSigla()
    {
        return jt_Sigla.getText();
    }
    public String devolverCodigo()
    {
        return jt_CodigoMatricula.getText();
    }
    public String devolverDato(int fila,int columna)
    {
        return ""+modelo.getValueAt(fila,columna);
    }
    public void mostrarInformacionEstudiante(String nombre) 
    {
        this.jt_NombreEstudiante.setText(nombre);
    }
    public void mostrarInformacionCurso(String nombre) 
    {
        this.jt_NombreCurso.setText(nombre);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void resetearVentana()
    {
        limpiarCamposEstudiante();
        limpiarCamposCurso();
        habilitarCamposEstudiante();
        habilitarCamposCurso();
        int tamaño=modelo.getRowCount();
        for(int contador=0;contador<tamaño;contador++)
        {
            modelo.removeRow(0);
        }
        this.btn_Finalizar.setEnabled(false);
        deshabilitarModificar();
        deshabilitarEliminar();
        colocarCodigo();
    }
    public void limpiarCamposEstudiante()
    {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
    }
    public void limpiarCamposCurso()
    {
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
    }
    public void habilitarAgregar()
    {
        this.panel_Botones1.habilitarAgregar();
    }
    public void deshabilitarAgregar()
    {
        this.panel_Botones1.deshabilitarAgregar();
    }
    public void habilitarModificar()
    {
        this.panel_Botones1.habilitarModificar();
    }
    public void deshabilitarModificar()
    {
        this.panel_Botones1.deshabilitarModificar();
    }
    public void habilitarFinalizar()
    {
        this.btn_Finalizar.setEnabled(true);
    }
    public void habilitarCamposEstudiante()
    {
        this.jt_Cedula.setEnabled(true);
        this.jt_NombreEstudiante.setEnabled(false);
    }
    public void deshabilitarCamposEstudiante()
    {
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreEstudiante.setEnabled(false);
    }
    public void habilitarCamposCurso()
    {
        this.jt_Sigla.setEnabled(true);
        this.jt_NombreCurso.setEnabled(false);
    }
    public void deshabilitarCamposCurso()
    {
        this.jt_Sigla.setEnabled(false);
        this.jt_NombreCurso.setEnabled(false);
    }
    public void habilitarEliminar()
    {
        this.panel_Botones1.habilitarEliminar();
    }
    public void deshabilitarEliminar()
    {
        this.panel_Botones1.deshabilitarEliminar();
    }
    public void agregarInformacionTabla()
    {
        String arreglo[]= new String [4];
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=this.jt_Cedula.getText();
        arreglo[2]=this.jt_NombreEstudiante.getText();
        arreglo[3]=this.jt_Sigla.getText();
        modelo.addRow(arreglo);
    }
    public void agregarInformacionTabla(String arreglo[])
    {
        modelo.addRow(arreglo);
        this.jt_NombreEstudiante.setText(arreglo[2]);
        this.jt_Cedula.setText(arreglo[1]);
    }
    public int devolverFilaSeleccionada()
    {
        return this.tbl_Tabla.getSelectedRow();
    }
    public void eliminarFilaSeleccionada()
    {
        modelo.removeRow(this.tbl_Tabla.getSelectedRow());
    }
    public String[] devolverMatriculaSeleccionada()
    {
        String arreglo[]= new String[2];
        arreglo[0]=""+modelo.getValueAt(tbl_Tabla.getSelectedRow(),0);
        arreglo[1]=""+modelo.getValueAt(tbl_Tabla.getSelectedRow(),3);
        
        return arreglo;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jl_NombreEstudiante = new javax.swing.JLabel();
        jt_NombreEstudiante = new javax.swing.JTextField();
        btn_BuscarEstudiante = new javax.swing.JButton();
        jl_Sigla = new javax.swing.JLabel();
        jl_NombreCurso = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombreCurso = new javax.swing.JTextField();
        btn_BuscarCurso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        panel_Botones1 = new vista.Panel_Botones();
        jl_CodigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        btn_Finalizar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jl_Cedula.setText("Cédula");

        jt_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_CedulaKeyPressed(evt);
            }
        });

        jl_NombreEstudiante.setText("Nombre Estudiante");

        jt_NombreEstudiante.setEnabled(false);

        btn_BuscarEstudiante.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN1\\Documents\\UCR\\Progra 2\\img\\buscar.png")); // NOI18N
        btn_BuscarEstudiante.setActionCommand("Consultar Estudiante");

        jl_Sigla.setText("Sigla");

        jl_NombreCurso.setText("Nombre Curso");

        jt_Sigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_SiglaKeyPressed(evt);
            }
        });

        jt_NombreCurso.setEnabled(false);

        btn_BuscarCurso.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN1\\Documents\\UCR\\Progra 2\\img\\buscar.png")); // NOI18N
        btn_BuscarCurso.setActionCommand("Consultar Curso");

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_Tabla);

        jl_CodigoMatricula.setText("Código Matricula");

        btn_Finalizar.setText("FINALIZAR MATRICULA");
        btn_Finalizar.setActionCommand("Finalizar");
        btn_Finalizar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_NombreEstudiante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jt_NombreEstudiante))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Cedula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_BuscarEstudiante)))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_NombreCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jt_NombreCurso))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Sigla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_BuscarCurso))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_CodigoMatricula)
                        .addGap(18, 18, 18)
                        .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btn_Finalizar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Finalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_CodigoMatricula)
                            .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_BuscarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_BuscarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jl_Cedula)
                                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jl_Sigla)
                                        .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreEstudiante)
                            .addComponent(jt_NombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_NombreCurso)
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_CedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_CedulaKeyPressed
        
        if(evt.getKeyCode()==10)
        {
            if(frm_Inicio.fuente.equals("AP"))
            this.controlador_FRM_Matricula.buscarEstudianteAP();
        }
    }//GEN-LAST:event_jt_CedulaKeyPressed

    private void jt_SiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_SiglaKeyPressed
        
        if(evt.getKeyCode()==10)
        {
            if(frm_Inicio.fuente.equals("AP"))
            this.controlador_FRM_Matricula.buscarCursoAP();
        }
    }//GEN-LAST:event_jt_SiglaKeyPressed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        
        this.controlador_FRM_Matricula.metodosMatricula.escribirInformacionEnElArchivo();
        resetearVentana();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BuscarCurso;
    private javax.swing.JButton btn_BuscarEstudiante;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_CodigoMatricula;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_NombreEstudiante;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private vista.Panel_Botones panel_Botones1;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}

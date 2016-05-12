/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoCursos;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class FRM_MantenimientoCursos extends javax.swing.JFrame {

    public Controlador_FRM_MantenimientoCursos controlador_FRM_MantenimientoCursos;
    FRM_Inicio frm_Inicio;
    
    public FRM_MantenimientoCursos(FRM_Inicio frm_Inicio) {
        super("Mantenimiento de Cursos");
        initComponents();
        this.setLocation(250, 200);
        this.frm_Inicio=frm_Inicio;
        controlador_FRM_MantenimientoCursos= new Controlador_FRM_MantenimientoCursos(frm_Inicio,this);
        agregarEventos();

    }
    
    public void agregarEventos()
    {
        this.panel_Botones1.agregarEventos(controlador_FRM_MantenimientoCursos);
        this.panel_Cursos2.agregarEventos(controlador_FRM_MantenimientoCursos);
    }
    public String devolverSigla() 
    {
        return this.panel_Cursos2.devolverSigla();
    }

    public void habilitarEdicion()
    {
        this.panel_Botones1.habilitarEdicion();
        this.panel_Cursos2.habilitarEdicion();
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.panel_Cursos2.mostrarInformacion(arreglo);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void habilitarAgregar()
    {
        this.panel_Botones1.habilitarAgregar();
        this.panel_Cursos2.habilitarCampos();
    }
    public String[] devolverInformacion()
    {
       return this.panel_Cursos2.devolverInformacion();
    }
    public void resetearGUI()
    {
        this.panel_Botones1.deshabilitarBotones();
        this.panel_Cursos2.limpiarCampos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Botones1 = new vista.Panel_Botones();
        panel_Cursos2 = new vista.Panel_Cursos();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Botones1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_Cursos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_Cursos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            this.controlador_FRM_MantenimientoCursos.metodosCursos.escribirInformacionEnElArchivo();
            resetearGUI();
        }
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Panel_Botones panel_Botones1;
    private vista.Panel_Cursos panel_Cursos2;
    // End of variables declaration//GEN-END:variables
}

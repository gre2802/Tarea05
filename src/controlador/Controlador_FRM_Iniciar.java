
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_Iniciar;

public class Controlador_FRM_Iniciar implements ActionListener {
    
    FRM_Iniciar frm_Inicio;
    private String opcion="";
    
    public Controlador_FRM_Iniciar(FRM_Iniciar frm_Inicio) 
    {
        this.frm_Inicio=frm_Inicio;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Base de Datos"))
        {
            opcion="Base";
            frm_Inicio.habilitarIniciar();
        }
        if(e.getActionCommand().equals("XML"))
        {
            opcion="XML";
            frm_Inicio.habilitarIniciar();
        }
        if(e.getActionCommand().equals("Archivos Planos"))
        {
            opcion="Archivos";
            frm_Inicio.habilitarIniciar();
        }
        if(e.getActionCommand().equals("Iniciar"))
        {
            frm_Inicio.opcionSeleccionada(opcion);
            frm_Inicio.setVisible(false);
        }
    }
    
}

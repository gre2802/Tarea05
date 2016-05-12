
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_Inicio;

public class Controlador_FRM_Inicio implements ActionListener
{
    FRM_Inicio frm_Inicio;
    private String fuente="";
    
    public Controlador_FRM_Inicio(FRM_Inicio frm_Inicio) 
    {
        this.frm_Inicio=frm_Inicio;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Base de Datos"))
        {
            fuente="BD";
            frm_Inicio.habilitarIniciar();
        }
        if(e.getActionCommand().equals("XML"))
        {
            fuente="XML";
            frm_Inicio.habilitarIniciar();
        }
        if(e.getActionCommand().equals("Archivos Planos"))
        {
            fuente="AP";
            frm_Inicio.habilitarIniciar();
        }
        if(e.getActionCommand().equals("Iniciar"))
        {
            frm_Inicio.fuenteSeleccionada(fuente);
            frm_Inicio.setVisible(false);
        }
    }
    
}

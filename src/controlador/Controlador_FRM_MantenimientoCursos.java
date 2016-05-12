
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosCursos;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoCursos;

public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    FRM_Inicio frm_Inicio;
    public MetodosCursos metodosCursos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_Inicio frm_Inicio,FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            metodosCursos= new MetodosCursos();
            this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        }
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                agregarAP();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarAP();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                modificarAP();
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                eliminarAP();
        }
    }
    /// Metodos AP ///
    public void buscarAP() 
    {
        if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
    }
    public void agregarAP()
    {
        metodosCursos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
        frm_MantenimientoCursos.resetearGUI();
    }
    public void modificarAP()
    {
        metodosCursos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
        frm_MantenimientoCursos.resetearGUI();
    }
    public void eliminarAP()
    {
        metodosCursos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
        frm_MantenimientoCursos.resetearGUI();
    }
}

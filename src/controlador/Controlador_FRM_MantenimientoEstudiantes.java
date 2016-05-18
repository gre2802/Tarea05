
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosEstudiantes;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoEstudiantes;

public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {
    
    public MetodosEstudiantes metodosEstudiantes;
    FRM_Inicio frm_Inicio;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    ConexionBD conexion;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_Inicio frm_Inicio,FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes,ConexionBD conexion)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            metodosEstudiantes= new MetodosEstudiantes();
            this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        }
        if(frm_Inicio.fuente.equals("BD"))
        {
            this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
            this.conexion=conexion;
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                agregarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                agregarBD();
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {   
            if(frm_Inicio.fuente.equals("AP"))
                buscarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                buscarBD();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                modificarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                modificarBD();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                eliminarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                eliminarBD();
        }
    }
    /// Metodos AP ///
    public void buscarAP()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
    }
    public void agregarAP()
    {
        metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
        frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
        frm_MantenimientoEstudiantes.resetearGUI();
    }
    public void modificarAP()
    {
        metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
        frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
        frm_MantenimientoEstudiantes.resetearGUI();
    }
    public void eliminarAP()
    {
        metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
        frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
        frm_MantenimientoEstudiantes.resetearGUI();
    }
    /// Metodos BD ///
    public void buscarBD()
    {
        if(conexion.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(conexion.getArregloEstudiantes());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
    }
       
    
    public void agregarBD()
    {
        conexion.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
        frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
        frm_MantenimientoEstudiantes.resetearGUI();
    }
    public void modificarBD()
    {
        conexion.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
        frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
        frm_MantenimientoEstudiantes.resetearGUI();
   
    }
    public void eliminarBD()
    {
        conexion.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
        frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
        frm_MantenimientoEstudiantes.resetearGUI();
    }
}

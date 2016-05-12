
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosUsuarios;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoUsuarios;

public class Controlador_FRM_MantenimientoUsuarios implements ActionListener {
    
    FRM_Inicio frm_Inicio;
    public MetodosUsuarios metodosUsuarios;
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;

    public Controlador_FRM_MantenimientoUsuarios(FRM_Inicio frm_Inicio,FRM_MantenimientoUsuarios frm_MantenimientoUsuarios) {
        
        this.frm_Inicio=frm_Inicio;
        if(frm_Inicio.fuente.equals("AP"))
        {
            metodosUsuarios= new MetodosUsuarios();
            this.frm_MantenimientoUsuarios=frm_MantenimientoUsuarios;
        }
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                agregarAP();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarAP();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                modificarAP();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                eliminarAP();
        }
    }
    /// Metodos AP ///
    public void buscarAP()
    {
        if(metodosUsuarios.consultarUsuario(frm_MantenimientoUsuarios.devolverCedula()))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(metodosUsuarios.getArregloInformacion());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("La cédula buscada no se encuentra");
                frm_MantenimientoUsuarios.habilitarAgregar();
            }
    }
    public void agregarAP()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
            {
                metodosUsuarios.agregarEstudiante(frm_MantenimientoUsuarios.devolverInformacion());
                frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue agregado de forma correcta");
                frm_MantenimientoUsuarios.resetearGUI();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
            }
    }
    public void modificarAP()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
            {
                metodosUsuarios.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue modificado de forma correcta");
                frm_MantenimientoUsuarios.resetearGUI();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
            }
    }
    public void eliminarAP()
    {
        metodosUsuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
        frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue eliminado de forma correcta");
        frm_MantenimientoUsuarios.resetearGUI();
    }
}

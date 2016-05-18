
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosUsuarios;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoUsuarios;

public class Controlador_FRM_MantenimientoUsuarios implements ActionListener {
    
    FRM_Inicio frm_Inicio;
    public MetodosUsuarios metodosUsuarios;
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    ConexionBD conexion;

    public Controlador_FRM_MantenimientoUsuarios(FRM_Inicio frm_Inicio,FRM_MantenimientoUsuarios frm_MantenimientoUsuarios,ConexionBD conexion) {
        
        this.frm_Inicio=frm_Inicio;
        if(frm_Inicio.fuente.equals("AP"))
        {
            metodosUsuarios= new MetodosUsuarios();
            this.frm_MantenimientoUsuarios=frm_MantenimientoUsuarios;
        }
        if(frm_Inicio.fuente.equals("BD"))
        {
            this.conexion=conexion;
            this.frm_MantenimientoUsuarios=frm_MantenimientoUsuarios;
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
        if(e.getActionCommand().equals("Consultar"))
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
    /// Metodos BD ///
    public void buscarBD()
    {
         if(conexion.consultarUsuario(frm_MantenimientoUsuarios.devolverCedula()))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(conexion.getArregloUsuarios());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("La cédula buscada no se encuentra");
                frm_MantenimientoUsuarios.habilitarAgregar();
            }
    }
    public void agregarBD()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
            {
                conexion.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue agregado de forma correcta");
                frm_MantenimientoUsuarios.resetearGUI();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
        }
    }
    public void modificarBD()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
            {
                conexion.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue modificado de forma correcta");
                frm_MantenimientoUsuarios.resetearGUI();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
        }
    }
    public void eliminarBD()
    {
        conexion.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
        frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue eliminado de forma correcta");
        frm_MantenimientoUsuarios.resetearGUI();
    }
}

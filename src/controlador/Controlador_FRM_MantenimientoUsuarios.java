
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosUsuarios;
import modelo.Metodos_XML_Usuarios;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoUsuarios;

public class Controlador_FRM_MantenimientoUsuarios implements ActionListener {
    
    FRM_Inicio frm_Inicio;
    public MetodosUsuarios metodosUsuarios;
    public Metodos_XML_Usuarios metodos_XML_Usuarios;
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
        if(frm_Inicio.fuente.equals("XML"))
        {
            this.metodos_XML_Usuarios= new Metodos_XML_Usuarios(frm_MantenimientoUsuarios);
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
            
            if(frm_Inicio.fuente.equals("XML"))
                agregarXML();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                buscarBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                buscarXML();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                modificarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                modificarBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                modificarXML();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                eliminarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                eliminarBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                eliminarXML();
        }
    }
    /// Metodos AP ///
    public void buscarAP()
    {
        if(frm_MantenimientoUsuarios.devolverCedula()!=null)
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
    }
    public void agregarAP()
    {
        if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
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
    }
    public void modificarAP()
    {
        if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
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
    }
    public void eliminarAP()
    {
        if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
        {
            metodosUsuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
            frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue eliminado de forma correcta");
            frm_MantenimientoUsuarios.resetearGUI();
        }
    }
    /// Metodos BD ///
    public void buscarBD()
    {
        if(frm_MantenimientoUsuarios.devolverCedula()!=null)
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
    }
    public void agregarBD()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
        {
            if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
            {
                conexion.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue agregado de forma correcta");
                frm_MantenimientoUsuarios.resetearGUI();
            }
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
                if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
                {
                    conexion.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                    frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue modificado de forma correcta");
                    frm_MantenimientoUsuarios.resetearGUI();
                }
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
        }
    }
    public void eliminarBD()
    {
        if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
        {
            conexion.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
            frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue eliminado de forma correcta");
            frm_MantenimientoUsuarios.resetearGUI();
        }
    }
    /// Metodos XML ///
    public void buscarXML()
    {
        if(frm_MantenimientoUsuarios.devolverCedula()!=null)
        {
            if(metodos_XML_Usuarios.consultarUsuario(frm_MantenimientoUsuarios.devolverCedula()))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(metodos_XML_Usuarios.getArregloInformacion());
                frm_MantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("La cédula buscada no se encuentra");
                frm_MantenimientoUsuarios.habilitarAgregar();
            }
        }
    }
    public void agregarXML()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
            {
                if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
                {
                    metodos_XML_Usuarios.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                    frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue agregado de forma correcta");
                    frm_MantenimientoUsuarios.resetearGUI();
                }
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
            }
    }
    public void modificarXML()
    {
        if(frm_MantenimientoUsuarios.verificarContraseñas())
            {
                if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
                {
                    metodos_XML_Usuarios.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                    frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue modificado de forma correcta");
                    frm_MantenimientoUsuarios.resetearGUI();
                }
            }
            else
            {
                frm_MantenimientoUsuarios.mostrarMensaje("Contaseñas distintas\n\nVuelva a repetir la contraseña");
                frm_MantenimientoUsuarios.limpiarRepetirContraseña();
            }
    }
    public void eliminarXML()
    {
        if(frm_MantenimientoUsuarios.devolverInformacion()!=null)
        {
            metodos_XML_Usuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
            frm_MantenimientoUsuarios.mostrarMensaje("El usuario fue eliminado de forma correcta");
            frm_MantenimientoUsuarios.resetearGUI();
        }
    }
}

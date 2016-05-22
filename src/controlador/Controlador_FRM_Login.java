
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosXML_Usuarios;
import vista.FRM_Iniciar;
import vista.FRM_Login;
import vista.FRM_Usuarios;
import vista.FRM_Ventana;

public class Controlador_FRM_Login implements ActionListener {

    FRM_Login frm_Login;
    FRM_Iniciar frm_Inicio;
    FRM_Ventana frm_VentanaPrincipal;
    MetodosXML_Usuarios metodos_XML_Usuarios;
    ConexionBD conexion;
    
    public Controlador_FRM_Login(FRM_Iniciar frm_Inicio,FRM_Login frm_Login,FRM_Ventana frm_VentanaPrincipal,ConexionBD conexion,FRM_Usuarios frm_MantenimientoUsuarios) 
    {
        this.frm_Inicio=frm_Inicio;
        this.frm_Login=frm_Login;
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        this.conexion=conexion;
        this.metodos_XML_Usuarios=frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.metodos_XML_Usuarios;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Ingresar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                ingresarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                ingresarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                ingresarXML();
        }
        if(e.getActionCommand().equals("Salir"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                salirAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                salirBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                salirXML();
        }
    }
    public void habilitarOpciones(String tipoUsuario) 
    {
        if(tipoUsuario.equals("Administrador"))
        {
            this.frm_VentanaPrincipal.habilitarUsuarios();
            this.frm_VentanaPrincipal.habilitarCursos();
            this.frm_VentanaPrincipal.habilitarEstudiantes();
            this.frm_VentanaPrincipal.habilitarMatricula();
        }
        if(tipoUsuario.equals("Docente"))
        {
            this.frm_VentanaPrincipal.deshabilitarUsuarios();
            this.frm_VentanaPrincipal.habilitarCursos();
            this.frm_VentanaPrincipal.deshabilitarEstudiantes();
            this.frm_VentanaPrincipal.deshabilitarMatricula();
        }
        if(tipoUsuario.equals("Estudiante"))
        {
            this.frm_VentanaPrincipal.deshabilitarUsuarios();
            this.frm_VentanaPrincipal.deshabilitarCursos();
            this.frm_VentanaPrincipal.habilitarEstudiantes();
            this.frm_VentanaPrincipal.habilitarMatricula();
        }
    }
    public void ingresarAP()
    {
        if(frm_Login.metodosUsuarios.consultarUsuarioRegistradoAP(frm_Login.devolverNombreUsuario()))
        {
            if(frm_Login.devolverContraseña().equals(frm_Login.metodosUsuarios.getArregloInformacion()[2]))
            {
                habilitarOpciones(frm_Login.metodosUsuarios.getArregloInformacion()[3]);
                frm_Login.mostrarMensaje("Sesión Iniciada");
                frm_Login.setVisible(false);
                frm_Login.deshabilitarIngreso();
                frm_VentanaPrincipal.show();
            }
            else
            {
                frm_Login.mostrarMensaje("Contraseña incorrecta, por favor digitela de nuevo");
                frm_Login.limpiarCampoContraseña();
            }
        }
        else
        {
            frm_Login.mostrarMensaje("El usuario no se encuentra registrado");
            frm_Login.resetearGUI();
        }
    }
    public void salirAP()
    {
        frm_Login.mostrarMensaje("Cerrando Sesión");
        frm_Login.resetearGUI();
        frm_Login.habilitarIngreso();
        this.frm_VentanaPrincipal.deshabilitarUsuarios();
        this.frm_VentanaPrincipal.deshabilitarCursos();
        this.frm_VentanaPrincipal.deshabilitarEstudiantes();
        this.frm_VentanaPrincipal.deshabilitarMatricula();
        frm_Login.setVisible(false);
    }
    public void ingresarBD()
    {
        if(conexion.consultarUsuarioRegistrado(frm_Login.devolverNombreUsuario()))
            {
                if(frm_Login.devolverContraseña().equals(conexion.getArregloUsuarios()[2]))
                {
                    habilitarOpciones(conexion.getArregloUsuarios()[3]);
                    frm_Login.mostrarMensaje("Sesión Iniciada");
                    frm_Login.setVisible(false);
                    frm_Login.deshabilitarIngreso();
                    frm_VentanaPrincipal.show();
                }
                else
                {
                    frm_Login.mostrarMensaje("Contraseña incorrecta, por favor digitela de nuevo");
                    frm_Login.limpiarCampoContraseña();
                }
            }
            else
            {
                frm_Login.mostrarMensaje("El usuario no se encuentra registrado");
                frm_Login.resetearGUI();
            }
    }
    public void salirBD()
    {
         frm_Login.mostrarMensaje("Cerrando Sesión");
        frm_Login.resetearGUI();
        frm_Login.habilitarIngreso();
        this.frm_VentanaPrincipal.deshabilitarUsuarios();
        this.frm_VentanaPrincipal.deshabilitarCursos();
        this.frm_VentanaPrincipal.deshabilitarEstudiantes();
        this.frm_VentanaPrincipal.deshabilitarMatricula();
        frm_Login.setVisible(false);
    }
    public void ingresarXML()
    {
        if(metodos_XML_Usuarios.consultarUsuarioRegistradoXML(frm_Login.devolverNombreUsuario()))
        {
            if(frm_Login.devolverContraseña().equals(metodos_XML_Usuarios.getArregloUsuariosXML()[1]))
            {
                habilitarOpciones(metodos_XML_Usuarios.getArregloUsuariosXML()[2]);
                frm_Login.mostrarMensaje("Sesión Iniciada");
                frm_Login.setVisible(false);
                frm_Login.deshabilitarIngreso();
                frm_VentanaPrincipal.show();
            }
            else
            {
                frm_Login.mostrarMensaje("Contraseña incorrecta, por favor digitela de nuevo");
                frm_Login.limpiarCampoContraseña();
            }
        }
        else
        {
            frm_Login.mostrarMensaje("El usuario no se encuentra registrado");
            frm_Login.resetearGUI();
        }
    }
    public void salirXML()
    {
        frm_Login.mostrarMensaje("Cerrando Sesión");
        frm_Login.resetearGUI();
        frm_Login.habilitarIngreso();
        this.frm_VentanaPrincipal.deshabilitarUsuarios();
        this.frm_VentanaPrincipal.deshabilitarCursos();
        this.frm_VentanaPrincipal.deshabilitarEstudiantes();
        this.frm_VentanaPrincipal.deshabilitarMatricula();
        frm_Login.setVisible(false);
    }
}

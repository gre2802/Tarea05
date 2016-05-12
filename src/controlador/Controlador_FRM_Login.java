
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_Inicio;
import vista.FRM_Login;
import vista.FRM_VentanaPrincipal;

public class Controlador_FRM_Login implements ActionListener {

    FRM_Login frm_Login;
    FRM_Inicio frm_Inicio;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    
    public Controlador_FRM_Login(FRM_Inicio frm_Inicio,FRM_Login frm_Login,FRM_VentanaPrincipal frm_VentanaPrincipal) 
    {
        this.frm_Inicio=frm_Inicio;
        this.frm_Login=frm_Login;
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Ingresar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                ingresarAP();
        }
        if(e.getActionCommand().equals("Salir"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                salirAP();
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
    /// Metodos AP ///
    public void ingresarAP()
    {
        if(frm_Login.metodosUsuarios.consultarUsuarioRegistrado(frm_Login.devolverNombreUsuario()))
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
}

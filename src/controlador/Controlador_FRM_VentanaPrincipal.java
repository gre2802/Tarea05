
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import vista.FRM_Inicio;
import vista.FRM_Login;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_MantenimientoUsuarios;
import vista.FRM_Matricula;
import vista.FRM_VentanaPrincipal;

public class Controlador_FRM_VentanaPrincipal implements ActionListener {

    FRM_VentanaPrincipal frm_VentanaPrincipal;
    FRM_Inicio frm_Inicio;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public FRM_Matricula frm_Matricula;
    FRM_Login frm_Login;
    public FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    ConexionBD conexion;
    
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal frm_VentanaPrincipal)
    {
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        frm_Inicio= new FRM_Inicio(this);
        frm_Inicio.show();
    }
    public void iniciar()
    {
        conexion= new ConexionBD(this);
        frm_MantenimientoEstudiantes= new FRM_MantenimientoEstudiantes(frm_Inicio,conexion);
        frm_MantenimientoCursos= new FRM_MantenimientoCursos(frm_Inicio,conexion);
        frm_Matricula= new FRM_Matricula(frm_Inicio,frm_MantenimientoEstudiantes,frm_MantenimientoCursos,conexion);
        conexion.asignarFRM_Matricula();
        frm_MantenimientoUsuarios= new FRM_MantenimientoUsuarios(frm_Inicio,frm_VentanaPrincipal,conexion);
        frm_Login= new FRM_Login(frm_Inicio,frm_VentanaPrincipal,frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.metodosUsuarios,conexion,frm_MantenimientoUsuarios);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Login"))
        {
            frm_Login.setVisible(true);
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            frm_MantenimientoEstudiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Cursos"))
        { 
            frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        { 
            frm_Matricula.setVisible(true);
            frm_Matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Usuarios"))
        { 
            frm_MantenimientoUsuarios.setVisible(true);
        }
    }
    public void inicio(String fuente)
    {
        if(fuente.equals("AP"))
        {
            if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.metodosUsuarios.getTamañoArreglo()==0)
            {
                this.frm_MantenimientoUsuarios.show();
            }
            else 
            {
                this.frm_Login.show();
            }
        }
        if(fuente.equals("BD"))
        {
            if(conexion.cantidadFilasUsuarios()==0)
            {
                this.frm_MantenimientoUsuarios.show();
            }
            else 
            {
                this.frm_Login.show();
            }
        }
        if(fuente.endsWith("XML"))
        {
            if(frm_MantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.metodos_XML_Usuarios.tamañoXML()>0)
            {
                this.frm_Login.show();
            }
            else 
            {
                this.frm_MantenimientoUsuarios.show();
            }
        }
    }
}













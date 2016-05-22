
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.Verificador_XML;
import vista.FRM_Iniciar;
import vista.FRM_Login;
import vista.FRM_Cursos;
import vista.FRM_Estudiantes;
import vista.FRM_Usuarios;
import vista.FRM_Matricula;
import vista.FRM_Ventana;

public class Controlador_FRM_Ventana implements ActionListener {

    FRM_Ventana frm_VentanaPrincipal;
    FRM_Iniciar frm_Inicio;
    FRM_Estudiantes frm_MantenimientoEstudiantes;
    FRM_Cursos frm_MantenimientoCursos;
    public FRM_Matricula frm_Matricula;
    FRM_Login frm_Login;
    public FRM_Usuarios frm_MantenimientoUsuarios;
    ConexionBD conexion;
    Verificador_XML verificador;
    
    public Controlador_FRM_Ventana(FRM_Ventana frm_VentanaPrincipal)
    {
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        frm_Inicio= new FRM_Iniciar(this);
        frm_Inicio.show();
    }
    public void iniciar()
    {
        conexion= new ConexionBD(this);
        verificador= new Verificador_XML();
        frm_MantenimientoEstudiantes= new FRM_Estudiantes(frm_Inicio,conexion,verificador);
        frm_MantenimientoCursos= new FRM_Cursos(frm_Inicio,conexion,verificador);
        frm_Matricula= new FRM_Matricula(frm_Inicio,frm_MantenimientoEstudiantes,frm_MantenimientoCursos,conexion);
        conexion.asignarMatricula();
        frm_MantenimientoUsuarios= new FRM_Usuarios(frm_Inicio,frm_VentanaPrincipal,conexion,verificador);
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
        if(fuente.equals("Archivos"))
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
        if(fuente.equals("Base"))
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













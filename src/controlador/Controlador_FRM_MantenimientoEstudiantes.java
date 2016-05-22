
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosEstudiantes;
import modelo.Metodos_XML_Estudiantes;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoEstudiantes;

public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {
    
    public MetodosEstudiantes metodosEstudiantes;
    public Metodos_XML_Estudiantes metodos_XML_Estudiantes;
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
        if(frm_Inicio.fuente.equals("XML"))
        {
            metodos_XML_Estudiantes= new Metodos_XML_Estudiantes(frm_MantenimientoEstudiantes);
            this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
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
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
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
        if(frm_MantenimientoEstudiantes.devolverCedula()!=null)
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
    }
    public void agregarAP()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void modificarAP()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void eliminarAP()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    /// Metodos BD ///
    public void buscarBD()
    {
        if(frm_MantenimientoEstudiantes.devolverCedula()!=null)
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
    }
    public void agregarBD()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            conexion.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void modificarBD()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            conexion.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void eliminarBD()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            conexion.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    /// Metodos XML ///
    public void buscarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverCedula()!=null)
        {
            if(metodos_XML_Estudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacionXML(metodos_XML_Estudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
        }
    }
    public void agregarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodos_XML_Estudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void modificarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodos_XML_Estudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void eliminarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodos_XML_Estudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
}


package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosEstudiantes;
import modelo.MetodosXML_Estudiantes;
import vista.FRM_Iniciar;
import vista.FRM_Estudiantes;

public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {
    
    public MetodosEstudiantes metodosEstudiantes;
    public MetodosXML_Estudiantes metodos_XML_Estudiantes;
    FRM_Iniciar frm_Inicio;
    FRM_Estudiantes frm_MantenimientoEstudiantes;
    ConexionBD conexion;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_Iniciar frm_Inicio,FRM_Estudiantes frm_MantenimientoEstudiantes,ConexionBD conexion)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.opcion.equals("Archivos"))
        {
            metodosEstudiantes= new MetodosEstudiantes();
            this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        }
        if(frm_Inicio.opcion.equals("BD"))
        {
            this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
            this.conexion=conexion;
        }
        if(frm_Inicio.opcion.equals("XML"))
        {
            metodos_XML_Estudiantes= new MetodosXML_Estudiantes(frm_MantenimientoEstudiantes);
            this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                agregarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                agregarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                agregarXML();
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {   
            if(frm_Inicio.opcion.equals("Archivos"))
                buscarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                buscarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                buscarXML();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                modificarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                modificarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                modificarXML();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                eliminarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                eliminarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                eliminarXML();
        }
    }
    public void buscarAP()
    {
        if(frm_MantenimientoEstudiantes.devolverCedula()!=null)
        {
            if(metodosEstudiantes.consultarEstudianteAP(frm_MantenimientoEstudiantes.devolverCedula()))
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
            metodosEstudiantes.agregarEstudianteAP(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void modificarAP()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodosEstudiantes.modificarEstudianteAP(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void eliminarAP()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodosEstudiantes.eliminarEstudianteAP(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
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
    public void buscarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverCedula()!=null)
        {
            if(metodos_XML_Estudiantes.consultarEstudianteXML(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacionXML(metodos_XML_Estudiantes.getArregloInformacionXML());
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
            metodos_XML_Estudiantes.agregarEstudianteXML(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void modificarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodos_XML_Estudiantes.modificarEstudianteXML(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void eliminarXML()
    {
        if(frm_MantenimientoEstudiantes.devolverInformacion()!=null)
        {
            metodos_XML_Estudiantes.eliminarEstudianteXML(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
}

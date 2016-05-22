
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import modelo.MetodosXML_Cursos;
import vista.FRM_Iniciar;
import vista.FRM_Cursos;

public class Controlador_FRM_MantenimientoCursos implements ActionListener {
    
    FRM_Cursos frm_MantenimientoCursos;
    FRM_Iniciar frm_Inicio;
    public MetodosCursos metodosCursos;
    public MetodosXML_Cursos metodos_XML_Cursos;
    ConexionBD conexion;
    
    public Controlador_FRM_MantenimientoCursos(FRM_Iniciar frm_Inicio,FRM_Cursos frm_MantenimientoCursos,ConexionBD conexion)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.opcion.equals("Archivos"))
        {
            metodosCursos= new MetodosCursos();
            this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        }
        if(frm_Inicio.opcion.equals("Base"))
        {
            this.conexion=conexion;
            this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        }
        if(frm_Inicio.opcion.equals("XML"))
        {
            metodos_XML_Cursos= new MetodosXML_Cursos(frm_MantenimientoCursos);
            this.frm_MantenimientoCursos=frm_MantenimientoCursos;
        }
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                agregarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                agregarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                agregarXML();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                buscarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                buscarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                buscarXML();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                modificarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                modificarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                modificarXML();
        }
        if(evento.getActionCommand().equals("Eliminar"))
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
        if(frm_MantenimientoCursos.devolverSigla()!=null)
        {
            if(metodosCursos.consultarCursoAP(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacionAP());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
        }
    }
    public void agregarAP()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            metodosCursos.agregarCursoAP(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void modificarAP()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            metodosCursos.modificarCursoAP(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void eliminarAP()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            metodosCursos.eliminarCursoAP(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void buscarBD() 
    {
        if(frm_MantenimientoCursos.devolverSigla()!=null)
        {
            if(conexion.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(conexion.getArregloCursos());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
        }
    }
    public void agregarBD()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            conexion.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void modificarBD()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            conexion.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void eliminarBD()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            conexion.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void buscarXML() 
    {
        if(frm_MantenimientoCursos.devolverSigla()!=null)
        {
            if(metodos_XML_Cursos.consultarCursoXML(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacionXML(metodos_XML_Cursos.getArregloInformacionXML());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_MantenimientoCursos.habilitarAgregar();
            }
        }
    }
    public void agregarXML()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            metodos_XML_Cursos.agregarCursoXML(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void modificarXML()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            metodos_XML_Cursos.modificarCursoXML(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
    public void eliminarXML()
    {
        if(frm_MantenimientoCursos.devolverInformacion()!=null)
        {
            metodos_XML_Cursos.eliminarCursoXML(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
        }
    }
}


package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import modelo.Metodos_XML_Cursos;
import modelo.Metodos_XML_Estudiantes;
import modelo.Metodos_XML_Matricula;
import vista.FRM_Inicio;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;

public class Controlador_FRM_Matricula implements ActionListener {
    
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    public MetodosMatricula metodosMatricula;
    Metodos_XML_Estudiantes metodos_XML_Estudiantes;
    Metodos_XML_Cursos metodos_XML_Cursos;
    public Metodos_XML_Matricula metodos_XML_Matricula;
    public FRM_Matricula frm_Matricula;
    FRM_Inicio frm_Inicio;
    boolean verificarEstudiante=false,verificarCurso=false;
    ConexionBD conexion;
    
    public Controlador_FRM_Matricula(FRM_Inicio frm_Inicio,FRM_Matricula frm_Matricula,FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes,FRM_MantenimientoCursos frm_MantenimientoCursos,ConexionBD conexion)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.fuente.equals("AP"))
        {
            this.metodosEstudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
            this.metodosCursos=frm_MantenimientoCursos.controlador_FRM_MantenimientoCursos.metodosCursos;
            this.frm_Matricula=frm_Matricula;
            metodosMatricula= new MetodosMatricula(this,metodosEstudiantes,metodosCursos,frm_Matricula);
        }
        if(frm_Inicio.fuente.equals("BD"))
        {
            this.conexion=conexion;
            this.frm_Matricula=frm_Matricula;
        }
        if(frm_Inicio.fuente.equals("XML"))
        {
            this.frm_Matricula=frm_Matricula;
            this.metodos_XML_Estudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos_XML_Estudiantes;
            this.metodos_XML_Cursos=frm_MantenimientoCursos.controlador_FRM_MantenimientoCursos.metodos_XML_Cursos;
            metodos_XML_Matricula= new Metodos_XML_Matricula(frm_Matricula);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar Estudiante"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarEstudianteAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                buscarEstudianteBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                buscarEstudianteXML();
        }
        if(e.getActionCommand().equals("Consultar Curso"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                buscarCursoAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                buscarCursoBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                buscarCursoXML();
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                agregarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                agregarBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                agregarXML();
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                finalizarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                finalizarBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                finalizarXML();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Inicio.fuente.equals("AP"))
                consultarAP();
            
            if(frm_Inicio.fuente.equals("BD"))
                consultarBD();
            
            if(frm_Inicio.fuente.equals("XML"))
                consultarXML();
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
        if(e.getActionCommand().equals("Modificar")) 
        {
            frm_Matricula.resetearVentana();
        }  
        verificarConsultas();
    }
    public void verificarConsultas()
    {
        if(verificarEstudiante && verificarCurso)
        {
            frm_Matricula.habilitarAgregar();
            frm_Matricula.deshabilitarCamposEstudiante();
        }
        else
        {
            frm_Matricula.deshabilitarAgregar();
        }
    }
    /// Metodos AP ///
    public void buscarEstudianteAP()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
        {
            frm_Matricula.mostrarInformacionEstudiante(metodosEstudiantes.getNombreEncontrado());
            verificarEstudiante=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            frm_Matricula.limpiarCamposEstudiante();
            verificarEstudiante=false;
        }
    }
    public void buscarCursoAP()
    {
        if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
        {
            frm_Matricula.mostrarInformacionCurso(metodosCursos.getNombreEncontrado());
            verificarCurso=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La sigla buscada no se encuentra.");
            frm_Matricula.limpiarCamposCurso();
            verificarCurso=false;
        }
    }
    public void agregarAP()
    {
        frm_Matricula.agregarInformacionTabla();
        frm_Matricula.limpiarCamposCurso();
        frm_Matricula.habilitarFinalizar();
        verificarCurso=false;
        verificarConsultas();
    }     
    public void finalizarAP()
    {
        String arreglo[]= new String[3];
        for(int contador=0;contador<frm_Matricula.getCantidadFilas();contador++)
        {
            arreglo[0]=frm_Matricula.devolverCodigo();
            arreglo[1]=frm_Matricula.devolverDato(contador,1);
            arreglo[2]=frm_Matricula.devolverDato(contador,3);
            metodosMatricula.agregarMatricula(arreglo);
        }
        frm_Matricula.colocarCodigo();
        frm_Matricula.resetearVentana();
        verificarEstudiante=false;
        verificarCurso=false;
        frm_Matricula.mostrarMensaje("Se ha finalizado la matrícula con éxito");
    }
    public void consultarAP()
    {
        if(metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
        {
            frm_Matricula.deshabilitarCamposEstudiante();
            frm_Matricula.deshabilitarCamposCurso();
            frm_Matricula.habilitarEliminar();
            frm_Matricula.habilitarModificar();
        }
        else
        {
            frm_Matricula.mostrarMensaje("No se encuentra ese código de matricula registrado");
            frm_Matricula.resetearVentana();
        }
    }
    public void eliminarAP()
    {
        if(frm_Matricula.devolverFilaSeleccionada()>=0)
        {
            metodosMatricula.eliminarMatricula(frm_Matricula.devolverMatriculaSeleccionada());
            frm_Matricula.eliminarFilaSeleccionada();
        }
        else
        {
            frm_Matricula.mostrarMensaje("Seleccione una matricula de la tabla");
        }
    }
    /// Metodos BD ///
    public void buscarEstudianteBD()
    {
        if(conexion.consultarEstudiante(frm_Matricula.devolverCedula()))
        {
            frm_Matricula.mostrarInformacionEstudiante(conexion.getNombreEstudiante());
            verificarEstudiante=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            frm_Matricula.limpiarCamposEstudiante();
            verificarEstudiante=false;
        }
    }
    public void buscarCursoBD()
    {
        if(conexion.consultarCurso(frm_Matricula.devolverSigla()))
        {
            frm_Matricula.mostrarInformacionCurso(conexion.getNombreCurso());
            verificarCurso=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La sigla buscada no se encuentra.");
            frm_Matricula.limpiarCamposCurso();
            verificarCurso=false;
        }
    }
    public void agregarBD()
    {
        frm_Matricula.agregarInformacionTabla();
        frm_Matricula.limpiarCamposCurso();
        frm_Matricula.habilitarFinalizar();
        verificarCurso=false;
        verificarConsultas();
    }     
    public void finalizarBD()
    {
        String arreglo[]= new String[3];
            for(int contador=0;contador<frm_Matricula.getCantidadFilas();contador++)
            {
                arreglo[0]=frm_Matricula.devolverCodigo();
                arreglo[1]=frm_Matricula.devolverDato(contador,1);
                arreglo[2]=frm_Matricula.devolverDato(contador,3);
                conexion.agregarDetalleMatricula(arreglo);
            }
            conexion.agregarMatricula(arreglo);
            frm_Matricula.colocarCodigo();
            frm_Matricula.resetearVentana();
            verificarEstudiante=false;
            verificarCurso=false;
            frm_Matricula.mostrarMensaje("Se ha finalizado la matrícula con éxito");
    }
    public void consultarBD()
    {
        System.out.println(frm_Matricula.devolverCodigo());
        if(conexion.consultarMatricula(frm_Matricula.devolverCodigo()))
            {
                frm_Matricula.deshabilitarCamposEstudiante();
                frm_Matricula.deshabilitarCamposCurso();
                frm_Matricula.habilitarEliminar();
                frm_Matricula.habilitarModificar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("No se encuentra ese código de matricula registrado");
                frm_Matricula.resetearVentana();
            }
    }
    public void eliminarBD()
    {
        if(frm_Matricula.devolverFilaSeleccionada()>=0)
            {
                conexion.eliminarMatricula(frm_Matricula.devolverMatriculaSeleccionada());
                frm_Matricula.eliminarFilaSeleccionada();
            }
            else
            {
                frm_Matricula.mostrarMensaje("Seleccione una matricula de la tabla");
            }
    }
    /// Metodos XML ///
    public void buscarEstudianteXML()
    {
        if(metodos_XML_Estudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
        {
            frm_Matricula.mostrarInformacionEstudiante(metodos_XML_Estudiantes.getNombreEstudiante());
            verificarEstudiante=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            frm_Matricula.limpiarCamposEstudiante();
            verificarEstudiante=false;
        }
    }
    public void buscarCursoXML()
    {
        if(metodos_XML_Cursos.consultarCurso(frm_Matricula.devolverSigla()))
        {
            frm_Matricula.mostrarInformacionCurso(metodos_XML_Cursos.getNombreCurso());
            verificarCurso=true;
        }
        else
        {
            frm_Matricula.mostrarMensaje("La sigla buscada no se encuentra.");
            frm_Matricula.limpiarCamposCurso();
            verificarCurso=false;
        }
    }
    public void agregarXML()
    {
        frm_Matricula.agregarInformacionTabla();
        frm_Matricula.limpiarCamposCurso();
        frm_Matricula.habilitarFinalizar();
        verificarCurso=false;
        verificarConsultas();
    }
    public void finalizarXML()
    {
        String arreglo[]= new String[4];
        for(int contador=0;contador<frm_Matricula.getCantidadFilas();contador++)
        {
            arreglo[0]=frm_Matricula.devolverCodigo();
            arreglo[1]=frm_Matricula.devolverDato(contador,1);
            arreglo[2]=frm_Matricula.devolverDato(contador,2);
            arreglo[3]=frm_Matricula.devolverDato(contador,3);
            metodos_XML_Matricula.agregarMatricula(arreglo);
        }
        frm_Matricula.colocarCodigo();
        frm_Matricula.resetearVentana();
        verificarEstudiante=false;
        verificarCurso=false;
        frm_Matricula.mostrarMensaje("Se ha finalizado la matrícula con éxito");
    }
    public void consultarXML()
    {
        if(metodos_XML_Matricula.consultarMatricula(frm_Matricula.devolverCodigo()))
        {
            frm_Matricula.deshabilitarCamposEstudiante();
            frm_Matricula.deshabilitarCamposCurso();
            frm_Matricula.habilitarEliminar();
            frm_Matricula.habilitarModificar();
        }
        else
        {
            frm_Matricula.mostrarMensaje("No se encuentra ese código de matricula registrado");
            frm_Matricula.resetearVentana();
        }
    }
    public void eliminarXML()
    {
        if(frm_Matricula.devolverFilaSeleccionada()>=0)
        {
            metodos_XML_Matricula.eliminarMatricula(frm_Matricula.devolverMatriculaSeleccionada());
            frm_Matricula.eliminarFilaSeleccionada();
        }
        else
        {
            frm_Matricula.mostrarMensaje("Seleccione una matricula de la tabla");
        }
    }
}


package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import modelo.MetodosXML_Cursos;
import modelo.MetodosXML_Estudiantes;
import modelo.MetodosXML_Matricula;
import vista.FRM_Iniciar;
import vista.FRM_Cursos;
import vista.FRM_Estudiantes;
import vista.FRM_Matricula;

public class Controlador_FRM_Matricula implements ActionListener {
    
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    public MetodosMatricula metodosMatricula;
    MetodosXML_Estudiantes metodos_XML_Estudiantes;
    MetodosXML_Cursos metodos_XML_Cursos;
    public MetodosXML_Matricula metodos_XML_Matricula;
    public FRM_Matricula frm_Matricula;
    FRM_Iniciar frm_Inicio;
    boolean verificarEstudiante=false,verificarCurso=false;
    ConexionBD conexion;
    
    public Controlador_FRM_Matricula(FRM_Iniciar frm_Inicio,FRM_Matricula frm_Matricula,FRM_Estudiantes frm_MantenimientoEstudiantes,FRM_Cursos frm_MantenimientoCursos,ConexionBD conexion)
    {
        this.frm_Inicio=frm_Inicio;
        
        if(frm_Inicio.opcion.equals("Archivos"))
        {
            this.metodosEstudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
            this.metodosCursos=frm_MantenimientoCursos.controlador_FRM_MantenimientoCursos.metodosCursos;
            this.frm_Matricula=frm_Matricula;
            metodosMatricula= new MetodosMatricula(this,metodosEstudiantes,metodosCursos,frm_Matricula);
        }
        if(frm_Inicio.opcion.equals("Base"))
        {
            this.conexion=conexion;
            this.frm_Matricula=frm_Matricula;
        }
        if(frm_Inicio.opcion.equals("XML"))
        {
            this.frm_Matricula=frm_Matricula;
            this.metodos_XML_Estudiantes=frm_MantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos_XML_Estudiantes;
            this.metodos_XML_Cursos=frm_MantenimientoCursos.controlador_FRM_MantenimientoCursos.metodos_XML_Cursos;
            metodos_XML_Matricula= new MetodosXML_Matricula(frm_Matricula);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar Estudiante"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                buscarEstudianteAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                buscarEstudianteBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                buscarEstudianteXML();
        }
        if(e.getActionCommand().equals("Consultar Curso"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                buscarCursoAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                buscarCursoBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                buscarCursoXML();
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                agregarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                agregarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                agregarXML();
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                finalizarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                finalizarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                finalizarXML();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(frm_Inicio.opcion.equals("Archivos"))
                consultarAP();
            
            if(frm_Inicio.opcion.equals("Base"))
                consultarBD();
            
            if(frm_Inicio.opcion.equals("XML"))
                consultarXML();
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
    public void buscarEstudianteAP()
    {
        if(metodosEstudiantes.consultarEstudianteAP(frm_Matricula.devolverCedula()))
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
        if(metodosCursos.consultarCursoAP(frm_Matricula.devolverSigla()))
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
            metodosMatricula.agregarMatriculAP(arreglo);
        }
        frm_Matricula.colocarCodigo();
        frm_Matricula.resetearVentana();
        verificarEstudiante=false;
        verificarCurso=false;
        frm_Matricula.mostrarMensaje("Se ha finalizado la matrícula con éxito");
    }
    public void consultarAP()
    {
        if(metodosMatricula.consultarMatriculaAP(frm_Matricula.devolverCodigo()))
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
            metodosMatricula.eliminarMatriculaAP(frm_Matricula.devolverMatriculaSeleccionada());
            frm_Matricula.eliminarFilaSeleccionada();
        }
        else
        {
            frm_Matricula.mostrarMensaje("Seleccione una matricula de la tabla");
        }
    }
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
    public void buscarEstudianteXML()
    {
        if(metodos_XML_Estudiantes.consultarEstudianteXML(frm_Matricula.devolverCedula()))
        {
            frm_Matricula.mostrarInformacionEstudiante(metodos_XML_Estudiantes.getNombreEstudianteXML());
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
        if(metodos_XML_Cursos.consultarCursoXML(frm_Matricula.devolverSigla()))
        {
            frm_Matricula.mostrarInformacionCurso(metodos_XML_Cursos.getNombreCursoXML());
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
            metodos_XML_Matricula.agregarMatriculaXML(arreglo);
        }
        frm_Matricula.colocarCodigo();
        frm_Matricula.resetearVentana();
        verificarEstudiante=false;
        verificarCurso=false;
        frm_Matricula.mostrarMensaje("Se ha finalizado la matrícula con éxito");
    }
    public void consultarXML()
    {
        if(metodos_XML_Matricula.consultarMatriculaXML(frm_Matricula.devolverCodigo()))
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
            metodos_XML_Matricula.eliminarMatriculaXML(frm_Matricula.devolverMatriculaSeleccionada());
            frm_Matricula.eliminarFilaSeleccionada();
        }
        else
        {
            frm_Matricula.mostrarMensaje("Seleccione una matricula de la tabla");
        }
    }
}

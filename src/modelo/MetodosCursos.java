/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class MetodosCursos {
    
    private ArrayList <Curso> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    ArchivoCursos archivoCursos;
    
    public MetodosCursos()
    {
        arrayCursos= new ArrayList <Curso>();
        archivoCursos= new ArchivoCursos();
        arrayCursos= archivoCursos.devolverInformacionCompleta();
    }
    public void agregarCurso(String informacion[])
    {
        Curso temporal=new Curso(informacion[0],informacion[1],Integer.parseInt(informacion[2]),informacion[3]);
        arrayCursos.add(temporal);
        
    }
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arregloInformacionConsultada[0]=arrayCursos.get(contador).getNombre();
                arregloInformacionConsultada[1]=""+arrayCursos.get(contador).getCreditos();
                arregloInformacionConsultada[2]=arrayCursos.get(contador).getHorario();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.get(contador).setNombre(arreglo[1]);
                arrayCursos.get(contador).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(contador).setHorario(arreglo[3]);
            }
        }
    }
    public void eliminarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.remove(contador);
            }
        }
    }
    public void escribirInformacionEnElArchivo()
    {
      archivoCursos.crearArchivo();
      
      for(int contador=0;contador<arrayCursos.size();contador++)
      {
        archivoCursos.escribirInformacionEnElArchivo(arrayCursos.get(contador));
        
      }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
    public String getNombreEncontrado()
    {
        return arregloInformacionConsultada[0];
    }
}

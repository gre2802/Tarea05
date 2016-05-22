
package modelo;

import java.util.ArrayList;

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
    public void agregarCursoAP(String informacion[])
    {
        Curso temporal=new Curso(informacion[0],informacion[1],Integer.parseInt(informacion[2]),informacion[3]);
        arrayCursos.add(temporal);
        
    }
    public boolean consultarCursoAP(String sigla)
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
    public void modificarCursoAP(String arreglo[])
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
    public void eliminarCursoAP(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.remove(contador);
            }
        }
    }
    public void escribirInformacionEnElArchivoAP()
    {
      archivoCursos.crearArchivoPlano();
      
      for(int contador=0;contador<arrayCursos.size();contador++)
      {
        archivoCursos.escribirInformacionEnElArchivoPlano(arrayCursos.get(contador));
        
      }
    }
    public String[] getArregloInformacionAP()
    {
        return this.arregloInformacionConsultada;
    }
    public String getNombreEncontrado()
    {
        return arregloInformacionConsultada[0];
    }
}

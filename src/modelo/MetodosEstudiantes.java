
package modelo;

import java.util.ArrayList;

public class MetodosEstudiantes {
    
    private ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[2];
    ArchivoEstudiantes archivoEstudiantes;
    
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
        archivoEstudiantes= new ArchivoEstudiantes();
        arrayEstudiantes= archivoEstudiantes.devolverInformacionCompleta();
    }
    public void agregarEstudianteAP(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(temporal);
    }
    public boolean consultarEstudianteAP(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombrecompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarEstudianteAP(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombrecompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
            }
        }
    }
    public void eliminarEstudianteAP(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.remove(contador);
            }
        }
    }
    public void escribirInformacionEnElArchivoAP()
    {
      archivoEstudiantes.crearArchivoPlano();
      
      for(int contador=0;contador<arrayEstudiantes.size();contador++)
      {
        archivoEstudiantes.escribirInformacionEnElArchivoPlano(arrayEstudiantes.get(contador));
        
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

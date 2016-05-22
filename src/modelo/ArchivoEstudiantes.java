
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoEstudiantes {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public void crearArchivoPlano()
    {
      try
      {
          archivoSalida = new ObjectOutputStream(new FileOutputStream("estudiantes.dat"));
          System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivoPlano(Estudiante estudiante)
    {
      try
      {
            archivoSalida.writeObject(estudiante);
            System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
            System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public ArrayList<Estudiante> devolverInformacionCompleta()
    {
      ArrayList<Estudiante> arrayEstudiantes = new ArrayList <Estudiante>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("estudiantes.dat"));
        while(true)
        {
          arrayEstudiantes.add((Estudiante)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayEstudiantes;
    }
}

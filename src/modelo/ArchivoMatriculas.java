
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoMatriculas {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public void crearArchivo()
    {
      try
      {
          archivoSalida = new ObjectOutputStream(new FileOutputStream("matriculas.dat"));
          System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivo(Matricula matricula)
    {
      try
      {
            archivoSalida.writeObject(matricula);
            System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
            System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public ArrayList<Matricula> devolverInformacionCompleta()
    {
      ArrayList<Matricula> arrayMatriculas = new ArrayList <Matricula>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("matriculas.dat"));
        while(true)
        {
          arrayMatriculas.add((Matricula)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayMatriculas;
    }
}

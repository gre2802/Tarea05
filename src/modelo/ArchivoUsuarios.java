
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoUsuarios {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;

    public void crearArchivoPlano()
    {
      try
      {
          archivoSalida = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
          System.out.println("Archivo creado");
      }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }  
    public void escribirInformacionEnElArchivoPlano(Usuario usuario)
    {
      try
      {
            archivoSalida.writeObject(usuario);
            System.out.println("Se escribió la informacion de forma correcta");
      }
      catch(Exception e)
      {
            System.out.println("Error al escribir en el archivo: "+e);
      }
    }
    public ArrayList<Usuario> devolverInformacionCompleta()
    {
      ArrayList<Usuario> arrayUsuarios = new ArrayList <Usuario>();
      
      try
      {
        archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
        while(true)
        {
          arrayUsuarios.add((Usuario)archivoEntrada.readObject());
        }
      }
      catch(Exception e)
      {
        System.out.println("Fin del archivo "+e);
      }
      
      return arrayUsuarios;
    }
}

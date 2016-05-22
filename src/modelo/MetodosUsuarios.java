
package modelo;

import java.util.ArrayList;

public class MetodosUsuarios {
    
    private ArrayList <Usuario> arrayUsuarios;
    String arregloInformacionConsultada[]=new String[4];
    ArchivoUsuarios archivoUsuarios;

    public MetodosUsuarios() 
    {
        arrayUsuarios= new ArrayList<Usuario>();
        archivoUsuarios= new ArchivoUsuarios();
        arrayUsuarios= archivoUsuarios.devolverInformacionCompleta();
    }
    public void agregarEstudianteAP(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0],informacion[1],informacion[2],informacion[3],informacion[4]);
        arrayUsuarios.add(temporal);
    }
    public boolean consultarUsuarioAP(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getNombreCompleto();
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getNombreUsuario();
                arregloInformacionConsultada[2]=arrayUsuarios.get(contador).getContraseña();
                arregloInformacionConsultada[3]=arrayUsuarios.get(contador).getTipo();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public boolean consultarUsuarioRegistradoAP(String nombreUsuario)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(nombreUsuario))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getNombreCompleto();
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getNombreUsuario();
                arregloInformacionConsultada[2]=arrayUsuarios.get(contador).getContraseña();
                arregloInformacionConsultada[3]=arrayUsuarios.get(contador).getTipo();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarUsuarioAP(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayUsuarios.get(contador).setNombreCompleto(arreglo[1]);
                arrayUsuarios.get(contador).setNombreUsuario(arreglo[2]);
                arrayUsuarios.get(contador).setContraseña(arreglo[3]);
                arrayUsuarios.get(contador).setTipo(arreglo[4]);
            }
        }
    }
    public void eliminarUsuarioAP(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayUsuarios.remove(contador);
            }
        }
    }
    public void escribirInformacionEnElArchivoAP()
    {
      archivoUsuarios.crearArchivoPlano();
      
      for(int contador=0;contador<arrayUsuarios.size();contador++)
      {
        archivoUsuarios.escribirInformacionEnElArchivoPlano(arrayUsuarios.get(contador));
        
      }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
    public int getTamañoArreglo() {
        return arrayUsuarios.size();
    }
}

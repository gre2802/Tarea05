
package modelo;

import controlador.Controlador_FRM_Matricula;
import java.util.ArrayList;
import vista.FRM_Matricula;

public class MetodosMatricula {
    
    private ArrayList <Matricula> arrayMatriculas;
    Controlador_FRM_Matricula controlador;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    FRM_Matricula frm_Matricula;
    String arregloInformacionConsultada[]=new String[4];
    ArchivoMatriculas archivoMatriculas;
    
    public MetodosMatricula(Controlador_FRM_Matricula controlador,MetodosEstudiantes metodosEstudiantes,MetodosCursos metodosCursos,FRM_Matricula frm_Matricula) 
    {
        this.controlador=controlador;
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        this.frm_Matricula=frm_Matricula;
        arrayMatriculas= new ArrayList <Matricula>();
        archivoMatriculas= new ArchivoMatriculas();
        arrayMatriculas= archivoMatriculas.devolverInformacionCompleta();
    }
    
    public void agregarMatriculAP(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2]);
        arrayMatriculas.add(temporal);
        
    }
    public boolean consultarMatriculaAP(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatriculas.size();contador++)
        {
            if(arrayMatriculas.get(contador).getCodigo().equals(codigo))
            {
                if(arrayMatriculas.get(contador).getEstado())
                {
                    arregloInformacionConsultada[0]=codigo;
                    arregloInformacionConsultada[1]=arrayMatriculas.get(contador).getCedula();
                    metodosEstudiantes.consultarEstudianteAP(arrayMatriculas.get(contador).getCedula());
                    arregloInformacionConsultada[2]=metodosEstudiantes.getArregloInformacion()[0];
                    arregloInformacionConsultada[3]=arrayMatriculas.get(contador).getSigla();
                    frm_Matricula.agregarInformacionTabla(arregloInformacionConsultada);
                    existe=true;
                }
            }
        
        }
        return existe;
    }
    public void eliminarMatriculaAP(String arreglo[])
    {
        for(int contador=0;contador<arrayMatriculas.size();contador++)
        {
            if(arrayMatriculas.get(contador).getCodigo().equals(arreglo[0]))
            {
                if(arrayMatriculas.get(contador).getSigla().equals(arreglo[1]))
                {
                    arrayMatriculas.get(contador).setEstado(false);
                }
            }
        }
    }
    public void escribirInformacionEnElArchivoAP()
    {
      archivoMatriculas.crearArchivoPlano();
      
      for(int contador=0;contador<arrayMatriculas.size();contador++)
      {
        archivoMatriculas.escribirInformacionEnElArchivoPlano(arrayMatriculas.get(contador));
        
      }
    }
    public String[] getArregloInformacionAP()
    {
        return this.arregloInformacionConsultada;
    }
    public String devolverCodigo()
    {
        String codigo= "0000";
        if(arrayMatriculas.size()==0)
        {
            codigo+=1;
        }
        else 
        {
            int numero=Integer.parseInt(arrayMatriculas.get(arrayMatriculas.size()-1).getCodigo());
            numero++;
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo;
    }
}

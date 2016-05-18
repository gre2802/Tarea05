
package modelo;

import controlador.Controlador_FRM_VentanaPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import vista.FRM_Matricula;

public class ConexionBD {
    
    Connection con=null;
    String arregloUsuarios[]= new String[4];
    String arregloEstudiantes[]=new String[2];
    String arregloCursos[]=new String[3];
    String arregloMatriculas[]=new String[4];
    private ArrayList arrayCodigos= new ArrayList();
    Controlador_FRM_VentanaPrincipal controlador;
    FRM_Matricula frm_Matricula;
    
    public ConexionBD(Controlador_FRM_VentanaPrincipal controlador) 
    {
        realizarConexion();
        this.controlador=controlador;
        
    }
    public void asignarFRM_Matricula()
    {
        frm_Matricula= controlador.frm_Matricula;
    }
    public void realizarConexion() 
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    /// Metodos Usuarios ///
    
    public boolean consultarUsuario(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios WHERE cedula="+cedula);
                
                while (rs.next()) 
                {
                    String cedulaEncontrada= rs.getString("cedula");
                    if(cedulaEncontrada.equals(cedula)) {
                        
                        String nombreCompleto= rs.getString("nombreCompleto");
                        String nombreUsuario= rs.getString("nombreUsuario");
                        String contraseña= rs.getString("contraseña");
                        String tipo= rs.getString("tipo");
                        
                        arregloUsuarios[0]=nombreCompleto;
                        arregloUsuarios[1]=nombreUsuario;
                        arregloUsuarios[2]=contraseña;
                        arregloUsuarios[3]=tipo;
                        existe=true;
                    }
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo consultarUsuario ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    public boolean consultarUsuarioRegistrado(String usuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios WHERE nombreUsuario='"+usuario+"'");
                
                while (rs.next()) 
                {
                    String usuarioEncontrado= rs.getString("nombreUsuario");
                    if(usuarioEncontrado.equals(usuario)) {
                        
                        String nombreCompleto= rs.getString("nombreCompleto");
                        String nombreUsuario= rs.getString("nombreUsuario");
                        String contraseña= rs.getString("contraseña");
                        String tipo= rs.getString("tipo");
                        
                        arregloUsuarios[0]=nombreCompleto;
                        arregloUsuarios[1]=nombreUsuario;
                        arregloUsuarios[2]=contraseña;
                        arregloUsuarios[3]=tipo;
                        existe=true;
                    }
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo consultarUsuarioRegistrado ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    public void agregarUsuario(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuarios(cedula, nombreCompleto, nombreUsuario, contraseña, tipo) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"','"+informacion[4]+"')");
                
                System.out.println("Usuario agregado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo agregarUsuario ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void modificarUsuario(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE usuarios SET cedula=('"+informacion[0]+"'),nombreCompleto=('"+informacion[1]+"'),nombreUsuario=('"+informacion[2]+"'),contraseña=('"+informacion[3]+"'),tipo=('"+informacion[4]+"') WHERE cedula="+informacion[0]);
                
               System.out.println("Usuario modificado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo modificarUsuario ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void eliminarUsuario(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;

        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM usuarios WHERE cedula="+informacion[0]);
                
                System.out.println("Usuario eliminado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo eliminarUsuario ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public int cantidadFilasUsuarios()
    {
        ArrayList<String> datos = new ArrayList<String>();
        ResultSet rs = null;
        Statement cmd = null;
        int cantidadFilas=0;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios");
         
                while (rs.next()) 
                {
                    datos.add(rs.getString("cedula"));
                }
                rs.close();
                
                cantidadFilas=datos.size();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return cantidadFilas;
    }
    public String[] getArregloUsuarios()
    {
        return this.arregloUsuarios;
    }
    
    /// MetodosEstudiantes ///
    
    public boolean consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes WHERE cedula="+cedula);
                
                while (rs.next()) 
                {
                    String cedulaEncontrada= rs.getString("cedula");
                    if(cedulaEncontrada.equals(cedula)) {
                        
                        String nombre= rs.getString("nombre");
                        String direccion= rs.getString("direccion");
                        
                        arregloEstudiantes[0]=nombre;
                        arregloEstudiantes[1]=direccion;
                        existe=true;
                    }
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo consultarEstudiante ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    public void agregarEstudiante(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
                
                System.out.println("Estudiante agregado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo agregarEstudiante ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void modificarEstudiante(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE estudiantes SET cedula=('"+informacion[0]+"'),nombre=('"+informacion[1]+"'),direccion=('"+informacion[2]+"') WHERE cedula="+informacion[0]);
                
               System.out.println("Estudiante modificado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo modificarEstudiante ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void eliminarEstudiante(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;

        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiantes WHERE cedula="+informacion[0]);
                
                System.out.println("Estudiante eliminado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo eliminarEstudiante ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public String[] getArregloEstudiantes()
    {
        return this.arregloEstudiantes;
    }
    public String getNombreEstudiante()
    {
        return arregloEstudiantes[0];
    }
    
    /// Metodos Cursos ///
    
    public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos WHERE sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    String siglaEncontrada= rs.getString("sigla");
                    if(siglaEncontrada.equals(sigla)) {
                        
                        String nombre= rs.getString("nombre");
                        String creditos= rs.getString("creditos");
                        String horario= rs.getString("horario");
                        
                        arregloCursos[0]=nombre;
                        arregloCursos[1]=creditos;
                        arregloCursos[2]=horario;
                        existe=true;
                    }
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo consultarCurso ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    public void agregarCurso(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {  
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos, horario) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
                
                System.out.println("Curso agregado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo agregarCurso ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void modificarCurso(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE cursos SET sigla=('"+informacion[0]+"'),nombre=('"+informacion[1]+"'),creditos=('"+informacion[2]+"'),horario=('"+informacion[3]+"') WHERE sigla='"+informacion[0]+"'");
                
               System.out.println("Curso modificado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo modificarCurso ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void eliminarCurso(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;

        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM cursos WHERE sigla='"+informacion[0]+"'");
                
                System.out.println("Curso eliminado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo eliminarCurso ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public String[] getArregloCursos()
    {
        return this.arregloCursos;
    }
    public String getNombreCurso()
    {
        return arregloCursos[0];
    }
    
    /// Metodos Matricula ///
    
    public boolean consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existe=false;

        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM detalle_matriculas WHERE codigo='"+codigo+"'");
                
                while (rs.next()) 
                {
                    String codigoEncontrado= rs.getString("codigo");
                    if(codigoEncontrado.equals(codigo)) {
                       
                        
                        String cedula= rs.getString("cedula");
                        String sigla= rs.getString("sigla");
                        consultarEstudiante(cedula);
                        String nombreEstudiante= arregloEstudiantes[0];
                        
                        arregloMatriculas[0]=codigoEncontrado;
                        arregloMatriculas[1]=cedula;
                        arregloMatriculas[2]=nombreEstudiante;
                        arregloMatriculas[3]=sigla;
                        
                        frm_Matricula.agregarInformacionTabla(arregloMatriculas);
                        existe=true;
                    }
                }
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo consultarMatricula ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    public void agregarMatricula(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {  
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matriculas(codigo, cedula) VALUES ('"+informacion[0]+"','"+informacion[1]+"')");
                arrayCodigos.add(ejecuto);
                System.out.println("Curso agregado con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo agregarMatricula ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void agregarDetalleMatricula(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {  
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO detalle_matriculas(codigo, cedula, sigla) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo agregarDetalleMatricula ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public void eliminarMatricula(String informacion[])
    {
        Statement cmd = null;
        boolean ejecuto;

        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM detalle_matriculas WHERE codigo='"+informacion[0]+"'and sigla='"+informacion[1]+"'");
                
                System.out.println("Matricula eliminada con éxito");
        }
        catch(Exception e)
        {
            System.out.println("SQLException en metodo eliminarMatricula ejecutando sentencia: " + e.getMessage());
        }
        
    }
    public int cantidadFilasMatricula()
    {
        arrayCodigos.clear();
        ResultSet rs = null;
        Statement cmd = null;
        int cantidadFilas=0;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matriculas");
         
                while (rs.next()) 
                {
                    arrayCodigos.add(rs.getString("codigo"));
                }
                rs.close();
                
                cantidadFilas=arrayCodigos.size();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return cantidadFilas;
    }
    public String devolverCodigo()
    {
        cantidadFilasMatricula();
        String codigo= "0000";
        if(arrayCodigos.size()==0)
        {
            codigo+=1;
        }
        else 
        {
            int numero=arrayCodigos.size();
            numero++;
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo;
    }
}

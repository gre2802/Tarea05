
package modelo;

import java.io.Serializable;

public class Curso implements Serializable {
    
    private String sigla;
    private String nombre;
    private int creditos;
    private String horario;

    public Curso(String sigla, String nombre, int creditos, String horario) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horario = horario;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public String getInformacion() {
        return "Sigla: "+sigla+" Nombre: "+nombre+" Créditos: "+creditos+" Horario: "+horario;
    }
}

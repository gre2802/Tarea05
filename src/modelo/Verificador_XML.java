
package modelo;

public class Verificador_XML 
{
    
    public String quitarEspacios(String texto) 
    {
        String txt;
        txt=texto.replaceAll(" ","").trim();
        return txt;
    }
    public boolean verificarCampoTexto(String texto)
    {
        if(texto.length()!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean verificarNumero(String texto) 
    {
        
        boolean esNumero=true;
        for(int i=0;i<texto.length();i++) {
            
            if(Character.isLetter(texto.charAt(i))) {
                esNumero=false;
            }
        }
        return esNumero;
    }
    public boolean verificarLetras(String texto) 
    {
        
        boolean esLetras=true;
        for(int i=0;i<texto.length();i++) {
            
            if(Character.isDigit(texto.charAt(i))) {
                esLetras=false;
            }
        }
        return esLetras;
    }
}

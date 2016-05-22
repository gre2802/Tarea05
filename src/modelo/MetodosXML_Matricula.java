
package modelo;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import vista.FRM_Matricula;

public class MetodosXML_Matricula 
{
    FRM_Matricula frm_Matricula;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz,principal;
    String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
    String nombreArchivo;
    private ArrayList arrayCodigos;
    
    public MetodosXML_Matricula(FRM_Matricula frm_Matricula)
    {
        this.frm_Matricula=frm_Matricula;
        nombreArchivo="Matriculas";
        
        if(cargarXML())
        {
            System.out.println("Ya existe un archivo XML_Matriculas creado, ya fue cargado y puede proceder a utilizarlo");
        }
        else
        {
            crearXML();
            System.out.println("No existía un archivo XML_Matriculas creado, ya fue creado y puede proceder a utilizarlo");
        }
        
        arregloInformacion=new String[4];
        titulos = new ArrayList();
        valores = new ArrayList();
        arrayCodigos= new ArrayList();
    }
    public void crearXML()
    {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo XML_Matriculas: " + e);
        }
    }
    public boolean cargarXML()
    {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(nombreArchivo+".xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("Matricula");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML_Matriculas"+e);
        }
        return cargo;
    }
    public boolean consultarMatriculaXML(String codigo)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,encontrado=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("codigo") && datoContenido.getNodeValue().equals(""+codigo))
                 {
                    itemEncontrado=true;
                    encontrado=true;
                 }
                 if(itemEncontrado && contador<4)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }
             frm_Matricula.agregarInformacionTabla(arregloInformacion);
             contador=0;
             itemEncontrado=false;
         }
         return encontrado;
    }
    public void agregarMatriculaXML(String arregloInformacion[])
    {
        try{
            
            raiz = document.createElement("Matricula");
            principal = document.createElement("Matricula");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor0 = document.createElement("codigo");
            Text text0 = document.createTextNode(arregloInformacion[0]);
            Element valor1 = document.createElement("cedula");
            Text text1 = document.createTextNode(arregloInformacion[1]);
            Element valor2 = document.createElement("nombreEstudiante");
            Text text2 = document.createTextNode(arregloInformacion[2]);
            Element valor3 = document.createElement("sigla");
            Text text3 = document.createTextNode(arregloInformacion[3]);
            
            raiz.appendChild(valor0);
            valor0.appendChild(text0);
            raiz.appendChild(valor1);
            valor1.appendChild(text1);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            arrayCodigos.add(1);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar en XML_Matriculas: " + e);
        }
    }
    public void eliminarMatriculaXML(String informacion[])
    { 
        System.out.println(informacion[0]+"  "+informacion[1]);
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("codigo") && datoContenido.getNodeValue().equals(""+informacion[0]))
                    {
                        tag = datosItem.item(contadorTags+3); 
                        datoContenido = tag.getLastChild();
                        if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+informacion[1]))
                        {
                            raiz.removeChild(item);
                            source = new DOMSource(document);
                            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
                            console = new StreamResult(System.out);
                            transformer = TransformerFactory.newInstance().newTransformer();
                            transformer.transform(source, result);
                            transformer.transform(source, console);
                        }
                    } 
                }
            }
         }
        catch (Exception e) 
        {
            System.err.println("Error al eliminar en XML_Matriculas: " + e);
        }
    }
    public String devolverCodigoXML()
    {
        Element raiz = document.getDocumentElement();
        NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
        Node tag=null,datoContenido=null;
        int numero=0;
        String codigo="0000";

        for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
        {
            Node item = listaDeItems.item(contadorItems);
            NodeList datosItem = item.getChildNodes();
            for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
            {
                tag = datosItem.item(contadorTags); 
                datoContenido = tag.getFirstChild();
                if(tag.getNodeName().equals("codigo") && datoContenido.getNodeValue()!=codigo)
                {
                    numero++;
                    codigo=datoContenido.getNodeValue();
                }
            }
            
        }
        if(numero==0)
        {
            codigo+=1;
        }
        else 
        {
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo;
    }
}

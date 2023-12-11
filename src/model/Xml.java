/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *
 * @author diegu
 */
public class Xml implements IRepository{
    
    
    @Override
     public void exportarIRepositoryConversaciones(ArrayList<List<String>> conversaciones,Path ruta ){
        
        ObjectMapper xmlMapper= new XmlMapper();
     
        File f=ruta.toFile();
        try{
            
            xmlMapper.writeValue(f,conversaciones);

           
        }catch(IOException e ){
            e.printStackTrace();
        }
          
    }
          
         
     
    @Override
    public void exportarIRepositoryMensajes(ArrayList<Integer> mensajes,Path ruta ){
        
      
        ObjectMapper xmlMapper= new XmlMapper();
     
        File f=ruta.toFile();
        try{
            
            xmlMapper.writeValue(f,mensajes);

           
        }catch(IOException e ){
            e.printStackTrace();
        }
          
    }
    
    @Override
    public void exportarIRepositoryPrimeraFrase(List<String> primeraFrase,Path ruta ){
           
        ObjectMapper xmlMapper= new XmlMapper();
     
        File f=ruta.toFile();
        try{
            
            xmlMapper.writeValue(f,primeraFrase);

           
        }catch(IOException e ){
            e.printStackTrace();
        }
          
    }
    
    @Override
    public ArrayList<List<String>> importarIRepositoryConversaciones(Path ruta){
        ArrayList<List<String>> temp = new ArrayList<List<String>>();        
        File f = ruta.toFile();
      
        //METODO 2
        
        ObjectMapper xmlMapper= new XmlMapper();
        
             try(Scanner scannerRef = new Scanner(f)){
                StringBuilder xml= new StringBuilder();
               

                    while(scannerRef.hasNext()){
                       xml.append(scannerRef.nextLine());
                  }
                     System.out.println("Contenido del XML: " + xml.toString());
                     
                     return xmlMapper.readValue(xml.toString(), new TypeReference <ArrayList<List<String>>>() {});
            
                }catch(IOException e){
                   e.printStackTrace();
                return null;
               }       
              
    }
      
    
    @Override
    public  ArrayList<Integer> importarIRepositoryMensajes(Path ruta){
       
          ObjectMapper xmlMapper= new XmlMapper();
        try(Scanner scannerRef = new Scanner(ruta)){
            StringBuilder xml= new StringBuilder();
            while(scannerRef.hasNext()){
                xml.append(scannerRef.nextLine());
            }
            return xmlMapper.readValue(xml.toString(), new TypeReference <ArrayList<Integer>>() {});
            
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        
        
    }
    
    @Override
    public List<String> importarIRepositoryPrimeraFrase(Path ruta){
           
         ObjectMapper xmlMapper= new XmlMapper();
        try(Scanner scannerRef = new Scanner(ruta)){
            StringBuilder xml= new StringBuilder();
            while(scannerRef.hasNext()){
                xml.append(scannerRef.nextLine());
            }
            return xmlMapper.readValue(xml.toString(), new TypeReference <List<String>>() {});
            
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String getIdentifierIRepository() {
        return "xml";
    }
    
}

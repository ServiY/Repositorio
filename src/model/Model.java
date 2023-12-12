/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diegu
 */
public class Model{
      
    ILLM illm;
    IRepository irepository;

    
    public Model(ILLM illm,IRepository irepository){
        
        this.illm=illm;
        this.irepository=irepository;
        
    }
    
    
   public String nuevaConversacion(int ronda,Path ruta) throws IOException{
        
        return illm.nuevaConversacion(ronda,ruta);
               
    }
              
    //METODO PARA GUARDAR LAS CONVERSACIONES
    
    public void guardarConversacion(Path ruta) throws IOException{
        
        illm.guardarConversacion(ruta);
                 
  
    }
    
    //METODO PARA COMPROBAR SI EXISTE LA PALABRA EN LA FRASE
    
    public boolean comprobarPalabra(String texto, String palabra){
        
        return illm.comprobarPalabra(texto, palabra);
    }
    
    //METODO PARA PRESENTAR SOLO LA PRIMERA LINEA DE CONVERSACION
    public String lineaConver(int num){

        return illm.lineaConver(num);
                
    }
    
    //METODO PARA DESPLEGAR UNA CONVERSACION ENTERA
    
   public List<String> escogerConversacion(int escogida){
        
        return illm.escogerConversacion(escogida);
             
    }
    
     public Integer numMensajes(int num){
        
        return illm.numMensajes(num);
             
    }
     
     public void eliminarConver(int escogida){
         
         illm.eliminarConver(escogida);
     }
     
  
    public void Serializacion(){
        
        illm.Serializacion();
        
    }
  
     public void Deserializacion(){
         
         illm.Deserializacion();
     }
     
      public Integer numConversacion(){
          
          return illm.numConversacion();
          
      }
      
    public String getIdentifier() {
        
        return illm.getIdentifier();
    }
       
    public String getIdentifierIRepository() {
        
        return irepository.getIdentifierIRepository();
    }
    
    //EXPORTACION E IMPORTACION DE TODOS LOS ARRAYLIST, STRINGS...
    
    
    public void exportarIRepositoryConversaciones(Path ruta){
              
        irepository.exportarIRepositoryConversaciones(illm.devolverConversaciones(),ruta);
           
    }
    
     public void exportarIRepositoryMensajes(Path ruta){
              
        irepository.exportarIRepositoryMensajes(illm.devolverMensajes(),ruta);
           
    }
     
     public void exportarIRepositoryPrimeraFrase(Path ruta){
              
        irepository.exportarIRepositoryPrimeraFrase(illm.devolverPrimeraFrase(),ruta);
           
    }
    
    public void importarIRepositoryConversaciones(Path ruta){
        
        ArrayList<List<String>> result= new ArrayList<>();

        result= irepository.importarIRepositoryConversaciones(ruta);
        illm.importarIRepositoryConversaciones(result);
    }
    
     public void importarIRepositoryMensajes(Path ruta){
              
        ArrayList<Integer> result = irepository.importarIRepositoryMensajes(ruta);
         
        illm.importarIRepositoryMensajes(result);
    }
     
     public void importarIRepositoryPrimeraFrase(Path ruta){
               
          
        List<String> result= irepository.importarIRepositoryPrimeraFrase(ruta);

        illm.importarIRepositoryPrimeraFrase(result);
    }
     
     public void leerConVoz(List<String> opciones) throws OllamaBaseException, InterruptedException{
         
        illm.leerConVoz(opciones);
     }
     
}
     


     






         
    

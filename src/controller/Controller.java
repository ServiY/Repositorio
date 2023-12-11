/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import model.Model;
import view.ApplicationView;


/**
 *
 * @author diegu
 */
public class Controller {
    
    ApplicationView view;
    Model model;
    
    public Controller(ApplicationView view, Model model){
        
        this.view= view;
        this.model= model;
        
    }
    
    //METODOS PARA NUEVA CONVERSACION
    
    public String nuevaConversacion(int ronda,Path ruta) throws IOException{
        
        return model.nuevaConversacion(ronda,ruta);
        
    }
    
    public void finalDeConversacion(){
        
        view.showMainMenu();
    }
    
    //METODOS PARA IMPRIMIR Y ELIMINAR CONVERSACIONES
    
    public List<String> escogerConversacion(int escogida){
        
        return model.escogerConversacion(escogida);
    }
    
    public boolean comprobarPalabra(String texto, String palabra){
        
        return model.comprobarPalabra(texto,palabra);
        
    }
    
    public void guardarConversacion(Path ruta)throws IOException{
        
        model.guardarConversacion(ruta);
        
    }
    
    public String lineaConver(int num){
        
        return model.lineaConver(num);
    }
    
    public Integer numMensajes(int num){
        
        return model.numMensajes(num);
        
    }
    
    public void eliminarConver(int escogida){
        
        model.eliminarConver(escogida);
        
    }
   
     public void Serializacion(){
        
        model.Serializacion();
    }
    
     public void Deserializacion(){
        
        model.Deserializacion();
        
    }
     
      public Integer numConversacion(){
         
         return model.numConversacion();
         
     }
      
       public String getIdentifier() {
        return model.getIdentifier();
    }
       
       public String getIdentifierIRepository() {
           
        return model.getIdentifierIRepository();
    }
       
       public void exportarIRepositoryConversaciones(Path ruta){
           
           model.exportarIRepositoryConversaciones(ruta);
       }
       
        public void exportarIRepositoryMensajes(Path ruta){
           
           model.exportarIRepositoryMensajes(ruta);
       }
        
       public void exportarIRepositoryPrimeraFrase(Path ruta){
           
           model.exportarIRepositoryPrimeraFrase(ruta);
       }
       
        public void importarIRepositoryConversaciones(Path ruta){
           
           model.importarIRepositoryConversaciones(ruta);
       }
        
        public void importarIRepositoryMensajes(Path ruta){
           
           model.importarIRepositoryMensajes(ruta);
       }
           
        public void importarIRepositoryPrimeraFrase(Path ruta){
           
           model.importarIRepositoryPrimeraFrase(ruta);
       }
    
       
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegu
 */
public class Smart extends TipoMensaje implements ILLM{
    
    @Override
    public String nuevaConversacion(int ronda,Path ruta){
              
    try{    
        
          String salto = "\n";
          String host = "http://localhost:11434/";
          OllamaAPI ollamaAPI = new OllamaAPI(host);
          String msg= "hola que tal?" ;
          String response=ollamaAPI.ask("mistral", msg);
          
            if(ronda==0){
            primeraFrase.add(response);     
            }
            
          Files.write(ruta,response.getBytes(),StandardOpenOption.APPEND);
          Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
          return response;
        
        
    }catch(IOException e){
        
        System.out.println("ERROR: "+ e.getMessage());
    }    catch (OllamaBaseException ex) {
             Logger.getLogger(Smart.class.getName()).log(Level.SEVERE, null, ex);
       
         } catch (InterruptedException ex) {
             Logger.getLogger(Smart.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
     
     
          return null;    
    }
    
       
    
    @Override
    public String getIdentifier() {
        return "smart";
    }
    
}

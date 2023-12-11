/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegu
 */
public class Voice extends ApplicationView {

     int conversaciones_totales=0;
    @Override
    public void showApplicationStart(){
        
        System.out.println("----------------------------º\n");
        System.out.println("BIENVENIDO A JMML\n");
        System.out.println("----------------------------\n");
        
    }
    
    @Override
    public void showMainMenu(){
        
        Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "conversaciones.txt"); 
        int ronda=0;
        
        List<String> opciones= new ArrayList<String>();
        opciones.add("MENU PRINCIPAL");
        opciones.add("OPCIONES:");
        opciones.add("1) Nueva conversacion");
        opciones.add("2) Listar y eliminar conversaciones");
        opciones.add("3) Exportacion de conversaciones");
        opciones.add("4) Importacion de conversaciones");
        opciones.add("5) SALIR");
        
        System.out.println("\n");
        System.out.println("MENU PRINCIPAL:\n");
        System.out.println("OPCIONES:\n");
        System.out.println("1) Nueva conversacion\n");
        System.out.println("2) Listar y eliminar conversaciones\n");
        System.out.println("3) Exportacion de conversaciones\n");
        System.out.println("4) Importacion de conversaciones\n");
        System.out.println("5) SALIR\n");
        
        
         try { 
             controller.leerConVoz(opciones);
         } catch (OllamaBaseException ex) {
             Logger.getLogger(Voice.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InterruptedException ex) {
             Logger.getLogger(Voice.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         while(true){
         try {
             String respuesta= controller.nuevaConversacion(ronda, ruta);
             System.out.println(respuesta);
         } catch (IOException ex) {
             Logger.getLogger(Voice.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         }
       
        
        
 }
    
    @Override
    public void showApplicationEnd(){
        
        System.out.println("\nGracias y hasta pronto!\n");   
    }
    
    @Override
    public void Serializacion(){
        
        System.out.println("REALIZADA LA SERIALIZACION DE LAS CONVERSACIONES");
        controller.Serializacion();
        
    }
    
    @Override
    public void Deserializacion(){
        
        controller.Deserializacion();
        
    }
       

    
    
    
}
    


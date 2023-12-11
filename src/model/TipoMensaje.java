/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegu
 */
public class TipoMensaje{
    
   // MensajeFake fake;
   // Model model;
   // CSV csv;
   // Controller controller;
    ArrayList<List<String>>conversaciones = new ArrayList<>();
    ArrayList<Integer>mensajes=new ArrayList<>();
    List<String>primeraFrase = new ArrayList<>();
    ArrayList<Integer>posicionesClave=new ArrayList<>();
    int i=0;
    
  public void guardarConversacion(Path ruta){
        
          int messages=0;
    
        //ARRAY LIST DE LISTAS DE STRINGS
       try{ 
         List<String>lineas = Files.readAllLines(ruta);
         
       
         List<String>lista = new ArrayList<>();
         for(String linea:lineas){
             
             String l= linea + "\n";
             lista.add(l);
             messages++;           
         }
         conversaciones.add(lista);
         mensajes.add(messages);
         
       } catch(IOException e){
        
        System.out.println("ERROR: "+ e.getMessage());
    }
      
  }
 
   public boolean comprobarPalabra(String texto, String palabra){
        
        return texto.toLowerCase().contains(palabra.toLowerCase());
    }
   
   public String lineaConver(int num){

        return primeraFrase.get(num);
                
    }
   
    public List<String> escogerConversacion(int escogida){
        
          return conversaciones.get(escogida);
             
    }
    
     public Integer numMensajes(int num){
        
          return mensajes.get(num);
             
    }
     
      public void eliminarConver(int escogida){
         
         conversaciones.remove(escogida);
         primeraFrase.remove(escogida);
         mensajes.remove(escogida);
     }
           
      
       public Integer numConversacion(){

         return conversaciones.size();
         
     }
     
     public void Serializacion(){

    try{
         ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("jLLm.bin"));
         oos.writeObject(conversaciones);
         oos.writeObject(primeraFrase);
         oos.writeObject(mensajes);
               
         
     }catch(IOException e){
         
         System.out.println("Error en la serializacion:" + e.getMessage());
     }
     
}
     
     public void Deserializacion(){

         try{
         ObjectInputStream ois=new ObjectInputStream(new FileInputStream("jLLm.bin"));
         conversaciones=(ArrayList<List<String>>) ois.readObject();
         primeraFrase= (List<String>) ois.readObject();
         mensajes = (ArrayList<Integer>) ois.readObject();
                 
         
     }catch(IOException e){
         
             System.out.println("Error en la deserializacion:"+ e.getMessage());
         
     }  catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
     public ArrayList<List<String>> devolverConversaciones(){
         
         return conversaciones;
         
     }
     
    public ArrayList<Integer> devolverMensajes(){
         
         return mensajes;
         
     }
      
     public List<String> devolverPrimeraFrase(){
         
         return primeraFrase;
         
     }
     
     public void importarIRepositoryConversaciones(ArrayList<List<String>> importacion){
         int i=0; 
         int j=0;
         
        
           
         for(List<String> importacionRealizada: importacion){
             boolean noSeHace=true;
             i=0;
              for(List<String> conver:conversaciones) {
             
             if(importacionRealizada.equals(conversaciones.get(i))){
                 
                 noSeHace=false;
              
             }
              i++;
         }
         
              if(noSeHace==true){
                  
                 
                  conversaciones.add(importacionRealizada);
                  System.out.printf("%s\n",conversaciones);
                  posicionesClave.add(j);
                  
              }
         j++;
       }
         

     }
     
     public void importarIRepositoryMensajes( ArrayList<Integer> importacion){
         int i=0;
     
        for(Integer posicionKey: posicionesClave){
           i=0; 
         for(Integer importacionRealizada: importacion){
              
             if(i==posicionKey){
              mensajes.add(importacionRealizada);
              break;
             }
             
          i++;   
         }
         
        }
     }
     
      public void importarIRepositoryPrimeraFrase(List<String> importacion){
        int i=0;
     
        for(Integer posicionKey: posicionesClave){
           i=0;   
         for(String importacionRealizada: importacion){
             
             if(i==posicionKey){
              primeraFrase.add(importacionRealizada);
                break;
             }
             
          i++;   
         }
         
        }
        
        borrarPosiciones();
       }      
    
      
      public void borrarPosiciones(){
        
        for(i=0;i<posicionesClave.size();i++){
            
            posicionesClave.remove(i);
        }
          
      }
}


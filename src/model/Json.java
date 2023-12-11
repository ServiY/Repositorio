/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


/**
 *
 * @author diegu
 */
public class Json implements IRepository{
    
    @Override
    public void exportarIRepositoryConversaciones(ArrayList<List<String>> conversaciones,Path ruta ){
        
        Gson gson= new Gson();
        String json= gson.toJson(conversaciones);
        
        try{
        Files.write(ruta,json.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        }catch(IOException e){
            e.printStackTrace();
        }
          
    }
    
     @Override
    public void exportarIRepositoryMensajes(ArrayList<Integer> mensajes,Path ruta ){
        
        Gson gson= new Gson();
        String json= gson.toJson( mensajes);
 
        try{
        Files.write(ruta,json.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        }catch(IOException e){
            e.printStackTrace();
        }
          
    }
    
    @Override
    public void exportarIRepositoryPrimeraFrase(List<String> primeraFrase,Path ruta ){
        
        Gson gson= new Gson();
        String json= gson.toJson(primeraFrase);
                     
        try{
        Files.write(ruta,json.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);

        }catch(IOException e){
            e.printStackTrace();
        }
          
    }
    
    @Override
    public ArrayList<List<String>> importarIRepositoryConversaciones(Path ruta){
        Gson gson = new Gson();
        try(Scanner scannerRef= new Scanner(ruta)){
            
            StringBuilder json= new StringBuilder();
            while(scannerRef.hasNext()){
                json.append(scannerRef.nextLine());
            }
                
            return gson.fromJson(json.toString(), new TypeToken<ArrayList<List<String>>>() {}.getType());
            
        }catch(IOException e){
                e.printStackTrace();     
                return null;
        }
        
        
    }
    
    @Override
    public  ArrayList<Integer> importarIRepositoryMensajes(Path ruta){
        Gson gson = new Gson();
        try(Scanner scannerRef= new Scanner(ruta)){
            
            StringBuilder json= new StringBuilder();
            while(scannerRef.hasNext()){
                json.append(scannerRef.nextLine());
            }
          
            return gson.fromJson(json.toString(), new TypeToken <ArrayList<Integer>>() {}.getType());
            
        }catch(IOException e){
                e.printStackTrace();     
                return null;
        }     
    }
    
    @Override
    public List<String> importarIRepositoryPrimeraFrase(Path ruta){
        Gson gson = new Gson();
        try(Scanner scannerRef= new Scanner(ruta)){
            
            StringBuilder json= new StringBuilder();
            while(scannerRef.hasNext()){
                json.append(scannerRef.nextLine());
            }
            return gson.fromJson(json.toString(), new TypeToken <List<String>>() {}.getType());
            
        }catch(IOException e){
                e.printStackTrace();     
                return null;
        }
               
    }
    
    @Override
    public String getIdentifierIRepository() {
        return "json";
    }
    
}

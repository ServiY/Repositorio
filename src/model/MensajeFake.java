/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static com.coti.tools.Esdia.readString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author diegu
 */
public class MensajeFake extends TipoMensaje implements ILLM{
    
    @Override
    public String nuevaConversacion(int ronda,Path ruta){
        
        DateFormat df = new SimpleDateFormat("[dd/MM/yy HH:mm:ss]:");
        Date fecha = new Date();
        
         String palabra_bot= "Agente" + df.format(fecha) + "Vuelve cuando quieras";
         String no_response= "Agente" + df.format(fecha) + "Lo siento... No tengo respuesta para eso";
         String inicio = "Yo" + df.format(fecha);
        
            
    try{    
        //YO HABLO
        String texto = readString("Yo" + df.format(fecha));
        if(ronda==0){
        primeraFrase.add(inicio+texto);     
        }
   
        
        String salto = "\n";
        
        Files.write(ruta,inicio.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        Files.write(ruta,texto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        String end = "/salir";
      
        //TURNO DEL BOT
        
                if(texto.equals(end)){
                   
                Files.write(ruta,palabra_bot.getBytes(),StandardOpenOption.APPEND);
                Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                
                return (palabra_bot);
                
                }
                
                if(comprobarPalabra(texto,"hola")){
                    
                    String palabraFichero = "Agente" + df.format(fecha) + "Hola, que tal estas?" ;
                    Files.write(ruta,palabraFichero.getBytes(),StandardOpenOption.APPEND);
                    Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                  
                 return(palabraFichero);
                    
                }
                
                if(comprobarPalabra(texto,"Quien eres")){
                    
                    String palabraFichero = "Agente" + df.format(fecha) + "Soy Diego, un bot programado para ayudar a las personas y responder a sus posibles cuestiones. Un placer" ;
                    Files.write(ruta,palabraFichero.getBytes(),StandardOpenOption.APPEND);
                    Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                  
                 return(palabraFichero);
                    
                }
                
                if(comprobarPalabra(texto,"hobbies")){
                    
                    String palabraFichero = "Agente" + df.format(fecha) + "Mis hobbies?, hm... Supongo que me gusta hablar con las personas, ah si, me gustaria tocar el piano tambien!" ;
                    Files.write(ruta,palabraFichero.getBytes(),StandardOpenOption.APPEND);
                    Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
                
                 return(palabraFichero);
                    
                }
        
        Files.write(ruta,no_response.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        Files.write(ruta,salto.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
    }catch(IOException e){
        
        System.out.println("ERROR: "+ e.getMessage());
    }
        return (no_response);
               
    }
    

    @Override
    public String getIdentifier() {
        return "fake";
    }
    
 
    
  
}

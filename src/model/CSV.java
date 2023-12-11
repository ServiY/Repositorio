/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author diegu
 */
public class CSV extends TipoMensaje implements ILLM{
   

    @Override
    public String nuevaConversacion(int ronda, Path ruta){
        
        Path ruta2= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "respuestasCSV.txt");
        
        Random random = new Random();
        String resultado = null;
        
    try{
        String salto = "\n";
        ArrayList<MensajeCSV> mensaje = obtencionMensajesCSV(ruta2);
        int max=mensaje.size();
        int numeroRandom=random.nextInt(max);
        
        MensajeCSV aleatorio= mensaje.get(numeroRandom);

        resultado= aleatorio.toString(); 
              
        Files.write(ruta,resultado.getBytes(),StandardOpenOption.APPEND);
        Files.write(ruta,salto.getBytes(),StandardOpenOption.APPEND);
        
        if(ronda==0){
        primeraFrase.add(resultado);     
        }
          
        
        }catch(IOException e){
        
        System.out.println("ERROR: "+ e.getMessage());
        
        }
    
        return resultado;      
    }
    
    public ArrayList<MensajeCSV> obtencionMensajesCSV(Path ruta2) throws IOException{
        
        
        ArrayList<MensajeCSV>mensajesCSV=new ArrayList<>();
        List<String>lineasCSV=Files.readAllLines(ruta2);
        
        for(String linea:lineasCSV){
            
            MensajeCSV m= leerDelimitado(linea,",");
            
            if(m!=null){
                
                mensajesCSV.add(m);               
            }                     
        }
        
        return mensajesCSV;
    }
    
        public MensajeCSV leerDelimitado(String delimitedString, String delimitador){
        
        String[]chunks=delimitedString.split(delimitador);
        
        if(chunks.length!=2){
            
            return null;
        }
        
        try{
            
            String tipofrase= chunks[0];
            int longitud= chunks[1].length();
            String frase= chunks[1];
            
            MensajeCSV m = new MensajeCSV(tipofrase,longitud,frase);
            return m;
            
            
        }catch(NumberFormatException e){
            
            return null;
            
        }      
        
    }
        
        
        @Override
    public String getIdentifier() {
        return "csv";
    }
 
  
    
}

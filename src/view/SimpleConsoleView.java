/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author diegu
 */
public class SimpleConsoleView extends ApplicationView {

     int conversaciones_totales=0;
    @Override
    public void showApplicationStart(){
        
        System.out.println("----------------------------º\n");
        System.out.println("BIENVENIDO A JMML\n");
        System.out.println("----------------------------\n");
        
    }
    
    @Override
    public void showMainMenu(){
         System.out.println("\n");
        System.out.println("MENU PRINCIPAL:\n");
        System.out.println("OPCIONES:\n");
        System.out.println("1) Nueva conversacion\n");
        System.out.println("2) Listar y eliminar conversaciones\n");
        System.out.println("3) Exportacion de conversaciones\n");
        System.out.println("4) Importacion de conversaciones\n");
        System.out.println("5) SALIR\n");
        
        int opcion= readInt("Escriba la opcion que desea: ");
       
        switch(opcion){
        
                case 1:
                               
                 try {
                if(controller.getIdentifier().equals("csv")){
                    conversaciones_totales+=1;
                    opcion1CSV(); 
                     
                 }
                 
                 if(controller.getIdentifier().equals("fake")){
                     conversaciones_totales+=1;
                    opcion1();
                     
                 }
                 
                  if(controller.getIdentifier().equals("smart")){
                     conversaciones_totales+=1;
                    opcion1Smart();
                     
                 }
                 } catch (IOException ex) {
                     Logger.getLogger(SimpleConsoleView.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  break;

                
                case 2:
                    
                    opcion2();
                    
                    break;
                
                case 3:
                    
                    if(controller.getIdentifierIRepository().equals("json")){
            
                     opcion3JSON();                    
                 }
                      if(controller.getIdentifierIRepository().equals("xml")){
          
                     opcion3XML();                    
                 }
                                      
                break;
                
                 case 4:
                      if(controller.getIdentifierIRepository().equals("json")){
            
                     opcion4JSON();                    
                 }
                      if(controller.getIdentifierIRepository().equals("xml")){
          
                     opcion4XML();                    
                 }
                break;
                
                 case 5:
                     
                     break;
        
    
        
        
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
       

    private void opcion1() throws IOException{
        
           Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "conversaciones.txt");        
                  boolean condicionBucle= true;      
                  int ronda=0;
                  while(condicionBucle){
                    
                          
                     //YO HABLO Y ME DEVUELVE UNA RESPUESTA
                     String respuesta = controller.nuevaConversacion(ronda,ruta);
                     ronda++;
                     
                     //RESPUESTA DEL BOT
                     System.out.printf("%s\n",respuesta);
        
                       if(controller.comprobarPalabra(respuesta,"Vuelve cuando quieras")){
            
                           condicionBucle=false;                       
                       }                                    
                  }
                  controller.guardarConversacion(ruta);
                  Files.newBufferedWriter(ruta, StandardOpenOption.TRUNCATE_EXISTING);
                  controller.finalDeConversacion();
    }
    
    private void opcion1Smart() throws IOException{
        
           Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "conversaciones.txt");        
                  boolean condicionBucle= true;      
                  int ronda=0;
                  while(condicionBucle){
                    
                       
                        try {
                            String respuesta= controller.nuevaConversacion(ronda, ruta);
                            System.out.println(respuesta);
                        } catch (IOException ex) {
                            Logger.getLogger(Voice.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
                     String opcion= readString("Si desea salir, escriba /salir:");
                     ronda++;
                     
        
                       if(controller.comprobarPalabra(opcion,"/salir")){
            
                           condicionBucle=false;                       
                       }                                    
                  }
                  controller.guardarConversacion(ruta);
                  Files.newBufferedWriter(ruta, StandardOpenOption.TRUNCATE_EXISTING);
                  controller.finalDeConversacion();
    }
    
   private void opcion1CSV() throws IOException{
        
           
           Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "conversaciones.txt"); 
           boolean condicionBucle= true;      
           int ronda=0;         
           while(condicionBucle){
               
                     String respuesta = controller.nuevaConversacion(ronda,ruta);      
                     
                     //RESPUESTA DEL BOT
                     System.out.printf("%s\n",respuesta);
                     ronda++;                                   
           String seguir=readString("Desea seguir viendo frases?(S/N): ");
           if(seguir.equals("S")){
             
           }
           
           if(seguir.equals("N")){
              condicionBucle=false;
           }
           
           if(!seguir.equals("S") && !seguir.equals("N" )){
             
             System.out.println("OPCION NO VALIDA, SOLO SE PUEDE USAR S/N");
             }
           
           }
          controller.guardarConversacion(ruta);
          Files.newBufferedWriter(ruta, StandardOpenOption.TRUNCATE_EXISTING);
          controller.finalDeConversacion();             
   }
    
    
    private void opcion2(){
        
        //PRIMERO MUESTRO TODAS LAS CONVERSACIONES
        conversacionesOpcion2();
       
        
        //AHORA MUESTRO LA QUE ME HA PEDIDO
        boolean condicionBucle= true; 
        boolean condicionMiniBucle= true;
        
        while(condicionBucle){
         String opcion =readString("Desea elegir alguna conversacion? S/N:");
         if(opcion.equals("S")){
             int escogida=readInt("Que conversacion quiere ver?:");
             System.out.printf("%s\n",controller.escogerConversacion(escogida-1));
             String eliminacion= readString("Desea eliminar esta conversacion? S/N:");
             
           while(condicionMiniBucle){
                   
             if(eliminacion.equals("S")){
                 
                 controller.eliminarConver(escogida-1);
                 System.out.println("Eliminacion realizada con exito\n");
                 condicionMiniBucle=false;  
                 condicionBucle=false;
                  conversaciones_totales-=1;
                 controller.finalDeConversacion();
             }
           
             if(eliminacion.equals("N")){
             condicionMiniBucle=false;
             condicionBucle=false;
             controller.finalDeConversacion();
            
             
             
            }
         
         if(!eliminacion.equals("S") && !eliminacion.equals("N" )){
             
             System.out.println("OPCION NO VALIDA, SOLO SE PUEDE USAR S/N");
             }
         }
           
        }
       
         if(opcion.equals("N")){
             condicionBucle=false;
             controller.finalDeConversacion();
             
         }
         
         if(!opcion.equals("S") && !opcion.equals("N" )){
             
             System.out.println("OPCION NO VALIDA, SOLO SE PUEDE USAR S/N");
             
         }
          
        }               
        
    }
    
    private void conversacionesOpcion2(){
        
        int i;
        int num=0; 
        int indice=1;
        
        for(i=0;i<controller.numConversacion();i++){
          
            System.out.printf("%d|          |%d       |%s\n",indice,controller.numMensajes(num),controller.lineaConver(num));
            num++;
            indice++;
        }      
    }
    
    private void opcion3JSON(){
        Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMJson.json"); 
         Path ruta2= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMMensajesJson.json"); 
          Path ruta3= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMPrimeraFraseJson.json"); 
        controller.exportarIRepositoryConversaciones(ruta);
        controller.exportarIRepositoryMensajes(ruta2);
        controller.exportarIRepositoryPrimeraFrase(ruta3);
        
        System.out.println("EXPORTACION COMPLETADA CON EXITO");
        controller.finalDeConversacion();
        
                
    }
    
    private void opcion3XML(){
        Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMXML.xml");
        Path ruta2= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMMensajesXML.xml"); 
        Path ruta3= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMPrimeraFraseXML.xml"); 
 
        controller.exportarIRepositoryConversaciones(ruta);
        controller.exportarIRepositoryMensajes(ruta2);
        controller.exportarIRepositoryPrimeraFrase(ruta3);
        
        System.out.println("EXPORTACION COMPLETADA CON EXITO");
        controller.finalDeConversacion();
        
                
    }
    
    private void opcion4JSON(){
        Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMJson.json"); 
        Path ruta2= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMMensajesJson.json"); 
        Path ruta3= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMPrimeraFraseJson.json"); 
        
        controller.importarIRepositoryConversaciones(ruta);
        controller.importarIRepositoryMensajes(ruta2);
        controller.importarIRepositoryPrimeraFrase(ruta3);
        
        System.out.println("IMPORTACION COMPLETADA CON EXITO");
        controller.finalDeConversacion();
        
                
    }
     
    private void opcion4XML(){
        Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMXML.xml"); 
        Path ruta2= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMMensajesXML.xml"); 
        Path ruta3= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM", "jLLMPrimeraFraseXML.xml"); 
        
        //controller.importarIRepositoryConversaciones(ruta);
        controller.importarIRepositoryMensajes(ruta2);
        controller.importarIRepositoryPrimeraFrase(ruta3);
        
        System.out.println("IMPORTACION COMPLETADA CON EXITO");
        controller.finalDeConversacion();
        
                
    }
    
    
}
    
    
    
    


   

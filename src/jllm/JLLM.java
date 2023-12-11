/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jllm;

import controller.Controller;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.CSV;
import model.ILLM;
import model.IRepository;
import model.Json;
import model.Model;
import model.MensajeFake;
import model.Xml;
import view.ApplicationView;
import view.SimpleConsoleView;
import view.Voice;

public class JLLM {

   
    public static void main(String[] args) {
        
        //COMPROBACIONES DE SI EXISTEN LOS FICHEROS NECESARIOS
        
        Path ruta= Paths.get(System.getProperty("user.home"), "Desktop", "JLLM");
        
       
        //COMPROBACIONES DE LOS ARGUMENTOS
        do{
        if(args.length!=3){
            
            System.err.println("Numero de argumentos invalido");
            return;
            
         }
        }while(args.length!=3);
        
        
        ApplicationView view;
        ILLM illm;
        IRepository irepository;
         view = obtenerView(args[2]);
         illm= obtenerILLM(args[1]);
         irepository= obtenerIRepository(args[0]);
        
        Model model=new Model(illm,irepository);
        Controller controller = new Controller(view,model);
        view.setController(controller);
        
          if(ruta == null){
            
            System.err.println("El archivo jLLm.bin no se ha encontrado, parece ser que nunca ha ejecutado este programa anteriormente");
            return;
        }
        
        else{
            
            System.out.println("Archivo encontrado con exito\n");
             view.Deserializacion();
        }
        
        view.showApplicationStart();
        view.showMainMenu();
        view.showApplicationEnd();
        view.Serializacion();
      
        
        
    }
    
    
    private static ApplicationView obtenerView(String argumento){
            
            switch(argumento){
                
                case "consola":                    
                  
                    return new SimpleConsoleView();
                    
                    
                case "voz":
                        return new Voice();
                
                default:
                    return new SimpleConsoleView();
                
            }
            
        }
    
        private static ILLM obtenerILLM(String argumento){
            
            switch(argumento){
                
                case "fake":
                    return new MensajeFake();
                    
                case "csv":
                        return new CSV();
                
                default:
                    return new MensajeFake();
                
            }
            
        }
        
        private static IRepository obtenerIRepository(String argumento){
            
            switch(argumento){
                
                case "xml":
                    return new Xml();
                    
                case "json":
                        return new Json();
                
                default:
                    return new Json();
                
            }
            
        }
    

    
}

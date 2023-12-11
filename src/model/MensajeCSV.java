/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diegu
 */
public class MensajeCSV extends CSV {
    
    String tipoFrase;
    int longitud;
    String frase;
    
    public MensajeCSV(String tipoFrase, int longitud, String frase){
        this.tipoFrase=tipoFrase;
        this.longitud=longitud;
        this.frase=frase;
          
    }


    @Override
    public String toString(){
        
        return "FRASE ALEATORIA CSV="+ tipoFrase+","+longitud+","+frase;
    }
    
    
}
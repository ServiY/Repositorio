/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diegu
 */
public interface ILLM {
    
    String getIdentifier();
    String nuevaConversacion(int ronda,Path ruta);
    void guardarConversacion(Path ruta);
    boolean comprobarPalabra(String texto, String palabra);
    String lineaConver(int num);
    List<String> escogerConversacion(int escogida);
    Integer numMensajes(int num);
    void eliminarConver(int escogida);
    public void Serializacion();
    public void Deserializacion();
    public Integer numConversacion();
    public ArrayList<List<String>> devolverConversaciones();
    public ArrayList<Integer> devolverMensajes();
    public List<String> devolverPrimeraFrase();
    public void importarIRepositoryConversaciones(ArrayList<List<String>> importacion);
    public void importarIRepositoryMensajes(ArrayList<Integer> importacion);
    public void importarIRepositoryPrimeraFrase(List<String> importacion);
    public void leerConVoz(List<String> opciones);
         
     
}

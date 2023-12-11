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
public interface IRepository {
    
    void exportarIRepositoryConversaciones(ArrayList<List<String>> conversaciones,Path ruta);
    void exportarIRepositoryMensajes(ArrayList<Integer> mensajes,Path ruta);
    void exportarIRepositoryPrimeraFrase(List <String> primeraFrase,Path ruta);
    ArrayList<List<String>> importarIRepositoryConversaciones(Path ruta);
    ArrayList<Integer> importarIRepositoryMensajes(Path ruta);
    List<String> importarIRepositoryPrimeraFrase(Path ruta);
    String getIdentifierIRepository();

    
}
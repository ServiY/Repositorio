/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.Controller;

/**
 *
 * @author diegu
 */
public abstract class ApplicationView {
    
    Controller controller;
    
    public abstract void showApplicationStart();
    public abstract void showMainMenu();
    public abstract void showApplicationEnd();
    public abstract void Serializacion();
    public abstract void Deserializacion();
    
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
      
    
}


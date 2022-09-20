/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import view.trafficcontroller;

/**
 *
 * @author admin
 */
public class GreenLight extends TrafficLights{
     
    public GreenLight(TrafficController tc, trafficcontroller gui) {
        super(tc);
        this.gui = gui;
    }
      
   
    public void setNSGreen(){
        gui.getNorth().setBackground(Color.green);
            gui.getSouth().setBackground(Color.green);
           gui.getjButton3().setEnabled(true);
    }
    public void setEWGreen(){
         gui.getEast().setBackground(Color.green);
            gui.getWest().setBackground(Color.green);
            gui.getjButton3().setEnabled(false);
    }
    
}

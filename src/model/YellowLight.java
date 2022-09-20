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
public class YellowLight extends TrafficLights {
    
    public YellowLight(TrafficController tc, trafficcontroller gui) {
        super(tc);
        this.gui = gui;
       
    }
    
    
    public void setNSYellow(){
        gui.getNorth().setBackground(Color.yellow);
            gui.getSouth().setBackground(Color.yellow);
            gui.getjButton3().setEnabled(false);
    }
    public void setEWYellow(){
       gui.getEast().setBackground(Color.yellow);
            gui.getWest().setBackground(Color.yellow);
            gui.getjButton2().setEnabled(false);
    }
}

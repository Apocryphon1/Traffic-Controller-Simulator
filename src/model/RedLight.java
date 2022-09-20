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
public class RedLight extends TrafficLights{
     trafficcontroller gui =new trafficcontroller();
    public RedLight(TrafficController tc, trafficcontroller gui) {
        super(tc);
        this.gui = gui;
    }
    public void setNSRed(){
            gui.getNorth().setBackground(Color.red);
            gui.getSouth().setBackground(Color.red);
            gui.getjButton2().setEnabled(true);
    }
    public void setEWRed(){
        gui.getEast().setBackground(Color.red);
            gui.getWest().setBackground(Color.red);
            //gui.getjButton3().setEnabled(true);
            
    }
    public void allRed(){
          gui.getNorth().setBackground(Color.red);
            gui.getSouth().setBackground(Color.red);
            gui.getEast().setBackground(Color.red);
            gui.getWest().setBackground(Color.red);
            gui.getjButton2().setEnabled(false);
            gui.getjButton3().setEnabled(false);
    }
}

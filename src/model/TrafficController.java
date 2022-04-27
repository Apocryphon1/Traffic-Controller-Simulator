/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import view.trafficcontroller;
import events.PowerEvent;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TrafficController {

    // The Kettle GUI
    private trafficcontroller gui;

    // This acts as our ON/OFF switch
    private boolean state = false;

    // The components
    private Timer timer;

    public TrafficController() {

        gui = new trafficcontroller();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        timer = new Timer(this);
        timer.start();
        TrafficLights tLights = new TrafficLights(this);
         tLights.start();
    }

    public boolean isTrafficOn() {
        return state;
    }

    public trafficcontroller getGui() {
        return gui;
    }

    public boolean isState() {
        return state;
    }

    public Timer getTimer() {
        return timer;
    }

    public void timerSignal(int secondss) {
         
        System.out.println("The time is now " + secondss);
         gui.getCurrentTimeTxt().setText(secondss + "");
    }

    public void setState(boolean state) {
        this.state = state;
        gui.getOnBtn().setEnabled(!state);


    }

    public void Colors(ArrayList<String> colors) {
       
        if (colors.get(0)=="red"){
        gui.getNorth().setBackground(Color.red);
        gui.getSouth().setBackground(Color.red);
        gui.getEast().setBackground(Color.green);
        gui.getWest().setBackground(Color.green);
        
        }
        else if (colors.get(0)=="green"){
         gui.getNorth().setBackground(Color.green);
        gui.getSouth().setBackground(Color.green);
        gui.getEast().setBackground(Color.red);
        gui.getWest().setBackground(Color.red);
        }
       
        
       
    }

}

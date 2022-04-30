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
    private PedestrianButton p;
    
    
    public TrafficController() {

        gui = new trafficcontroller();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        timer = new Timer(this);
        p= new PedestrianButton();
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
    public PedestrianButton getPButton(){
        return p;
    }
    public void timerSignal(int secondss) {
        
         
         
        System.out.println(secondss+" seconds left.");
         gui.getCurrentTimeTxt().setText(secondss + "");
          
    }

    public void setState(boolean state) {
        this.state = state;
        gui.getOnBtn().setEnabled(!state);


    }

    public void Colors(ArrayList<String> colors) {
       
        if (colors.get(0)=="redNS"){
        gui.getNorth().setBackground(Color.red);
        gui.getSouth().setBackground(Color.red);
        gui.getEast().setBackground(Color.yellow);
        gui.getWest().setBackground(Color.yellow);
        
        }
        else if (colors.get(0)=="greenNS"){
        gui.getNorth().setBackground(Color.green);
        gui.getSouth().setBackground(Color.green);
        gui.getEast().setBackground(Color.red);
        gui.getWest().setBackground(Color.red);
        }
        else if(colors.get(0)=="yellowNS"){
        gui.getNorth().setBackground(Color.yellow);
        gui.getSouth().setBackground(Color.yellow);
        gui.getEast().setBackground(Color.green);
        gui.getWest().setBackground(Color.green);
        }
         if (colors.get(0)=="greenEW"){
        gui.getNorth().setBackground(Color.red);
        gui.getSouth().setBackground(Color.red);
        gui.getEast().setBackground(Color.green);
        gui.getWest().setBackground(Color.green);
        
        }
        else if (colors.get(0)=="redEW"){
        gui.getNorth().setBackground(Color.green);
        gui.getSouth().setBackground(Color.green);
        gui.getEast().setBackground(Color.red);
        gui.getWest().setBackground(Color.red);
        }
        else if(colors.get(0)=="yellowEW"){
         
        gui.getNorth().setBackground(Color.red);
        gui.getSouth().setBackground(Color.red);
        gui.getEast().setBackground(Color.yellow);
        gui.getWest().setBackground(Color.yellow);
        }
        if (colors.get(0)=="redall"){
            System.out.println("Our System is being initialized");
        gui.getNorth().setBackground(Color.red);
        gui.getSouth().setBackground(Color.red);
        gui.getEast().setBackground(Color.red);
        gui.getWest().setBackground(Color.red);
        
        }
       
        
       
    }
    
    public void PedestrianButton(boolean state) throws InterruptedException{
       
       if(state){
        System.out.println("Pedestrian Button is pressed!");
        timer.Reset();
        
        gui.getNorth().setBackground(Color.yellow);
        gui.getSouth().setBackground(Color.yellow);
        gui.getEast().setBackground(Color.red);
        gui.getWest().setBackground(Color.red);
        timer.n=2;
         gui.getjButton2().setEnabled(!state);
        
       }
       else{
            gui.getjButton2().setEnabled(!state);
       }
    }
}

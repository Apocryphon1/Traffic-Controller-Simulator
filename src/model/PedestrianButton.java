/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.TimerReading;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import view.trafficcontroller;

/**
 *
 * @author admin
 */
public class PedestrianButton extends Thread {
    // The Traffic Controller GUI
    private trafficcontroller gui;
    private TrafficController tc;
    ArrayList<String> Colors = new ArrayList<String>();
    int sec=0;
    private Timer timer;
     private boolean state = false;
       public PedestrianButton(TrafficController tcc) {
        this.tc = tcc;
        
    }
      public trafficcontroller getGui() {
          
          
        return gui;
    }

    public boolean isClicked() {
       
        
    return state;
    }

    public PedestrianButton() {
       
    }
      
     public Timer getTimer() {
        return timer;
    }
    public void disableothers(){
       
        
    }
      public void setState(boolean state) {
        this.state = state;
        


    }
     
        @Override
    public void run() {
        
        while (true) {
            
           try {
             //if (tc.isTrafficOn()){
                 
           
             
             //}
             if(tc.isTrafficOn()){
                
                 
              if(isClicked()){
                 
                 
                 while(timer.getSeconds()<5){
               
                  Colors.add("yellow");
                 tc.Colors(Colors);
                   timer.setSeconds(sec);
                   sec++;
             }
              
             }
            }
             
        
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new TimerReading(timer.getSeconds()));
        }
    }
}


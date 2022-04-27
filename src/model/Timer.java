/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import java.util.logging.Level;
import java.util.logging.Logger;
import esper.Config;
import events.LightsColor;
import events.TimerReading;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Timer extends Thread{
    int secondss;
  ArrayList<String> Colors = new ArrayList<String>();
    public float getSeconds() {
        return secondss;
    }

    public void setSeconds(int seconds) {
        this.secondss = seconds;
    }
    
    private TrafficController tc;

    
    public Timer(TrafficController tcc) {
        this.tc = tcc;
        this.secondss = 0;
    }
    
   
    
   
     @Override
    public void run() {
        while (true) {
           try {
             if (tc.isTrafficOn()){
             secondss++;
             
            
             
             }
        
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new TimerReading(secondss));
        }
    }
}

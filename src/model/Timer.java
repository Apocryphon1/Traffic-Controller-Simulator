/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import java.util.logging.Level;
import java.util.logging.Logger;
import esper.Config;
import java.awt.Color;
import events.LightsColor;
import events.PedestrianButtonClicked;
import events.TimerReading;
import java.util.ArrayList;
import view.trafficcontroller;
/**
 *
 * @author User
 */
public class Timer extends Thread{
    int secondss;
    int n=0;
    PedestrianButton p;
    private trafficcontroller gui;
  ArrayList<String> Colors;
  
  
    public int getSeconds() {
        return secondss;
    }

    public void setSeconds(int seconds) {
        this.secondss = seconds;
    }
    
    private TrafficController tc;

    
    public Timer(TrafficController tcc) {
        this.Colors = new ArrayList<String>();
        Colors.add("greenNS");
        Colors.add("yellowNS");
         Colors.add("yellowEW");
         Colors.add("redEW");
         Colors.add("yellowNS");
        Colors.add("yellowEW");
       
       
        
        this.tc = tcc;
        this.secondss = 0;
    }
  
    public void TimesOut(){
         secondss=1;
       
         
                ArrayList<String> Colory = new ArrayList<String>();
                Colory.add(Colors.get(n));
                tc.Colors(Colory);
                Colory.clear();
                n++;
                Config.sendEvent(new PedestrianButtonClicked(false));
    
           if(n==5){
               n=0;
           }
    }
      
   
    public void Reset(){
        secondss=0;
    }
   
     @Override
    public void run() {
     
        while (true) {
           try {
            
             if(tc.isTrafficOn()){
                
                 secondss++;
                 
              if(secondss==6){
                  System.out.println("Traffic Light Change!");
                  TimesOut();
                  
              }
              
            }
             
        
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new TimerReading(secondss));
        }
    }
}

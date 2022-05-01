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
public class Timer extends Thread {
    int secondss;
    int NScounter = 0;
    int EWcounter = 1;
    PedestrianButton p;
    private trafficcontroller gui;
    ArrayList<String> ColorsNS;
    ArrayList<String> ColorsEW;

    public int getSeconds() {
        return secondss;
    }

    public void setSeconds(int seconds) {
        this.secondss = seconds;
    }

    private TrafficController tc;

    public Timer(TrafficController tcc) {
        this.ColorsNS = new ArrayList<String>();
        ColorsNS.add("red");
        ColorsNS.add("green");
        ColorsNS.add("yellow");
        this.ColorsEW = new ArrayList<String>();
        ColorsEW.add("red");
        ColorsEW.add("green");
        ColorsEW.add("yellow");

        this.tc = tcc;
        this.secondss = 0;
    }

    public void TimesOut(int currentSeconds) {
        ArrayList<String> Colory = new ArrayList<String>();
        ArrayList<String> Colorx = new ArrayList<String>();

        if(currentSeconds == 8){
            secondss = 1;
        }
        
        Colory.add(ColorsNS.get(NScounter));
        Colorx.add(ColorsEW.get(EWcounter));
        tc.Colors(Colory,Colorx);
        Colory.clear();
        Colorx.clear();
        Config.sendEvent(new PedestrianButtonClicked(false));

        //0 = red, 1 = green, 2 = yellow
        /* 
        01
        02
        10
        20 */
        switch(NScounter){
            case 0:
                if (EWcounter == 1 ){
                    EWcounter++;
                }  else{
                    NScounter++;
                    EWcounter = 0;
                } 
                break;
            case 1:
                NScounter ++;
                break;
            case 2:
                NScounter = 0;
                EWcounter ++;
                break;
        }
    }

    public void Reset() {
        secondss = 0;
    }

    @Override
    public void run() {

        while (true) {
            try {

                if (tc.isTrafficOn()) {

                    secondss++;
                    
                    if(secondss == 6 || secondss == 1){
                        TimesOut(secondss);
                    }

                    if (secondss == 8) {
                        System.out.println("Traffic Light Change!");
                        TimesOut(secondss);

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

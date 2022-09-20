/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import events.LightsColorNS;
import events.TimerReading;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.trafficcontroller;

/**
 *
 * @author User
 */
public class TrafficLights extends Thread {

    ArrayList<String> colors = new ArrayList<String>();
    private TrafficController tc;
    trafficcontroller gui=new trafficcontroller();
    boolean stop = false;

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public TrafficLights(TrafficController tc) {
        // the order for the lights in the array list is:
        // north,south,east,west
        this.tc = tc;

    }

    public void Reset() {
        stop = true;
    }

    @Override

    public void run() {
        while (!stop) {
            try {

                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }

            Config.sendEvent(new LightsColorNS(colors));
        }
    }
}

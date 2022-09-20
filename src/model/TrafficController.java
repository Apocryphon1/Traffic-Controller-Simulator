/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import esper.Main;
import static esper.Main.main;
import view.trafficcontroller;
import events.PowerEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TrafficController extends Thread {

    trafficcontroller gui;

    // This acts as our ON/OFF switch
    private boolean state = false;

    // The components
    private Timer timer;
    private TrafficLights tLights;
    private PedestrianButton pNS;
    private PedestrianButton pEW;
    private RedLight red;
    private GreenLight green;
    private YellowLight yellow;
    private intersectionSensor sensor;
    Thread NS = new Thread(pNS);
    Thread EW = new Thread(pEW);

    public TrafficController() {
        Car c1 = new Car("car1", 190, 280);
        Car c2 = new Car("car2", 240, -10);
        Car c3 = new Car("car3", 0, 110);
        Car c4 = new Car("car4", 420, 220);
        gui = new trafficcontroller();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        timer = new Timer(this);
        red = new RedLight(this, gui);
        green = new GreenLight(this, gui);
        yellow = new YellowLight(this, gui);
        timer.start();
        sensor = new intersectionSensor(this);
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

    public int getCarTimer() {
        System.out.println(timer.carTimer);
        return timer.getCarTimer();
    }

    public PedestrianButton getPButtonNS() {
        return pNS;
    }

    public PedestrianButton getPButtonEW() {
        return pEW;
    }

    public void timerSignal(int secondss) {
        gui.getCurrentTimeTxt().setText(secondss + "");
    }

    public void buttonStatusNS(boolean status) {
        NS.start();
        pEW.State(status, "NS");
    }

    public void setpClickedNS(boolean clicked) {
        timer.setpClicked(clicked);
    }

    public void buttonStatusEW(boolean status) {
        EW.start();
        pEW.State(status, "EW");
    }    

    public void setpClickedEW(boolean clicked) {
        timer.setpClicked(clicked);
    }

    public void setState(boolean state) {
        this.state = state;
        gui.getOnBtn().setEnabled(!state);
        gui.getOffBtn().setEnabled(state);
    }

    public void updateIntersection() {
        sensor.intersection();
    }

    public String requestChangeDirection(String direction) {
        sensor.changeDirection(direction);
        return sensor.getDirection();
    }

    public void ColorsNS(ArrayList<String> colorsNS) {
        if (colorsNS.get(0) == "red") {
            red.setNSRed();
        } else if (colorsNS.get(0) == "green") {
            green.setNSGreen();
        } else if (colorsNS.get(0) == "yellow") {
            yellow.setNSYellow();
        }
  if (colorsNS.get(0) == "redall") {
            red.allRed();

        }
      
    }
public void ColorsEW(ArrayList<String> colorsEW){
      if (colorsEW.get(0) == "red") {
            red.setEWRed();
        } else if (colorsEW.get(0) == "green") {
            green.setEWGreen();
        } else if (colorsEW.get(0) == "yellow") {
            yellow.setEWYellow();
        }

      
}
    
    public void Reset(boolean stop) {
        if (stop == true) {
            this.timer.Reset();
            this.gui.dispose();         
            Main.main(null);
            gui.getOnBtn().setEnabled(true);
            gui.getOffBtn().setEnabled(false);
            gui.getjButton2().setEnabled(false);
            gui.getjButton3().setEnabled(false);

        }
    }

}

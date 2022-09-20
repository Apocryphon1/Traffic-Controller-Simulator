/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.PedestrianButtonEWClicked;
import events.PedestrianButtonNSClicked;
import events.TimerReading;
import java.awt.Color;
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
    private boolean state = false;

    public trafficcontroller getGui() {
        return gui;
    }

    public boolean isClicked() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void State(boolean state, String direction) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setState(state);
                if (direction.equals("NS")) {
                    Config.sendEvent(new PedestrianButtonNSClicked(state));
                } else {
                    Config.sendEvent(new PedestrianButtonEWClicked(state));
                }
            }

        }).start();
    }
}

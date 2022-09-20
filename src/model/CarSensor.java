/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.PedestrianButtonNSClicked;
import events.TimerReading;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import view.trafficcontroller;

/**
 *
 * @author hagar
 */
public class CarSensor extends Thread{
    
    // The Traffic Controller GUI
    private trafficcontroller gui;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public trafficcontroller getGui() {

        return gui;
    }
    
    
    
    private int random(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    

    
}

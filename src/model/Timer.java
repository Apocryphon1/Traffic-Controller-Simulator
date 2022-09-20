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
import events.LightsColorNS;
import events.PedestrianButtonNSClicked;
import events.TimerReading;
import events.changeDirection;
import java.util.ArrayList;
import java.util.Random;
import view.trafficcontroller;

/**
 *
 * @author User+
 */
public class Timer extends Thread {

    int secondss;
    boolean timeChange = false;
    private trafficcontroller gui;
    int NScarArrival = 0;
    int EWcarArrival = 0;
    String direction = "EW";
    boolean placeHolder = true;
    boolean stop = false;
    boolean pClicked = false;
    int carTimer;
    private TrafficController tc;

    public int getSeconds() {
        return secondss;
    }

    public void setSeconds(int seconds) {
        this.secondss = seconds;
    }

    public int getCarTimer() {
        return carTimer;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setpClicked(boolean pClicked) {
        this.pClicked = pClicked;
    }

    public Timer(TrafficController tcc) {
        this.tc = tcc;
        this.secondss = 0;
    }

    public void TimesOut(int currentSeconds, int StopLight) {
        if (currentSeconds == StopLight) {
            secondss = 1;
            timeChange = !timeChange;
        }
        tc.updateIntersection();
    }

    public void Reset() {
        stop = true;
    }

    public int setTimer(int changeCount, int seconds) {
        if (direction == "EW") {
            carTimer = EWcarArrival + 5;
        } else {
            carTimer = NScarArrival + 5;
        }

        if (secondss == carTimer || secondss == 1 || pClicked == true) {
            if (secondss != carTimer && pClicked == true) {
                pClicked = false;
                secondss = carTimer;
            }
            TimesOut(secondss, 0);
        }

        if (secondss == carTimer + 4) {
            System.out.println("Traffic Light Change!");
            changeCount++;
            TimesOut(secondss, carTimer + 4);
            Config.sendEvent(new changeDirection(direction));
            direction = tc.requestChangeDirection(direction);
        }
        return changeCount;
    }

    @Override
    public void run() {
        int x3 = 0;
        int x4 = 420;
        int y4 = 220;
        int x1 = 190;
        int y1 = 280;
        int x2 = 240;
        int y2 = -10;
        int changeCount = 0;

        Car c = new Car("car5", -70, 100);
        int x = c.getxPos();
        while (!stop) {
            try {
                if (tc.isTrafficOn()) {
                    if (timeChange == true) {
                        tc.gui.getCar1().setBounds(x1 = x1, y1 = y1 - 70, 70, 110);
                        tc.gui.getCar2().setBounds(x2 = x2, y2 = y2 + 70, 70, 110);
                        NScarArrival = 1;
                        tc.gui.getCar5().setVisible(true);
                        if (placeHolder) {
                            tc.gui.getCar5().setBounds(0, 100, 110, 50);
                        }
                    } else {
                        if (secondss >= 2) {
                            tc.gui.getCar3().setBounds(x3 = x3 + 70, 110, 110, 50);
                            tc.gui.getCar4().setBounds(x4 = x4 - 70, y4, 110, 50);
                            EWcarArrival = 3;
                        }
                    }
                    if (changeCount == 2) {
                        // generating random car
                        //tc.gui.getCar5().setVisible(true);
                        if (direction == "EW") {
                            if (placeHolder) {
                                EWcarArrival = secondss;
                                placeHolder = false;
                            }
                            tc.gui.getCar5().setBounds(x = x + 70, 100, 110, 50);
                            if (secondss == 7) {

                                tc.gui.getCar5().setBounds(x = x + 70, 100, 110, 50);
                            }
                        }
                    }
                    secondss++;
                    changeCount = setTimer(changeCount, secondss);
                }
                this.sleep(1000);
                System.out.println(secondss + " seconds left.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            Config.sendEvent(new TimerReading(secondss));
        }
    }
}

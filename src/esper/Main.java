/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import events.PedestrianButtonNSClicked;
import java.util.ArrayList;
import model.PedestrianButton;
import model.TrafficController;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Youssef Negm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);

        // Register events
        Config.registerEvents();

        // Create Kettle
        final TrafficController tc = new TrafficController();

        Config.createStatement("select time from TimerReading")
                .setSubscriber(new Object() {
                    public void update(int temp) throws InterruptedException {
                        tc.timerSignal(temp);
                    }
                });

        Config.createStatement("select state from PowerEvent")
                .setSubscriber(new Object() {
                    public void update(boolean state) {
                        tc.setState(state);
                    }
                });
        Config.createStatement("select colors from LightsColorNS")
                .setSubscriber(new Object() {
                    public void update(ArrayList<String> colorsNS) {
                        tc.ColorsNS(colorsNS);
                         
                    }
                   
                });
              Config.createStatement("select colors from LightsColorEW")
                .setSubscriber(new Object() {
                    public void update(ArrayList<String> colorsEW) {
                        tc.ColorsEW(colorsEW);
                         
                    }
                   
                });
         Config.createStatement("select state from PedestrianButtonNSClicked")
                .setSubscriber(new Object() {
                    public void update(boolean state) throws InterruptedException{
                        tc.setpClickedNS(true);
                        tc.buttonStatusNS(state);      
                    }
                });
          Config.createStatement("select state from PedestrianButtonEWClicked")
                .setSubscriber(new Object() {
                    public void update(boolean state) throws InterruptedException{                      
                        tc.setpClickedEW(true);
                        tc.buttonStatusEW(state);
                    }
                });
          

              Config.createStatement("select stop from StopSystem")
                .setSubscriber(new Object() {
                    public void update(boolean stop) throws InterruptedException{
                       
                        tc.Reset(stop);
                       
                    }
                });
              Config.createStatement("select direction from changeDirection")
                .setSubscriber(new Object() {
                    public void update(String direction) throws InterruptedException{
                       tc.requestChangeDirection(direction);                     
                    }
                });
             
    }

}

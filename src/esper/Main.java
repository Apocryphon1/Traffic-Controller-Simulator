/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import java.util.ArrayList;
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
        Config.createStatement("select colors from LightsColor")
                .setSubscriber(new Object() {
                    public void update(ArrayList<String> colors) {
                        tc.Colors(colors);
                    }
                });
         Config.createStatement("select state from PedestrianButtonClicked")
                .setSubscriber(new Object() {
                    public void update(boolean state) throws InterruptedException{
                        tc.PedestrianButton(state);
                    }
                });
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.LightsColorEW;

import events.LightsColorNS;
import events.PedestrianButtonEWClicked;
import events.PedestrianButtonNSClicked;
import events.PowerEvent;
import events.StopSystem;
import events.TimerReading;
import events.changeDirection;

/**
 *
 * @author User
 */
public class Config {

    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(PowerEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(TimerReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(LightsColorNS.class);
        engine.getEPAdministrator().getConfiguration().addEventType(LightsColorEW.class);
       engine.getEPAdministrator().getConfiguration().addEventType(PedestrianButtonNSClicked.class);
       engine.getEPAdministrator().getConfiguration().addEventType(PedestrianButtonEWClicked.class);
        engine.getEPAdministrator().getConfiguration().addEventType(StopSystem.class);
        engine.getEPAdministrator().getConfiguration().addEventType(changeDirection.class);
        System.out.println("Our System is being initialized");
        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }

    public static void sendEvent(Object o) {
        engine.getEPRuntime().sendEvent(o);
    }
}

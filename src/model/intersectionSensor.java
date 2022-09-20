/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static com.espertech.esper.core.context.util.StatementAgentInstanceUtil.stop;
import esper.Config;
import events.LightsColorEW;
import events.LightsColorNS;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class intersectionSensor extends Thread {

    ArrayList<String> ColorsNS;
    ArrayList<String> ColorsEW;
    private TrafficController tc;
    int NScounter = 0;
    int EWcounter = 1;
    String direction;

    public intersectionSensor(TrafficController tcc) {
        this.tc = tcc;
        this.ColorsNS = new ArrayList<String>();
        ColorsNS.add("red");
        ColorsNS.add("green");
        ColorsNS.add("yellow");
        this.ColorsEW = new ArrayList<String>();
        ColorsEW.add("red");
        ColorsEW.add("green");
        ColorsEW.add("yellow");
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void intersection() {
        ArrayList<String> Colory = new ArrayList<String>();
        ArrayList<String> Colorx = new ArrayList<String>();
        Colory.add(ColorsNS.get(NScounter));
        Colorx.add(ColorsEW.get(EWcounter));
         Config.sendEvent(new LightsColorNS(Colory));
         Config.sendEvent(new LightsColorEW(Colorx));
        //tc.Colors(Colory, Colorx);
        Colory.clear();
        Colorx.clear();
        //0 = red, 1 = green, 2 = yellow
        /* 
        01
        02
        10
        20 */
        switch (NScounter) {
            case 0:
                if (EWcounter == 1) {
                    EWcounter++;
                } else {
                    NScounter++;
                    EWcounter = 0;
                }
                break;
            case 1:
                NScounter++;
                break;
            case 2:
                NScounter = 0;
                EWcounter++;
                break;
        }
    }
    
    public void changeDirection(String direction){
        if (direction == "NS") {
                direction = "EW";
            } else {
                direction = "NS";
            }
        setDirection(direction);
    }

}

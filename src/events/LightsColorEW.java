/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class LightsColorEW {
     private ArrayList<String> colors = new ArrayList<String>();

    public LightsColorEW(ArrayList<String> colors) {
        this.colors = colors;
    }

  

    public ArrayList<String> getColors() {
        return colors;
    }

}

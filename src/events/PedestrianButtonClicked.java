/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author admin
 */
public class PedestrianButtonClicked {
      private boolean state;
    
    public PedestrianButtonClicked(boolean state)
    {
        this.state = state;
    }
    
    public boolean getState() {
        return state;
    }
    
}

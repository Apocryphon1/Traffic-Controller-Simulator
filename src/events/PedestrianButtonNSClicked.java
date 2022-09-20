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
public class PedestrianButtonNSClicked {
      private boolean state;
    
    public PedestrianButtonNSClicked(boolean state)
    {
        this.state = state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public PedestrianButtonNSClicked() {
    }

   
    
    public boolean getState() {
        return state;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author hagar
 */
public class PedestrianButtonEWClicked {
     private boolean state;
    
    public PedestrianButtonEWClicked(boolean state)
    {
        this.state = state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public PedestrianButtonEWClicked() {
    }

   
    
    public boolean getState() {
        return state;
    }
    
}

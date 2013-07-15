/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.clock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Dony
 */
public class NiconClockController implements Initializable {
@FXML
public static Label clockdisplay;
private DigitalClock clock;
  
public static void setclock(String a){
clockdisplay.setText(a);
}

public static void setzone(String a){
nicon.NiconDesktop.clock.DigitalClock.setZone(a);
}

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    clock = new DigitalClock();
    
 
    
    }    
}


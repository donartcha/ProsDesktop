/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.DesktopViewer;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Dony
 */
public class DesktopViewerController implements Initializable {

   
    
    
    
    @FXML
    private void ActionSesiondown(ActionEvent event){
        try {
            nicon.NiconDesktop.main.CloseSesion();
        } catch (Exception ex) {
            Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void ActionShutdown(ActionEvent event){
    System.exit(0);
    }
    
    
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.DesktopViewer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Dony
 */
public class DesktopViewerController implements Initializable {
private Parent navigator; 
private AnchorPane AppContenedor;




    @FXML
private AnchorPane desktop;
    
   
   
    @FXML
    private MenuItem closeIN;
    @FXML
    private MenuItem openIN;
    
    
    
    
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
    
    @FXML
    private void OpenNiconNavigator(){
    
        try {
            navigator = FXMLLoader.load(nicon.NiconDesktop.guifx.NiconNavigator.NavegadorController.class.getResource("Navegador.fxml"));
            navigator.setVisible(true);
            
            
            AnchorPane.setTopAnchor(navigator, 0.0);
            AnchorPane.setBottomAnchor(navigator, 0.0);
            AnchorPane.setLeftAnchor(navigator, 0.0);
            AnchorPane.setRightAnchor(navigator, 0.0);
            AppContenedor = new AnchorPane();
            AppContenedor.setStyle("-fx-background-color:linear-gradient(#000000, #FF7700);");
            AppContenedor.getChildren().add(navigator);
            AnchorPane.setTopAnchor(AppContenedor, 0.0);
            AnchorPane.setBottomAnchor(AppContenedor, 0.0);
            AnchorPane.setLeftAnchor(AppContenedor, 0.0);
            AnchorPane.setRightAnchor(AppContenedor, 0.0);
            desktop.getChildren().add(AppContenedor);
            openIN.setVisible(false);
            closeIN.setVisible(true);
        } catch (IOException ex) {
           System.out.println("Error OpenNavigator"+ex);
        }
    }
    
    @FXML
    private void CloseNiconNavigator(){
    desktop.getChildren().remove(AppContenedor);
    openIN.setVisible(true);
    closeIN.setVisible(false);
    }
    
    
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    closeIN.setVisible(false); 
    
 
   
    
    
  
      
   //Platform.runLater(timer);
    

        // TODO
    }    
}

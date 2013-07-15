/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.Plugins.Buscador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import nicon.NiconDesktop.guifx.DesktopViewer.DesktopViewerController;
import nicon.NiconDesktop.guifx.NiconNavigator.NavegadorController;

/**
 * FXML Controller class
 *
 * @author Dony
 */
public class BuscadorController implements Initializable {

    @FXML
    private AnchorPane primario;
    
    @FXML
    private AnchorPane secundario;
    
    @FXML
    private TextField Searcher;
    
    
    /**
     * Método para Borrar texto de la barra de busqueda
     * @param event 
     */
    @FXML
    private void Action1(MouseEvent event){
    Searcher.setText(null);    
    }
    
    @FXML
    private void Action2(KeyEvent event){
    String pulsado = event.getCode().toString();
    String search = Searcher.getText();
    if ("ENTER".equals(pulsado)){
    DesktopViewerController.OpenSearcher();
    NavegadorController.SetBusqueda(search);
    Searcher.setText("Buscar en Google");
    }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}

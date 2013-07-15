/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.core;

/**
 *
 * @author Dony
 */
import javafx.stage.*; 
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nicon.NiconDesktop.guifx.DesktopViewer.DesktopViewerController;
import nicon.NiconDesktop.object.Icono;

public class coreOption{
    Button aceptar;
    Button declina;
public coreOption(final Stage stg, final Icono IMG) {
        aceptar = new Button();
        declina = new Button();
        
        final  Stage stage = new Stage(StageStyle.UNDECORATED);
        //Initialize the Stage with type of modal
        stage.initModality(Modality.APPLICATION_MODAL);
        //Set the owner of the Stage 
        stage.initOwner(stg);
        stage.setTitle("Top Stage With Modality");
        
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250, Color.LIGHTGREEN);
        
         
        declina.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            stage.hide();
            
            }
        });
        
        aceptar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            stage.hide();
            DesktopViewerController.setBGRuta(IMG.getRuta());
            }
        });
         
        declina.setLayoutX(120);
        declina.setLayoutY(80);
        declina.setText("Cancelar");
        
        aceptar.setLayoutX(20);
        aceptar.setLayoutY(80);
        aceptar.setText("Aceptar");
        
        root.getChildren().add(declina);
        root.getChildren().add(aceptar);   
        
        stage.setScene(scene);        
        stage.show();
      
    }
    
}

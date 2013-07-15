/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.core;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Dony
 */
public class coreAppWindow {
    private Parent gate;
    private Label Title = new Label();
    private AnchorPane pane = new AnchorPane();
    private AnchorPane woopsPane = new AnchorPane();
    private Button woopsWC = new Button();
    private Button woopsC = new Button();
    private Boolean act;
    private Tooltip tooltip1 = new Tooltip();
    /**
     * Creador de Ventana de Aplicación 
     * @param a Parent de la aplicacion
     */
public coreAppWindow(String name, Parent app){
gate = app;
Title.setText(name);
Title.setStyle("-fx-text-fill: #ffffff;"
        + "-fx-font-weight: bold;");


AnchorPane.setTopAnchor(gate, 24.0);
AnchorPane.setLeftAnchor(gate, 0.0);
AnchorPane.setRightAnchor(gate, 0.0);
AnchorPane.setBottomAnchor(gate, 0.0);
pane.getChildren().add(gate);

pane.setStyle("-fx-background-color:rgba(0,0,0,255);");
act = true;
showing();
this.addWindowOption();

}
public Parent getGate(){
return pane;
}

public Button getClose(){
return woopsC;
}

private void showing(){
if (act == true){
pane.setVisible(act);

}else{
pane.setVisible(act);
}
}

public void setActive(){
act = true;
showing();
}

private void addWindowOption(){
woopsPane.setMaxSize(100, 24);
woopsPane.setMinSize(100, 24);
woopsPane.setPrefSize(100, 24);
woopsC.setMaxSize(20, 20);
woopsC.setMinSize(20, 20);
woopsC.setPrefSize(20, 20);
woopsWC.setMaxSize(20, 20);
woopsWC.setMinSize(20, 20);
woopsWC.setPrefSize(20, 20);
woopsWC.getStyleClass().add("ShowWindow");
woopsC.getStyleClass().add("CloseWindow");
woopsC.setVisible(true);
woopsWC.setVisible(true);
Title.setVisible(true);
AnchorPane.setTopAnchor(woopsWC, 2.0);
AnchorPane.setRightAnchor(woopsWC, 24.0);
AnchorPane.setTopAnchor(woopsC, 2.0);
AnchorPane.setRightAnchor(woopsC, 2.0);
AnchorPane.setTopAnchor(Title, 4.0);
AnchorPane.setLeftAnchor(Title, 2.0);
woopsPane.getChildren().add(Title);
woopsPane.getChildren().add(woopsWC);
woopsPane.getChildren().add(woopsC);
woopsPane.getStyleClass().add("menu-bar");



tooltip1.setText("Ocultar ventana");
woopsWC.setTooltip(tooltip1);

woopsWC.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override 
    public void handle(MouseEvent evnt){
    if (act == true){
    act = false;
    showing();
    tooltip1.setText("Mostrar ventana");
    }else{
    act = true;
    showing();
    tooltip1.setText("Ocultar ventana");
    }        
    
    
    }});//Fin de set On MouseClicked

AnchorPane.setTopAnchor(woopsPane, 0.0);
AnchorPane.setLeftAnchor(woopsPane, 0.0);
AnchorPane.setRightAnchor(woopsPane, 0.0);
pane.getChildren().add(woopsPane);


System.out.println("Añadido woops");
}
}

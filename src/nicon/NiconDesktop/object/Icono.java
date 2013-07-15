/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.object;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Dony
 */
public class Icono extends Button{
private String ruta;    
    
public Icono(){
this.setPrefSize(150, 150);
this.setMaxSize(150, 150);
this.setMinSize(150, 150);
this.setStyle("-fx-background-color: rgba(0,0,0,0);");
}
public void setImagen(String ruta){
this.ruta = ruta;    
this.setStyle("-fx-background-image: url(\""+ruta+"\");" 
        + "-fx-background-position: 0% 0%;"
        + "-fx-background-size:150px 150px;");
}
public void setDescription(String tip){
Tooltip tooltip1 = new Tooltip();
tooltip1.setText(tip+"  ");
this.setTooltip(tooltip1);
}
public void setSize(Double x, Double y){
this.setPrefSize(x, y);
this.setMaxSize(x, y);
this.setMinSize(x, y);
this.setWidth(x);
this.setHeight(y);
}
public String getRuta(){
return ruta;
}
}
